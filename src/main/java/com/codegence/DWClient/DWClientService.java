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

package com.codegence.DWClient;

import com.codegence.DWClient.healthchecks.MainHealthCheck;
import com.codegence.DWClient.resources.DroneResource;
import com.codegence.DWClient.resources.MainResource;
import com.codegence.DWClient.resources.RecyclerResource;
import com.codegence.DWClient.resources.TerminatorResource;
import com.sun.jersey.api.container.filter.LoggingFilter;
import com.sun.jersey.api.core.ResourceConfig;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class DWClientService extends Service<DWClientConfiguration> {
    public static void main(String[] args) throws Exception {
    	if(args.length == 0) {
    		String[] defaultArgs = { "server" };
    		args = defaultArgs;
    	}
    		
        new DWClientService().run(args);
    }

    @Override
    public void initialize(Bootstrap<DWClientConfiguration> bootstrap) {
        bootstrap.setName("DWClient");
    }

    @Override
    public void run(DWClientConfiguration configuration, Environment environment) {
        environment.setJerseyProperty(ResourceConfig.PROPERTY_CONTAINER_REQUEST_FILTERS, LoggingFilter.class.getName());
        environment.setJerseyProperty(ResourceConfig.PROPERTY_CONTAINER_RESPONSE_FILTERS, LoggingFilter.class.getName());

        environment.addResource(new MainResource());
        environment.addResource(new RecyclerResource());
        environment.addResource(new DroneResource());
        environment.addResource(new TerminatorResource());
        environment.addHealthCheck(new MainHealthCheck());
    }
}
