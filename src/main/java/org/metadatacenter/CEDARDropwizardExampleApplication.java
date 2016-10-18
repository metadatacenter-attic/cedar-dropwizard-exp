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
    // TODO: application initialization
  }

  @Override public void run(final CEDARDropwizardExampleConfiguration configuration, final Environment environment)
  {
    final CEDARDropwizardExampleResource resource = new CEDARDropwizardExampleResource(configuration.getTemplate(),
      configuration.getDefaultName());
    environment.jersey().register(resource);

    final CEDARDropwizardExampleHealthCheck healthCheck = new CEDARDropwizardExampleHealthCheck(
      configuration.getTemplate());
    environment.healthChecks().register("template", healthCheck);
    environment.jersey().register(resource);
  }
}
