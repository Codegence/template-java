/*
    Copyright (C) 2014  Fernando Farias
    This file is part of Codegence.

    Codegence is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Codegence is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Codegence. If not, see <http://www.gnu.org/licenses/>.
*/

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
