grammar Cubic;

cubic: cubicAlg | cubicComm;

cubicAlg: cubicMove+;

cubicMove: singleDepthCubic
         | nDepthCubic
         | outerSliceCubic
         | centralSliceCubic;

singleDepthCubic: CUBIC_PLANE CUBIC_MODIFIER?;
nDepthCubic: CUBIC_DEPTH? CUBIC_PLANE CUBIC_WIDE CUBIC_MODIFIER?;
centralSliceCubic: CUBIC_CENTRAL_SLICE CUBIC_MODIFIER?;
outerSliceCubic: (CUBIC_DEPTH | CUBIC_MODIFIER_DOUBLE)? CUBIC_OUTER_SLICE CUBIC_MODIFIER?;

cubicComm: cubicPureComm | cubicSetupComm;

cubicPureComm: COMM_BR_OPEN cubic COMM_COMMA cubic COMM_BR_CLOSE;

cubicSetupComm: COMM_BR_OPEN cubic COMM_SEMI_COLON cubic COMM_BR_CLOSE;

CUBIC_PLANE: [UDLRFBxyz];
CUBIC_OUTER_SLICE: [udlrfb];
CUBIC_CENTRAL_SLICE: [MSE];
CUBIC_MODIFIER: CUBIC_MODIFIER_CCW | CUBIC_MODIFIER_DOUBLE;
CUBIC_MODIFIER_CCW: '\'';
CUBIC_MODIFIER_DOUBLE: '2';
CUBIC_WIDE: 'w';
CUBIC_DEPTH: [3-9] | ([1-9][0-9]+);

COMM_BR_OPEN: '[';
COMM_COMMA: ',';
COMM_BR_CLOSE: ']';
COMM_SEMI_COLON: [;:];

WHITESPACE: [ \t\n] -> skip;