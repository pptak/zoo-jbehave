package net.zoo.staff;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import net.zoo.ZOOSystem;

public class StaffMustLoginToOpenCageSteps {

	private ZOOSystem sys = new ZOOSystem();
	private String user = null;
	private String pin = null;
	private String wrongPin = null;

	@Given("animal guardian name is <user>")
	public void theGuardianIsUser(@Named("user") String user) {
		this.user = user;
	}
	
	@When("guardian press the correct autorize code <pin> on keypad")
	public void theCorrectPin(@Named("pin") String pin) {
		assertTrue("Unexpected PIN", sys.checkGorillaPIN(user, pin));
		this.pin = pin;
	}
	
	@When("guardian press the wrong autorize code <wrong_pin> on keypad")
	public void theWrongPin(@Named("wrong_pin") String wrongPin) {
		assertFalse("Unexpected PIN", sys.checkGorillaPIN(user, wrongPin));
		this.wrongPin = wrongPin;
	}

	@Then("the cage door is opening")
	public void theDoorOpened() {
		assertNotNull(user);
		assertNotNull(pin);
	}

	@Then("the cage door is still closed")
	public void theDoorIsStillClosed() {
		assertNotNull(user);
		assertNotNull(wrongPin);
	}

	@Then("alarm with be dispayed in security center")
	public void theAlarmDisplayed() {
		assertNotNull(user);
		assertNotNull(wrongPin);
	}

}
