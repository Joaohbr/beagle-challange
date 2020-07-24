package br.com.zup.gps.application.poi

import br.com.zup.gps.application.poi.request.CreatePointOfInterestRequest

interface CreatePointOfInterestInteractor {
    fun execute(name: String, request: CreatePointOfInterestRequest)
}