grammar Clock;

clock: clockAlg | clockComm;

clockAlg: clockMove* endPinClock?;

clockMove: turnPinClock
         | rotationClock;
turnPinClock: CLOCK_PLANE_SINGLE CLOCK_NUM_MODIFIER CLOCK_DIRECTION_MODIFIER;
rotationClock: CLOCK_PLANE_ROTATION;
endPinClock: CLOCK_PLANE_SINGLE;

clockComm: clockPureComm | clockSetupComm;

clockPureComm: COMM_BR_OPEN clock COMM_COMMA clock COMM_BR_CLOSE;

clockSetupComm: COMM_BR_OPEN clock COMM_SEMI_COLON clock COMM_BR_CLOSE;

CLOCK_PLANE_SINGLE: 'U' | 'R' | 'D' | 'L' | 'UR' | 'DR' | 'DL' | 'UL' | 'ALL';
CLOCK_NUM_MODIFIER: [0-6];
CLOCK_DIRECTION_MODIFIER: [+-];
CLOCK_PLANE_ROTATION: 'y2';

COMM_BR_OPEN: '[';
COMM_COMMA: ',';
COMM_BR_CLOSE: ']';
COMM_SEMI_COLON: [;:];

WHITESPACE: [ \t\n] -> skip;