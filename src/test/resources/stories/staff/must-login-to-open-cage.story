Meta:
@author Piotr
@date	13-06-2017
@exampleData

Narrative: Staff must authorizate to look after animals

In order to improve security in ZOO
As a ZOO manager
I want to ZOO staff have to be authorized for access to animals
					 
Scenario:  An animal guardian having correct authorization code want to enter it's cage

Given animal guardian name is <user>
When guardian press the correct autorize code <pin> on keypad
Then the cage door is opening

Examples:
|user|pin|
|Marc|123456|
|Bill|654321|
|Sussan|121212|
|Anna|32345|

Scenario:  An animal guardian having incorrect authorization code want to enter it's cage

Given animal guardian name is <user>
When guardian press the wrong autorize code <wrong_pin> on keypad
Then the cage door is still closed
And alarm with be dispayed in security center

Examples:
|user|wrong_pin|
|Marc|234445|
|Bill|111111|
|Sussan|222222|
|Anna|333333|
