package info.gridworld.grid;

import java.util.ArrayList;

public class UnboundedGridDoubling<E> extends AbstractGrid<E>{
    private Object [][] occupantArray;

    public UnboundedGridDoubling(){
        occupantArray = new Object[16][16];
    }
 
    public int getNumRows(){
        return occupantArray.length;
    }

    public int getNumCols(){
        return occupantArray[0].length;
    }

    public boolean isValid(Location loc){
        return true;
    }

    public E put(Location loc, E obj){
        //Efficiency(Within Bound): O(1)
        if (loc.getRow() < getNumRows() && loc.getCol() < getNumCols()){
            E toReturn = (E)occupantArray[loc.getRow()][loc.getCol()];
            occupantArray[loc.getRow()][loc.getCol()] = obj;
            return toReturn;
        //Efficiency(Out of Bound): O(n^2)
        }else{
            Object[][] temp = new Object[getNumRows()*2][getNumCols()*2];
            for (int i=0;i<occupantArray.length;i++){
                for (int j=0;j<occupantArray[i].length;j++){
                    temp[i][j] = occupantArray[i][j];
                }
            }
            occupantArray = temp;
            occupantArray[loc.getRow()][loc.getCol()] = obj;
            return null;
        }
    }

    public E remove(Location loc){
        E toReturn = (E)occupantArray[loc.getRow()][loc.getCol()];
        occupantArray[loc.getRow()][loc.getCol()] = null;
        return toReturn;
    }

    //Efficiency: O(1)
    public E get(Location loc){
        return (E)occupantArray[loc.getRow()][loc.getCol()];
    }

    public ArrayList<Location> getOccupiedLocations(){
        ArrayList<Location> locations  = new ArrayList<Location>();
        for (int i=0;i<occupantArray.length;i++){
            for (int j=0;j<occupantArray[i].length;j++){
                if (occupantArray[i][j] != null){
                    Location loc = new Location(i,j);
                    locations.add(loc);
                }
            }
        }
        return locations;
    }


}
