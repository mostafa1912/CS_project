package engine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import units.Archer;
import units.Army;
import units.Cavalry;
import units.Infantry;
import units.Status;
import units.Unit;
import buildings.*;
import exceptions.*;

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
				
				// MileStone 2 Setting the Parent Army of the new Unit
				newArcher.setParentArmy(newArmy);
			}
			
			if (type.equals("Infantry")) {
				// Set maxSolider 
				if (level == 1 ) { maxSoldier = 50; idleKeep = 0.5; marchkeep= 0.6;siegeKeep=0.7;}
				else if (level == 2) { maxSoldier = 50; idleKeep = 0.5; marchkeep= 0.6;siegeKeep=0.7;}
				else if (level == 3 ) { maxSoldier = 60; idleKeep = 0.6; marchkeep= 0.7;siegeKeep=0.8;}
	
				//Create archer unit and add it to the units read from the csv file
				Unit newInfantry = new Infantry(level,maxSoldier,idleKeep,marchkeep,siegeKeep);
				unitsFromCSVFile.add(newInfantry);
				
				// MileStone 2 Setting the Parent Army of the new Unit
				newInfantry.setParentArmy(newArmy);
			}
			
			
			if (type.equals("Cavalry")) {
				// Set maxSolider 
				if (level == 1 ) { maxSoldier = 40; idleKeep = 0.6; marchkeep= 0.7;siegeKeep=0.75;}
				else if (level == 2)  { maxSoldier = 40; idleKeep = 0.6; marchkeep= 0.7;siegeKeep=0.75;}
				else if (level == 3 ) { maxSoldier = 60; idleKeep = 0.7; marchkeep= 0.8;siegeKeep=0.9;}
	
				//Create archer unit and add it to the units read from the csv file
				Unit newCavalry = new Cavalry(level,maxSoldier,idleKeep,marchkeep,siegeKeep);
				unitsFromCSVFile.add(newCavalry);
				
				// MileStone 2 Setting the Parent Army of the new Unit
				newCavalry.setParentArmy(newArmy);
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
	
	//code for milestone 2
	public void targetCity(Army army, String targetName) /*This method assigns a target to
	the given army by updating the distancetoTarget to be the distance between the current city
	and the target city. Think about how you will get the correct distance between the two cities. If
	the army is on road to another city then you can’t send it to another city unless it reaches the
	target city first.*/
	{
		//put targets in queue?? or ignore
		int distanceToTarget = 0;
		String currentArmyLocation = army.getCurrentLocation();
		army.setTarget(targetName);
		
		for (Distance d : distances)
		{
			if ((d.getFrom() ==currentArmyLocation && d.getTo() == targetName) ||
					(d.getFrom() == targetName && d.getTo() == currentArmyLocation))
			{
				distanceToTarget = d.getDistance();
				
			}
		}
		if (army.getCurrentStatus()!= Status.MARCHING)
			army.setDistancetoTarget(distanceToTarget);
		
		
		
		
	}
	
	public void endTurn() {
		currentTurnCount++;
		for (City currentCity:player.getControlledCities()) {
			for(EconomicBuilding b : currentCity.getEconomicalBuildings()) {
				b.setCoolDown(false);
				if (b instanceof Market) {
				player.setTreasury(player.getTreasury()+b.harvest());	
				}
				else {
					player.setFood(player.getFood() + b.harvest());
				}
				}
			for(MilitaryBuilding b : currentCity.getMilitaryBuildings()) {
				b.setCoolDown(false);
				b.setCurrentRecruit(0);
			}
			if (currentCity.getUnderSiege()) {
				currentCity.setTurnsUnderSiege(currentCity.getTurnsUnderSiege() + 1);
				Army a = currentCity.getDefendingArmy();
				for(Unit u : a.getUnits()) {
					int decay = (int) (u.getCurrentSoldierCount()*0.1);
					u.setCurrentSoldierCount(u.getCurrentSoldierCount()-decay);
				}
			
			}
		}
		
		int f = 1;
		for (Army currentArmy:player.getControlledArmies()) {
			if(player.getFood()<currentArmy.foodNeeded()) {
			f = (int)player.getFood()/(int)currentArmy.foodNeeded();
			player.setFood(0);
			}
			player.setFood(player.getFood()-currentArmy.foodNeeded());
			// Assuming zero distance to target if no target so no need to check for target (for Seif)
			if (currentArmy.getDistancetoTarget() != 0) {
				currentArmy.setDistancetoTarget(currentArmy.getDistancetoTarget() -1);
			}
			else {
				currentArmy.setTarget("");
			}
			int decay = (int) (f * 0.1);
			if (player.getFood() == 0) {
				for(Unit u : currentArmy.getUnits()) {
					u.setCurrentSoldierCount(u.getCurrentSoldierCount()-u.getCurrentSoldierCount()*decay);
				}
			}
		}
		

		
		
		
	}
	
	
	
	
	public void occupy(Army a,String cityName) {
		City currentCity  = null;
		for(City c : availableCities)
		{
			if(c.getName() == "cityName")
			{
				currentCity = c ;
			}
		}
		player.getControlledCities().add(currentCity);
		currentCity.setDefendingArmy(a);
		currentCity.setTurnsUnderSiege(0);
		currentCity.setUnderSiege(false);
		
	}
	
	public void autoResolve(Army attacker, Army defender) throws
	FriendlyFireException, IOException {
		
		
		 
		
		//armies take turns attacking during the battle until one of them reaches zero unit size
		if(player.getControlledArmies().contains(defender) && player.getControlledArmies().contains(attacker))
			throw new FriendlyFireException("both armies belong to the same player");
		
		boolean attackerTurn = true;
		
		
		// Two armies facing each other till one ends 
		while (attacker.findArmySize() >0 && defender.findArmySize()>0)
		{
			
			int randomNumAttacker =  (int)(Math.random() * attacker.getUnits().size());
			int randomNumDefender =  (int)(Math.random() * defender.getUnits().size());
			Unit attackerUnit = attacker.getUnits().get(randomNumAttacker);
			Unit defenderUnit = defender.getUnits().get(randomNumDefender);
			
			
			
			
			// Two Units facing each other till one ends 
			while (attackerUnit.getCurrentSoldierCount()> 0 && defenderUnit.getCurrentSoldierCount()> 0) {
				if (attackerTurn) {
					attackerUnit.attack(defenderUnit);
					
				}
				else {
					defenderUnit.attack(attackerUnit);
				}
				attackerTurn = !attackerTurn;
			}
			
			attacker.handleAttackedUnit(attackerUnit);
			defender.handleAttackedUnit(defenderUnit);
		
		}
		
		// Check whether to remove the Army from contolled armies or not 
		
		// Attacker army won 
		if (attacker.findArmySize() >0) {
			this.occupy(attacker, defender.getCurrentLocation());
		}
		
		
		
		
	}
	
	
	
	public boolean isGameOver() {
		if (currentTurnCount > this.maxTurnCount)
			return true; 
		
		for (City currentAvaliableCity  : this.availableCities) {
			
			if (!this.player.getControlledCities().contains(currentAvaliableCity))
				return false;
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	

}
