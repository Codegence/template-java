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
