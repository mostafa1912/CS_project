package engine;
import java.util.ArrayList;

import buildings.*;
import exceptions.*;

import units.*;

public class Player {
	
//Instance variables
	private String name;
	private ArrayList<City> controlledCities;
	private ArrayList<Army> controlledArmies;
	private double treasury;
	private double food;
	
	
	
// Constructor
	public Player(String name) {
			this.name = name;
			controlledCities = new ArrayList<>();
			controlledArmies = new ArrayList<>();
			
		}
	
	

	

	//Setters and Getters
	public double getTreasury() {
		return treasury;
	}
	public void setTreasury(double treasury) {
		this.treasury = treasury;
	}
	public double getFood() {
		return food;
	}
	public void setFood(double food) {
		this.food = food;
	}
	public String getName() {
		return name;
	}
	public ArrayList<City> getControlledCities() {
		return controlledCities;
	}
	public ArrayList<Army> getControlledArmies() {
		return controlledArmies;
	}

	
	
	/*****************************************/
	/*MileStone 2 Code*/
	

	public void recruitUnit(String type,String cityName) throws
	BuildingInCoolDownException, MaxRecruitedException, NotEnoughGoldException	
	{	int i = 0;
		double neededCost = 0;
		boolean flag = false;
		City currentCity = null;
		Building usedBuilding ;
		Unit newUnit =null  ;
		while (!flag) 
		{
			
			currentCity = (City)controlledCities.get(i);
			i++;
			if (currentCity.getName() == cityName)
			{	
				flag = true;
			}
			
		}
		
		usedBuilding = currentCity.searchBuilding(type);
		
		if (type == "Archer")
		{
			ArcheryRange usedBuilding2 = (ArcheryRange) usedBuilding ;
			newUnit = usedBuilding2.recruit();			
			
			if (usedBuilding2.getLevel() == 1)
				neededCost = 400;
			if (usedBuilding2.getLevel() == 2)
				neededCost = 450;
			if (usedBuilding2.getLevel() == 3)
				neededCost = 500;
			
		}
		if (type == "Infantry")
		{
			Barracks usedBuilding2 = (Barracks) usedBuilding ;
			newUnit = usedBuilding2.recruit();
			if (usedBuilding2.getLevel() == 1)
				neededCost = 500;
			if (usedBuilding2.getLevel() == 2)
				neededCost = 550;
			if (usedBuilding2.getLevel() == 3)
				neededCost = 600;
			
		}
		if (type == "Cavalry")
		{
			Stable usedBuilding2 = (Stable) usedBuilding ;
			newUnit = usedBuilding2.recruit();			
			if (usedBuilding2.getLevel() == 1)
				neededCost = 600;
			if (usedBuilding2.getLevel() == 2)
				neededCost = 650;
			if (usedBuilding2.getLevel() == 3)
				neededCost = 700;
		}
		if (treasury < neededCost) {
			
			throw new NotEnoughGoldException("Not Enough Gold");
			}
		else {
			currentCity.getDefendingArmy().getUnits().add(newUnit);
			newUnit.setParentArmy(currentCity.getDefendingArmy());
			treasury = treasury - neededCost;
			}
	}
	
	
		
		
	
	 public void build(String type,String cityName) throws NotEnoughGoldException{
		City currentCity = null;
		boolean found = false;
		int i =0;
		Building newBuilding = null;
		while (!found) {
			
			currentCity = controlledCities.get(i);
			if(cityName == currentCity.getName())
				found = true;
		
		
		
				i++;
		}
		//need to check for type of building to add 
		
		if (type == "Farm" && !currentCity.checkDuplicateBuilding("Farm")) {
			 newBuilding = new Farm();
		}
		else if (type == "Market" && !currentCity.checkDuplicateBuilding("Market")) {
			 newBuilding = new Market();
		}
		else if (type == "Stable" && !currentCity.checkDuplicateBuilding("Stable")) {
			 newBuilding = new Stable();
			
		}
		else if (type == "ArcheryRange" && !currentCity.checkDuplicateBuilding("ArcheryRange")) {
			newBuilding = new ArcheryRange();
			
		}
		else if (type == "Barracks" && !currentCity.checkDuplicateBuilding("Barracks")) {
			newBuilding = new Barracks();
				}
		//check for gold before adding
		if (treasury < newBuilding.getCost())
			throw new NotEnoughGoldException();
		else if (newBuilding instanceof EconomicBuilding)
			currentCity.getEconomicalBuildings().add((EconomicBuilding) newBuilding);
		else 
			currentCity.getMilitaryBuildings().add((MilitaryBuilding) newBuilding);



		
	 }
	 
	 
	 public void upgradeBuilding(Building b) throws NotEnoughGoldException,BuildingInCoolDownException, MaxLevelException{
		 for (City c : this.getControlledCities()) {
			 ArrayList<EconomicBuilding> currentCityEconomicalBuildings = c.getEconomicalBuildings();
			 ArrayList<MilitaryBuilding> currentCityMilitaryBuildings = c.getMilitaryBuildings();
			 
			 if (currentCityEconomicalBuildings.contains(b)) {
				 if (b.getCost()> this.getTreasury())
					 throw new NotEnoughGoldException ("Not enough gold to upgrade this Building");
				 else { 
					 this.setTreasury(this.getTreasury()-b.getUpgradeCost());
					 b.upgrade();
				 }
			 }
			 
			 if (currentCityMilitaryBuildings.contains(b)) {
				 if (b.getCost()> this.getTreasury())
					 throw new NotEnoughGoldException ("Not enough gold to upgrade this Building");
				 else { 
					 this.setTreasury(this.getTreasury()-b.getUpgradeCost());
					 b.upgrade();
				 }
			 }
		 }
	 }
	
	
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
=======
>>>>>>> Stashed changes
	 public void upgradeBuilding(Building b) throws NotEnoughGoldException,
	 BuildingInCoolDownException, MaxLevelException  

	//Setters and Getters
	public double getTreasury() {
		return treasury;
	}
	public void setTreasury(double treasury) {
		this.treasury = treasury;
	}
	public double getFood() {
		return food;
	}
	public void setFood(double food) {
		this.food = food;
	}
	public String getName() {
		return name;
	}
	public ArrayList<City> getControlledCities() {
		return controlledCities;
	}
	public ArrayList<Army> getControlledArmies() {
		return controlledArmies;
	}

	
>>>>>>> Stashed changes
	
	

}
