Meta:
@author Piotr
@date	21-06-2017
@refs

Narrative: Every user in ZOO management system should have at least one role

In order to work with ZOO management system
As a staff of ZOO
I want to gain at least one role after login

!-- A precondition to entire story
!-- GivenStories: stories/staff/must-login.story

GivenStories: stories/staff/do-login.story
					 
Scenario: User gain exactly one role

Given role
When exists
Then have

Scenario: User gain even no one role

Given role
When exists
Then have

Scenario: User gain more than one role

Given role
When exists
Then have

