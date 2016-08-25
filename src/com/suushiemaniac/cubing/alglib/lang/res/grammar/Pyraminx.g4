grammar Pyraminx;

pyraminx: pyraminxAlg | EOF;

pyraminxAlg: pyraminxSimple | pyraminxComm;

pyraminxSimple: pyraminxMove+;

pyraminxMove: pyraminxFullMove | pyraminxTipMove;

pyraminxFullMove: PYRAMINX_FULL_PLANE PYRAMINX_MODIFIER?;
pyraminxTipMove: PYRAMINX_TIP_PLANE PYRAMINX_MODIFIER?;

pyraminxComm: pyraminxPureComm | pyraminxSetupComm;

pyraminxPureComm: COMM_BR_OPEN pyraminxAlg COMM_COMMA pyraminxAlg COMM_BR_CLOSE;

pyraminxSetupComm: COMM_BR_OPEN pyraminxAlg COMM_SEMI_COLON pyraminxAlg COMM_BR_CLOSE;

PYRAMINX_FULL_PLANE: [UBLR];
PYRAMINX_TIP_PLANE: [ublr];
PYRAMINX_MODIFIER: '\'';

COMM_BR_OPEN: '[';
COMM_COMMA: ',';
COMM_BR_CLOSE: ']';
COMM_SEMI_COLON: [;:];

WHITESPACE: [ \t\n] -> skip;

