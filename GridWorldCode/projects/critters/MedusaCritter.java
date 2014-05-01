/*
A new type of Critter has appeared on the scene:

MedusaCritter Specs:
-MedusaCritter can turn the actor in front of it into a rock by removing it and spawning a rock object on the location.
-Class MedusaCritter inherits all methods and variables/constants of superclasses Critter and Actor. Below are overwritten methods

-processActors(Actor a){//Overwrites processActors() of superclass Critter
    If the actorâ€™s direction is the direction of the medusaâ€™s + 180 && the actor is directly in front of the medusa (basically, eye contact and one space away), the actor in front will be removed and replaced by a rock UNLESS it is a Critter or Rock
}
-ArrayList<Actor> getActors(){//Overwrites getActors() of superclass Critter
    Only obtains critter directly in front for processing. Dependent on direction of MedusaCritter executing code. Returns ArrayList consisting of all objects one space ahead*/
}


 */

 public class MedusaCritter extends Critter {

 
     package info.gridworld.actor; 
     
     import info.gridworld.grid.Location; 
     import java.util.ArrayList; 
     
     public ArrayList<E> getNeighbors(Location loc) {
	 
     }
/** 
 * A Critter is an actor that moves through its world, processing 
 * other actors in some way and then moving to a new location. 
 * Define your own critters by extending this class and overriding any methods of this class except for act. 
 * When you override these methods, be sure to preserve the postconditions. 
 * The implementation of this class is testable on the AP CS A and AB Exams. 
 */ 
 /** 
 * A critter acts by getting a list of other actors, processing that list, getting locations to move to, 
 * selecting one of them, and moving to the selected location. 
 */ 
     public void act() {
	 if (getGrid() == null) 
	     return; 
	 ArrayList<Actor> actors = getActors(); 
	 processActors(actors); 
	 ArrayList<Location> moveLocs = getMoveLocations(); 
	 Location loc = selectMoveLocation(moveLocs); 
	 makeMove(loc); 
 } 
 
 
 
 /** 
 * Gets the actors for processing. Implemented to return the actors that occupy neighboring grid locations. 
 * Override this method in subclasses to look elsewhere for actors to process. 
 * Postcondition: The state of all actors is unchanged. 
 * @return a list of actors that this critter wishes to process 
 */ 
 public ArrayList<Actor> getActors() 
 { 
     //want to get actors that are only ahead of this critter 
     return getGrid().getNeighbors(getLocation()); 
 } 

/** 
 * Processes the elements of actors. New actors may be added to empty locations. 
 * Implemented to “eat” (i.e., remove) selected actors that are not rocks or critters. 
 * Override this method in subclasses to process actors in a different way. 
 * Postcondition: (1) The state of all actors in the grid other than this critter and the 
 * elements of actors is unchanged. (2) The location of this critter is unchanged. 
 * @param actors the actors to be processed 
 */ 
     public void processActors(ArrayList<Actor> actors) { 
	  Rock r = new Rock();
	  int dir = getDirection();
               
                        for (Actor a: actors)
                        {
                                if (a.getDirection() == (dir - 180) || (a.getDirection() == (dir + 180)))
                                {
                                        Location loc = a.getLocation();
                                        a.removeSelfFromGrid();
                                        r.putSelfInGrid(getGrid(), loc);
                                }
                        }
     } 
 
 
 /** 
 * Gets a list of possible locations for the next move. These locations must be valid in the grid of this critter. 
 * Implemented to return the empty neighboring locations. Override this method in subclasses to look 
 * elsewhere for move locations. 
 * Postcondition: The state of all actors is unchanged. 
 * @return a list of possible locations for the next move 
 */ 
     public ArrayList<Location> getMoveLocations() {
	 //want to get locations of bugs that are 
	 return getGrid().getEmptyAdjacentLocations(getLocation()); 
     } 
 
 
 /** 
 * Selects the location for the next move. Implemented to randomly pick one of the possible locations, 
 * or to return the current location if locs has size 0. Override this method in subclasses that 
 * have another mechanism for selecting the next move location. 
 * Postcondition: (1) The returned location is an element of locs, this critter’s current location, or null. 
 * (2) The state of all actors is unchanged. 
 * @param locs the possible locations for the next move 
 * @return the location that was selected for the next move 
 */ 
     public Location selectMoveLocation(ArrayList<Location> locs) {
	 int n = locs.size(); 
	 if (n == 0) 
	     return getLocation(); 
	 int r = (int) (Math.random() * n); 
	 return locs.get(r); 
     }

/** 
 * Moves this critter to the given location loc, or removes this critter from its grid if loc is null. 
 * An actor may be added to the old location. If there is a different actor at location loc, that actor is 
 * removed from the grid. Override this method in subclasses that want to carry out other actions 
 * (for example, turning this critter or adding an occupant in its previous location). 
 * Postcondition: (1) getLocation() == loc. 
 * (2) The state of all actors other than those at the old and new locations is unchanged. 
 * @param loc the location to move to 
 */ 
     public void makeMove(Location loc) {
	 if (loc == null) 
	     removeSelfFromGrid(); 
	 else 
	     moveTo(loc); 
     } 

}
