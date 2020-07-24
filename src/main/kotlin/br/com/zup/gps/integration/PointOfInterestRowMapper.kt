package br.com.zup.gps.integration

import br.com.zup.gps.domain.PointOfInterest
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class PointOfInterestRowMapper : RowMapper<PointOfInterest> {
    override fun mapRow(rs: ResultSet, rowNum: Int): PointOfInterest? {
        return PointOfInterest(
                rs.getString("name"),
                rs.getInt("x_coord"),
                rs.getInt("y_coord")
        )
    }
}