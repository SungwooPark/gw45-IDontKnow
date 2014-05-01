import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Actor;
import java.util.ArrayList;
public class KingCrab extends CrabCritter {
    /*
      causes each actor it processes to move 1 location further away from it
      If the actor cannot move away, the KingCrab removes it from the grid.
      When it has completed processing the actors, it moves like a CrabCritter
    */
    public void proccessActors(ArrayList<Actor> actors) {
	for (Actor a: actors) {//using crabcritter, only those processed front
	    Location target = a.getLocation();
	    Grid gr = getGrid();
	    ArrayList<Location> locs = gr.getEmptyAdjacentLocations(target);
	    if (locs.size() == 0) 
		a.removeSelfFromGrid();
	    else {
		int r = (int) (Math.random() * locs.size());
		a.moveTo(locs.get(r));//should direction be considered?
	    }
	}
    }
}
