public class UnboundedGridDoubling<E> extends AbstractGrid<E>{
    private Objects[][] occupantArray;

    public UnboundedGridDobuling(){
        occupantArray = new Objects[16][16];
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
            E toReturn = occupantArray[loc.getRow()][loc.getCol()];
            occupantArray[loc.getRow()][loc.getCol()] = obj;
            return toReturn;
        //Efficiency(Out of Bound): O(n^2)
        }else{
            Objects[][] temp = new Objects[getNumRows()*2][getNumCols()*2];
            for (int i=0;i<occupantArray.lenth;i++){
                for (int j=0;j<occupantArray[i].length;j){
                    temp[i][j] = occupantArray[i][j]
                }
            }
            occupantArray = temp;
            occupantArray[loc.getRow()][loc.getCol()] = obj;
            return null;
        }
    }

    public E remove(Location loc){
        E toReturn = occupantArray[loc.getRow()][loc.getCol()];
        occupantArray[loc.getRow()][loc.getCol()] = null;
        return toReturn;
    }

    //Efficiency: O(1)
    public E get(Location loc){
        return occupantArray[loc.getRow()][loc.getCol()];
    }

    public ArrayList<Location> getOccupiedLocations(){
        ArrayList<Location> locations  = new ArrayList<Location>();
        for (int i=0;i<occupantArray.length;i++){
            for (int j=0;j<occupantArray[i].length;j++){
                if (occupantArray[i][j] != null){
                    Location loc = new Location(i,r);
                    locations.add(loc);
                }
            }
        }
        return locations;
    }


}
