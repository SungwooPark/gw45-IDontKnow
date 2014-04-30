public class RockHounds extends Critter{
    public void processActors(ArrayList<Actor> actors){
        for (Actor a : actors){
            if (a instanceof Rock){
                a.removeSelfFromGrid();
            }
        }
    }
}
