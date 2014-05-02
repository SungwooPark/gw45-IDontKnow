//use this class to test?
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class Driver {
    public static void main (String[] args) {
	ActorWorld world = new ActorWorld();
	world.add(new Location(3,5), new QuickCrab());
	world.add(new Location(3,6), new Rock());
	world.add(new Location(5,7), new KingCrab());
	world.add(new Location(4,4), new Flower());
	world.add(new Location(1,1), new ChameleonKid());
	world.show();
    }
}
