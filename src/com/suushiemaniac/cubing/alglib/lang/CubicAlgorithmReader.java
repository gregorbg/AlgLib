package com.suushiemaniac.cubing.alglib.lang;

import com.suushiemaniac.cubing.alglib.alg.Algorithm;
import com.suushiemaniac.cubing.alglib.alg.SimpleAlg;
import com.suushiemaniac.cubing.alglib.alg.commutator.Commutator;
import com.suushiemaniac.cubing.alglib.alg.commutator.PureComm;
import com.suushiemaniac.cubing.alglib.alg.commutator.SetupComm;
import com.suushiemaniac.cubing.alglib.lang.antlr.cubic.CubicBaseVisitor;
import com.suushiemaniac.cubing.alglib.lang.antlr.cubic.CubicLexer;
import com.suushiemaniac.cubing.alglib.lang.antlr.cubic.CubicParser;
import com.suushiemaniac.cubing.alglib.move.CubicMove;
import com.suushiemaniac.cubing.alglib.move.modifier.CubicModifier;
import com.suushiemaniac.cubing.alglib.move.plane.CubicPlane;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class CubicAlgorithmReader extends CubicBaseVisitor<Algorithm> implements NotationReader {
    @Override
    public Algorithm parse(String input) {
        CubicLexer lexer = new CubicLexer(new ANTLRInputStream(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CubicParser parser = new CubicParser(tokens);
        ParseTree tree = parser.cubic();
        return this.visit(tree);
    }

    private class CubicMoveReader extends CubicBaseVisitor<CubicMove> {
        @Override
        public CubicMove visitSingleDepthCubic(CubicParser.SingleDepthCubicContext ctx) {
            CubicPlane plane = CubicPlane.fromNotation(ctx.CUBIC_PLANE().getText());
            CubicModifier modifier = CubicModifier.fromNotation(ctx.CUBIC_MODIFIER() == null ? "" : ctx.CUBIC_MODIFIER().getText());
            return new CubicMove(plane, modifier, 1);
        }

        @Override
        public CubicMove visitTwoDepthCubic(CubicParser.TwoDepthCubicContext ctx) {
            CubicPlane plane = CubicPlane.fromNotation(ctx.CUBIC_PLANE().getText());
            CubicModifier modifier = CubicModifier.fromNotation(ctx.CUBIC_MODIFIER() == null ? "" : ctx.CUBIC_MODIFIER().getText());
            return new CubicMove(plane, modifier, 2);
        }

        @Override
        public CubicMove visitNDepthCubic(CubicParser.NDepthCubicContext ctx) {
            CubicMove twoMove = visit(ctx.twoDepthCubic());
            return new CubicMove(twoMove.getPlane(), twoMove.getModifier(), Integer.parseInt(ctx.CUBIC_DEPTH().getText()));
        }
    }

    private class CubicCommReader extends CubicBaseVisitor<Commutator> {
        private CubicAlgorithmReader algorithmReader;

        public CubicCommReader(CubicAlgorithmReader algorithmReader) {
            this.algorithmReader = algorithmReader;
        }

        @Override
        public Commutator visitCubicPureComm(CubicParser.CubicPureCommContext ctx) {
            Algorithm partA = this.algorithmReader.visit(ctx.cubic(0));
            Algorithm partB = this.algorithmReader.visit(ctx.cubic(1));
            return new PureComm(partA, partB);
        }

        @Override
        public Commutator visitCubicSetupComm(CubicParser.CubicSetupCommContext ctx) {
            Algorithm partA = this.algorithmReader.visit(ctx.cubic(0));
            Algorithm partB = this.algorithmReader.visit(ctx.cubic(1));
            return new SetupComm(partA, partB);
        }
    }

    private CubicMoveReader moveReader;
    private CubicCommReader commReader;

    public CubicAlgorithmReader() {
        this.moveReader = new CubicMoveReader();
        this.commReader = new CubicCommReader(this);
    }

    @Override
    public SimpleAlg visitCubicAlg(CubicParser.CubicAlgContext ctx) {
        CubicMove[] moves = new CubicMove[ctx.cubicMove().size()];
        for (int i = 0; i < moves.length; i++) moves[i] = this.moveReader.visit(ctx.cubicMove(i));
        return new SimpleAlg(moves);
    }

    @Override
    public Commutator visitCubicComm(CubicParser.CubicCommContext ctx) {
        return this.commReader.visit(ctx);
    }
}
