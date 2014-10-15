package com.codegence.DWClient.resources;

import java.util.Random;

import com.codegence.DWClient.dto.Action;
import com.codegence.DWClient.dto.Construct;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/sectors/{sectorId}/factions/{factionId}/recyclers/{id}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RecyclerResource {

	// TODO: recycler position should be in a map, if you play with several sectors/factions...
    static private float[] recyclerPosition;

    @POST
    @Timed
    public Action handleBorn(@PathParam("sectorId") Integer sectorId, @PathParam("factionId") Integer factionId,
                             @PathParam("id") Integer id, Construct construct) {
    	// save recycler position... if someone want to go home...
        recyclerPosition = construct.getPosition();
        Action action = new Action();
        action.setCommand(Commands.newDrone);
        return action;
    }

    @PUT
    @Timed
    public Action handleEvent(@PathParam("sectorId") Integer sectorId, @PathParam("factionId") Integer factionId,
                              @PathParam("id") Integer id, Construct construct) {
        Action action = new Action();
        float r = new Random().nextFloat();
        if ((construct.getStatus().equals(Status.actioning) || construct.getStatus().equals(Status.dradisContact)) && construct.getResources() >= 70 && r < 0.5)
            action.setCommand(Commands.newTerminator);
        else if ((construct.getStatus().equals(Status.actioning) || construct.getStatus().equals(Status.dradisContact)) && construct.getResources() >= 50)
            action.setCommand(Commands.newDrone);
        else {
            action.setCommand(Commands.sleep);
            action.setValue(30);
        }
        return action;
    }

    @DELETE
    @Timed
    public void handleLost(@PathParam("sectorId") Integer sectorId, @PathParam("factionId") Integer factionId,
                              @PathParam("id") Integer id, Construct construct) {
    }	
    
    public static float[] getRecyclerPosition() {
        return recyclerPosition;
    }
}
