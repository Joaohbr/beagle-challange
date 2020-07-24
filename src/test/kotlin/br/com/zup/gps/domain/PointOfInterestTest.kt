package br.com.zup.gps.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class PointOfInterestTest {

    @Test
    fun `Failed to create Point of interest negative X`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            PointOfInterest("POI", -1, 0)
        }
        Assertions.assertEquals("xCoord is less then 0", exception.message)
    }

    @Test
    fun `Failed to create Point of interest negative Y`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            PointOfInterest("POI", 0, -1)
        }
        Assertions.assertEquals("xCoord is less then 0", exception.message)
    }

}