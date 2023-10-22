# JetsProject

# Description
The Jets project is a project used to test ones ability to use lists, input/output streams, abstract classes, interfaces, and exceptions. In this project, there are two packages, one for the app and one for the entities, as well as a .txt file. 

In the entities package there are seven classes. one abstract class (Jet), two interfaces (CargoCarrier, and CombatReady), three classes that inherit the Jet class(CargoPlane and FighterJet, which implement interfaces, and PassengerJet, which does not have an interface), and one other class (AirField).  

In the app package, there is the JetsApp class which runs the code. When the program runs the data that is stored in the jets.txt file is read into the program and stored as a fleet (arrayList) of jets in the Airfield class. The app then shows a menu giving the user 9 choices. 

The first option lists the information about the jets that are in the flee, including the type, model, speed, range, and price
of the jet. 

The second option runs the fly() methods for each jet, this print out the information of the jets including the amount of time the jet can fly before running out of fuel. 

The third and forth options display the information about the jets with the fastest speed and the longest range respectively. 

The fifth and sixth options show a message correlating with only the cargo planes and fighter jets respectively. 

The seventh option allows the user to add another jet to the fleet. The user is shown a menu asking what type of jet they are adding, they are then prompted for the model, speed, range, and price of the jets. This information is then added to the fleet's list and the .txt file. This menu will loop until the user chooses to exit by pressing zero.

The eighth option shows a menu with all of the jets in the fleet and prompts the user to choose one to get rid of. upon choosing, a message is shown giving the information of the jet being removed and that jet is removed from the ArrayList as well as the .txt file. This menu is looped until the user chooses zero to exit.

The ninth option quits the program, showing an exit message
# Technologies Used
Java, OOP, Eclipse
# Lessons Learned
Throughout this project I learned a few things regarding input/output streams and using list. With input/output streams I furthered my knowledge on writing to a file, and I learned a way to remove information from the file, although I do feel like there is a better way to remove information than the way I did. The way I formatted my code removes all of the information from the .txt file and rewrites it using the fleet list with the one jet removed. I want to figure out if there is a way to just parse through the file and remove the line directly (instead of rewriting everything else). I also furthered my knowledge in using ArrayLists and classes to organize and accomplish tasks.