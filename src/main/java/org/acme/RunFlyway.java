package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.flywaydb.core.Flyway;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class RunFlyway {

    @ConfigProperty(name = "myapp.flyway.migrate")
    boolean runMigration;

    @ConfigProperty(name = "quarkus.datasource.reactive.url")
    String datasourceUrl;
    @ConfigProperty(name = "quarkus.datasource.username")
    String datasourceUsername;
    @ConfigProperty(name = "quarkus.datasource.password")
    String datasourcePassword;

    public void runFlywayMigration(@Observes StartupEvent event) {
        if (runMigration) {
            Flyway flyway = Flyway.configure().dataSource("jdbc:" + datasourceUrl, datasourceUsername, datasourcePassword).load();
            flyway.migrate();
        }
    }    
    
}
