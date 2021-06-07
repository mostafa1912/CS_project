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
    
    
      
    public Unit(int level,int maxSoldierCount,double idleUpkeep, double
            marchingUpkeep,double siegeUpkeep){
            
                this.level = level;
                this.maxSoldierCount = maxSoldierCount;
                this.idleUpKeep = idleUpkeep ;
                this.marchingUpKeep = marchingUpkeep;
                this.siegeUpKeep = siegeUpkeep;
               
                // Implementing in the constructor for any future update 
                this.currentSoldierCount = this.maxSoldierCount;
               

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
    

	public Army getParentArmy() {
		return parentArmy;
	}

	public void setParentArmy(Army parentArmy) {
		this.parentArmy = parentArmy;
	}
	
	
	
	 public void attack(Unit target) throws FriendlyFireException , IOException
	    {	
		 
		 	if (this.getParentArmy().equals(target.getParentArmy()))
		 		throw new FriendlyFireException("The current unit can't attack this target as they belong to the same Army ");
		 	
	    	String type = "";
	    	double factor =0.0;
	    	if (this instanceof Archer)
	    		type = "Archers";
	    	else if (this instanceof Infantry)
	    		type = "Infantry";
	    	else if (this instanceof Cavalry)
	    		type = "Cavalry";
	    	
	    	String path = type + "_factor.csv";    	
	    	String currentLine = "";	
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
	    	if (this instanceof Archer) { 
		
			
			while ((currentLine = br.readLine()) != null ) {
				String[] line = currentLine.split(",");
				if ( getLevel() == Integer.parseInt(line[0]))
						factor = Integer.parseInt(line[3]);
			}
			}
	    	else if (this instanceof Infantry) { 
	    		for(int i =0; i < 4 ; i++) 
	    			{currentLine = br.readLine();}
	    		while ((currentLine = br.readLine()) != null ) {
	    			String[] line = currentLine.split(",");
	    			if ( getLevel() == Integer.parseInt(line[0]))
	    					factor = Integer.parseInt(line[3]);
	    		}
	    			
	    		
	    		
	        	}
	    	else if (this instanceof Cavalry) { 
	    		for(int i =0; i < 7 ; i++) 
	    			{currentLine = br.readLine();}
	    		while ((currentLine = br.readLine()) != null ) {
	    			String[] line = currentLine.split(",");
	    			if ( getLevel() == Integer.parseInt(line[0]))
	    					factor = Integer.parseInt(line[3]);
	    		}
	    			
	    		
	    		
	        	}
	    	br.close();
	    	
	    	
	    	currentSoldierCount = (int)(currentSoldierCount - (currentSoldierCount*factor));
	    }
	 
	 
	 
	 	


	
 
}