package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;

public abstract class Building {
	// Updated 
	private int cost, upgradeCost;
	private int level = 1;
	private boolean coolDown = true;
	public Building(int cost,int upgradeCost) {
		super();
		this.cost = cost;
		this.upgradeCost=upgradeCost;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getUpgradeCost() {
		return upgradeCost;
	}
	public void setUpgradeCost(int upgradeCost) {
		this.upgradeCost = upgradeCost;
	}
	
	public void setCoolDown(boolean coolDown) {
		this.coolDown = coolDown;
	}
	public boolean isCoolDown() {
		return this.coolDown;
	}
	public int getCost() {
		return cost;
	}
	
	
	
	
	/***************************/ 
	// Milestone 2 Code : 
	
	
	public abstract void upgrade() throws BuildingInCoolDownException, MaxLevelException ; 
	
	
	
	
}
