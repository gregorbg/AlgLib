package com.suushiemaniac.cubing.alglib.lang

import com.suushiemaniac.cubing.alglib.alg.Algorithm
import com.suushiemaniac.cubing.alglib.alg.SimpleAlg
import com.suushiemaniac.cubing.alglib.move.ImageLetterMove
import com.suushiemaniac.cubing.alglib.move.plane.ImageLetterPlane

class ImageStringReader : NotationReader {
    override fun parse(input: String): Algorithm {
        val moves = input.toCharArray().map(::ImageLetterPlane).map(::ImageLetterMove)

        return SimpleAlg(moves, "")
    }
}
