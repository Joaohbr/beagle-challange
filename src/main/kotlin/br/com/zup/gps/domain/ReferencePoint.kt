package br.com.zup.gps.domain

import java.lang.IllegalArgumentException

data class ReferencePoint(val xCoord: Int, val yCoord: Int, val maxD: Int) {
    init {
        if(xCoord < 0) throw IllegalArgumentException("xCoord is less then 0")
        if(yCoord < 0) throw IllegalArgumentException("xCoord is less then 0")
        if(maxD < 0) throw IllegalArgumentException("maxD is less then 0")
    }
}