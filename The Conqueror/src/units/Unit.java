package units;
import java.io.*;
import java.util.*;

import exceptions.*;

public class Unit{
	
    private int level ;
    private int maxSoldierCount ;
    private int currentSoldierCount = maxSoldierCount;
    private double idleUpkeep;
    private double marchingUpkeep;
    private double siegeUpkeep;
    private Army parentArmy;
    
    
      
    public Unit(int level,int maxSoldierCount,double idleUpkeep, double
            marchingUpkeep,double siegeUpkeep){
            
                this.level = level;
                this.maxSoldierCount = maxSoldierCount;
                this.idleUpkeep = idleUpkeep ;
                this.marchingUpkeep = marchingUpkeep;
                this.siegeUpkeep = siegeUpkeep;
               
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
    public double getIdleUpkeep(){
        return this.idleUpkeep;
    }

    public double getMarchingUpkeep(){
        return this.marchingUpkeep ;
    }

    public double getSiegeUpkeep(){
        return this.siegeUpkeep ;
    }
    

	public Army getParentArmy() {
		return parentArmy;
	}

	public void setParentArmy(Army parentArmy) {
		this.parentArmy = parentArmy;
	}
	
	
	/*
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
	    	System.out.println("****************");
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
	    	
			while ((currentLine = br.readLine()) != null ) {
			
				System.out.println(currentLine);
				if (this instanceof Archer) { 
				
			
				System.out.println("dddddddddddddddd");
				String[] line = currentLine.split(",");
				System.out.println(line);
				if ( getLevel() == Integer.parseInt(line[0]))
						factor = Integer.parseInt(line[2]);
				System.out.println(line[0]);
				System.out.println(line[2]);
			}
			
	    	else if (this instanceof Infantry) { 
	    		for(int i =0; i < 4 ; i++) 
	    			{currentLine = br.readLine();}
	    		while ((currentLine = br.readLine()) != null ) {
	    			String[] line = currentLine.split(",");
	    			if ( getLevel() == Integer.parseInt(line[0]))
	    					factor = Integer.parseInt(line[2]);
	    		}
	    			
	    		
	    		
	        	}
	    	else if (this instanceof Cavalry) { 
	    		for(int i =0; i < 7 ; i++) 
	    			{currentLine = br.readLine();}
	    		while ((currentLine = br.readLine()) != null ) {
	    			String[] line = currentLine.split(",");
	    			if ( getLevel() == Integer.parseInt(line[0]))
	    					factor = Integer.parseInt(line[2]);
	    		}
	    			
	    		
	    		
	        	}
			}
	    	br.close();
	    	
	    	
	    	currentSoldierCount = (int)(currentSoldierCount - (currentSoldierCount*factor));
	    }
			
	 */
	 
	 public void attack(Unit target) throws FriendlyFireException { 
		 
		 if (this.getParentArmy().equals(target.getParentArmy()) || this.parentArmy == null || target.parentArmy ==null)
		 		throw new FriendlyFireException("The current unit can't attack this target as they belong to the same Army ");
		 	
		 double factor = 0.0 ; 
		 
		 if (this instanceof Archer) { 
			 
				 if (target instanceof Archer) {
						 if (this.getLevel() ==1)
							 factor  =0.3;
						 if (this.getLevel() ==2)
							 factor  =0.4;
						 if (this.getLevel() ==3)
							 factor  =0.5;
				 }
				 
				 if (target instanceof Infantry) {
					 if (this.getLevel() ==1)
						 factor  =0.2;
					 if (this.getLevel() ==2)
						 factor  =0.3;
					 if (this.getLevel() ==3)
						 factor  =0.4;
				 }
				 
				 if (target instanceof Cavalry) {
					 if (this.getLevel() ==1)
						 factor  =0.1;
					 if (this.getLevel() ==2)
						 factor  =0.1;
					 if (this.getLevel() ==3)
						 factor  =0.2;
				 }
			 
				 
			 
			 
		 }
		 
		 
		 if (this instanceof Infantry) { 
			 
			 if (target instanceof Archer) {
					 if (this.getLevel() ==1)
						 factor  =0.3;
					 if (this.getLevel() ==2)
						 factor  =0.4;
					 if (this.getLevel() ==3)
						 factor  =0.5;
			 }
			 
			 if (target instanceof Infantry) {
				 if (this.getLevel() ==1)
					 factor  =0.1;
				 if (this.getLevel() ==2)
					 factor  =0.2;
				 if (this.getLevel() ==3)
					 factor  =0.3;
			 }
			 
			 if (target instanceof Cavalry) {
				 if (this.getLevel() ==1)
					 factor  =0.1;
				 if (this.getLevel() ==2)
					 factor  =0.2;
				 if (this.getLevel() ==3)
					 factor  =0.25;
			 }
			 
			 
			 
		 
			 
		 
		 
		 }
		 
		 if (this instanceof Cavalry) { 
			 
			 if (target instanceof Archer) {
					 if (this.getLevel() ==1)
						 factor  =0.5;
					 if (this.getLevel() ==2)
						 factor  =0.6;
					 if (this.getLevel() ==3)
						 factor  =0.7;
			 }
			 
			 if (target instanceof Infantry) {
				 if (this.getLevel() ==1)
					 factor  =0.3;
				 if (this.getLevel() ==2)
					 factor  =0.4;
				 if (this.getLevel() ==3)
					 factor  =0.5;
			 }
			 
			 if (target instanceof Cavalry) {
				 if (this.getLevel() ==1)
					 factor  =0.2;
				 if (this.getLevel() ==2)
					 factor  =0.2;
				 if (this.getLevel() ==3)
					 factor  =0.3;
			 }
		 
			 
		 
		 
	 }
		 
		 
		 target.setCurrentSoldierCount( target.getCurrentSoldierCount() -( (int)( factor * this.currentSoldierCount )) );
		 target.parentArmy.handleAttackedUnit(target);
		 if (target.getCurrentSoldierCount() < 0 )
			 target.setCurrentSoldierCount(0);
	 }
	    
	 
	 
	 	


	
 
}