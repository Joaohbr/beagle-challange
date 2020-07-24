package br.com.zup.gps.application.poi.impl;

import br.com.zup.gps.application.PointOfInterestService
import br.com.zup.gps.application.poi.ListNearPointsOfInterestInteractor
import br.com.zup.gps.domain.PointOfInterest
import br.com.zup.gps.domain.ReferencePoint
import org.springframework.stereotype.Component

@Component
class ListNearPointsOfInterestInteractorImpl(
        private val pointOfInterestService: PointOfInterestService
) : ListNearPointsOfInterestInteractor {

    override fun execute(xCoord: Int, yCoord: Int, maxD: Int): List<PointOfInterest> {
        return pointOfInterestService.listNearPointsOfInterest(ReferencePoint(xCoord, yCoord, maxD))
    }
}
