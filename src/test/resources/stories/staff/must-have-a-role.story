Meta:
@author Piotr
@date	21-06-2017
@refs

Narrative: Every user in ZOO management system should have at least one role

In order to work with ZOO management system
As a staff of ZOO
I want to gain at least one role after login

GivenStories: stories/staff/do-login.story
					 
Scenario: User gain functionality for exactly one role

Given user Marc has only one role
When user login into system
Then user gain access functionality available for one role and public user role

Scenario: User gain functionality for only for public user

Given user Bill has no one role
When user login into system
Then user gain access only functionality available for public users

Scenario: User gain functionality for more than one role

Given user Anna has more than one role
When user login into system
Then user gain access at least functionality available for two or more roles and public user role
