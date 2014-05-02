import info.gridworld.actor.Critter;
import info.gridworld.actor.Actor;
import java.util.ArrayList;
import info.gridworld.grid.Location;
import java.awt.Color;
public class BlusterCritter extends Critter {
    private int c;

    public BlusterCritter (){
	super();
        c = 5;
    }

    public ArrayList<Actor> getActors(){
        return getGrid().getNeighbors(getLocation());
	//We have to somehow modify this to get all neighbors within two boxes.
    }

    public void processActors (ArrayList<Actor> actors) {
	int crowd = 0;
	for (Actor a : actors)
	    if (a instanceof Critter) 
		crowd++;
	if (crowd < c)
	    brighten();
	else 
	    darken();
    }

    //from Chameleon Critter
     private void darken(){
    	Color c = getColor(); //color of itself
        int red = (int) (c.getRed() * 0.95);
        int green = (int) (c.getGreen() * 0.95);
        int blue = (int) (c.getBlue() * 0.95);

        setColor(new Color(red, green, blue)); //sets the color of itself
    } 
}
