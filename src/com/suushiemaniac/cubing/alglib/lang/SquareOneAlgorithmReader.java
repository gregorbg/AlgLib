package com.suushiemaniac.cubing.alglib.lang;

import com.suushiemaniac.cubing.alglib.alg.Algorithm;
import com.suushiemaniac.cubing.alglib.alg.SimpleAlg;
import com.suushiemaniac.cubing.alglib.alg.commutator.Commutator;
import com.suushiemaniac.cubing.alglib.alg.commutator.PureComm;
import com.suushiemaniac.cubing.alglib.alg.commutator.SetupComm;
import com.suushiemaniac.cubing.alglib.exception.InvalidNotationException;
import com.suushiemaniac.cubing.alglib.lang.antlr.squareone.SquareOneBaseVisitor;
import com.suushiemaniac.cubing.alglib.lang.antlr.squareone.SquareOneLexer;
import com.suushiemaniac.cubing.alglib.lang.antlr.squareone.SquareOneParser;
import com.suushiemaniac.cubing.alglib.move.SquareOneMove;
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneDirectionModifier;
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneHalfModifier;
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneModifier;
import com.suushiemaniac.cubing.alglib.move.modifier.SquareOneNumModifier;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class SquareOneAlgorithmReader extends SquareOneBaseVisitor<Algorithm> implements NotationReader {
    @Override
    public Algorithm parse(String input) {
        SquareOneLexer lexer = new SquareOneLexer(new ANTLRInputStream(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SquareOneParser parser = new SquareOneParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new InvalidNotationException(input, msg);
            }
        });
        ParseTree tree = parser.squareOne();
        return this.visit(tree);
    }

    private class SquareOneMoveReader extends SquareOneBaseVisitor<SquareOneMove> {
        private SquareOneModifierReader modifierReader;

        public SquareOneMoveReader(SquareOneModifierReader modifierReader) {
            this.modifierReader = modifierReader;
        }

        @Override
        public SquareOneMove visitSquareOneMoveSlash(SquareOneParser.SquareOneMoveSlashContext ctx) {
            SquareOneModifier modifier = this.modifierReader.visit(ctx.squareOneModifier());
            boolean endSlash = ctx.SQUARE_ONE_SLASH() != null;
            return new SquareOneMove(modifier, false, endSlash);
        }
    }

    private class SquareOneModifierReader extends SquareOneBaseVisitor<SquareOneModifier> {
        private SquareOneHalfModifierReader halfModifierReader;

        public SquareOneModifierReader() {
            this.halfModifierReader = new SquareOneHalfModifierReader();
        }

        @Override
        public SquareOneModifier visitSquareOneModifier(SquareOneParser.SquareOneModifierContext ctx) {
            SquareOneHalfModifier halfUp = this.halfModifierReader.visit(ctx.squareOneFaceTurn(0));
            SquareOneHalfModifier halfDown = this.halfModifierReader.visit(ctx.squareOneFaceTurn(1));
            return new SquareOneModifier(halfUp, halfDown);
        }
    }

    private class SquareOneHalfModifierReader extends SquareOneBaseVisitor<SquareOneHalfModifier> {
        @Override
        public SquareOneHalfModifier visitSquareOneFaceTurn(SquareOneParser.SquareOneFaceTurnContext ctx) {
            SquareOneDirectionModifier directionModifier = SquareOneDirectionModifier.fromNotation(ctx.SQUARE_ONE_PLANE_ZERO() == null ? (ctx.SQUARE_ONE_DIRECTION_MODIFIER() == null ? "" : ctx.SQUARE_ONE_DIRECTION_MODIFIER().getText()) : "");
            SquareOneNumModifier halfModifier = SquareOneNumModifier.fromNotation(ctx.SQUARE_ONE_PLANE_ZERO() == null ? ctx.SQUARE_ONE_PLANE_POS().getText() : "0");
            return new SquareOneHalfModifier(directionModifier, halfModifier);
        }
    }

    private class SquareOneCommReader extends SquareOneBaseVisitor<Commutator> {
        private SquareOneAlgorithmReader algorithmReader;

        public SquareOneCommReader(SquareOneAlgorithmReader algorithmReader) {
            this.algorithmReader = algorithmReader;
        }

        @Override
        public Commutator visitSquareOnePureComm(SquareOneParser.SquareOnePureCommContext ctx) {
            Algorithm partA = this.algorithmReader.visit(ctx.squareOne(0));
            Algorithm partB = this.algorithmReader.visit(ctx.squareOne(1));
            return new PureComm(partA, partB);
        }

        @Override
        public Commutator visitSquareOneSetupComm(SquareOneParser.SquareOneSetupCommContext ctx) {
            Algorithm partA = this.algorithmReader.visit(ctx.squareOne(0));
            Algorithm partB = this.algorithmReader.visit(ctx.squareOne(1));
            return new SetupComm(partA, partB);
        }
    }

    private SquareOneModifierReader modifierReader;
    private SquareOneMoveReader moveReader;
    private SquareOneCommReader commReader;

    public SquareOneAlgorithmReader() {
        this.modifierReader = new SquareOneModifierReader();
        this.moveReader = new SquareOneMoveReader(this.modifierReader);
        this.commReader = new SquareOneCommReader(this);
    }

    @Override
    public SimpleAlg visitSquareOneAlg(SquareOneParser.SquareOneAlgContext ctx) {
        SquareOneMove[] moves = new SquareOneMove[ctx.squareOneMoveSlash().size() + 1];
        SquareOneModifier firstModifier = this.modifierReader.visit(ctx.squareOneMoveSlash().size() > 0 ? ctx.squareOneMoveSlash(0).squareOneModifier() : ctx.squareOneModifier());
        boolean firstBeginSlash = ctx.squareOneBeginSlash() != null;
        boolean firstEndSlash = (ctx.squareOneMoveSlash().size() > 0 ? ctx.squareOneMoveSlash(0).SQUARE_ONE_SLASH() : ctx.SQUARE_ONE_SLASH()) != null;
        SquareOneMove firstMove = new SquareOneMove(firstModifier, firstBeginSlash, firstEndSlash);
        moves[0] = firstMove;
        if (ctx.squareOneMoveSlash().size() < 1) return new SimpleAlg(moves);
        if (ctx.squareOneMoveSlash().size() > 1)
            for (int i = 1; i < ctx.squareOneMoveSlash().size(); i++) moves[i] = this.moveReader.visit(ctx.squareOneMoveSlash(i));
        SquareOneModifier lastModifier = this.modifierReader.visit(ctx.squareOneModifier());
        boolean lastEndSlash = ctx.SQUARE_ONE_SLASH() != null;
        moves[moves.length - 1] = new SquareOneMove(lastModifier, false, lastEndSlash);
        return new SimpleAlg(moves);
    }

    @Override
    public Commutator visitSquareOneComm(SquareOneParser.SquareOneCommContext ctx) {
        return this.commReader.visit(ctx);
    }
}