package br.com.zup.gps.integration

import br.com.zup.gps.domain.PointOfInterest
import br.com.zup.gps.domain.PointOfInterestRepository
import br.com.zup.gps.domain.ReferencePoint
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component

@Component
class JdbcPointOfInterestRepository(
        private val jdbcTemplate: JdbcTemplate
): PointOfInterestRepository {

    private val insertPoiSql = "INSERT INTO point_of_interest VALUES (?, ?, ?)"
    private val findPoiSql = "SELECT * FROM point_of_interest where point_of_interest.name = ?"
    private val listAllPoiSql = "SELECT * FROM point_of_interest"
    private val listNearPoiSql = "SELECT * FROM point_of_interest " +
            "WHERE |/((x_coord - ?)^2 + (y_coord -?)^2) < ?"


    override fun insertPointOfInterest(pointOfInterest: PointOfInterest) {
        jdbcTemplate.update(
                this.insertPoiSql,
                pointOfInterest.name,
                pointOfInterest.xCoord,
                pointOfInterest.yCoord
        )
    }

    override fun findPointOfInterest(name: String): PointOfInterest? {
        val result = jdbcTemplate.query(this.findPoiSql, PointOfInterestRowMapper(), name)
        return when {
            result.isEmpty() -> null
            else -> result[0]
        }
    }

    override fun listAllPointsOfInterest() : List<PointOfInterest> {
        return jdbcTemplate.query(this.listAllPoiSql, PointOfInterestRowMapper())
    }

    override fun listNearPointsOfInterest(rp: ReferencePoint) : List<PointOfInterest> {
        return jdbcTemplate.query(this.listNearPoiSql, PointOfInterestRowMapper(), rp.xCoord, rp.yCoord, rp.maxD)
    }

}