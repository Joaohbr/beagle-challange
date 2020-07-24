package br.com.zup.gps.domain

interface PointOfInterestRepository {

    fun insertPointOfInterest(pointOfInterest: PointOfInterest)

    fun findPointOfInterest(name: String): PointOfInterest?

    fun listAllPointsOfInterest(): List<PointOfInterest>

    fun listNearPointsOfInterest(referencePoint: ReferencePoint): List<PointOfInterest>
}