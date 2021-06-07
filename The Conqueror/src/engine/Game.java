package engine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import units.Archer;
import units.Army;
import units.Cavalry;
import units.Infantry;
import units.Unit;

public class Game {
	
//Instance Variables	
	private Player player;
	private ArrayList<City> availableCities = new ArrayList<>();
	private ArrayList<Distance> distances = new ArrayList<>();
	private final int maxTurnCount = 30;
	private int currentTurnCount = 1;
	
	
	
// Constructor
	public Game(String playerName,String playerCity) throws IOException{
		
		Player playerTmp = new Player(playerName);

		
		// Loading all cities and distances
		loadCitiesAndDistances();
		
		
		
		// Initializing the armies of the defending cities
		for (int i = 0 ; i < availableCities.size(); i ++ ) { 
			//Name and Path of each available city
			if (!availableCities.get(i).equals(null)) {
			
				String currCityName  =availableCities.get(i).getName(); 
				String currCityPath = currCityName;
				currCityPath = currCityPath.toLowerCase();
				currCityPath = currCityPath+ "_army.csv";
				
				
				
				//Load army if the city is not the player's city
				if (!currCityName.equals(playerCity)){
					loadArmy(currCityName,currCityPath);
				}
				
				//Army of defending City is Null
				else { 
					availableCities.get(i).setDefendingArmy(null);
					playerTmp.getControlledCities().add(availableCities.get(i));
					
				}
			
			}
		}
		
		
		
		
		setPlayer(playerTmp);
		
		
		
	}
	
	
//Setters and Getters
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public int getCurrentTurnCount() {
		return currentTurnCount;
	}
	public void setCurrentTurnCount(int currentTurnCount) {
		this.currentTurnCount = currentTurnCount;
	}
	public ArrayList<City> getAvailableCities() {
		return this.availableCities;
	}
	public ArrayList<Distance> getDistances() {
		return distances;
	}
	public int getMaxTurnCount() {
		return maxTurnCount;
	}
	
	
	
	
// Methods 
	
	public void loadArmy(String cityName,String path) throws IOException{
		
		
		// This method to get the name and to point at the required city in the avaliableCities 
		City currCity = null; 
		String currCityName = "";
		for (int i = 0 ; i < availableCities.size(); i ++ ) {
			City tmpCity = availableCities.get(i);
			String tmpCityName = tmpCity.getName();
			
			// Once we find it 
			if (tmpCityName.equals(cityName)) {
				currCity = tmpCity;
				currCityName = tmpCityName;
			}
		}
		
		
	
		//Creating the army 
		Army newArmy = new Army(cityName);
		
		//This List holds all units read from the csv file
		ArrayList<Unit> unitsFromCSVFile = new ArrayList<>() ; 
		//TYPE,LEVEL
		
		// The buffer reader part
		String currentLine = "";
		FileReader fileReader= new FileReader(path);
		BufferedReader br = new BufferedReader(fileReader);
		while ((currentLine = br.readLine()) != null) {
			//System.out.println(currentLine);
			
			// Parsing the currentLine String
			String [] line= currentLine.split(",");
			String type = line[0];
			int level = Integer.parseInt(line[1]);
			
			int maxSoldier = 0;
			double idleKeep = 0,marchkeep = 0,siegeKeep = 0;
			
			if (type.equals("Archer")) {
				// Set maxSolider 
				if (level == 1 ) { maxSoldier = 60; idleKeep = 0.4; marchkeep= 0.5;siegeKeep=0.6;}
				else if (level == 2) { maxSoldier = 60; idleKeep = 0.4; marchkeep= 0.5;siegeKeep=0.6;}
				else if (level == 3 ) { maxSoldier = 70; idleKeep = 0.5; marchkeep= 0.6;siegeKeep=0.7;}
	
				//Create archer unit and add it to the units read from the csv file
				Unit newArcher = new Archer(level,maxSoldier,idleKeep,marchkeep,siegeKeep);
				unitsFromCSVFile.add(newArcher);
			}
			
			if (type.equals("Infantry")) {
				// Set maxSolider 
				if (level == 1 ) { maxSoldier = 50; idleKeep = 0.5; marchkeep= 0.6;siegeKeep=0.7;}
				else if (level == 2) { maxSoldier = 50; idleKeep = 0.5; marchkeep= 0.6;siegeKeep=0.7;}
				else if (level == 3 ) { maxSoldier = 60; idleKeep = 0.6; marchkeep= 0.7;siegeKeep=0.8;}
	
				//Create archer unit and add it to the units read from the csv file
				Unit newInfantry = new Infantry(level,maxSoldier,idleKeep,marchkeep,siegeKeep);
				unitsFromCSVFile.add(newInfantry);
			}
			
			
			if (type.equals("Cavalry")) {
				// Set maxSolider 
				if (level == 1 ) { maxSoldier = 40; idleKeep = 0.6; marchkeep= 0.7;siegeKeep=0.75;}
				else if (level == 2)  { maxSoldier = 40; idleKeep = 0.6; marchkeep= 0.7;siegeKeep=0.75;}
				else if (level == 3 ) { maxSoldier = 60; idleKeep = 0.7; marchkeep= 0.8;siegeKeep=0.9;}
	
				//Create archer unit and add it to the units read from the csv file
				Unit newCavalry = new Cavalry(level,maxSoldier,idleKeep,marchkeep,siegeKeep);
				unitsFromCSVFile.add(newCavalry);
			}
			
			
			
			newArmy.setUnits(unitsFromCSVFile);
			
			currCity.setDefendingArmy(newArmy);
			
			
			
				
			
		}
		
		
		
		
	}
	
	
	
	private  void loadCitiesAndDistances() throws IOException{ 
		
		// The buffer reader Part
		String currentLine = "";
		FileReader fileReader= new FileReader("distances.csv");
		BufferedReader br = new BufferedReader(fileReader);
		// This loop works line by line 
		while ((currentLine = br.readLine()) != null) {
			// The currentLine variable contains all the values of the line separated by commas
			//CITY1NAME,CITY2NAME,DISTANCE
			//System.out.println(currentLine);
			
			
			// Get data of each line separately and store it in separate variables  
			String [] line= currentLine.split(",");
			String cityName1 = line[0];			
			String cityName2 = line[1];
			int distance = Integer.parseInt(line[2]);

			// These boolean variables are to check if the cities will be added to the avaliable cities or not 
			boolean containsCityName1 = false;
			boolean containsCityName2 = false;
			
	

			// See if input cities are already contained in the game
			for (int i = 0 ; i < availableCities.size(); i ++ ) { 
			
				if (!availableCities.get(i).equals(null)) {
					City curr = availableCities.get(i);
					
					if (curr.getName().equals(cityName1))
						containsCityName1= true;
					if (curr.getName().equals(cityName2))
						containsCityName2= true;
				}
				
				
			}
			
			//Add the cities if they are not already there
			if (!containsCityName1)
				availableCities.add(new City(cityName1));
			if (!containsCityName2)
				availableCities.add(new City(cityName2));
			
		
			
			


			//Add the distances
			this.distances.add(new Distance(cityName1,cityName2,distance));
			
			
			
		
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
