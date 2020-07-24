package br.com.zup.gps.integration

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.sql.ResultSet

@ExtendWith(MockitoExtension::class)
class PointOfInterestRowMapperTest {

    private val rs: ResultSet = Mockito.mock(ResultSet::class.java)

    private val rowMapper = PointOfInterestRowMapper()

    @Test
    fun `Should map to Point of Interest`() {
        Mockito.`when`(rs.getString("name")).thenReturn("POI")
        Mockito.`when`(rs.getInt("x_coord")).thenReturn(1)
        Mockito.`when`(rs.getInt("y_coord")).thenReturn(2)

        val pointOfInterest = rowMapper.mapRow(rs, 1)

        Assertions.assertEquals("POI", pointOfInterest?.name)
        Assertions.assertEquals(1, pointOfInterest?.xCoord)
        Assertions.assertEquals(2, pointOfInterest?.yCoord)
    }
}