# CEDARDropwizardExample

Created from http://www.dropwizard.io/1.0.2/docs/getting-started.html

How to start the CEDARDropwizardExample application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/cedar-dropwizard-exp-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080/hello-world?name=bob`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
