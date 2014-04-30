public class BlusterCritter extends Critter{
    private int c;

    public BlusterCritter{
        c = 5;
    }

    public ArrayList<Actor> getActors(){
        return getGrid().getNeighbors(getLocation());//We have to somehow modify this to get all neighbors within two boxes.
    } 
}
