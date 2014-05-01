import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.util.ArrayList;

public class QuickCrab extends CrabCritter {

    /*moves to one of the 2 locations, randomly selected, that are two spaces to its right or left, if that location & the intervening location are both empty.
      Otherwise, a QuickCrab moves like a CrabCritter */

    public ArrayList<Location> getLocationsInDirections(int[] directions) {
	ArrayList<Location> locs = new ArrayList<Location>();
	Grid gr = getGrid();
	Location loc = getLocation();
	for (int d : directions) {
	    int dir = getDirection() + d;
	    Location neighborLoc = loc.getAdjacentLocation(dir);
	    if (gr.isValid(neighborLoc) && gr.get(neighborLoc) == null) {
		Location two = neighborLoc.getAdjacentLocation(dir);
		if (gr.isValid(two))
		    locs.add(two);
	    }
	}
	return locs;
    }
}
