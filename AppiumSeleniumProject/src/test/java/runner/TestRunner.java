package runner;


import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(features={"src//test//java//featurefiles"}
					,glue={"stepdefinitioncode"}
					,plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}	
					,tags= "@mobile"
					,monochrome=true
		
		)
@Test
public class TestRunner extends AbstractTestNGCucumberTests  {
	
	
	
	

}
