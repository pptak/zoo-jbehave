package net.zoo;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.ScenarioType;

/**
 * Annotation are called many times before annotated element (globally not class context).
 * So you should have one class for all tests processing below annotations.
 * 
 * @author zwsppak
 *
 */
public class BeforeAndAfter {

	@BeforeStories 
	public void beforeStories() {
		System.out.println ("*** afterStories: " + getClass().getCanonicalName());
	}

	@BeforeScenario
	public void beforeEachScenario() {
		System.out.println ("*** beforeEachScenario: " + getClass().getCanonicalName());
	}
	 
	@BeforeScenario(uponType=ScenarioType.EXAMPLE)
	public void beforeEachExampleScenario() {
		System.out.println ("*** beforeEachExampleScenario: " + getClass().getCanonicalName());
	}

	@BeforeStory // equivalent to @BeforeStory(uponGivenStory=false)
	public void beforeStory() {
		System.out.println ("*** beforeStory: " + getClass().getCanonicalName());
	}
	 
	@BeforeStory(uponGivenStory=true)
	public void beforeGivenStory() {
		System.out.println ("*** beforeGivenStory: " + getClass().getCanonicalName());
	}
	     

	@AfterStories
	public void afterStories() {
		System.out.println ("*** afterStories: " + getClass().getCanonicalName());
	}
	
	@AfterScenario // equivalent to  @AfterScenario(uponOutcome=AfterScenario.Outcome.ANY)
	public void afterAnyScenario() {
		System.out.println ("*** afterAnyScenario: " + getClass().getCanonicalName());
	}
	 
	@AfterScenario(uponType=ScenarioType.EXAMPLE)
	public void afterEachExampleScenario() {
		System.out.println ("*** afterEachExampleScenario: " + getClass().getCanonicalName());
	}
	     
	@AfterScenario(uponOutcome=AfterScenario.Outcome.SUCCESS)
	public void afterSuccessfulScenario() {
		System.out.println ("*** afterSuccessfulScenario: " + getClass().getCanonicalName());
	}
	     
	@AfterScenario(uponOutcome=AfterScenario.Outcome.FAILURE)
	public void afterFailedScenario() {
		System.out.println ("*** afterFailedScenario: " + getClass().getCanonicalName());
	}
	
	@AfterStory // equivalent to @AfterStory(uponGivenStory=false)
	public void afterStory() {
		System.out.println ("*** afterStory: " + getClass().getCanonicalName());
	}
	 
	@AfterStory(uponGivenStory=true)
	public void afterGivenStory() {
		System.out.println ("*** afterStory: " + getClass().getCanonicalName());
	}

}
