package net.zoo.staff;

import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import net.zoo.ZOOSystem;

public class UserMustHaveARoleSteps {
	
	private ZOOSystem sys = new ZOOSystem();
	private String user = null;
	
	@Given("user $user has only one role")
	public void givenOneRole(String user) {
		this.user = user;
	}

	@Given("user $user has no one role")
	public void givenOneOneRole(String user) {
		this.user = user;
	}
	
	@Given("user $user has more than one role")
	public void givenMoreThanOneRoles(String user) {
		this.user = user;
	}

	@When("user login into system")
	public void testIfLoged() {
		assertTrue("User isn't loged in !", sys.isUserLoged(user));
	}

	@Then("user gain access functionality available for one role and public user role")
	public void testIfWithOneRole() {
		assertTrue("User has less or more than two roles !", sys.userRoles(user).size() == 2
				 && sys.userRoles(user).contains(ZOOSystem.PUBLIC_ACCESS_ROLE_NAME));
	}
	
	@Then("user gain access only functionality available for public users")
	public void testIfWithNoRole() {
		assertTrue("User don't have only one public role !", sys.userRoles(user).size() == 1
			 && sys.userRoles(user).contains(ZOOSystem.PUBLIC_ACCESS_ROLE_NAME));
	}

	@Then("user gain access at least functionality available for two or more roles and public user role")
	public void testIfWithMoreThanTwoRoles() {
		assertTrue("User has less then three roles !", sys.userRoles(user).size() >= 3
				 && sys.userRoles(user).contains(ZOOSystem.PUBLIC_ACCESS_ROLE_NAME));
	}

}
