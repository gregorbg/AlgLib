grammar Pyraminx;

pyraminx: pyraminxAlg | pyraminxComm;

pyraminxAlg: pyraminxMove+;

pyraminxMove: pyraminxFullMove | pyraminxTipMove;

pyraminxFullMove: PYRAMINX_FULL_PLANE PYRAMINX_MODIFIER?;
pyraminxTipMove: PYRAMINX_TIP_PLANE PYRAMINX_MODIFIER?;

pyraminxComm: pyraminxPureComm | pyraminxSetupComm;

pyraminxPureComm: COMM_BR_OPEN pyraminx COMM_COMMA pyraminx COMM_BR_CLOSE;

pyraminxSetupComm: COMM_BR_OPEN pyraminx COMM_SEMI_COLON pyraminx COMM_BR_CLOSE;

PYRAMINX_FULL_PLANE: [UBLR];
PYRAMINX_TIP_PLANE: [ublr];
PYRAMINX_MODIFIER: '\'';

COMM_BR_OPEN: '[';
COMM_COMMA: ',';
COMM_BR_CLOSE: ']';
COMM_SEMI_COLON: [;:];

WHITESPACE: [ \t\n] -> skip;

