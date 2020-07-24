package br.com.zup.gps.application.poi

import br.com.zup.gps.domain.PointOfInterest

interface ListNearPointsOfInterestInteractor {
    fun execute(xCoord : Int, yCoord: Int, maxD: Int): List<PointOfInterest>
}