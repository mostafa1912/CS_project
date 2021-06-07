package engine;

import java.util.ArrayList;
import buildings.*;
import buildings.Building;
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
		this.defendingArmy = new Army(name);
		
	}
	
	public Building searchBuilding (String type)
	{
		int i = 0;
		boolean found = false;
		Building usedBuilding = null ; 
		if(type == "Archer")
		{
			while (!found) {
				
				usedBuilding = militaryBuildings.get(i);
				i++;
				if (usedBuilding instanceof ArcheryRange)
				{
					found = true;
				}
			}
		}
		if(type == "Infantry")
		{
			while (!found) {
				
				usedBuilding = militaryBuildings.get(i);
				i++;
				if (usedBuilding instanceof Barracks)
				{
					found = true;
				}
			}
		}
		
		if(type == "Cavalry")
		{
			while (!found) {
				
				usedBuilding = militaryBuildings.get(i);
				i++;
				if (usedBuilding instanceof Stable)
				{
					found = true;
				}
			}
		}
		
		return usedBuilding;
		
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
