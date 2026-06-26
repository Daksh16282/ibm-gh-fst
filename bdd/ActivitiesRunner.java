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
// @ConfigurationParameter(
//   key = Constants.FILTER_TAGS_PROPERTY_NAME,
//   value = "@activity1")    
// @ConfigurationParameter(
//   key = Constants.FILTER_TAGS_PROPERTY_NAME,
//   value = "@activity2")  
// @ConfigurationParameter(
//   key = Constants.FILTER_TAGS_PROPERTY_NAME,
//   value = "@activity3")  
// @ConfigurationParameter(
//   key = Constants.FILTER_TAGS_PROPERTY_NAME,
//   value = "@activity4")  
// @ConfigurationParameter(
//   key = Constants.FILTER_TAGS_PROPERTY_NAME,
//   value = "@activity5")
@ConfigurationParameter(
  key = Constants.FILTER_TAGS_PROPERTY_NAME,
  value = "@activity6")
public class ActivitiesRunner {}
