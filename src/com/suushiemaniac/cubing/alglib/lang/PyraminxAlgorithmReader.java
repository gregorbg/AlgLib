package com.suushiemaniac.cubing.alglib.lang;

import com.suushiemaniac.cubing.alglib.alg.Algorithm;
import com.suushiemaniac.cubing.alglib.alg.SimpleAlg;
import com.suushiemaniac.cubing.alglib.alg.commutator.Commutator;
import com.suushiemaniac.cubing.alglib.alg.commutator.PureComm;
import com.suushiemaniac.cubing.alglib.alg.commutator.SetupComm;
import com.suushiemaniac.cubing.alglib.lang.antlr.pyraminx.PyraminxBaseVisitor;
import com.suushiemaniac.cubing.alglib.lang.antlr.pyraminx.PyraminxLexer;
import com.suushiemaniac.cubing.alglib.lang.antlr.pyraminx.PyraminxParser;
import com.suushiemaniac.cubing.alglib.move.PyraminxMove;
import com.suushiemaniac.cubing.alglib.move.modifier.PyraminxModifier;
import com.suushiemaniac.cubing.alglib.move.plane.PyraminxPlane;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class PyraminxAlgorithmReader extends PyraminxBaseVisitor<Algorithm> implements NotationReader {
    @Override
    public Algorithm parse(String input) {
        InvalidNotationErrorListener errorListener = new InvalidNotationErrorListener(input);
        PyraminxLexer lexer = new PyraminxLexer(new ANTLRInputStream(input));
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PyraminxParser parser = new PyraminxParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        ParseTree tree = parser.pyraminx();
        return this.visit(tree);
    }

    private class PyraminxMoveReader extends PyraminxBaseVisitor<PyraminxMove> {
        @Override
        public PyraminxMove visitPyraminxFullMove(PyraminxParser.PyraminxFullMoveContext ctx) {
            PyraminxPlane plane = PyraminxPlane.fromNotation(ctx.PYRAMINX_FULL_PLANE().getText());
            PyraminxModifier modifier = PyraminxModifier.fromNotation(ctx.PYRAMINX_MODIFIER() == null ? "" : ctx.PYRAMINX_MODIFIER().getText());
            return new PyraminxMove(plane, modifier, 1);
        }

        @Override
        public PyraminxMove visitPyraminxTipMove(PyraminxParser.PyraminxTipMoveContext ctx) {
            PyraminxPlane plane = PyraminxPlane.fromNotation(ctx.PYRAMINX_TIP_PLANE().getText().toUpperCase());
            PyraminxModifier modifier = PyraminxModifier.fromNotation(ctx.PYRAMINX_MODIFIER() == null ? "" : ctx.PYRAMINX_MODIFIER().getText());
            return new PyraminxMove(plane, modifier, 0);
        }
    }

    private class PyraminxCommReader extends PyraminxBaseVisitor<Commutator> {
        private PyraminxAlgorithmReader algorithmReader;

        public PyraminxCommReader(PyraminxAlgorithmReader algorithmReader) {
            this.algorithmReader = algorithmReader;
        }

        @Override
        public Commutator visitPyraminxPureComm(PyraminxParser.PyraminxPureCommContext ctx) {
            Algorithm partA = this.algorithmReader.visit(ctx.pyraminx(0));
            Algorithm partB = this.algorithmReader.visit(ctx.pyraminx(1));
            return new PureComm(partA, partB);
        }

        @Override
        public Commutator visitPyraminxSetupComm(PyraminxParser.PyraminxSetupCommContext ctx) {
            Algorithm partA = this.algorithmReader.visit(ctx.pyraminx(0));
            Algorithm partB = this.algorithmReader.visit(ctx.pyraminx(1));
            return new SetupComm(partA, partB);
        }
    }

    private PyraminxMoveReader moveReader;
    private PyraminxCommReader commReader;

    public PyraminxAlgorithmReader() {
        this.moveReader = new PyraminxMoveReader();
        this.commReader = new PyraminxCommReader(this);
    }

    @Override
    public SimpleAlg visitPyraminxAlg(PyraminxParser.PyraminxAlgContext ctx) {
        PyraminxMove[] moves = new PyraminxMove[ctx.pyraminxMove().size()];
        for (int i = 0; i < moves.length; i++) moves[i] = this.moveReader.visit(ctx.pyraminxMove(i));
        return new SimpleAlg(moves);
    }

    @Override
    public Algorithm visitPyraminxComm(PyraminxParser.PyraminxCommContext ctx) {
        return this.commReader.visit(ctx);
    }
}
