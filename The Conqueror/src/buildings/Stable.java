package buildings;


import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import units.Cavalry;
import units.Infantry;
import units.Unit;
import exceptions.BuildingInCoolDownException;

public class Stable extends MilitaryBuilding{

	public Stable(int cost, int upgradeCost, int recruitmentCost) {
		super(cost, upgradeCost, recruitmentCost);
		
		
	}

	
	public Stable() {
		super(2500,1500,600);
	}
	
	
	
	/***********************/
	// Milestone 2 Code 
	
	
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException {
		if (this.isCoolDown())
			throw new BuildingInCoolDownException ();
		if (this.getLevel()== 3)
			throw new MaxLevelException ();
		
		if (this.getLevel() == 1) {
			this.setLevel(2);
			this.setUpgradeCost(2000);
			this.setRecruitmentCost(650);
		}
		
		if (this.getLevel() == 2) {
			this.setLevel(3);
			this.setRecruitmentCost(700);
		}
	}


	

	
	@Override
	public Unit recruit() throws BuildingInCoolDownException, MaxRecruitedException {
		if (this.getCurrentRecruit() == this.getMaxRecruit())
			throw new MaxRecruitedException();
		if (this.isCoolDown())
			throw new BuildingInCoolDownException ();
		
		// Incrementing Current Recruit 
		this.setCurrentRecruit(this.getCurrentRecruit()+1);
		
		
		// Setting properties of the new Unit
		Cavalry recruitedCavalry = null ; 
		if (this.getLevel() == 1 ) 
			
			recruitedCavalry = new Cavalry (1, 40, 0.6, 0.7,0.75);
		
		if (this.getLevel() == 2)
			recruitedCavalry = new Cavalry (2, 40, 0.6, 0.7,0.75 );
		
		if (this.getLevel() == 3)
			recruitedCavalry = new Cavalry (3,60,0.7,0.8,0.9);
			
		
		
		return recruitedCavalry ;
			
	}
}
