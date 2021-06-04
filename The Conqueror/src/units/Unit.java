package units;
import java.io.*;
import java.util.*;

import exceptions.*;

public class Unit{
    private int level ;
    private int maxSoldierCount ;
    private int currentSoldierCount = maxSoldierCount;
    private double idleUpKeep;
    private double marchingUpKeep;
    private double siegeUpKeep;
    private Army parentArmy;
    
    private Unit target;
   
    
    
    public void attack(Unit target) throws FriendlyFireException
    {	
    	double factor =0.0;
    	if (this instanceof Archers)
    		factor =Archers.FindFactor()
    	
    	
    	currentSoldierCount = (int)(currentSoldierCount - (currentSoldierCount*factor));
    }

    public int getLevel(){
        return this.level ;
    }
    
    public int getMaxSoldierCount(){
        return this.maxSoldierCount ;
    }

    
    public int getCurrentSoldierCount(){
        return this.currentSoldierCount ;
    }

    
    public void setCurrentSoldierCount(int n){
        this.currentSoldierCount = n ;
        return ;
    }
    public double getIdleUpKeep(){
        return this.idleUpKeep;
    }

    public double getMarchingUpKeep(){
        return this.marchingUpKeep ;
    }

    public double getSiegeUpKeep(){
        return this.siegeUpKeep ;
    }
    public Unit(int level,int maxSoldierCount,double idleUpkeep, double
                marchingUpkeep,double siegeUpkeep){
                
                    this.level = level;
                    this.maxSoldierCount = maxSoldierCount;
                    this.idleUpKeep = idleUpkeep ;
                    this.marchingUpKeep = marchingUpkeep;
                    this.siegeUpKeep = siegeUpkeep;
                  
                    



                    

                }

	public Army getParentArmy() {
		return parentArmy;
	}

	public void setParentArmy(Army parentArmy) {
		parentArmy = parentArmy;
	}

	public static Unit getTarget() {
		return target;
	}

	public void setTarget(Unit target) {
		this.target = target;
	}

	

}