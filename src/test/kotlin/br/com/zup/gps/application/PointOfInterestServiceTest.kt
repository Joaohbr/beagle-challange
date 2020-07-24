package br.com.zup.gps.application

import br.com.zup.gps.domain.PointOfInterest
import br.com.zup.gps.domain.PointOfInterestRepository
import com.nhaarman.mockito_kotlin.doAnswer
import com.nhaarman.mockito_kotlin.mock
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PointOfInterestServiceTest {

    @Test
    fun `Should exist point of Interest`() {
        val poi =  PointOfInterest("POI", 1, 2)
        val repository = mock<PointOfInterestRepository> {
            on { findPointOfInterest("POI") } doAnswer {poi}
        }
        val service = PointOfInterestServiceImpl(repository)

        Assertions.assertTrue(service.existsPointOfInterest("POI"))
    }

    @Test
    fun `Should not exist point of Interest`() {
        val repository = mock<PointOfInterestRepository> {
            on { findPointOfInterest("POI") } doAnswer {null}
        }
        val service = PointOfInterestServiceImpl(repository)

        Assertions.assertFalse(service.existsPointOfInterest("POI"))
    }

    @Test
    fun `Should insert point of Interest`() {

    }

    @Test
    fun `Should list all points of Interest`() {

    }
}