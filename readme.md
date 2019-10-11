# Ayakha Auto Sales

Ayakha Auto Sales

Ayakha is an upcoming car salesman in the northern suburbs of Cape Town. He wants to start a second hand car dealership and is doing some market research.

He gave you [some data](/cars.json) that he wants help with analyzing.

For a few towns he recorded the model, color and make of cars. He needs to decide which models of cars to sell and where to open his Auto (car) dealership.

Each object in the list looks like this:

```javascript

var car = {
  "color": "orange",
  "make": "Ford",
  "model": "Fiesta",
  "reg_number": "CL 77790"
}

```

Use your new found skills of Java Streams answer his questions.

## Cars can be from these towns

  Town  | Reg number start
--------------|------
Paarl         |`CJ`
Bellville     | `CY`
Stellenbosch  | `CL`
Malmesbury    |`CK`
Cape Town     | `CA`
Kuilsriver    | `CF`

Ayakha  wants to know:

* What make is the most popular car model? (`mostPopularCarModel`)
* How many Nissan's are from Malmesbury? (`howManyNissansFromMalmesbury`)
* Which town has the most blue cars? (`townWithMostBlueCars`)
* What town has the fewest orange cars? (`townWithFewestOrangeCars`)
* What is the most popular model car overall? (`mostPopularModel`)
* What is the most popular model car in Stellenbosch? (`mostPopularModelFromStellenbosch`)
* What is the least popular model car in Kuilsriver? (`leastPopularModelCarInKuilsrivier`)

Write functions that can answer these questions for your friend. Each function's name in brackets.

> **Remember** that your functions should correctly if the input data change.

Test your code using `assert` statements.
> **Note:** there is a global variable called `cars` that you can use for functions that doesn't take a list of cars as a parameter.

**There's more**

Your friend also wants this data:

* all the cars for any given town `carsForTown('townname')`
* all the cars for a specific color for a specific town `numberOfCars('blue', 'town name')`
* the  cars for a specific color & model for a specific town `numberOfCarsPerModel('blue', 'model', 'town name')`
* the most popular color car for any given town `mostPopularColorForTown('townname')`

Run maven using:

* `mvn compile`
* `mvn test`
* `mvn package`