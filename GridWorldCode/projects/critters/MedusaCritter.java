import  info.gridworld.actor; 
     
import info.gridworld.grid.Location; 
import java.util.ArrayList; 
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
    
    public ArrayList<Actors> getActors(){
        ArrayList<Actors> actors = new ArrayList<Actors>();
        if (getDirection() == 0){
            Location loc = new Lacation(getLocation.getRow()-1,getLocation().getCol());
            if (isValid(loc){
                actors.add(loc);
            }else{
                return null;
            }
        }
        if else (getDirection() == 90){
            Location loc = new Lacation(getLocation.getRow(),getLocation().getCol()+1);
            if (isValid(loc){
                actors.add(loc);
            }else{
                return null;
            }
        }
        if (getDirection() == 180){
            Location loc = new Lacation(getLocation.getRow()+1,getLocation().getCol());
            if (isValid(loc){
                actors.add(loc);
            }else{
                return null;
            }
        }
        if (getDirection() == 270){
            Location loc = new Lacation(getLocation.getRow(),getLocation().getCol()-1);
            if (isValid(loc){
                actors.add(loc);
            }else{
                return null;
            }
        }
        return actors;
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
