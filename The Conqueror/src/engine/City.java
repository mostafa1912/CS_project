package engine;

import java.util.ArrayList;

import buildings.EconomicBuilding;
import buildings.MilitaryBuilding;
import units.Army;

public class City {

// Instance Variables
	private String name ;
	private ArrayList <EconomicBuilding> economicalBuildings;
	private ArrayList<MilitaryBuilding> militaryBuildings;
	private Army defendingArmy ;
	private int turnsUnderSiege;
	private boolean underSiege = false;
	

// Constructor
	public City(String name) {
		this.name = name;
		
	}
	
	
	
//Getters
	public String getName() { 
		return name;
	}

	public  ArrayList<EconomicBuilding> getEconomicalBuildings(){
		return economicalBuildings;
	}
	
	public ArrayList<MilitaryBuilding> getMilitaryBuildings(){
		return militaryBuildings;
	}
	
	public Army getDefendingArmy() {
		return this.defendingArmy;
	}
	
	public int getTurnsUnderSiege() { 
		return this.turnsUnderSiege;
	}
	
	public boolean isUnderSiege() {
		return underSiege;
	}
	
	
	
	
	
//Setters	
	// Here I used the currentLocatrion as it is the variable of Army constructor
	public void setDefendingArmy(String currentLocation) {
		this.defendingArmy = new Army (currentLocation);	
	}
	
	public void setTurnsUnderSiege(int turnsUnderSiege) {
		this.turnsUnderSiege = turnsUnderSiege;
	}
	
	public void setUnderSiege(boolean underSiege) {
		this.underSiege = underSiege;
	}
	
	
	
	
	
	
}
