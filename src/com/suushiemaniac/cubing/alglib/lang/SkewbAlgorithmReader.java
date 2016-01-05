package com.suushiemaniac.cubing.alglib.lang;

import com.suushiemaniac.cubing.alglib.alg.Algorithm;
import com.suushiemaniac.cubing.alglib.alg.SimpleAlg;
import com.suushiemaniac.cubing.alglib.alg.commutator.Commutator;
import com.suushiemaniac.cubing.alglib.alg.commutator.PureComm;
import com.suushiemaniac.cubing.alglib.alg.commutator.SetupComm;
import com.suushiemaniac.cubing.alglib.lang.antlr.skewb.SkewbBaseVisitor;
import com.suushiemaniac.cubing.alglib.lang.antlr.skewb.SkewbLexer;
import com.suushiemaniac.cubing.alglib.lang.antlr.skewb.SkewbParser;
import com.suushiemaniac.cubing.alglib.move.SkewbMove;
import com.suushiemaniac.cubing.alglib.move.modifier.SkewbModifier;
import com.suushiemaniac.cubing.alglib.move.plane.SkewbPlane;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class SkewbAlgorithmReader extends SkewbBaseVisitor<Algorithm> implements NotationReader {
    @Override
    public Algorithm parse(String input) {
        SkewbLexer lexer = new SkewbLexer(new ANTLRInputStream(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SkewbParser parser = new SkewbParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                System.err.println("Something went wrong @ " + input + " : " + msg);
            }
        });
        ParseTree tree = parser.skewb();
        return this.visit(tree);
    }

    private class SkewbMoveReader extends SkewbBaseVisitor<SkewbMove> {
        @Override
        public SkewbMove visitSkewbMove(SkewbParser.SkewbMoveContext ctx) {
            SkewbPlane plane = SkewbPlane.fromNotation(ctx.SKEWB_PLANE().getText());
            SkewbModifier modifier = SkewbModifier.fromNotation(ctx.SKEWB_MODIFIER() == null ? "" : ctx.SKEWB_MODIFIER().getText());
            return new SkewbMove(plane, modifier);
        }
    }

    private class SkewbCommReader extends SkewbBaseVisitor<Commutator> {
        private SkewbAlgorithmReader algorithmReader;

        public SkewbCommReader(SkewbAlgorithmReader algorithmReader) {
            this.algorithmReader = algorithmReader;
        }

        @Override
        public Commutator visitSkewbPureComm(SkewbParser.SkewbPureCommContext ctx) {
            Algorithm partA = this.algorithmReader.visit(ctx.skewb(0));
            Algorithm partB = this.algorithmReader.visit(ctx.skewb(1));
            return new PureComm(partA, partB);
        }

        @Override
        public Commutator visitSkewbSetupComm(SkewbParser.SkewbSetupCommContext ctx) {
            Algorithm partA = this.algorithmReader.visit(ctx.skewb(0));
            Algorithm partB = this.algorithmReader.visit(ctx.skewb(1));
            return new SetupComm(partA, partB);
        }
    }

    private SkewbMoveReader moveReader;
    private SkewbCommReader commReader;

    public SkewbAlgorithmReader() {
        this.moveReader = new SkewbMoveReader();
        this.commReader = new SkewbCommReader(this);
    }

    @Override
    public SimpleAlg visitSkewbAlg(SkewbParser.SkewbAlgContext ctx) {
        SkewbMove[] moves = new SkewbMove[ctx.skewbMove().size()];
        for (int i = 0; i < moves.length; i++) moves[i] = this.moveReader.visit(ctx.skewbMove(i));
        return new SimpleAlg(moves);
    }

    @Override
    public Algorithm visitSkewbComm(SkewbParser.SkewbCommContext ctx) {
        return this.commReader.visit(ctx);
    }
}
