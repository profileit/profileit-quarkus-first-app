package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.service.GreetingService;


@Path("/hello")
public class GreetingResource {


	@Inject
	GreetingService saludoService;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return saludoService.greet();
    }
    

}


