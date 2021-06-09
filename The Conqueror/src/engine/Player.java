package engine;
import java.util.ArrayList;

import buildings.*;
import exceptions.*;

import units.*;

public class Player {
	// Player class finished 
	
//Instance variables
	private String name;
	private ArrayList<City> controlledCities = new ArrayList<City>();
	private ArrayList<Army> controlledArmies = new ArrayList<Army>();
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
	
/*
	public void recruitUnit(String type,String cityName) throws
	BuildingInCoolDownException, MaxRecruitedException, NotEnoughGoldException	
	{	int i = 0;
		double neededCost = 0;
		boolean flag = false;
		City currentCity ;
		Building usedBuilding ;
		Unit newUnit =null  ;
		
		
		while (!flag && i < controlledCities.size()) 
		{
			
			currentCity = (City)controlledCities.get(i);
			
			if (currentCity.getName() == cityName)
			{	
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
				else  {
					currentCity.getDefendingArmy().getUnits().add(newUnit);
					newUnit.setParentArmy(currentCity.getDefendingArmy());
					treasury = treasury - neededCost;
					}
				flag = true;
			}
			
			i++;
			
		}
		
		
	}
	
	
		
	*/
	
	public void recruitUnit(String type,String cityName) throws BuildingInCoolDownException, MaxRecruitedException, NotEnoughGoldException {
		
		City givenCity = null;
		for (City c : this.controlledCities) {
			if (c.getName().equals(cityName))
				givenCity = c;
		}
	
		
			
		
		MilitaryBuilding buildingThatWillRecruitUnit = null;
		
		for (MilitaryBuilding b : givenCity.getMilitaryBuildings()) {
			
			if (type.equals("Archer") && b instanceof ArcheryRange) {
				buildingThatWillRecruitUnit = b;
			}
			
			if (type.equals("Infantry") && b instanceof Barracks) {
				buildingThatWillRecruitUnit = b;
			}
			
			if (type.equals("Cavalry") && b instanceof Stable) {
				buildingThatWillRecruitUnit = b;
				
			}
			
		}
		
		Unit recruitedUnit = buildingThatWillRecruitUnit.recruit();
		
		
		if (buildingThatWillRecruitUnit.getRecruitmentCost() > treasury)
			throw new NotEnoughGoldException ("Not Enough gold to Recrit Units from that building");

		else {
			recruitedUnit.setParentArmy(givenCity.getDefendingArmy());
			givenCity.getDefendingArmy().getUnits().add(recruitedUnit);
			this.setTreasury(this.getTreasury() - buildingThatWillRecruitUnit.getRecruitmentCost());
			
		}
		
	}
	
	
	
	 public void build(String type,String cityName) throws NotEnoughGoldException{
		City currentCity = null;
		boolean found = false;
		int i =0;
		Building newBuilding = null;
		while (!found && i < controlledCities.size()) {
			
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
		if( newBuilding != null) {
		if (treasury < newBuilding.getCost())
			throw new NotEnoughGoldException();
		else if (newBuilding instanceof EconomicBuilding)
			currentCity.getEconomicalBuildings().add((EconomicBuilding) newBuilding);
		else 
			currentCity.getMilitaryBuildings().add((MilitaryBuilding) newBuilding);
		
		this.setTreasury(getTreasury()  - newBuilding.getCost()); 
		}



		
	 }
	 
	 
	 public void upgradeBuilding(Building b) throws NotEnoughGoldException,BuildingInCoolDownException, MaxLevelException{
		 if (b.getLevel() == 3) {
			 throw new MaxLevelException ("This building can't be upgraded");
		 }
		 
		 if (b.getUpgradeCost() > this.treasury)
			 throw new NotEnoughGoldException ("Not enough gold to upgrade this Building"); 
		 
		 if (b.isCoolDown())
			 throw new BuildingInCoolDownException("Building in Cooldown");
		
		 for (City c : this.getControlledCities()) {
			 ArrayList<EconomicBuilding> currentCityEconomicalBuildings = c.getEconomicalBuildings();
			 ArrayList<MilitaryBuilding> currentCityMilitaryBuildings = c.getMilitaryBuildings();
			 
			 if (currentCityEconomicalBuildings.contains(b)) {
				 
				   	 b.upgrade();
					 this.setTreasury(this.getTreasury()-b.getUpgradeCost());
					
				 
			 }
			 
			 if (currentCityMilitaryBuildings.contains(b)) {
				 
				 	 b.upgrade();
					 this.setTreasury(this.getTreasury()-b.getUpgradeCost());
					 
				 
			 }
		 }
	 }
	 
	 
	 
	 public void initiateArmy(City city,Unit unit) {
		 
		 
		 Army newArmy = new Army (city.getName());
		 
		 // ArrayList containing the input unit to be added to the new army 
		 ArrayList<Unit> newArmyUnits = new ArrayList<>();
		 
		 //add the given units to the new army units
		 newArmyUnits.add(unit);
		 newArmy.setUnits(newArmyUnits);
		 
		 //remove the given unit from the given city's defending army
		 city.getDefendingArmy().getUnits().remove(unit);
		 
		 //update the parentArmy of the given unit.
		 unit.setParentArmy(newArmy);
		 
		 //adds the new army to the controlled armies.
		 this.controlledArmies.add(newArmy);
		 
		 
	 }
	 
	 
	 
	 
	 public void laySiege(Army army,City city) throws TargetNotReachedException, FriendlyCityException {
		 if (this.controlledCities.contains(city))
			 throw new FriendlyCityException ("A player can't lay Siege on a city he is defending ");
		 
		 if (!(army.getCurrentLocation() == city.getName()))
			 throw new TargetNotReachedException();
		 
		 
		 
		 city.setUnderSiege(true);
		 army.setCurrentStatus(Status.BESIEGING);
		 
	 }
	
	

	

}
