package com.codegence.DWClient.resources;

import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codegence.DWClient.dto.Action;
import com.codegence.DWClient.dto.Construct;
import com.yammer.metrics.annotation.Timed;

@Path("/sectors/{sectorId}/factions/{factionId}/terminators/{id}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TerminatorResource {

    final static Logger logger = LoggerFactory.getLogger(TerminatorResource.class);

    @POST
    @Timed
    public Action handleBorn(@PathParam("sectorId") Integer sectorId, @PathParam("factionId") Integer factionId,
                             @PathParam("id") Integer id, Construct construct) {
        Action action = new Action();
        action.setCommand(Commands.advance);
        action.setValue(5);
        return action;
    }

    @PUT
    @Timed
    public Action handleEvent(@PathParam("sectorId") Integer sectorId, @PathParam("factionId") Integer factionId,
                              @PathParam("id") Integer id, Construct construct) {
        Action action = new Action();
        float r = new Random().nextFloat();
        if(r < 0.5) {
            action.setCommand(Commands.advance);
            action.setValue(5);
        } else { 
        	if(r < 0.6) {
	            action.setCommand(Commands.rotate);
	            action.setValue((float)Math.PI / 8);
	        } else {
	            action.setCommand(Commands.fire);
	            action.setValue(0);
	        }
        }
        return action;
    }

    @DELETE
    @Timed
    public void handleLost(@PathParam("sectorId") Integer sectorId, @PathParam("id") Integer id, Construct construct) {
    }
}
