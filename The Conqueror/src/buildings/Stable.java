package buildings;

public class Stable extends MilitaryBuilding{

	public Stable(int cost, int upgradeCost, int recruitmentCost) {
		super(cost, upgradeCost, recruitmentCost);
		cost = 2500;
		upgradeCost =1500;
		recruitmentCost = 600;
	}

}
