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

@Path("/sectors/{sectorId}/factions/{factionId}/drones/{id}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DroneResource {

    final static Logger logger = LoggerFactory.getLogger(DroneResource.class);

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
        action.setValue(r * 10);
        if( r < .5 ) {
        	action.setCommand(Commands.advance);
        } else { 
        	action.setCommand(Commands.rotate);
        }
        return action;
    }
    
    @DELETE
    @Timed
    public void handleLost(@PathParam("sectorId") Integer sectorId, @PathParam("factionId") Integer factionId,
                           @PathParam("id") Integer id, Construct construct) {
    }
}
