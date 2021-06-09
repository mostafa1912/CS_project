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
	private ArrayList <EconomicBuilding> economicalBuildings = new ArrayList<EconomicBuilding>();
	private ArrayList<MilitaryBuilding> militaryBuildings = new ArrayList<MilitaryBuilding>();
	private Army defendingArmy = new Army(name) ;
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
			while (!found && i < economicalBuildings.size()) {
				if (economicalBuildings.get(i) instanceof Farm )
				{
					found = true;
					
				}
				i++;
			}
		}
		else if(type == "Stable")
		{
			while (!found  && i < militaryBuildings.size()) {
				if (militaryBuildings.get(i) instanceof Stable )
				{
					found = true;
				}
				i++;

			}
		}
		else if(type == "Market")
		{
			while (!found && i < economicalBuildings.size()) {
				if (economicalBuildings.get(i) instanceof Market)
				{
					found = true;

				}
				i++;

			}
		}
		else if(type == "ArcheryRange")
		{
			while (!found && i < militaryBuildings.size()) {
				if (militaryBuildings.get(i) instanceof ArcheryRange)
				{
					found = true;

				}
				i++;

			}
		}
		else if(type == "Barracks")
		{
			while (!found && i < militaryBuildings.size()) {
				if (militaryBuildings.get(i) instanceof Barracks )
				{
					found = true;

				}
				i++;

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
