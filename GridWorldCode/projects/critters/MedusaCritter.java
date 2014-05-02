/*****************************************************************
 * Team IDontKnow
 * APCS pd 9
 * HW35 -- GridWorld, Part 4
 * 2014-05-01
 *
 * class MeduseCritter
 *
 * BEACUASE:
 We thought it was a cool and interesting Critter. We liked the idea of changing and actor to a rock, and also the challenge of that. It was a very interesting class that someone designed! 
 * 
 *
 * SPECIFICATIONS:
 MedusaCritter Specs:
 MedusaCritter can turn the actor in FRONT of it into a rock by removing it and spawning a rock object on the location.
 Class MedusaCritter inherits all methods and variables/constants of superclasses Critter and Actor. Below are overwritten methods
 
 processActors(Actor a){//Overwrites processActors() of superclass Critter
 If the actor's direction is the direction of the medusaâ€™s + 180 && the actor is directly in front of the medusa (basically, eye contact and one space away), the actor in front will be removed and replaced by a rock UNLESS it is a Critter or Rock
   }
 ArrayList<Actor> getActors(){//Overwrites getActors() of superclass Critter
 Only obtains critter directly in front for processing. Dependent on direction of MedusaCritter executing code. Returns ArrayList consisting of all objects one space ahead
 *
 * TEST CASES:
 * T2-There is a non-rock-non-critter actor on the tile ahead but not facing the MedusaCritter: act() will not do anything to the actor. The MedusaCritter will then move as specified by the Critter class
 T3-There is a non-rock-non-critter actor on the tile to the right but not facing the MedusaCritter: act() will not do anything to the actor. The MedusaCritter will then move as specified by the Critter class
 T4-There is a rock/critter actor on the tile ahead: act() will not do anything to the actor. The MedusaCritter will then move as specified by the Critter class
 T5-All other scenarios: MedusaCritter will behave as a normal Critter
 *
 * ERRATA:
 * <any extra test cases, any developer decisions, or
 * other judgment calls your team made to get the class working...>
*****************************************************************/

import info.gridworld.actor.Actor; 
import info.gridworld.grid.Grid;     
import info.gridworld.grid.Location; 
import java.util.ArrayList; 
import info.gridworld.actor.Critter;
public class MedusaCritter extends Critter {

    //medusa critter extends critter, so if a method is not changed, it does not have to be rewritten
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
    
    public void act() {
	if (getGrid() == null) 
	    return; 
	ArrayList<Actor> actors = getActors(); 
	processActors(actors); 
	ArrayList<Location> moveLocs = getMoveLocations(); 
	Location loc = selectMoveLocation(moveLocs); 
	makeMove(loc); 
    }  
    */

    public ArrayList<Actor> getActors(){
        ArrayList<Actor> actors = new ArrayList<Actor>();
        if (getDirection() == 0){
            Location loc = new Location(getLocation.getRow()-1,getLocation().getCol());
	    if (isValid(loc)){
                actors.add(loc);
            }
	    else{
                return null;
            }
        }
	else if (getDirection() == 90){
            Location loc = new Location(getLocation.getRow(),getLocation().getCol()+1);
	    if (isValid(loc)){
                actors.add(loc);
            }
	    else{
                return null;
            }
        }
        else if (getDirection() == 180){
            Location loc = new Location(getLocation.getRow()+1,getLocation().getCol());
	    if (isValid(loc)){
                actors.add(loc);
            }
	    else{
                return null;
            }
        }
	else if (getDirection() == 270){
            Location loc = new Location(getLocation.getRow(),getLocation().getCol()-1);
            if (isValid(loc)){
                actors.add(loc);
            }
	    else{
                return null;
            }
        }
        return actors;
    }

/** 
 * Processes the elements of actors. New actors may be added to empty locations. 
 * Implemented to "eat" (i.e., remove) selected actors that are not rocks or critters. 
 * Override this method in subclasses to process actors in a different way. 
 * Postcondition: (1) The state of all actors in the grid other than this critter and the 
 * elements of actors is unchanged. (2) The location of this critter is unchanged. 
 * @param actors the actors to be processed 
 */ 
    public void processActors(ArrayList<Actor> actors) { 
	Rock r = new Rock();
	int dir = getDirection();
               
	for (Actor a: actors)
 {   if (!(a instanceof Rock) || !(a instanceof Critter)){//Makes sure an actor is not a rock or critter
		    if (a.getDirection() == (dir - 180) || (a.getDirection() == (dir + 180)))
			{
			    Location loc = a.getLocation();
			    a.removeSelfFromGrid();
			    r.putSelfInGrid(getGrid(), loc);
			}
		}
	    }
    } 
}
