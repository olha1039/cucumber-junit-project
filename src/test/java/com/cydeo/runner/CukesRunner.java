package com.cydeo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features", // where to get the data
        glue = "com/cydeo/step_definitions", // what implementation to run, whatever is under the tag
        dryRun = false,
        tags ="@eating",
        publish = true
)
public class CukesRunner {



}
