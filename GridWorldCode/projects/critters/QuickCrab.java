import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>CrabCritter</code> looks at a limited set of neighbors when it eats and moves.
 * <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class QuickCrab extends CrabCritter {
    public QuickCrab(){
        setColor(Color.RED);// does the color matter?
    }

    /**
     * A crab gets the actors in the three locations immediately in front, to its
     * front-right and to its front-left
     * @return a list of actors occupying these locations
     */
    /* public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        int[] dirs =
            { Location.AHEAD, Location.HALF_LEFT, Location.HALF_RIGHT };
        for (Location loc : getLocationsInDirections(dirs))
        {
            Actor a = getGrid().get(loc);
            if (a != null)
                actors.add(a);
        }

        return actors;
	}*/

    /**
     * @return list of empty locations immediately to the right and to the left
     */
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
	Grid grid = getGrid();
	if (locs.size==0)
	    return super.getMoveLocations(); // will then move like a crab critter
	else{
	    helperForGML(locs, getDirection() +Location.LEFT); // two ways it could move
	    helperForGML(locs,getDirection()+ Location.RIGHT);}
	return locs;
    }
    public void helperForGML(ArrayList<Location> lo, int direc){
	//to get validity of the locations to go to 

	Grid grid = getGrid();
	Location loc = getLocation();
	Location temp = loc.getAdjacentLocation(direc);
	if(g.get(tmp)==null && g.isValid(temp)){
	    Location temp2 = temp.getAdjacentLocation(dir);
	    if(g.isValid(tmp2) && g.get(temp2)==null)
		loc.add(tmp2); //adding this to list of valid locations 
	}
    }

    }
    /**
     * If the crab critter doesn't move, it randomly turns left or right.
     */
/* public void makeMove(Location loc)
    {
        if (loc.equals(getLocation()))
        {
            double r = Math.random();
            int angle;
            if (r < 0.5)
                angle = Location.LEFT;
            else
                angle = Location.RIGHT;
            setDirection(getDirection() + angle);
        }
        else
            super.makeMove(loc);
    }
*/
    /**
     * Finds the valid adjacent locations of this critter in different
     * directions.
     * @param directions - an array of directions (which are relative to the
     * current direction)
     * @return a set of valid locations that are neighbors of the current
     * location in the given directions
     */
/* public ArrayList<Location> getLocationsInDirections(int[] directions)
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
	}    */ 
}
