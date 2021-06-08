package buildings;


import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import units.Archer;
import units.Unit;
import exceptions.BuildingInCoolDownException;

public class ArcheryRange extends MilitaryBuilding {

	public ArcheryRange(int cost, int upgradeCost, int recruitmentCost) {
		super(cost, upgradeCost, recruitmentCost);
		
	}
	
	
	
	// Just adding empty constructor 
	public ArcheryRange() {
		super(1500, 800, 400);
	}



	/***********************/
	// Milestone 2 Code 
	
	
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException {
		if (this.getCoolDown())
			throw new BuildingInCoolDownException ();
		if (this.getLevel()>= 3)
			throw new MaxLevelException ();
		
		if (this.getLevel() == 1) {
			this.setLevel(2);
			this.setUpgradeCost(700);
			this.setRecruitmentCost(450);
		}
		
		if (this.getLevel() == 2) {
			this.setLevel(3);
			this.setRecruitmentCost(500);
		}
	}
	
	
	
	@Override
	public Unit recruit() throws BuildingInCoolDownException, MaxRecruitedException {
		if (this.getCurrentRecruit() == this.getMaxRecruit())
			throw new MaxRecruitedException();
		if (this.getCoolDown())
			throw new BuildingInCoolDownException ();
		
		// Incrementing Current Recruit 
		this.setCurrentRecruit(this.getCurrentRecruit()+1);
		
		
		// Setting properties of the new Unit
		Archer recruitedArcher = null;
		if (this.getLevel() == 1 ) 
			recruitedArcher=  new Archer (1,60, 0.4, 0.5,0.6);
		
		if (this.getLevel() == 2)
			recruitedArcher = new Archer (2,60,0.4,0.5,0.6);
		
		if (this.getLevel() == 3)
			recruitedArcher = new Archer (3, 70, 0.5, 0.6,0.7);
			
		
		
		return recruitedArcher;
			
	}

}
