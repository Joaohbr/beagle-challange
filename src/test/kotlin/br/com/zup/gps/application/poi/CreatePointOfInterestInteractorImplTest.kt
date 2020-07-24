package br.com.zup.gps.application.poi

import br.com.zup.gps.application.PointOfInterestServiceImpl
import br.com.zup.gps.application.poi.impl.CreatePointOfInterestInteractorImpl
import br.com.zup.gps.application.poi.request.CreatePointOfInterestRequest
import br.com.zup.gps.domain.PointOfInterest
import com.nhaarman.mockito_kotlin.doAnswer
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.jupiter.api.Test

class CreatePointOfInterestInteractorImplTest {

    @Test
    fun `Should create Point of Interest`() {
        val poi = PointOfInterest("POI", 1, 2)
        val request = CreatePointOfInterestRequest(1, 2)
        val service = mock<PointOfInterestServiceImpl> {
            on() { existsPointOfInterest("POI") } doAnswer {false}
            on() { insertPointOfInterest(poi) } doAnswer {}
        }
        val interactor : CreatePointOfInterestInteractorImpl = CreatePointOfInterestInteractorImpl(service)

        interactor.execute("POI", request)

        verify(service).insertPointOfInterest(eq(poi))
    }

    @Test
    fun `Should fail create Point of Interest that already exists`() {
        val poi = PointOfInterest("POI", 1, 2)
        val request = CreatePointOfInterestRequest(1, 2)
        val service = mock<PointOfInterestServiceImpl> {
            on() { insertPointOfInterest(poi) } doAnswer {}
        }
        val interactor : CreatePointOfInterestInteractorImpl = CreatePointOfInterestInteractorImpl(service)

        interactor.execute("POI", request)

        verify(service).insertPointOfInterest(eq(poi))
    }


}