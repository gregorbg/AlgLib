package com.suushiemaniac.cubing.alglib.lang;

import com.suushiemaniac.cubing.alglib.alg.Algorithm;
import com.suushiemaniac.cubing.alglib.alg.SimpleAlg;
import com.suushiemaniac.cubing.alglib.alg.commutator.Commutator;
import com.suushiemaniac.cubing.alglib.alg.commutator.PureComm;
import com.suushiemaniac.cubing.alglib.alg.commutator.SetupComm;
import com.suushiemaniac.cubing.alglib.exception.InvalidNotationException;
import com.suushiemaniac.cubing.alglib.lang.antlr.clock.ClockBaseVisitor;
import com.suushiemaniac.cubing.alglib.lang.antlr.clock.ClockLexer;
import com.suushiemaniac.cubing.alglib.lang.antlr.clock.ClockParser;
import com.suushiemaniac.cubing.alglib.move.ClockMove;
import com.suushiemaniac.cubing.alglib.move.modifier.ClockDirectionModifier;
import com.suushiemaniac.cubing.alglib.move.modifier.ClockNumModifier;
import com.suushiemaniac.cubing.alglib.move.plane.ClockPlane;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class ClockAlgorithmReader extends ClockBaseVisitor<Algorithm> implements NotationReader {
    @Override
    public Algorithm parse(String input) {
        ClockLexer lexer = new ClockLexer(new ANTLRInputStream(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ClockParser parser = new ClockParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new InvalidNotationException(input, msg);
            }
        });
        ParseTree tree = parser.clock();
        return this.visit(tree);
    }

    private class ClockMoveReader extends ClockBaseVisitor<ClockMove> {
        @Override
        public ClockMove visitTurnPinClock(ClockParser.TurnPinClockContext ctx) {
            ClockPlane plane = ClockPlane.fromNotation(ctx.CLOCK_PLANE_SINGLE().getText());
            ClockNumModifier numModifier = ClockNumModifier.fromNotation(ctx.CLOCK_NUM_MODIFIER().getText());
            ClockDirectionModifier directionModifier = ClockDirectionModifier.fromNotation(ctx.CLOCK_DIRECTION_MODIFIER().getText());
            return new ClockMove(plane, numModifier, directionModifier);
        }

        @Override
        public ClockMove visitRotationClock(ClockParser.RotationClockContext ctx) {
            return new ClockMove(ClockPlane.VERTICAL, ClockNumModifier.TWO, ClockDirectionModifier.POS);
        }

        @Override
        public ClockMove visitEndPinClock(ClockParser.EndPinClockContext ctx) {
            ClockPlane plane = ClockPlane.fromNotation(ctx.CLOCK_PLANE_SINGLE().getText());
            return new ClockMove(plane);
        }
    }

    private class ClockCommReader extends ClockBaseVisitor<Commutator> {
        private ClockAlgorithmReader algorithmReader;

        public ClockCommReader(ClockAlgorithmReader algorithmReader) {
            this.algorithmReader = algorithmReader;
        }

        @Override
        public Commutator visitClockPureComm(ClockParser.ClockPureCommContext ctx) {
            Algorithm partA = this.algorithmReader.visit(ctx.clock(0));
            Algorithm partB = this.algorithmReader.visit(ctx.clock(1));
            return new PureComm(partA, partB);
        }

        @Override
        public Commutator visitClockSetupComm(ClockParser.ClockSetupCommContext ctx) {
            Algorithm partA = this.algorithmReader.visit(ctx.clock(0));
            Algorithm partB = this.algorithmReader.visit(ctx.clock(1));
            return new SetupComm(partA, partB);
        }
    }

    private ClockMoveReader moveReader;
    private ClockCommReader commReader;

    public ClockAlgorithmReader() {
        this.moveReader = new ClockMoveReader();
        this.commReader = new ClockCommReader(this);
    }

    @Override
    public SimpleAlg visitClockAlg(ClockParser.ClockAlgContext ctx) {
        int endConfigLength = ctx.endPinClock() == null ? 0 : 1;
        ClockMove[] moves = new ClockMove[ctx.clockMove().size() + endConfigLength];
        for (int i = 0; i < moves.length - endConfigLength; i++) moves[i] = this.moveReader.visit(ctx.clockMove(i));
        if (ctx.endPinClock() != null) moves[moves.length - 1] = this.moveReader.visit(ctx.endPinClock());
        return new SimpleAlg(moves);
    }

    @Override
    public Algorithm visitClockComm(ClockParser.ClockCommContext ctx) {
        return this.commReader.visit(ctx);
    }
}
