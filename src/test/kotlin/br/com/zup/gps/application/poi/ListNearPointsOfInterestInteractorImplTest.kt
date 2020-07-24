package br.com.zup.gps.application.poi

import br.com.zup.gps.application.PointOfInterestServiceImpl
import br.com.zup.gps.application.poi.impl.ListNearPointsOfInterestInteractorImpl
import br.com.zup.gps.domain.PointOfInterest
import br.com.zup.gps.domain.ReferencePoint
import com.nhaarman.mockito_kotlin.doAnswer
import com.nhaarman.mockito_kotlin.mock
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ListNearPointsOfInterestInteractorImplTest {

    @Test
    fun `Should list all nearby points of interest`() {
        val rp = ReferencePoint( 1, 2, 10)
        val list = listOf(PointOfInterest("POI", 1, 2))
        val service = mock<PointOfInterestServiceImpl> {
            on() { listNearPointsOfInterest(rp) } doAnswer {list}
        }
        val interactor = ListNearPointsOfInterestInteractorImpl(service)

        Assertions.assertFalse(interactor.execute(1, 2, 10).isEmpty())
    }

    @Test
    fun `Should be empty`() {
        val rp = ReferencePoint( 1, 2, 10)
        val list = emptyList<PointOfInterest>()
        val service = mock<PointOfInterestServiceImpl> {
            on() { listNearPointsOfInterest(rp) } doAnswer {list}
        }
        val interactor = ListNearPointsOfInterestInteractorImpl(service)

        Assertions.assertTrue(interactor.execute(1, 2, 10).isEmpty())
    }
}