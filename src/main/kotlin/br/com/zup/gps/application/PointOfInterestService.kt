package br.com.zup.gps.application

import br.com.zup.gps.domain.PointOfInterest
import br.com.zup.gps.domain.ReferencePoint

interface PointOfInterestService {
    fun existsPointOfInterest(name: String): Boolean

    fun insertPointOfInterest(pointOfInterest: PointOfInterest)

    fun listAllPointsOfInterest() : List<PointOfInterest>

    fun listNearPointsOfInterest(rp: ReferencePoint) : List<PointOfInterest>
}