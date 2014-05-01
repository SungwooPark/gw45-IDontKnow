/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;

import java.awt.Color;//For darkening color of critter
/**
 * A <code>ChameleonCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class ChameleonCritter extends Critter
{
    /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's.
if no neighbors, the color of the ChameleonCritter will darken (like a flower)
^ part  4 exercise 1
     */
    public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        if (n == 0) {
	    darken(); 
	    return;
	}
	/*
	Color c = getColor();//gets own color
	int red = (int)( c.getRed() * 0.95);
	int green = (int)(c.getGreen()*0.95);
	int blue = (int)(c.getBlue() * 0.95);
	setColor(new Color(red,green,blue));
	*/
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

     private void darken(){
    	Color c = getColor(); //color of itself
        int red = (int) (c.getRed() * 0.95);
        int green = (int) (c.getGreen() * 0.95);
        int blue = (int) (c.getBlue() * 0.95);

        setColor(new Color(red, green, blue)); //sets the color of itself
    }

}
