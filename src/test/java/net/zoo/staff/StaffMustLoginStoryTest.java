package net.zoo.staff;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class StaffMustLoginStoryTest {

	private String user = null;
	private String pin = null;
	private String wrongPin = null;
	private List<String> userName = new ArrayList<>();
	private Map<String, String> userPins = new HashedMap<>();
	private Map<String, String> userWrongPins = new HashedMap<>();


	public StaffMustLoginStoryTest() {
		userName.add("Mike");
		userName.add("Bill");
		userName.add("Maria");
		userName.add("Sylvia");
		
		userPins.put("Mike","123456");
		userPins.put("Bill", "654321");
		userPins.put("Maria", "121212");
		userPins.put("Sylvia", "32345");

		userWrongPins.put("Mike","234445");
		userWrongPins.put("Bill", "111111");
		userWrongPins.put("Maria", "222222");
		userWrongPins.put("Sylvia", "333333");
	}

	@Given("animal guardian name is <user>")
	public void theGuardianIsUser(@Named("user") String user) {
		this.user = user;
	}

	@When("guardian press the correct autorize code <pin> on keypad")
	public void theCorrectPin(@Named("pin") String pin) {
		assertNotNull(user);
		assertEquals(userPins.get(user), pin);
		this.pin = pin;
	}
	
	@When("guardian press the wrong autorize code <wrong_pin> on keypad")
	public void theWrongPin(@Named("wrong_pin") String wrongPin) {
		assertNotNull(user);
		assertEquals(userWrongPins.get(user), wrongPin);
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
