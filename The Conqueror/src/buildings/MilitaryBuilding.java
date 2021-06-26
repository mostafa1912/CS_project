package buildings;

import java.io.IOException;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxRecruitedException;
import units.Unit;

public abstract class  MilitaryBuilding extends Building {
	private int recruitmentCost,currentRecruit;
	private final int maxRecruit = 3;

	public int getRecruitmentCost() {
		return recruitmentCost;
	}

	public void setRecruitmentCost(int recruitmentCost) {
		this.recruitmentCost = recruitmentCost;
	}

	public int getCurrentRecruit() {
		return currentRecruit;
	}
	
	public void setCurrentRecruit(int currentRecruit) {
		this.currentRecruit = currentRecruit;
	}

	

	public int getMaxRecruit() {
		return maxRecruit;
	}

	public MilitaryBuilding(int cost, int upgradeCost, int recruitmentCost) {
		super(cost, upgradeCost);
		this.recruitmentCost = recruitmentCost;
	}
	
	
	
	/***********************************/
	// MileStone 2 code 
	public abstract Unit recruit() throws BuildingInCoolDownException, MaxRecruitedException;

}
