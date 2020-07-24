package br.com.zup.gps.application.poi

import br.com.zup.gps.domain.PointOfInterest

interface ListAllPointsOfInterestInteractor {
    fun execute(): List<PointOfInterest>
}