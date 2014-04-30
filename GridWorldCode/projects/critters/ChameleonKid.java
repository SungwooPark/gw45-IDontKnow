public class ChameleonKid extends ChameleonCritter{
    public void processActors(ArrayList<Actor> actors){
        Actor other = get(new Location(getNumRows()-1,getNumCols());//Gets an object in front
        setColor(other.getColor());
    }
}
