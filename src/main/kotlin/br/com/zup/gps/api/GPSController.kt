package br.com.zup.gps.api
import br.com.zup.gps.application.poi.CreatePointOfInterestInteractor
import br.com.zup.gps.application.poi.ListAllPointsOfInterestInteractor
import br.com.zup.gps.application.poi.ListNearPointsOfInterestInteractor
import br.com.zup.gps.application.poi.request.CreatePointOfInterestRequest
import br.com.zup.gps.domain.PointOfInterest
import org.springframework.web.bind.annotation.*

@RequestMapping("api/geoloc")
@RestController
class GPSController (
        private val createPointOfInterestInteractor: CreatePointOfInterestInteractor,
        private val findAllPointsOfInterestInteractor: ListAllPointsOfInterestInteractor,
        private val findNearPointsOfInterestInteractor: ListNearPointsOfInterestInteractor
) {

    @PostMapping("/{name}")
    fun createPointOfInterest(
            @PathVariable("name") name: String,
            @RequestBody request: CreatePointOfInterestRequest) {
        createPointOfInterestInteractor.execute(name, request)
    }

    @GetMapping
    fun listAllPointsOfInterest() : List<PointOfInterest> {
         return findAllPointsOfInterestInteractor.execute()
    }

    @GetMapping("/near")
    fun listNearPointsOfInterest(@RequestParam xCoord: Int, @RequestParam yCoord: Int,
                                 @RequestParam maxD: Int) : List<PointOfInterest> {
        return findNearPointsOfInterestInteractor.execute(xCoord, yCoord, maxD)
    }
}