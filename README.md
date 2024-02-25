# Serenity BDD TodoMVC Demo

This project is a demonstration of how to use Serenity BDD with the Screenplay Pattern to test a web application.

These tests use tasks, questions and page elements defined in `src/main/java/net/serenitybdd/demos/lemu/screenplay`.

The overall project structure is shown below:
````
+ tasks
    Business-level tasks
+ pages
    Page Objects and Page Elements
+ questions
    Objects used to query the application
````

## Running the project

To run the project you'll need JDK 17 and Maven installed.

### Screenplay and Cucumber

The first demo shows the integration of Serenity BDD, Screenplay and Cucumber JVM.
To run it, execute:

```
mvn clean verify
```

## Reporting

The Serenity reports will be generated in the `target/site/serenity` directory.
