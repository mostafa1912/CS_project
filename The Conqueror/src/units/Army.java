package units;
import java.util.*;

import exceptions.MaxCapacityException;
public class Army{
    private Status currentStatus = Status.IDLE;
    private ArrayList<Unit> units = new ArrayList<Unit>();
    private int distancetoTarget = -1;
    private String target = "";
    private String currentLocation ;
    private int maxToHold = 10;
    
    public Army(String currentLocation) {
    	this.currentLocation = currentLocation;
    }
	
	public Status getCurrentStatus() {
		return currentStatus;
	}
	
	public void setCurrentStatus(Status currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	public ArrayList<Unit> getUnits() {
		return units;
	}
	
	public void setUnits(ArrayList<Unit> units) {
		this.units = units;
	}
	
	public int getDistancetoTarget() {
		return distancetoTarget;
	}
	
	public void setDistancetoTarget(int distancetoTarget) {
		this.distancetoTarget = distancetoTarget;
	}
	
	public String getTarget() {
		return target;
	}
	
	public void setTarget(String target) {
		this.target = target;
	}
	
	public String getCurrentLocation() {
		return currentLocation;
	}
	
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
		//can either be in a city or on road to another one...dont know how to do it.
	}
	
	public int getMaxToHold() {
		return maxToHold;
	}
   

    
    public void relocateUnit(Unit unit) throws MaxCapacityException { 
    	if (this.units.size() == this.maxToHold)
    		throw new MaxCapacityException();
    	Army parentArmyOfUnit = unit.getParentArmy();
    	
    	// Remove unit from the parent army 
    	parentArmyOfUnit.getUnits().remove(unit);
    	
    	unit.setParentArmy(this);
    	this.units.add(unit);
    	
    
    }
    
    
    // If unit has no soldiers left it is deleted from Units 
    public void handleAttackedUnit(Unit u) { 
    	if (u.getCurrentSoldierCount() <= 0 )
    		this.units.remove(u);
    }
   
    
    // A method that calculates the food needed from each unit inside the army based on the unit's status.
    public double foodNeeded() { 
    	double amountOfFoodNeeded = 0 ; 
    	
    	if (this.getCurrentStatus() == Status.IDLE) 
    		for (Unit u : this.units) 
    			amountOfFoodNeeded += u.getIdleUpkeep() * u.getCurrentSoldierCount();
        
    	
    	
    	else if (this.getCurrentStatus() == Status.MARCHING) 
    		for (Unit u : this.units) 
    			amountOfFoodNeeded += u.getMarchingUpkeep() * u.getCurrentSoldierCount();
    	
    	
    	else if (this.getCurrentStatus() == Status.BESIEGING) 
    		for (Unit u : this.units) 
    			amountOfFoodNeeded += u.getSiegeUpkeep() * u.getCurrentSoldierCount();
    	
    	
    	
    	return amountOfFoodNeeded;
    }
   
    //helper method to be used in autoresolve in the game class
    public boolean armyStillHasUnits()
    {
    	return !units.isEmpty();
    }
    
    
    
    
    
}