# That's Life
<b>That's Life</b> is a variant of <b>The Game of Life</b>, a board game originally created by Milton Bradley in 1860 and redesigned a century later by Reuben Klamer. As the name suggests, it mirrors actual events from a person's life — from going to college and landing a job, through getting married and buying a house, to borrowing loans and finally retiring. The most distinguishing feature of the game is the presence of branching points where a player has to make a decision: take the normal route or explore a more roundabout path towards the goal of retiring with the most amount of cash on hand.

## Task
<b>That's Life</b> is the major course output for an object-oriented programming class. Below are screenshots of the gameplay: <br/>

<img src="https://github.com/memgonzales/thats-life/blob/master/gameplay_screenshots/ThatsLife_1.PNG?raw=True" alt="Action Card" width = 750> 
<img src="https://github.com/memgonzales/thats-life/blob/master/gameplay_screenshots/ThatsLife_2.PNG?raw=True" alt="Get Married" width = 750> 
<img src="https://github.com/memgonzales/thats-life/blob/master/gameplay_screenshots/ThatsLife_3.PNG?raw=True" alt="Choose Path" width = 750> 
<img src="https://github.com/memgonzales/thats-life/blob/master/gameplay_screenshots/ThatsLife_4.png?raw=True" alt="Buy a House" width = 750>  <br/>

This project consists of four folders:
- <code>api</code> - <code>Javadoc</code> documentation of this project
- <code>bin</code> - <code>.class</code> files
- <code>src</code> - <code>.java</code> files (source codes)
- <code>uml</code> - Unified Modeling Language (UML) class diagrams of this project

It also includes the following files:
- <code>Test Script Documentation.pdf</code> - Description of test cases
- <code>source.txt</code> - File paths of the <code>.java</code> source codes (used in compilation)


## Built Using
This project was built using <b>Java</b> following the Model-View-Controller (MVC) architectural pattern. The graphical user interface was created using <b>Swing</b>, a platform-independent toolkit that is part of the Java Foundation Classes.

## Compilation and Running
The <code>.class</code> files were generated using <b>Java SE Development Kit 14</b>. To compile the Java files, execute the following command in the terminal (opened from the directory containing <code>source.txt</code>):

<code>javac -d out @source.txt</code>

To run the game, execute the following command in the terminal (opened from the directory containing <code>source.txt</code>):

<code>java -cp .;bin;\*\*/\*.class ThatsLife</code>

## Authors
- <b>Mark Edward M. Gonzales</b> <br/>
  mark_gonzales@dlsu.edu.ph <br/>
  gonzales.markedward@gmail.com <br/>
  
- <b>Hylene Jules G. Lee</b> <br/>
  hylene_jules_lee@dlsu.edu.ph <br/>
  lee.hylene@gmail.com

Assets (images) are properties of their respective owners. Attribution is included in the Rules section of the game and can be found in <code>src/assets/rules.txt</code>.
