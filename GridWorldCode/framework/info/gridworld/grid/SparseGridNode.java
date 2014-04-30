public class SparseGridNode{
     private Object occupant;
     private int col;
     private SparseGridNode next;

     public SparseGridNode(Object cargo, int colValue, SparseGridNode nextNode){
            occupant = cargo;
            col = colValue;
            next = nextNode;
     }
     
     public Object getCargo(){
        return occupant;
     }

     public void setCargo(Object s){
        occupant = s;
     }

     public int getColValue(){
        return col;
     }

     public SparseGridNode getNext(){
        return next;
     }
}
