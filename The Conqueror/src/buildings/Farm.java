package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;



public class Farm extends EconomicBuilding {

	public Farm(int cost, int upgradeCost) {
		super(cost, upgradeCost);
		cost = 1000;
		upgradeCost = 500;
	}
	
	public Farm() {
		super(1000, 500);
	}

	/***********************/
	// Milestone 2 Code 
	
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException {
		if (this.isCoolDown())
			throw new BuildingInCoolDownException ();
		if (this.getLevel()>= 2)
			throw new MaxLevelException ();
		
		this.setLevel(2);
		this.setUpgradeCost(700);
		this.setCoolDown(true);
		
		
	}

	@Override
	public int harvest() {
		if (this.getLevel() == 1 )
			return 500;
		if (this.getLevel() == 2 )
			return 700;
		if (this.getLevel() == 3)
			return 1000;
		return 0;
	}
	

}
