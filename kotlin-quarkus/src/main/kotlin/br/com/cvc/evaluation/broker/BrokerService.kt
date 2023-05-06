package br.com.cvc.evaluation.broker

import br.com.cvc.evaluation.broker.dto.BrokerHotel
import jakarta.enterprise.context.ApplicationScoped
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient

@Path("/hotels")
@ApplicationScoped
@RegisterRestClient
interface BrokerService {
    @GET
    @Path("/avail/{codeCity}")
    fun findHotelsByCity(@PathParam("codeCity") codeCity: Int): Set<BrokerHotel>

    @GET
    @Path("/{codeHotel}")
    fun getHotelDetails(@PathParam("codeHotel") codeHotel: Int): BrokerHotel
}