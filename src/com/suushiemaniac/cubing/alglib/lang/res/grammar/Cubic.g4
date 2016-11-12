grammar Cubic;

cubic: cubicAlg | EOF;

cubicAlg: cubicSimple | cubicComm;

cubicSimple: cubicMove+;

cubicMove: singleDepthCubic
         | nDepthCubic
         | outerSliceCubic
         | centralSliceCubic;

singleDepthCubic: CUBIC_PLANE cubicModifier;
nDepthCubic: CUBIC_DEPTH? CUBIC_PLANE CUBIC_WIDE cubicModifier;
centralSliceCubic: CUBIC_CENTRAL_SLICE cubicModifier;
outerSliceCubic: (CUBIC_DEPTH | CUBIC_MODIFIER_DOUBLE)? CUBIC_OUTER_SLICE cubicModifier;

cubicModifier: CUBIC_MODIFIER_CCW | CUBIC_MODIFIER_DOUBLE | ;

cubicComm: cubicPureComm | cubicSetupComm;

cubicPureComm: COMM_BR_OPEN cubicAlg COMM_COMMA cubicAlg COMM_BR_CLOSE;

cubicSetupComm: COMM_BR_OPEN cubicAlg COMM_SEMI_COLON cubicAlg COMM_BR_CLOSE;

CUBIC_PLANE: [UDLRFBxyz];
CUBIC_OUTER_SLICE: [udlrfb];
CUBIC_CENTRAL_SLICE: [MSE];
CUBIC_DEPTH: [3-9] | ([1-9][0-9]+);
CUBIC_MODIFIER_CCW: '\'';
CUBIC_MODIFIER_DOUBLE: '2';
CUBIC_WIDE: 'w';

COMM_BR_OPEN: '[';
COMM_COMMA: ',';
COMM_BR_CLOSE: ']';
COMM_SEMI_COLON: [;:];

WHITESPACE: [ \t\n] -> skip;