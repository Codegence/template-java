package com.codegence.DWClient.healthchecks;

import com.codegence.DWClient.resources.MainResource;
import com.yammer.metrics.core.HealthCheck;

public class MainHealthCheck extends HealthCheck {
    public MainHealthCheck() {
        super("Welcome Message");
    }

    @Override
    protected Result check() throws Exception {
        MainResource mainResource = new MainResource();
        final String answer = mainResource.handleWelcome();
        if (!answer.equals(mainResource.welcomeMsg)) {
            return Result.unhealthy("Wrong answer.");
        }
        return Result.healthy();
    }
}