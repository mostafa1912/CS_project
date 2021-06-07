package engine;
import java.util.ArrayList;

import buildings.*;
import exceptions.*;
import units.Army;
import units.Unit;
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
	}
	
	

	public void recruitUnit(String type,String cityName) throws
	BuildingInCoolDownException, MaxRecruitedException, NotEnoughGoldException	
	{	int i = 0;
		boolean flag = false;
		City currentCity = null;
		Building usedBuilding ;
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
			usedBuilding2.recruit();
			treasury = treasury - 
			
		}
		if (type == "Infantry")
		{
			Barracks usedBuilding2 = (Barracks) usedBuilding ;
			usedBuilding2.recruit();
			
		}
		if (type == "Cavalry")
		{
			Stable usedBuilding2 = (Stable) usedBuilding ;
			usedBuilding2.recruit();
			
		}
	
	
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

	
	
	

}
