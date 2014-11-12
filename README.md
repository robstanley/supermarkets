Brandwatch Interview Question: Supermarkets
============
Background
----------

If you've ever worked in the food retail industry, you'll notice that there are some simple rules that supermarkets follow:

* Customers buy products.
* Supermarkets sell products.
* Supermarkets can only keep a certain amount of product in stock.
* Supermarkets supply shops from their warehouses.
* Supermarkets buy lots of products from suppliers.

When all of these things happen in unison, supermarkets make lots of money, people have food on their tables, and everyone is very happy indeed.

The problem
-----------
A large retail chain wants a program to control buying stock and dispatching it to their supermarkets. They have an existing
logistics program that does all the heavy lifting and stats gathering, but it needs a plugin to give it a brain.

There's no definite set of rules*, but:

* Customers wanting to buy products and the shop not having any is bad
* Having too many products sitting on shelves or in the warehouse is bad 
* Selling products is good
* Selling products quickly is even better

In this version there's only one shop/warehouse/supplier, and the supplier always has stock.

The code, and how to run it
---------------------------
Unfortunately for you, this is a legacy app. There are no tests. You're lucky you a) have the source, and b) it's not in COBOL.

`mvn clean package exec:java` will fire up a simulation. There's some config options to control the simulation speed, 
what gets printed out, etc. _At the moment some of these involve adding/removing the `@Component` annotation from 
plugin classes._

What do you want me to do?
--------------------------

You'll notice that running the simulator will cause the supermarkets to sell their existing stock and then sit there empty. That's not good! To fix that you'll need to find where the plugin system lives and improve it.Try to write a plugin that controls the simulation according to the rules above. Use this as an opportunity to showcase your expertise. 

When you're done, zip the folder up and send it to the member of the Brandwatch recruitment team you are in contact with. From here it will be forwarded to our engineers to review. When they receive this, we'll be looking at the following things:

* The ability to build it out of the box using maven
* The quality and style of code written
* The tests and their structure and coverage
* The choice of technologies used to complete the task
* The documentation provided 

Typically we expect it to compile and run on a Linux environment with Java 7. If your set up is any different, do let us know!

Good luck!

_* We're happy to see attempts at creating a weighted score-based system. Our engineers created formula that tried to 
weight the good and bad outcomes against each other, but it makes it too easy to game. A more realistic alternative would be a deeper simulation that has expiry dates on products and customers who get unhappy and don't come back. It makes the problem much cooler, but much harder also._
