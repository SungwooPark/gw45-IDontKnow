package info.gridworld.grid;

import java.util.ArrayList;

public class SparseBoundedGrid extends AbstractGrid<E>{
    private ArrayList<SparseGridNode> sparseArray;

    public SparseBoundedGrid(int rows, int cols){
        sparseArray = new ArrayList<SparseGridNode>();
        for (int i=0;i<rows;i++){
            sparseArray.add(null);
        }
    }

    public int getNumRows(){
        return sparseArray.getSize();
    }

    //How to implement getNumCol()??

    public boolean isValid(location loc){
        return 0 <= loc.getRow() < getNumRows() && 0 <= low.getCol <= getNumCols;
    }

    public E put(Location loc, E obj){
        int row = loc.getRow();
        SparseGridNode nodeToAdd = new SparseGridNode(obj,loc.getCol(),sparseArray.get(row));
        sparseArray.set(0,nodeToAdd);
    }

    public E remove(Location loc){
        int row = loc.getRow();
        SparseGridNode temp = sparseArray.get(row);
        if (temp.getInt() == loc.getCol()){
            sparseArray.set(0,temp.sgetNext());
        }else{
            while (temp.getNext() != null){
                if (temp.getNext().getInt() == loc.getCol()){
                    E toReturn = temp.getNext().getCargo();
                    temp.setNext(temp.getNext().getNext());
                    return toReturn;
                }
                temp = temp.getNext();
            }
        }
    }
}
