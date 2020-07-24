package br.com.zup.gps.application.poi.impl

import br.com.zup.gps.application.PointOfInterestService
import br.com.zup.gps.application.poi.ListAllPointsOfInterestInteractor
import br.com.zup.gps.domain.PointOfInterest
import org.springframework.stereotype.Component


@Component
class ListAllPointsOfInterestInteractorImpl(
        private val pointOfInterestService: PointOfInterestService
): ListAllPointsOfInterestInteractor {

    override fun execute(): List<PointOfInterest> {
        return pointOfInterestService.listAllPointsOfInterest()
    }

}