/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zalando.services.restful.service;

import de.zalando.services.models.MessageModel;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author gostendorf
 */
@Path("simple")
@Stateless
public class SimpleRestfulService {

    @POST
    @Path("single")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public MessageModel sayHello(MessageModel input) {
        return new MessageModel("Hello, " + input.getMessage());
    }

    @POST
    @Path("multiple/{count}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
    public List<MessageModel> sayHelloMultipleTimes(MessageModel input, @PathParam("count") int repeatCount) {
        List<MessageModel> result = new ArrayList<MessageModel>();
        for (int i = 0; i < repeatCount; i++) {
            result.add(new MessageModel("Hallo " + input.getMessage()));
        }
        return result;
    }
    
    @GET
    @Path("test")
    @Produces({MediaType.TEXT_PLAIN})
    public String testWS(){
        return "Hallo!";
    }

}
