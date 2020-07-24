package br.com.zup.gps.application.poi.request

import br.com.zup.gps.domain.PointOfInterest

data class CreatePointOfInterestRequest(val xCoord: Int, val yCoord: Int) {
    fun toDomain(name: String) = PointOfInterest(
            name = name,
            xCoord = xCoord,
            yCoord = yCoord
    )
}