import java.util.ArrayList;

public class User implements Player {
    private ArrayList<Card> Phand; 
    private int Ppoint;
    public void play_card(ArrayList<Card> Hand, ArrayList<Card> Table, int index){
        index--;
        if(Hand.get(index) != null){
            Table.add(Hand.get(index));
            Hand.remove(index);
        }
    }
}
