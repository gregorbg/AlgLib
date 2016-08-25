package com.suushiemaniac.cubing.alglib.lang;

import com.suushiemaniac.cubing.alglib.alg.Algorithm;
import com.suushiemaniac.cubing.alglib.alg.SimpleAlg;
import com.suushiemaniac.cubing.alglib.alg.commutator.Commutator;
import com.suushiemaniac.cubing.alglib.alg.commutator.PureComm;
import com.suushiemaniac.cubing.alglib.alg.commutator.SetupComm;
import com.suushiemaniac.cubing.alglib.lang.antlr.megaminx.MegaminxBaseVisitor;
import com.suushiemaniac.cubing.alglib.lang.antlr.megaminx.MegaminxLexer;
import com.suushiemaniac.cubing.alglib.lang.antlr.megaminx.MegaminxParser;
import com.suushiemaniac.cubing.alglib.move.MegaminxMove;
import com.suushiemaniac.cubing.alglib.move.modifier.MegaminxUpModifier;
import com.suushiemaniac.cubing.alglib.move.modifier.MegaminxWideModifier;
import com.suushiemaniac.cubing.alglib.move.plane.MegaminxUpPlane;
import com.suushiemaniac.cubing.alglib.move.plane.MegaminxWidePlane;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MegaminxAlgorithmReader extends MegaminxBaseVisitor<Algorithm> implements NotationReader {
    @Override
    public Algorithm parse(String input) {
        InvalidNotationErrorListener errorListener = new InvalidNotationErrorListener(input);
        MegaminxLexer lexer = new MegaminxLexer(new ANTLRInputStream(input));
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MegaminxParser parser = new MegaminxParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        ParseTree tree = parser.megaminx();
        return this.visit(tree);
    }

    private class MegaminxMoveReader extends MegaminxBaseVisitor<MegaminxMove> {
        @Override
        public MegaminxMove visitGripMegaminx(MegaminxParser.GripMegaminxContext ctx) {
            MegaminxWidePlane plane = MegaminxWidePlane.fromNotation(ctx.MEGAMINX_WIDE_PLANE().getText());
            MegaminxWideModifier modifier = MegaminxWideModifier.fromNotation(ctx.MEGAMINX_WIDE_MODIFIER().getText());
            return new MegaminxMove(plane, modifier);
        }

        @Override
        public MegaminxMove visitUMegaminx(MegaminxParser.UMegaminxContext ctx) {
            MegaminxUpPlane plane = MegaminxUpPlane.fromNotation(ctx.MEGAMINX_U_PLANE().getText());
            MegaminxUpModifier modifier = MegaminxUpModifier.fromNotation(ctx.MEGAMINX_U_MODIFIER().getText());
            return new MegaminxMove(plane, modifier);
        }
    }

    private class MegaminxCommReader extends MegaminxBaseVisitor<Commutator> {
        private MegaminxAlgorithmReader algorithmReader;

        public MegaminxCommReader(MegaminxAlgorithmReader algorithmReader) {
            this.algorithmReader = algorithmReader;
        }

        @Override
        public Commutator visitMegaminxPureComm(MegaminxParser.MegaminxPureCommContext ctx) {
            Algorithm partA = this.algorithmReader.visit(ctx.megaminxAlg(0));
            Algorithm partB = this.algorithmReader.visit(ctx.megaminxAlg(1));
            return new PureComm(partA, partB);
        }

        @Override
        public Commutator visitMegaminxSetupComm(MegaminxParser.MegaminxSetupCommContext ctx) {
            Algorithm partA = this.algorithmReader.visit(ctx.megaminxAlg(0));
            Algorithm partB = this.algorithmReader.visit(ctx.megaminxAlg(1));
            return new SetupComm(partA, partB);
        }
    }

    private MegaminxMoveReader moveReader;
    private MegaminxCommReader commReader;

    public MegaminxAlgorithmReader() {
        this.moveReader = new MegaminxMoveReader();
        this.commReader = new MegaminxCommReader(this);
    }

    @Override
    public Algorithm visitMegaminx(MegaminxParser.MegaminxContext ctx) {
        return ctx.megaminxAlg() != null ? this.visit(ctx.megaminxAlg()) : new SimpleAlg();
    }

    @Override
    public SimpleAlg visitMegaminxSimple(MegaminxParser.MegaminxSimpleContext ctx) {
        MegaminxMove[] moves = new MegaminxMove[ctx.megaminxMove().size()];
        for (int i = 0; i < moves.length; i++) moves[i] = this.moveReader.visit(ctx.megaminxMove(i));
        return new SimpleAlg(moves);
    }

    @Override
    public Commutator visitMegaminxComm(MegaminxParser.MegaminxCommContext ctx) {
        return this.commReader.visit(ctx);
    }
}
