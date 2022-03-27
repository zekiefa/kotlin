package br.com.cvc.evaluation.broker

import br.com.cvc.evaluation.broker.dto.BrokerHotel
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam

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