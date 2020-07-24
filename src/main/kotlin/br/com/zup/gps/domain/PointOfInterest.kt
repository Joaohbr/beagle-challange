package br.com.zup.gps.domain

import java.lang.IllegalArgumentException

data class PointOfInterest(val name: String, val xCoord: Int, val yCoord: Int) {
    init {
        if(xCoord < 0) throw IllegalArgumentException("xCoord is less then 0")
        if(yCoord < 0) throw IllegalArgumentException("xCoord is less then 0")
    }
}