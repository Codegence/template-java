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
