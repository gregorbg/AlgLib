package com.suushiemaniac.cubing.alglib.lang

import com.suushiemaniac.cubing.alglib.alg.Algorithm

interface NotationReader {
    fun parse(input: String): Algorithm
}
