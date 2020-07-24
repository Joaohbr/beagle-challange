package br.com.zup.gps.application.poi

import br.com.zup.gps.application.PointOfInterestServiceImpl
import br.com.zup.gps.application.poi.impl.ListAllPointsOfInterestInteractorImpl
import br.com.zup.gps.domain.PointOfInterest
import com.nhaarman.mockito_kotlin.doAnswer
import com.nhaarman.mockito_kotlin.mock
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ListAllPointsOfInterestInteractorImplTest {

    @Test
    fun `Should list all points of interest`() {
        val list = listOf(PointOfInterest("POI", 1, 2))
        val service = mock<PointOfInterestServiceImpl> {
            on() { listAllPointsOfInterest() } doAnswer {list}
        }
        val interactor = ListAllPointsOfInterestInteractorImpl(service)

        Assertions.assertFalse(interactor.execute().isEmpty())
    }

    @Test
    fun `Should be empty`() {
        val list = emptyList<PointOfInterest>()
        val service = mock<PointOfInterestServiceImpl> {
            on() { listAllPointsOfInterest() } doAnswer {list}
        }
        val interactor = ListAllPointsOfInterestInteractorImpl(service)

        Assertions.assertTrue(interactor.execute().isEmpty())
    }
}