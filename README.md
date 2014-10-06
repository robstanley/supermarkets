Supermarkets
============
Background
----------
Customers buy stuff.

Supermarkets sell stuff.

Supermarkets can only keep a bit of stuff in shops.

Supermarkets supply shops from their warehouses.

Supermarkets buy lots of stuff from suppliers.

Problem
-------
The supermarket wants a program to control buying stock and dispatching it to supermarkets. They have an existing
logistics program that does all the heavy lifting and stats gathering, but it needs a plugin to give it a brain.

There's no 'score', but generally customers wanting to buy stuff and the shop not having any stuff is bad, having more 
stuff sitting on shelves (or in the warehouse) is bad, selling stuff is good, selling stuff quickly is even better.

_I'm happy to listen to suggestions about the 'no score' point. My earlier version did have a formula that tried to 
weight the good and bad things, but it makes it too easy to game. An alternative would be a deeper simulation that 
had expiry dates on stuff, and customers who get unhappy and don't come back. It makes the problem cooler, but bigger._
The Code
--------
It's a legacy app. There's no tests. You're lucky you a) have the source, and b) it's not in COBOL.

_Feel free to add tests for your code - it's not required, but you're probably increasing the likelihood of getting
asked about testing later on._

`mvn clean package exec:java` will fire up a simulation. There's some config options to control the sim speed, 
what gets printed out, etc. _At the moment some of these involve adding/removing the `@Component` annotation from 
plugin classes._

Since the plugin doesn't exist yet, running the sim right now will just have supermarkets 
selling their existing stock and then sitting there empty. To fix that you'll need to find where the plugin system 
lives and hook into it. Please, only change/add code in the plugins package!

Submission
----------
Please email your code (and any description of what you've done, if you think it needs it) to robs@brandwatch.com.
If you've had different instructions from anybody else then do that instead! Feel free to email me to check if
you're not sure, or if you've got any questions about the task.

Don't worry if one of the technologies used is something you've never encountered before; there's nothing extremely
strange, so it should be possible to figure it out, but if you hit a brick wall then we're not going to hold it against
you if you ask.