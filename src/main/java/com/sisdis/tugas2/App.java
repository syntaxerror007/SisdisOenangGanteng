package com.sisdis.tugas2;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
/**
 * Created by MartinOenang on 10/1/2015.
 */

public class App extends Application<Tugas2Configuration> {
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public String getName() {
        return "Tugas 2 Sisdis";
    }

    @Override
    public void initialize(Bootstrap<Tugas2Configuration> bootstrap) {

    }

    @Override
    public void run(Tugas2Configuration configuration,
                    Environment environment) {
        final ImageServerResource resource = new ImageServerResource();
        environment.jersey().register(resource);
        final ImageClientResource resourceClient = new ImageClientResource();
        environment.jersey().register(resourceClient);
    }

}