import info.gridworld.actor.Critter;
import info.gridworld.actor.Actor;
import java.util.ArrayList;
import info.gridworld.grid.Location;

public class BlusterCritter extends Critter {
    private int c;

    public BlusterCritter (){
	//super();
        c = 5;
    }

    public ArrayList<Actor> getActors(){
        return getGrid().getNeighbors(getLocation());
	//We have to somehow modify this to get all neighbors within two boxes.
    } 
}
