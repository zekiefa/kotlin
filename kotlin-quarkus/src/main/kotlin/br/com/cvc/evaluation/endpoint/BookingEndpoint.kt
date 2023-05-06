package br.com.cvc.evaluation.endpoint

import br.com.cvc.evaluation.domain.Hotel
import br.com.cvc.evaluation.service.BookingService
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Path("/api/v1/booking")
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