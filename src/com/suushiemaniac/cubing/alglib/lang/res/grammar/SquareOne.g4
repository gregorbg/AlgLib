grammar SquareOne;

squareOne: squareOneAlg | EOF;

squareOneAlg: squareOneSimple | squareOneComm;

squareOneSimple: squareOneBeginSlash? squareOneMoveSlash* squareOneModifier SQUARE_ONE_SLASH?;

squareOneBeginSlash: SQUARE_ONE_SLASH;
squareOneMoveSlash: squareOneModifier SQUARE_ONE_SLASH;
squareOneModifier: SQUARE_ONE_BR_OPEN squareOneFaceTurn SQUARE_ONE_COMMA squareOneFaceTurn SQUARE_ONE_BR_CLOSE;
squareOneFaceTurn: SQUARE_ONE_PLANE_ZERO
                 | (SQUARE_ONE_DIRECTION_MODIFIER? SQUARE_ONE_PLANE_POS);

squareOneComm: squareOnePureComm | squareOneSetupComm;

squareOnePureComm: COMM_BR_OPEN squareOneAlg COMM_COMMA squareOneAlg COMM_BR_CLOSE;

squareOneSetupComm: COMM_BR_OPEN squareOneAlg COMM_SEMI_COLON squareOneAlg COMM_BR_CLOSE;

SQUARE_ONE_SLASH: '/';
SQUARE_ONE_BR_OPEN: '(';
SQUARE_ONE_PLANE_ZERO: '0';
SQUARE_ONE_COMMA: ',';
SQUARE_ONE_BR_CLOSE: ')';
SQUARE_ONE_PLANE_POS: [1-6];
SQUARE_ONE_DIRECTION_MODIFIER: '-';

COMM_BR_OPEN: '[';
COMM_COMMA: ',';
COMM_BR_CLOSE: ']';
COMM_SEMI_COLON: [;:];

WHITESPACE: [ \t\n] -> skip;