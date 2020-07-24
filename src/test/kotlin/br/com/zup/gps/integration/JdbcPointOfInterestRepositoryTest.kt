package br.com.zup.gps.integration

import br.com.zup.gps.domain.PointOfInterest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.internal.verification.VerificationModeFactory.times
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.jdbc.core.JdbcTemplate

@ExtendWith(MockitoExtension::class)
class JdbcPointOfInterestRepositoryTest {

    private val jdbcTemplate: JdbcTemplate = Mockito.mock(JdbcTemplate::class.java)

    private val pointOfInterestRepository = JdbcPointOfInterestRepository(jdbcTemplate)

    @Test
    fun `Should find Point of Interest`() {
        Mockito.`when`(
                jdbcTemplate
                        .query(eq("SELECT * FROM point_of_interest where point_of_interest.name = ?"),
                                any(PointOfInterestRowMapper::class.java),
                                eq("POI")
                        )
        ).thenReturn(
                listOf(PointOfInterest("POI", 1, 2))
        )

        val response = pointOfInterestRepository.findPointOfInterest("POI")

        Assertions.assertEquals("POI", response?.name)
        Assertions.assertEquals(1, response?.xCoord)
        Assertions.assertEquals(2, response?.yCoord)

        verify(jdbcTemplate, times(1))
                .query(eq("SELECT * FROM point_of_interest where point_of_interest.name = ?"),
                        any(PointOfInterestRowMapper::class.java),
                        eq("POI"))
    }

    @Test
    fun `Should fail to find Point of Interest`() {
        Mockito.`when`(
                jdbcTemplate
                        .query(eq("SELECT * FROM point_of_interest where point_of_interest.name = ?"),
                                any(PointOfInterestRowMapper::class.java),
                                eq("POI")
                        )
        ).thenReturn(emptyList())

        val response = pointOfInterestRepository.findPointOfInterest("POI")

        Assertions.assertNull(response)

        verify(jdbcTemplate, times(1))
                .query(eq("SELECT * FROM point_of_interest where point_of_interest.name = ?"),
                        any(PointOfInterestRowMapper::class.java),
                        eq("POI"))
    }

    @Test
    fun `Should create Point of Interest`() {
        pointOfInterestRepository.insertPointOfInterest(PointOfInterest("POI", 1, 2))
        verify(jdbcTemplate, times(1))
                .update("INSERT INTO point_of_interest VALUES (?, ?, ?)", "POI", 1, 2)
    }

    @Test
    fun `Should list All Points of Interest`() {
        pointOfInterestRepository.listAllPointsOfInterest()
        verify(jdbcTemplate, times(1))
                .query(eq("SELECT * FROM point_of_interest"), any(PointOfInterestRowMapper::class.java))
    }

    @Test
    fun `Failed to create Point of Interest`() {
        pointOfInterestRepository.insertPointOfInterest(PointOfInterest("POI", 1, 2))
        verify(jdbcTemplate, times(1))
                .update(eq("INSERT INTO point_of_interest VALUES (?, ?, ?)"), eq("POI"), eq(1), eq(2))
    }
}