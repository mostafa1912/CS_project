package units;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Infantry extends Unit {

	public Infantry(int level, int maxSoldierCount, double idleUpkeep, double marchingUpkeep, double siegeUpkeep) {
		super(level, maxSoldierCount, idleUpkeep, marchingUpkeep, siegeUpkeep);
		
	}
	
	
	public double FindFactor() throws IOException { 
    	String currentLine = "";	
    	double factor = 0.0;
    	String path = "Infantry_factor.csv";
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
    	if (getTarget() instanceof Archers) { 
	
		
		while ((currentLine = br.readLine()) != null ) {
			String[] line = currentLine.split(",");
			if ( getLevel() == Integer.parseInt(line[0]))
					factor = Integer.parseInt(line[3]);
		}
			
		
		
    	}
    	
    	else if (getTarget() instanceof Infantry) { 
    		for(int i =0; i < 4 ; i++) 
    			{currentLine = br.readLine();}
    		while ((currentLine = br.readLine()) != null ) {
    			String[] line = currentLine.split(",");
    			if ( getLevel() == Integer.parseInt(line[0]))
    					factor = Integer.parseInt(line[3]);
    		}
    			
    		
    		
        	}
    	else if (getTarget() instanceof Cavalry) { 
    		for(int i =0; i < 7 ; i++) 
    			{currentLine = br.readLine();}
    		while ((currentLine = br.readLine()) != null ) {
    			String[] line = currentLine.split(",");
    			if ( getLevel() == Integer.parseInt(line[0]))
    					factor = Integer.parseInt(line[3]);
    		}
    			
    		
    		
        	}
    	
    	
    	return factor;
    	}
	
	
}
