package net.zoo.staff;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import net.zoo.System;
import net.zoo.System.SYSTEM_RESPONSE;

public class DoLoginSteps {
	
	private System sys = new System();
	private String formButton = null;
	private Boolean login = false; 
		
	@Given("User start the web browser \"<browser>\"")
	public void userStartsBrowser(@Named("browser") String browser) {
		assertTrue("Not supported browser", sys.supportedBrowser(browser));
	}

	@Given("go to URL \"$url\"")
	public void gotToURL(String url) {
		assertTrue("Wrong system URL", sys.checkStartUrl(url));
	}
	
	@When("enter login \"<login>\" and password \"<password>\"")
	public void enterLoginAndPassword(@Named("login") String login, @Named("password") String password) {
		assertTrue("User not exists", sys.userExists(login));
		this.login = sys.login(login, password);
	}

	@When("press form button \"<button>\"")
	public void pressFromButton(@Named("button") String button) {
		formButton = button;
	}
	
	@Then("system returns \"<response>\"")
	public void systemResponse(@Named("response") String response) {
		System.SYSTEM_RESPONSE sres = System.SYSTEM_RESPONSE.valueOf(response);
		System.SYSTEM_RESPONSE expected = null;
		if (formButton.equals("Close")) {
			expected = SYSTEM_RESPONSE.TRY_AGAIN;
		} else if (formButton.equals("Login")) {
			expected = (login ? SYSTEM_RESPONSE.OK : SYSTEM_RESPONSE.ERROR);
		}
		assertEquals("Unexpected system response", expected, sres);
	}

}
