package br.com.cvc.evaluation.endpoint

import br.com.cvc.evaluation.domain.Hotel
import br.com.cvc.evaluation.service.BookingService
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam

@Path("/hotels")
class HotelEndpoint @Inject constructor(val service: BookingService) {
    @GET
    @Path("/{id}")
    fun find(@PathParam("id") id: Int): Hotel? {
        return service.getHotelDetails(id)
    }
}