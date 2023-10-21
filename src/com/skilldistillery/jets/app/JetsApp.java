package com.skilldistillery.jets.app;

import java.io.*;
import java.util.*;
import com.skilldistillery.jets.entities.*;

public class JetsApp {
	Scanner sc = new Scanner(System.in);
	AirField fleet = new AirField();

	public static void main(String[] args) {
		JetsApp ja = new JetsApp();
		ja.launch();

	}

	public void launch() {

		int input;

		fleet.setFleet(loadFleet("jets.txt"));
		
		do {
			displayUserMenu();
			input = userChoice();

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
			default:
				continue;
			}
		} while (input != 9);
		System.out.println("Thank you, come again!");
	}

	private List<Jet> loadFleet(String fileName) {
		// Declare outside the try/catch.
		List<Jet> jets = new ArrayList<>();
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String JetRecord[] = line.split(", ");
				String model = JetRecord[1];
				double speed = Double.parseDouble(JetRecord[2]);
				int range = Integer.parseInt(JetRecord[2]);
				long price = Long.parseLong(JetRecord[3]);
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
		} catch (IOException e) {
			System.err.println(e);
		}
		return jets;
	}

	private void ListFleet() {
			
		for (Jet jet : fleet.getFleet()) {
			System.out.println(jet.toString());	
		}
	}

	private void FlyJets() {
		// TODO Auto-generated method stub

	}

	private void fastest() {
		// TODO Auto-generated method stub

	}

	private void longestRange() {
		// TODO Auto-generated method stub

	}

	private void loadCargo() {
		// TODO Auto-generated method stub

	}

	private void dogFight() {
		// TODO Auto-generated method stub

	}

	public void addJets() {

	}

	private void removeJets() {
		// TODO Auto-generated method stub

	}

	public void displayUserMenu() {
		System.out.println(" ____________________________________");
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

	public int userChoice() {
		System.out.print("Please pick an option: ");
		int input = -1;
		try {
			input = sc.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Invalid input, try again");
		}

		sc.nextLine();
		return input;
	}

}
