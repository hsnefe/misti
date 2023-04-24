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

            for(int i=Table.size();i<Table.size();i++){
                Templist.add(Table.get(i));
            }


            point_sum(Templist);
            Table.clear();
        }
    }


    public void point_sum(ArrayList <Card> SummedCards) {
        int temp_point=0;

        for (int i =0;i<SummedCards.size();i++){

        temp_point+=SummedCards.get(i).getPoint();
        Ppoint+=temp_point;
        }
    }
}



















