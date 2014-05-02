//<<<<<<< HEAD
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
	super();
        setColor(Color.RED);// does the color matter?
    }

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
    /**
     * @return list of empty locations immediately to the right and to the left
     
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
    
     * If the crab critter doesn't move, it randomly turns left or right.
     
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
    
}
