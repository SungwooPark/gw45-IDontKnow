import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Actor;
import java.util.ArrayList;
import java.awt.Color;
public class KingCrab extends CrabCritter {

    public KingCrab() {
	super();
	setColor(Color.CYAN);
    }
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

    /*
    private boolean moveAwayFromCrab(Actor actor){
	//need to see how far away the actor is from the crab and if they can move
	// might be easier/ cleaner with a helper method
	for (Location l ":
}

    private double distance(Location loc){
	//found this interesting thing online, the Point2D class, makes stuff 
	//easier!
	return Point2D.distance(loc.getRow(),loc.getCol(),this.getLocation().getRow(),this.getLocation().getCol())

	    // distance (x1, y1, x2, y2)
    }
	
*/

}
