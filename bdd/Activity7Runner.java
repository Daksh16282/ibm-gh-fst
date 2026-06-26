package testRunner;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectPackages;

import io.cucumber.junit.platform.engine.Constants;	
 
@Suite
@IncludeEngines("cucumber")
@SelectPackages("features")
@ConfigurationParameter(
  key = Constants.GLUE_PROPERTY_NAME,
  value = "stepDefinitions")
  @ConfigurationParameter(
	key = Constants.PLUGIN_PROPERTY_NAME,
	value = "html:test-output/cucumberReports/HTML_Report.html")
@ConfigurationParameter(
  key = Constants.FILTER_TAGS_PROPERTY_NAME,
  value = "@activity1 or @activity2 or @activity3")
public class Activity7Runner {}
