import java.util.ArrayList;
import java.util.Objects;

public class User implements Player {
    private ArrayList<Card> Phand;
    private int Ppoint;
    public ArrayList<Card> Templist = new ArrayList<Card>();


    public void play_card(ArrayList<Card> Hand, ArrayList<Card> Table, int index){
        index--;
        if(Hand.get(index) != null){
            Table.add(Hand.get(index));
            Hand.remove(index);
        }
        if (Objects.equals(Table.get(Table.size() - 1).getRank(), Table.get(Table.size() - 2).getRank())){

            Templist.add(Table.get(Table.size()-1));
            Templist.add(Table.get(Table.size()-2));

            point_sum(Templist);
            Table.clear();
        }
    }

    @Override
    public void point_sum(ArrayList <Card> SummedCards) {
        int temp_point;
        temp_point=SummedCards.get(SummedCards.size()-1).getPoint() +SummedCards.get(SummedCards.size()-2).getPoint();
        Ppoint+=temp_point;

    }
}



















