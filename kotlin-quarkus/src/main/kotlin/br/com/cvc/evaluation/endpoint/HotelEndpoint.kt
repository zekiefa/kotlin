package br.com.cvc.evaluation.endpoint

import br.com.cvc.evaluation.domain.Hotel
import br.com.cvc.evaluation.service.BookingService
import jakarta.inject.Inject
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam

@Path("/api/v1/hotels")
class HotelEndpoint @Inject constructor(val service: BookingService) {
    @GET
    @Path("/{id}")
    fun find(@PathParam("id") id: Int): Hotel? {
        return service.getHotelDetails(id)
    }
}