package units;
import java.util.*;

import exceptions.MaxCapacityException;
public class Army{
    private Status currentStatus = Status.IDLE;
    private ArrayList<Unit> units ;
    private int distancetoTarget = -1;
    private String target = "";
    private String currentLocation ;
    private int maxToHold = 10;
	
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
    public Army(String currentLocation) {
    	this.currentLocation = currentLocation;
    }

    
    public void relocateUnit(Unit unit) throws MaxCapacityException { 
    	if (this.units.size() == this.maxToHold)
    		throw new MaxCapacityException();
    	Army parentArmyOfUnit = unit.getParentArmy();
    	
    	// Remove unit from the parent army 
    	parentArmyOfUnit.getUnits().remove(unit);
    	
    	this.units.add(unit);
    	
    	
    	
    }	
   
}