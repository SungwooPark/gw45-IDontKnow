import info.gridworld.grid.Location;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Actor;
import java.util.ArrayList;
import info.gridworld.grid.Grid;
public class ChameleonKid extends ChameleonCritter{
    public ArrayList<Actor> getActors() {
	ArrayList<Actor> actors = new ArrayList<Actor>();
	int[] dirs = {Location.AHEAD, Location.HALF_RIGHT};
	for (Location loc : getLocationsInDirections(dirs)) {
	    Actor a = getGrid().get(loc);
	    if (a != null)
		actors.add(a);
	}
	return actors;
    }

    /** from CrabCritter
     * Finds the valid adjacent locations of this critter in different
     * directions.
     * @param directions - an array of directions (which are relative to the
     * current direction)
     * @return a set of valid locations that are neighbors of the current
     * location in the given directions
     */
    public ArrayList<Location> getLocationsInDirections(int[] directions)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();
    
        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc))
                locs.add(neighborLoc);
        }
        return locs;
	} 
}
