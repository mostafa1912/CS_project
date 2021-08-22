# CS_project
This is a team project that consists of building a game using java and java fx.


The Conqueror
This is a single player turn-based empire building game. A player initially chooses one historical city to start his empire with. The goal is to conquer the whole world by taking control over every other city under a certain number of turns. In order to achieve this goal, the player has the option of building various types of building in any city he has control over and also build armies in order to conquer other cities.

Winning/Loosing
The player wins if he managed to conquer all cities available in the game under the deter-
mined amounts of turns. If these turns passed and the player did not achieve this goal, this is
considered a loss.

Conquering a city
Each city has an army that defends it from conquerors. The player needs to build a powerful
army and defeat the defending army in order to take control over the city. Once the attacking
army reaches the city, it can either lay siege on the target city trying to starve them out or
directly attack the defending army. If the player chooses to besiege the city, the defending
army will gradually lose soldiers each turn the city is under siege. However, the player can
only besiege a city for a max of three turns. During these three turns, the player can choose
to break the siege and leave the city or directly fight the defending army. If these three turns
passed, the player has to fight the defending army in a decisive battle. When the player engages
the defending army in a battle, he can choose to either automatically resolves the battle or
he manually commands his units during it. In auto resolve mode, a random unit from the
attacking army will attack another random unit from the defending army then, same action
happens but this time the defending army is be the attacker and so on till one of the two
armies are completely destroyed. In all cases, only the attacked unit receives damage and have
some of its soldiers lost during the attack. The attacking unit does not receive any damage
in the process. In the manual mode, the battle starts by the player choosing one of his units
to attack another unit in the defending army followed by a random unit from the defending
army attack another random unit from the player's army and so on till one of the two armies is
destroyed. Once the city's defending army is defeated, the player takes control over it and can
build any building or recruit any unit inside it.

Available resources
Throughout his journey of conquering the world, the player has two major resources that he
can spend in order to achieve his goal namely gold and food.
1. Gold is the main resource needed to build or upgrade any building and also to recruit
units. Gold is also be used to maintain and upkeep any army the player controls. The
player has to pay a certain amount of gold each turn for this purpose. If the player does
not have enough gold to maintain/upkeep his army, soldiers in his armies is gradually
lose faith and leave the army each turn until the player has enough gold to maintain his
army again.
2. Food, on the other hand, is used to keep the soldiers in the player's army alive. All
soldiers consume a certain amount of food each turn. They consume more while marching
to a city and is consume the most while besieging the city. If the player does not have
sufficient amount of food for all of his soldiers, they is gradually die each turn until he
has enough food again to feed his army.

Buildings
The player can build multiple types of buildings to help him achieving his goal of conquering
the world. There are two types of buildings, economic and military. Economic buildings help
the player builds his economy as well as provide enough food supplies for his army. Military
buildings are the ones that the player is use to build his armies by recruiting different types of
units. Buildings can be upgraded to enhance their effects. The higher the level of the building,
the better its outcome. Each turn, the player can only do one action per building. Either
building it, upgrading it or recruit units from it (for military buildings). Military buildings also
have a max number of units that can be recruited from them per turn.
1 Economic Buildings
1. Markets: these buildings are the source of gold for the player. The more markets he
controls, the more profit he gains hence, the bigger his treasury is. The gained profit can
be used in constructing other buildings, upgrading them and recruit units.
2. Farms: They provide the food supplies of the army. The bigger the army, the bigger the
supply it is need. The player is need to balance the size of his army and the supplies
he can provide to his army
2 Military Buildings and units
1. Archery Range: This building will enable the player to recruit archers. Archers can attack
from range using their bows. They have great advantage over foot units but greatly
vulnerable to mounted units.
2. Barracks: This building will enable the player to recruit infantry. Infantry units are
foot units that can engage in hand-to-hand combat. They have good advantage against
mounted units but vulnerable against archers
3. Stable: This building will enable the player to recruit cavalry units. Cavalry units are
horse riders that can charge fast towards their enemies dealing great damage. They are
supreme against archers, good against infantry units and mediocre against other cavalry
units.


