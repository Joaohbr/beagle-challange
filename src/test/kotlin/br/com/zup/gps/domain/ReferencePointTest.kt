package br.com.zup.gps.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ReferencePointTest {

    @Test
    fun `Failed to create reference point negative X`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            ReferencePoint(-1, 0, 0)
        }
        Assertions.assertEquals("xCoord is less then 0", exception.message)
    }

    @Test
    fun `Failed to create reference point negative Y`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            ReferencePoint(0, -1,0)
        }
        Assertions.assertEquals("xCoord is less then 0", exception.message)
    }

    @Test
    fun `Failed to create reference point negative maxD`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            ReferencePoint(0, 0, -1)
        }
        Assertions.assertEquals("maxD is less then 0", exception.message)
    }
}