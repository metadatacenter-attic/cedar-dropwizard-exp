package org.metadatacenter;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.metadatacenter.health.CEDARDropwizardExampleHealthCheck;
import org.metadatacenter.resources.CEDARDropwizardExampleResource;

public class CEDARDropwizardExampleApplication extends Application<CEDARDropwizardExampleConfiguration>
{

  public static void main(final String[] args) throws Exception
  {
    new CEDARDropwizardExampleApplication().run(args);
  }

  @Override public String getName()
  {
    return "CEDARDropwizardExample";
  }

  @Override public void initialize(final Bootstrap<CEDARDropwizardExampleConfiguration> bootstrap)
  {
  }

  @Override public void run(final CEDARDropwizardExampleConfiguration configuration, final Environment environment)
  {
    final CEDARDropwizardExampleResource resource = new CEDARDropwizardExampleResource(configuration.getMessage(),
      configuration.getDefaultName());
    environment.jersey().register(resource);

    final CEDARDropwizardExampleHealthCheck healthCheck = new CEDARDropwizardExampleHealthCheck(
      configuration.getMessage());
    environment.healthChecks().register("message", healthCheck);
  }
}
