Meta:
@author Piotr
@date	22-06-2017
@examplesFromFile

Narrative: User must be authorized into ZOO management system

In order to work with ZOO management system
As a staff of ZOO
I want to login in
					 
Scenario: User login into ZOO management system

Given User start the web browser "<browser>"
And go to URL "zoo.system.org"
When enter login "<login>" and password "<password>"
And press form button "<button>"
Then system returns "<response>"

Examples: 
stories/staff/userlogin.table
