package buildings;

public class Building {
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
	public boolean isCoolDown() {
		return coolDown;
	}
	public void setCoolDown(boolean coolDown) {
		this.coolDown = coolDown;
	}
	public int getCost() {
		return cost;
	}
/*teet --- 7etta zyada kman
*/
}
