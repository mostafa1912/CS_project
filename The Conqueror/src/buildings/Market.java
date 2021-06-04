package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;

public class Market extends EconomicBuilding {

	public Market(int cost, int upgradeCost) {
		super(cost, upgradeCost);
		
	}
	
	public Market() {
		super (1500,700);
	}
	
	
	
	
	
	/***********************/
	// Milestone 2 Code 
	
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException {
		if (this.getCoolDown())
			throw new BuildingInCoolDownException ();
		if (this.getLevel()>= 2)
			throw new MaxLevelException ();
		
		this.setLevel(2);
		this.setUpgradeCost(1000);
		this.setCoolDown(true);
		
		
	}
	
	
	
	public int harvest() {
		if (this.getLevel() == 1 )
			return 1000;
		if (this.getLevel() == 2 )
			return 1500;
		if (this.getLevel() == 3)
			return 2000;
		return 0;
	}

}
