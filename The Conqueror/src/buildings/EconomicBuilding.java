package buildings;

public abstract class EconomicBuilding extends Building {

	public EconomicBuilding(int cost, int upgradeCost) {
		super(cost, upgradeCost);
	}
	
	
	
	/************************/
	//Milestone 2 Code
	public abstract int harvest();

}
