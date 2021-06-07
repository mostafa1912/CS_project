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

	
	

	public boolean checkDuplicateBuilding(String type) {
		
		int i =0;
		boolean found = false;
		if(type == "Farm")
		{
			while (!found) {
				if (economicalBuildings.get(i) instanceof Farm )
				{
					found = true;
				}
			}
		}
		if(type == "Stable")
		{
			while (!found) {
				if (militaryBuildings.get(i) instanceof Stable )
				{
					found = true;
				}
			}
		}
		if(type == "Market")
		{
			while (!found) {
				if (economicalBuildings.get(i) instanceof Market)
				{
					found = true;
				}
			}
		}
		if(type == "ArcheryRange")
		{
			while (!found) {
				if (militaryBuildings.get(i) instanceof ArcheryRange)
				{
					found = true;
				}
			}
		}
		if(type == "Barracks")
		{
			while (!found) {
				if (militaryBuildings.get(i) instanceof Barracks )
				{
					found = true;
				}
			}
		}
		
		
		return found;
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
		
		public boolean getUnderSiege() {
			return this.underSiege;
		}
		
		public boolean isUnderSiege() {
			return underSiege;
		}
	
	
	
	
	
	//Setters	
	
		public void setDefendingArmy(Army defendingArmy ) {
			this.defendingArmy = defendingArmy;
		}
		
		public void setTurnsUnderSiege(int turnsUnderSiege) {
			this.turnsUnderSiege = turnsUnderSiege;
		}
		
		public void setUnderSiege(boolean underSiege) {
			this.underSiege = underSiege;
		}
	
	
	
	
	
	
}
