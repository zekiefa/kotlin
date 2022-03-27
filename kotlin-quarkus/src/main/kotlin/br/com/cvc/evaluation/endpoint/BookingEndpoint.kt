package br.com.cvc.evaluation.endpoint

import br.com.cvc.evaluation.domain.Hotel
import br.com.cvc.evaluation.service.BookingService
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam

@Path("/booking")
class BookingEndpoint @Inject constructor(val service: BookingService) {
    private val format = "yyyy-MM-dd"

    @GET
    @Path("/{cityCode}/{checkin}/{checkout}/{adults}/{children}")
    fun find(@PathParam("cityCode") cityCode: Int,
             @PathParam("checking")checkin: String,
             @PathParam("checkout")checkout: String,
             @PathParam("adults")adults: Int,
             @PathParam("children")child: Int): List<Hotel>  {
        return this.service.findHotels(cityCode, this.parseDate(checkin), this.parseDate(checkout), adults, child)
    }

    private fun parseDate(date: String):LocalDate {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(format))
    }
}