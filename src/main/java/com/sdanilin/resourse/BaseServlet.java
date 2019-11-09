package com.sdanilin.resourse;

import com.sdanilin.services.BaseService;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/base")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BaseServlet {
    @Inject
    private Logger logger;

    @Inject
    private BaseService service;

    @PUT
    @Path("/putValue/{key}/{value}")
    public Response putValue(@PathParam("key") String key, @PathParam("value") String value){
        logger.info("putValue");
        service.putValue(key, value);
        return Response.ok().build();
    }

    @GET
    @Path("/getValue/{key}")
    public Response getValue(@PathParam("key") String key){
        logger.info("getValue");

        return Response.ok(service.getValue(key)).build();
    }

    @DELETE
    @Path("/deleteValue/{key}")
    public Response deleteValue(@PathParam("key") String key){
        logger.info("deleteCases");
        service.deleteValue(key);

        return Response.ok().build();
    }
}
