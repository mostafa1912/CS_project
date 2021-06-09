package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import units.Archer;
import units.Infantry;
import units.Unit;

public class Barracks extends MilitaryBuilding{

	public Barracks(int cost, int upgradeCost, int recruitmentCost) {
		super(cost, upgradeCost, recruitmentCost);
		cost = 2000;
		upgradeCost = 1000;
		recruitmentCost = 500;
	}
	
	public Barracks(){
		super(2000,1000,500);
	}
	
	
	
	
	
	/***********************/
	// Milestone 2 Code 
	
	
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException {
		if (this.isCoolDown())
			throw new BuildingInCoolDownException ();
		if (this.getLevel()==3)
			throw new MaxLevelException ();
		
		else if (this.getLevel() == 1) {
			 this.setLevel(2);
			this.setUpgradeCost(1500);
			this.setRecruitmentCost(550);
		}
		
		else if (this.getLevel() == 2) {
			this.setLevel(3);
			this.setRecruitmentCost(600);
		}
	}
	
	
	public Unit recruit() throws BuildingInCoolDownException, MaxRecruitedException {
		if (this.getCurrentRecruit() == this.getMaxRecruit())
			throw new MaxRecruitedException();
		if (this.isCoolDown())
			throw new BuildingInCoolDownException ();
		
		// Incrementing Current Recruit 
		this.setCurrentRecruit(this.getCurrentRecruit()+1);
		
		
		// Setting properties of the new Unit
		Infantry recruitedInfantry = null ; 
		if (this.getLevel() == 1 ) 
			
			recruitedInfantry = new Infantry (1, 50, 0.5,0.6,0.7);
		
		if (this.getLevel() == 2)
			recruitedInfantry = new Infantry (2 ,50  ,0.5 ,0.6 ,0.7);
		
		if (this.getLevel() == 3)
			recruitedInfantry = new Infantry (3,60 ,0.6 ,0.7 ,0.8);
			
		
		
		return recruitedInfantry ;
			
	}

}
