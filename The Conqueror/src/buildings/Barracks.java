package buildings;

public class Barracks extends MilitaryBuilding{

	public Barracks(int cost, int upgradeCost, int recruitmentCost) {
		super(cost, upgradeCost, recruitmentCost);
		cost = 2000;
		upgradeCost = 1000;
		recruitmentCost = 500;
	}

}
