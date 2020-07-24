package br.com.zup.gps.application.poi.impl

import br.com.zup.gps.application.BusinessException
import br.com.zup.gps.application.poi.CreatePointOfInterestInteractor
import br.com.zup.gps.application.PointOfInterestService
import br.com.zup.gps.application.poi.request.CreatePointOfInterestRequest
import org.springframework.stereotype.Component

@Component
open class CreatePointOfInterestInteractorImpl(
        private val pointOfInterestService: PointOfInterestService
) : CreatePointOfInterestInteractor {

    override fun execute(name: String, request: CreatePointOfInterestRequest) {
        if (pointOfInterestService.existsPointOfInterest(name)) {
            throw BusinessException("'$name' already exists")
        }
        pointOfInterestService.insertPointOfInterest(request.toDomain(name))
    }
}