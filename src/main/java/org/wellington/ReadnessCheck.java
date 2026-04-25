package org.wellington;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Readiness
public class ReadnessCheck implements HealthCheck {

    @RestClient
    StarWarsService starWarsService;
    @Override
    public HealthCheckResponse call() {

        if (starWarsService.getvehicles().contains(StarWarsService.MESS_ERROR)) {
            return HealthCheckResponse.down("Error");
        }else {
            return HealthCheckResponse.up("ok");
        }
    }
}
