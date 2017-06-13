package net.zoo.gorilla;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class GorillaMoreBananasStoryTest {

	private Integer bananasNo = -1;
	private Map<Integer, String> expectedMood = new HashedMap<>();
	private Map<Integer, String> expectedFilling = new HashedMap<>();


	public GorillaMoreBananasStoryTest() {
		expectedMood.put(0, "angry");
		expectedMood.put(5, "sad");
		expectedMood.put(20, "happy");

		expectedFilling.put(0, "scared");
		expectedFilling.put(5, "disappointed");
		expectedFilling.put(20, "satisfied");
	}

	@Given("gorilla gets $number more bananas")
	public void theGorillaGetsBananas(Integer number) {
		bananasNo = number;
	}

	@When("gorilla have had the bananas")
	@Alias("gorilla want to eat bananas")
	public void theGorillaAte() {
		assertTrue(bananasNo >= 0);
	}

	@Then("gorilla is $mood")
	public void theGorillaMood(String mood) {
		assertEquals(expectedMood.get(bananasNo), mood);
	}

	@Then("ZOO visitors are $filling")
	public void theVisitorsFilling(String filling) {
		assertEquals(expectedFilling.get(bananasNo), filling);
	}

}
