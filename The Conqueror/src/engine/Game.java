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
	private Player player;
	private ArrayList<City> availableCities;
	private ArrayList<Distance> distances;
	private final int maxTurnCount = 30;
	private int currentTurnCount;

	public Game(String playerName, String playerCity) throws IOException {

		player = new Player(playerName);
		availableCities = new ArrayList<City>();
		distances = new ArrayList<Distance>();
		currentTurnCount = 1;
		loadCitiesAndDistances();
		for (City c : availableCities) {
			if (c.getName().equals(playerCity))

				player.getControlledCities().add(c);

			else
				loadArmy(c.getName(), c.getName().toLowerCase() + "_army.csv");

		}
	}

	private void loadCitiesAndDistances() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("distances.csv"));
		String currentLine = br.readLine();
		ArrayList<String> names = new ArrayList<String>();

		while (currentLine != null) {

			String[] content = currentLine.split(",");
			if (!names.contains(content[0])) {
				availableCities.add(new City(content[0]));
				names.add(content[0]);
			} else if (!names.contains(content[1])) {
				availableCities.add(new City(content[1]));
				names.add(content[1]);
			}
			distances.add(new Distance(content[0], content[1], Integer.parseInt(content[2])));
			currentLine = br.readLine();

		}
		br.close();
	}

	public void loadArmy(String cityName, String path) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(path));
		String currentLine = br.readLine();
		Army resultArmy = new Army(cityName);
		while (currentLine != null) {
			String[] content = currentLine.split(",");
			String unitType = content[0].toLowerCase();
			int unitLevel = Integer.parseInt(content[1]);
			Unit u = null;
			if (unitType.equals("archer")) {

				if (unitLevel == 1)
					u = (new Archer(1, 60, 0.4, 0.5, 0.6));

				else if (unitLevel == 2)
					u = (new Archer(2, 60, 0.4, 0.5, 0.6));
				else
					u = (new Archer(3, 70, 0.5, 0.6, 0.7));
			} else if (unitType.equals("infantry")) {
				if (unitLevel == 1)
					u = (new Infantry(1, 50, 0.5, 0.6, 0.7));

				else if (unitLevel == 2)
					u = (new Infantry(2, 50, 0.5, 0.6, 0.7));
				else
					u = (new Infantry(3, 60, 0.6, 0.7, 0.8));
			} else if (unitType.equals("cavalry")) {
				if (unitLevel == 1)
					u = (new Cavalry(1, 40, 0.6, 0.7, 0.75));

				else if (unitLevel == 2)
					u = (new Cavalry(2, 40, 0.6, 0.7, 0.75));
				else
					u = (new Cavalry(3, 60, 0.7, 0.8, 0.9));
			}
			// Only added Line From MileStone  2
			u.setParentArmy(resultArmy);
			resultArmy.getUnits().add(u);
			currentLine = br.readLine();
		}
		br.close();
		for (City c : availableCities) {
			if (c.getName().toLowerCase().equals(cityName.toLowerCase()))
				c.setDefendingArmy(resultArmy);
				
		}
	}

	public ArrayList<City> getAvailableCities() {
		return availableCities;
	}

	public ArrayList<Distance> getDistances() {
		return distances;
	}

	public int getCurrentTurnCount() {
		return currentTurnCount;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getMaxTurnCount() {
		return maxTurnCount;
	}

	public void setCurrentTurnCount(int currentTurnCount) {
		this.currentTurnCount = currentTurnCount;
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
		
		for (City currentCity: player.getControlledCities()) {
			
			
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
			
		}
		
		int f = 1;
		for (Army currentArmy :  player.getControlledArmies()) {
			
			
			double foodNeededByCurrentArmy = currentArmy.foodNeeded();
			
			player.setFood(player.getFood() - foodNeededByCurrentArmy);
			
			if (player.getFood() < 0 )
				player.setFood(0);
			
			if (player.getFood() == 0) { 
				for (Unit u : currentArmy.getUnits()) {
					u.setCurrentSoldierCount((int) (u.getCurrentSoldierCount() - (0.1 * u.getCurrentSoldierCount())));
					
					if (u.getCurrentSoldierCount() < 0 ) { 
						u.setCurrentSoldierCount(0);
						currentArmy.getUnits().remove(u);
					}
				}
			}
			// Assuming zero distance to target if no target so no need to check for target (for Seif)
			// This Resulted in EndTurn method logic 7 error 
			
			if (currentArmy.getDistancetoTarget() > 0 && currentArmy.getTarget()!="" ) {
				currentArmy.setDistancetoTarget(currentArmy.getDistancetoTarget() -1);
			}
			if (currentArmy.getDistancetoTarget() == 0 ) {
				currentArmy.setCurrentStatus(Status.IDLE);
				currentArmy.setCurrentLocation(currentArmy.getTarget());
				currentArmy.setTarget("");
				currentArmy.setDistancetoTarget(-1);
			}
			
			
			
		}
		
		
		for (City c : this.getAvailableCities()) {
			if (c.isUnderSiege()) {
				c.setTurnsUnderSiege(c.getTurnsUnderSiege() + 1 );
			
				Army a = c.getDefendingArmy();
				for(Unit u : a.getUnits()) {
					int decay = (int) (u.getCurrentSoldierCount()*0.1);
					u.setCurrentSoldierCount(u.getCurrentSoldierCount()-decay);
				}
			}
			
		}
		

		
		
		
	}
	
	
	
	
	public void occupy(Army a,String cityName) {
		City currentCity ;
		
		for(City c : availableCities)
		{	
			if(c.getName().equals(cityName))
			{
				currentCity = c ;
				player.getControlledCities().add(currentCity);
				currentCity.setDefendingArmy(a);
				currentCity.setTurnsUnderSiege(-1);
				currentCity.setUnderSiege(false);
			}
		
		}
		
		
	}
	
	public void autoResolve(Army attacker, Army defender) throws
	FriendlyFireException, IOException {
		
		
		 
		
		//armies take turns attacking during the battle until one of them reaches zero unit size
		if(player.getControlledArmies().contains(defender) && player.getControlledArmies().contains(attacker))
			throw new FriendlyFireException("both armies belong to the same player");
		
		boolean attackerTurn = true;
		
		
		// Two armies facing each other till one ends 
		while (attacker.armyStillHasUnits() && defender.armyStillHasUnits())
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
		if (attacker.getUnits().isEmpty())
			this.player.getControlledArmies().remove(attacker);
		
		// Attacker army won 
		if (attacker.armyStillHasUnits()) {
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
