package com.skilldistillery.jets.app;

import java.io.*;
import java.util.*;
import com.skilldistillery.jets.entities.*;

public class JetsApp {
	Scanner sc = new Scanner(System.in);
	AirField fleet = new AirField();
//Story 1
	public static void main(String[] args) {
		JetsApp ja = new JetsApp();
		ja.launch();
		ja.sc.close();
	}
	
//Story 4
	public void launch() {

		int input;

		fleet.setFleet(loadFleet("jets.txt"));

		do {
			
			displayUserMenu();
			input = userChoice();
			System.out.println();
			
			switch (input) {
			case 1:
				ListFleet();
				break;
			case 2:
				FlyJets();
				break;
			case 3:
				fastest();
				break;
			case 4:
				longestRange();
				break;
			case 5:
				loadCargo();
				break;
			case 6:
				dogFight();
				break;
			case 7:
				addJets();
				break;
			case 8:
				removeJets();
				break;
			case 9:
				System.out.println("You have chosen to quit.");
				break;
			default:
				System.err.println("Invalid input.");
				continue;
			}
		} while (input != 9);
		System.out.println("Thank you, come again!");
	}

//Story 3
	private List<Jet> loadFleet(String fileName) {
		// Declare outside the try/catch.
		List<Jet> jets = new ArrayList<>();
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;

			while ((line = bufIn.readLine()) != null) {

				String JetRecord[] = line.split(", ");

				String model = JetRecord[1];
				double speed = Double.parseDouble(JetRecord[2]);
				int range = Integer.parseInt(JetRecord[3]);
				long price = Long.parseLong(JetRecord[4]);

				if (JetRecord[0].equals("Cargo")) {
					CargoPlane cp = new CargoPlane(model, speed, range, price);
					jets.add(cp);
				} else if (JetRecord[0].equals("Fighter")) {
					FighterJet fj = new FighterJet(model, speed, range, price);
					jets.add(fj);
				} else if (JetRecord[0].equals("Passenger")) {
					PassengerJet pj = new PassengerJet(model, speed, range, price);
					jets.add(pj);
				}

			}
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
		} catch (IOException e) {
			System.err.println(e);
		}
		return jets;
	}

//Story 5
	private void ListFleet() {
		for (Jet jet : fleet.getFleet()) {
			System.out.println(jet.toString());
		}
	}

//Story 6
	private void FlyJets() {
		for (Jet jet : fleet.getFleet()) {
			jet.fly();
		}
	}

//Story 7
	private void fastest() {
		Jet fastest = fleet.getFleet().get(0);

		for (Jet jet : fleet.getFleet()) {
			if (fastest.getSpeed() < jet.getSpeed()) {
				fastest = jet;
			}
		}
		System.out.println("The fastest jet in the fleet is:");
		System.out.println(fastest.toString());

	}

// Story 8
	private void longestRange() {
		Jet farthest = fleet.getFleet().get(0);

		for (Jet jet : fleet.getFleet()) {
			if (farthest.getRange() < jet.getRange()) {
				farthest = jet;
			}
		}
		System.out.println("The jet with the longest range is:");
		System.out.println(farthest.toString());
	}

	
//Story 8
	private void loadCargo() {
		for (Jet jet : fleet.getFleet()) {
			if (jet instanceof CargoPlane) {
				((CargoPlane) jet).loadCargo();
			}
		}
	}

//Story 8
	private void dogFight() {
		for (Jet jet : fleet.getFleet()) {
			if (jet instanceof FighterJet) {
				((FighterJet) jet).fight();
			}
		}
	}

//Story 9
	public void addJets() {
		boolean addLoop = true;
		while (addLoop) {
			try {
				newJetMenu();
				int iType = sc.nextInt();
				String sType = "";
				sc.nextLine();

				if (iType == 0) {
					addLoop = false;
				} else if (iType >= 1 && iType <= 3) {
					System.out.print("Input the model of jet: ");
					String model = sc.nextLine();

					System.out.print("Input the jet's speed in mph: ");
					double speed = sc.nextDouble();

					System.out.print("Input the jet's range in miles: ");
					int range = sc.nextInt();

					System.out.print("Input the jet's price: $");
					long price = sc.nextLong();
					sc.nextLine();

					if (iType == 1) {
						sType = "Cargo";
						CargoPlane cargoPlane = new CargoPlane(model, speed, range, price);
						fleet.getFleet().add(cargoPlane);

					} else if (iType == 2) {
						sType = "Fighter";
						FighterJet fighterJet = new FighterJet(model, speed, range, price);
						fleet.getFleet().add(fighterJet);

					} else if (iType == 3) {
						sType = "Passenger";
						PassengerJet passJet = new PassengerJet(model, speed, range, price);
						fleet.getFleet().add(passJet);
					}
					try {
						FileWriter fw = new FileWriter("jets.txt", true);
						PrintWriter pw = new PrintWriter(fw);

						String addJet = sType + ", " + model + ", " + speed + ", " + range + ", " + price;

						pw.println(addJet);

						pw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					System.err.println("Invalid input.");
				}

			} catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("Invalid input.");
			}
		}
	}

// Story 9 sub-menu
	private void newJetMenu() {
		System.out.println(" ____________________________________");
		System.out.println("|            New Jet Menu            |");
		System.out.println("|––––––––––––––––––––––––––––––––––––|");
		System.out.println("|  What type of Jet are you adding?  |");
		System.out.println("|                                    |");
		System.out.println("|   0: Go  Back                      |");
		System.out.println("|   1: New cargo jet                 |");
		System.out.println("|   2: New fighter jet               |");
		System.out.println("|   3: New passenger jet             |");
		System.out.println("|____________________________________|");
	}

//Story 10
	private void removeJets() {
		boolean removeLoop = true;
		while (removeLoop) {
			removeJetMenu();
			try {
				int choice = sc.nextInt()-1;

				if (choice == -1) {
					removeLoop = false;
				} else if (choice >= 0 && choice < fleet.size()) {

					try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
						String line;
						FileWriter fw = new FileWriter("jets.txt");
						PrintWriter pw = new PrintWriter(fw);
						Jet jet = fleet.getFleet().get(choice);
						String removeJet = jet.fileFormat();

						//Clear File
						while ((line = bufIn.readLine()) != null) {
							if (!removeJet.equals(line)) {
							}
						}
						
						System.out.println("Removing: " + fleet.getFleet().remove(choice));
						//Rebuild file without removed jet
						for (int i = 0; i < fleet.size(); i++) {
							jet = fleet.getFleet().get(i);
							String keepJets = jet.fileFormat();
							pw.write(keepJets);
							
						}


						pw.close();
						bufIn.close();
						
					} catch (IOException e) {
						e.printStackTrace();
					}

				} else {
					System.err.println("Invalid input.");
				}

			} catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("Invalid input.");
			}
		}

	}

//Story 10 sub-menu
	private void removeJetMenu() {
		System.out.println(" ____________________________________");
		System.out.println("|          Remove Jet Menu           |");
		System.out.println("|––––––––––––––––––––––––––––––––––––|");
		System.out.println("| Which jet would you like to remove |");
		System.out.println("|                                    |");
		System.out.println("|   0: Go Back                       |");
		for (int i = 0; i < fleet.size(); i++) {
			Jet jet = fleet.getFleet().get(i);
			System.out.printf("|   %d: %-30s|%n", (i+1), jet.getModel());
		}
		System.out.println("|____________________________________|");

	}

//Story 4
	public void displayUserMenu() {
		System.out.println();
		System.out.println(" ____________________________________ ");
		System.out.println("|           Jet Fleet Menu           |");
		System.out.println("|––––––––––––––––––––––––––––––––––––|");
		System.out.println("|   1: List fleet                    |");
		System.out.println("|   2: Fly all jets                  |");
		System.out.println("|   3: View fastest jet              |");
		System.out.println("|   4: View jet with longest range   |");
		System.out.println("|   5: Load all Cargo Jets           |");
		System.out.println("|   6: Dogfight!                     |");
		System.out.println("|   7: Add a jet to Fleet            |");
		System.out.println("|   8: Remove a jet from Fleet       |");
		System.out.println("|   9: Quit                          |");
		System.out.println("|____________________________________|");
	}

//Story 4-11
	public int userChoice() {
		System.out.print("Please pick an option: ");
		int input = -1;
		try {
			input = sc.nextInt();
		} catch (InputMismatchException e) {
		}

		sc.nextLine();
		return input;
	}

}
