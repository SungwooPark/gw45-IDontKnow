
//Sydney Caputo
//APCS9
//HW34
//2014-4-29
/*import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;*/


public class ChameleonCritter extends Critter
{
    //SHOULD WE HAVE IT SO IT PRETENDS TO DO THIS?
    private double dark = 0.5; 
    /** 
 * Randomly selects a neighbor and changes this critter’s color to be the same as that neighbor’s. 
 * If there are no neighbors, no action is taken. 
 */ 
    public void processActors(ArrayList<Actor> actors) 
    { 
	int n = actors.size(); 
	if (n == 0) 
	    return; 
	int r = (int) (Math.random() * n); 
	
	Actor other = actors.get(r); 
	setColor(other.getColor()); 
 } 
 
 /** 
 * Turns towards the new location as it moves. 
 */ 
    public void makeMove(Location loc) 
    { 
	setDirection(getLocation().getDirectionToward(loc)); 
	super.makeMove(loc); 
    } 
    //^^copy and pasted the code from the class and all of the imports
    //confused about this 
    private void darken(){
    	Color c = getColor(); //returns the color of this actor 
        int red = (int) (c.getRed() * (1 - dark));
        int green = (int) (c.getGreen() * (1 - dark));
        int blue = (int) (c.getBlue() * (1 - dark));

        setColor(new Color(red, green, blue)); //sets the color of the actor 
    }

}
