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

import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.HashMap;
import java.util.Map;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MainResource {
    private static final String VERSION = "version";
	public String welcomeMsg = "Drop Wizard client for Codegence.";
    public String version = "1.1.0";

    @GET
    @Timed
    public String handleWelcome() {
        return welcomeMsg;
    }

    @GET
    @Path("info")
    @Timed
    public Map<String, String> handleInfo() {
        Map<String, String> map = new HashMap<String, String>();
        map.put(VERSION, version);
        return map;
    }
}
