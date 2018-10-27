grammar Skewb;

skewb: skewbAlg | EOF;

skewbAlg: skewbSimple | skewbComm;

skewbSimple: skewbMove+;

skewbMove: SKEWB_PLANE SKEWB_MODIFIER?;

skewbComm: skewbPureComm | skewbSetupComm;

skewbPureComm: COMM_BR_OPEN skewbAlg COMM_COMMA skewbAlg COMM_BR_CLOSE;

skewbSetupComm: COMM_BR_OPEN skewbAlg COMM_SEMI_COLON skewbAlg COMM_BR_CLOSE;

SKEWB_PLANE: [UBLR];
SKEWB_MODIFIER: '\'';

COMM_BR_OPEN: '[';
COMM_COMMA: ',';
COMM_BR_CLOSE: ']';
COMM_SEMI_COLON: [;:];

WHITESPACE: [ \t\n] -> skip;