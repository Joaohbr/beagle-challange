package br.com.zup.gps.application

import br.com.zup.gps.domain.PointOfInterest
import br.com.zup.gps.domain.PointOfInterestRepository
import br.com.zup.gps.domain.ReferencePoint
import org.springframework.stereotype.Component

@Component
open class PointOfInterestServiceImpl(
        private val pointOfInterestRepository: PointOfInterestRepository
) : PointOfInterestService {

    override fun existsPointOfInterest(name: String): Boolean {
        return when (pointOfInterestRepository.findPointOfInterest(name)) {
            null -> false
            else -> true
        }
    }

    override fun insertPointOfInterest(pointOfInterest: PointOfInterest) {
        pointOfInterestRepository.insertPointOfInterest(pointOfInterest)
    }

    override fun listAllPointsOfInterest() : List<PointOfInterest> {
        return pointOfInterestRepository.listAllPointsOfInterest()
    }

    override fun listNearPointsOfInterest(rp: ReferencePoint) : List<PointOfInterest> {
        return pointOfInterestRepository.listNearPointsOfInterest(rp)
    }
}