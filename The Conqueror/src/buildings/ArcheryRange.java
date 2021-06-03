package buildings;

public class ArcheryRange extends MilitaryBuilding {

	public ArcheryRange(int cost, int upgradeCost, int recruitmentCost) {
		super(cost, upgradeCost, recruitmentCost);
		cost = 1500;
		upgradeCost = 800;
		recruitmentCost = 400;
	}

}
