grammar Cubic;

cubic: cubicAlg | EOF;

cubicAlg: cubicSimple | cubicComm;

cubicSimple: cubicMove+;

cubicMove: singleDepthCubic
         | nDepthCubic
         | outerSliceCubic;

singleDepthCubic: singleDepthHelper cubicModifier;
nDepthCubic: CUBIC_DEPTH? CUBIC_PLANE CUBIC_WIDE cubicModifier;
outerSliceCubic: outerDepthHelper? CUBIC_OUTER_SLICE cubicModifier;

singleDepthHelper: CUBIC_PLANE | CUBIC_CENTRAL_SLICE;
outerDepthHelper: CUBIC_MODIFIER_DOUBLE | CUBIC_DEPTH;

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