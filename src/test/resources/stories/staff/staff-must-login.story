Stuff must authorizate to look after animals

Meta:
@author Piotr
@date	13-06-2017
@exampleData

Narrative:
In order to improve security in ZOO
As a ZOO manager
I want to ZOO staff have to be authorized for access to animals
					 
Scenario:  An animal guardian having correct authorization code want to enter it's cage

Given animal guardian name is <user>
When guardian press the correct autorize code <pin> on keypad
Then the cage door is opening

Examples:
|user|pin|
|Mike|123456|
|Bill|654321|
|Maria|121212|
|Sylvia|32345|

Scenario:  An animal guardian having incorrect authorization code want to enter it's cage

Given animal guardian name is <user>
When guardian press the wrong autorize code <wrong_pin> on keypad
Then the cage door is still closed
And alarm with be dispayed in security center

Examples:
|user|wrong_pin|
|Mike|234445|
|Bill|111111|
|Maria|222222|
|Sylvia|333333|
