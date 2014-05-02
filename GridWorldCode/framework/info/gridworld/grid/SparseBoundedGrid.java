package info.gridworld.grid;

import java.util.ArrayList;

public class SparseBoundedGrid<E> extends AbstractGrid<E>{
    private ArrayList<SparseGridNode> sparseArray;
    private int numRows;
    private int numCols;

    public SparseBoundedGrid(int rows, int cols){
        sparseArray = new ArrayList<SparseGridNode>();
        for (int i=0;i<rows;i++){
            sparseArray.add(null);
        }
        numRows = rows;
        numCols = cols;
    }

    public int getNumRows(){
        return numRows;
    }

    public int getNumCols(){
        return numCols;
    }

    public boolean isValid(Location loc){
        return 0 <= loc.getRow() && loc.getRow() <= getNumRows() && 0 <= loc.getCol() && loc.getCol() <= getNumCols();
    }

    public E put(Location loc, E obj){
        int row = loc.getRow();
        SparseGridNode temp = sparseArray.get(loc.getRow());
        while (temp != null){
            if (loc.getCol() == temp.getColValue()){
                E toReturn = (E)temp.getCargo();
                temp.setCargo(obj);
                return toReturn;
            }
        }
        SparseGridNode nodeToAdd = new SparseGridNode(obj,loc.getCol(),sparseArray.get(row));
        sparseArray.set(0,nodeToAdd);
        return null;
    }

    public E remove(Location loc){
        int row = loc.getRow();
        E toReturn = null;
        SparseGridNode temp = sparseArray.get(row);
        if (temp.getColValue() == loc.getCol()){
            toReturn = (E)temp.getCargo();
            sparseArray.set(0,temp.getNext());
        }else{
            while (temp.getNext() != null){
                if (temp.getNext().getColValue() == loc.getCol()){
                    toReturn = (E)temp.getNext().getCargo();
                    temp.setNext(temp.getNext().getNext());
                    return toReturn;
                }
                temp = temp.getNext();
            }
        }
        return toReturn;
    }

    public E get(Location loc){
        int row = loc.getRow();
        SparseGridNode temp = sparseArray.get(row);
        while (temp.getNext() != null){
            if (temp.getColValue() == loc.getCol()){
                return (E)temp.getCargo();
            }
            temp.getNext();
        }
        return null;
    }

    public ArrayList<Location> getOccupiedLocations(){
        ArrayList<Location> locations = new ArrayList<Location>();
        for (int i=0;i<sparseArray.size();i++){
            if (sparseArray.get(i) != null){
                SparseGridNode temp = sparseArray.get(i);
                while (temp != null){
                    locations.add(new Location(i,temp.getColValue()));
                    temp.getNext();
                }
            }
        }
        return locations;
    }
}
