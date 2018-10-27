grammar Megaminx;

megaminx: megaminxAlg | EOF;

megaminxAlg: megaminxSimple | megaminxComm;

megaminxSimple: megaminxMove+;

megaminxMove: gripMegaminx
           | uMegaminx;
gripMegaminx: MEGAMINX_WIDE_PLANE MEGAMINX_WIDE_MODIFIER;
uMegaminx: MEGAMINX_U_PLANE MEGAMINX_U_MODIFIER?;

megaminxComm: megaminxPureComm | megaminxSetupComm;

megaminxPureComm: COMM_BR_OPEN megaminxAlg COMM_COMMA megaminxAlg COMM_BR_CLOSE;

megaminxSetupComm: COMM_BR_OPEN megaminxAlg COMM_SEMI_COLON megaminxAlg COMM_BR_CLOSE;

MEGAMINX_WIDE_PLANE: [RD];
MEGAMINX_WIDE_MODIFIER: '++' | '--';
MEGAMINX_U_PLANE: 'U';
MEGAMINX_U_MODIFIER: '\'';

COMM_BR_OPEN: '[';
COMM_COMMA: ',';
COMM_BR_CLOSE: ']';
COMM_SEMI_COLON: [;:];

WHITESPACE: [ \t\n] -> skip;