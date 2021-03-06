# Mars-Rover
A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.   A rover’s position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.   In order to control a rover, NASA sends a simple string of letters. The possible letters are ‘L’, ‘R’ and ‘M’. ‘L’ and ‘R’ makes the rover spin 90 degrees left or right respectively, without moving from its current spot. ‘M’ means move forward one grid point, and maintain the same heading. Assume that the square directly North from (x, y) is (x, y+1).

#### Input:

The first line of input is the upper-right coordinates of the plateau, the lowerleft coordinates are assumed to be 0,0.
The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover’s position, and the second line is a series of instructions telling the rover how to explore the plateau.
The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover’s orientation.
Each rover will be finished sequentially, which means that the second rover won’t start to move until the first one has finished moving.

#### Contents:
The project contains three classes and the input text file. The main class in which the output is calculated is the calculateOutput class. The classes that are implemented to perform automated tests are MyTest and TestJUnit. The class MyTest contains the Java main method, which is used to run the tests and the TestJUnit is used to implement the scenarios tests and read the input information
from the file. More details on variables, program and design logic are explained in the code comments.


# Setup
You must have the following to run this project:
* JRE System Library [JavaSE-1.8]
* JUnit 4

# Running the tests
Two different scenarios are implemented to confirm whether the program is working properly. The following is the input given and the desired output:
#### Test Input:
5 5

1 2 N

LMLMLMLMM

3 3 E

MMRMMRMRRM

#### Expected Output:
1 3 N

5 1 E

To run the two automated tests you need to run the *Java main Method* of the *MyTest class*.

# License

Copyright 2020 Christos Daoulas

Licensed under the Apache License, Version 2.0 (the "License");
