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
		if (this.isCoolDown())
			throw new BuildingInCoolDownException ();
		if (this.getLevel()==3)
			throw new MaxLevelException ();
		else if (this.getLevel() == 1 ) {
			this.setLevel(2);
			this.setUpgradeCost(1000);
			this.setCoolDown(true);
		}
		else if (this.getLevel() == 2 ) {
			this.setLevel(3);
			this.setUpgradeCost(1000);
			this.setCoolDown(true);
		}
		
		
		
	}
	
	
	
	public int harvest() {
		if (this.getLevel() == 1 )
			return 1000;
		else if (this.getLevel() == 2 )
			return 1500;
		else if (this.getLevel() == 3)
			return 2000;
		return 0;
	}

}