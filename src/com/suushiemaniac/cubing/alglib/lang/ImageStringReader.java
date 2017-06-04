package com.suushiemaniac.cubing.alglib.lang;

import com.suushiemaniac.cubing.alglib.alg.Algorithm;
import com.suushiemaniac.cubing.alglib.alg.SimpleAlg;
import com.suushiemaniac.cubing.alglib.move.ImageLetterMove;
import com.suushiemaniac.cubing.alglib.move.Move;
import com.suushiemaniac.cubing.alglib.move.plane.ImageLetterPlane;

import java.util.ArrayList;
import java.util.List;

public class ImageStringReader implements NotationReader {
	@Override
	public Algorithm parse(String input) {
		List<Move> moves = new ArrayList<>();

		for (char letter : input.toCharArray()) {
			ImageLetterPlane plane = new ImageLetterPlane(letter);
			moves.add(new ImageLetterMove(plane));
		}

		SimpleAlg stringAlg = new SimpleAlg(moves);
		stringAlg.setFormatDelimiter("");

		return stringAlg;
	}
}
