# That's Life

![badge](https://img.shields.io/badge/language-Java-orange.svg)

<b>That's Life</b> is a variant of <b>The Game of Life</b>, a board game originally created by Milton Bradley in 1860 and redesigned a century later by Reuben Klamer. As the name suggests, it mirrors actual events in a person's life — from going to college and landing a job, through getting married and buying a house, to borrowing loans and finally retiring. The most distinguishing feature of the game is the presence of branching points where a player has to make a decision: take the normal route or explore a more roundabout path towards the goal of retiring with the most amount of cash on hand.

## Task
<b>That's Life</b> is the major course output in an object-oriented programming class under Ms. Shirley B. Chu of the Software Technology Department, De La Salle University. The complete project specifications and rules of the game are given in the file [<code>Project Specifications.pdf</code>](https://github.com/memgonzales/thats-life/blob/master/Project%20Specifications.pdf). Below are screenshots of the gameplay: <br/>

<img src="https://github.com/memgonzales/thats-life/blob/master/gameplay_screenshots/ThatsLife_1.PNG?raw=True" alt="Action Card" width = 750> 
<img src="https://github.com/memgonzales/thats-life/blob/master/gameplay_screenshots/ThatsLife_2.PNG?raw=True" alt="Get Married" width = 750> 
<img src="https://github.com/memgonzales/thats-life/blob/master/gameplay_screenshots/ThatsLife_3.PNG?raw=True" alt="Choose Path" width = 750> 
<img src="https://github.com/memgonzales/thats-life/blob/master/gameplay_screenshots/ThatsLife_4.png?raw=True" alt="Buy a House" width = 750>  <br/>

This project consists of four folders:
- [<code>api</code>](https://github.com/memgonzales/thats-life/tree/master/api) - <code>Javadoc</code> documentation of this project
- [<code>bin</code>](https://github.com/memgonzales/thats-life/tree/master/bin) - <code>.class</code> files
- [<code>src</code>](https://github.com/memgonzales/thats-life/tree/master/src) - <code>.java</code> files (source codes)
- [<code>uml</code>](https://github.com/memgonzales/thats-life/tree/master/uml) - Unified Modeling Language (UML) class diagrams of this project

Besides the [`That's Life.jar`](https://github.com/memgonzales/thats-life/blob/master/That's%20Life.jar) binary, it also includes the following files:
- [<code>Project Specifications.pdf</code>](https://github.com/memgonzales/thats-life/blob/master/Project%20Specifications.pdf) - Complete project specifications
- [<code>Test Script Documentation.pdf</code>](https://github.com/memgonzales/thats-life/blob/master/Test%20Script%20Documentation.pdf) - Detailed description of test cases alongside expected and actual program behavior
- [<code>source.txt</code>](https://github.com/memgonzales/thats-life/blob/master/source.txt) - File paths of the <code>.java</code> source codes (used in compilation)

## Built Using
This project was built using <b>Java</b> following the Model-View-Controller (MVC) architectural pattern. The graphical user interface was created using <b>Swing</b>, a platform-independent toolkit that is part of the Java Foundation Classes.

## Compilation and Running
The <code>.class</code> files were generated using <b>Java SE Development Kit 14</b>. To compile the Java files, execute the following command in the terminal (opened from the root directory, i.e., the directory containing [<code>source.txt</code>](https://github.com/memgonzales/thats-life/blob/master/source.txt)):

<code>javac -d out @source.txt</code>

To run the game, execute the following command in the terminal (opened from the root directory as well):

<code>java -cp .;bin;\*\*/\*.class ThatsLife</code>

Alternatively, the [`.jar`](https://github.com/memgonzales/thats-life/blob/master/That's%20Life.jar) file is also provided. 

The game instructions can be found in this [document](https://github.com/memgonzales/thats-life/blob/master/Project%20Specifications.pdf); they can also be accessed in-game.

## Authors
- <b>Mark Edward M. Gonzales</b> <br/>
  mark_gonzales@dlsu.edu.ph <br/>
  gonzales.markedward@gmail.com <br/>
  
- <b>Hylene Jules G. Lee</b> <br/>
  hylene_jules_lee@dlsu.edu.ph <br/>
  lee.hylene@gmail.com

Assets (images) are properties of their respective owners. Attribution is included in the Rules section of the game and can be found in [<code>src/assets/rules.txt</code>](https://github.com/memgonzales/thats-life/blob/master/src/assets/rules.txt).
