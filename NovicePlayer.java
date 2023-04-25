import java.util.Objects;
import java.util.ArrayList;

public class NovicePlayer  implements Player{
    private static boolean misti;
    private static int tempnumber;
    private ArrayList<Card>Novice_Collected_card;
    private static int Novicepoint;
    private ArrayList<Card>NoviceHand = new ArrayList<Card>();

    private  ArrayList<Card>Templist = new ArrayList<Card>();



    @Override
    public void play_card(ArrayList<Card> NoviceHand, ArrayList<Card> Table, int index) {
        index--;
        if(NoviceHand.get(index) != null){
            Table.add(NoviceHand.get(index));
            NoviceHand.remove(index);
        }

        if (Objects.equals(Table.get(Table.size() - 1).getRank(), Table.get(Table.size() - 2).getRank())){

            if (Table.size()==2){
                System.out.println("!!!!!!!!!!!!!MİŞTİ!!!!!!!!!!!!!");
                for (int i=0;i<2;i++){
                    tempnumber+=Table.get(i).getPoint();
                }
                misti = true;
                tempnumber*=5;

            }


            else {
                for(int i=Table.size();i<Table.size();i++){

                    Templist.add(Table.get(i));
                    Novice_Collected_card.add(Table.get(i));

                }
            }


            if(misti){
                Templist.remove(Templist.size()-1);
                Templist.remove(Templist.size()-2);
            }


            point_sum(Templist);
            Table.clear();
        }


    }

    @Override
    public void point_sum(ArrayList<Card> SummedCards) {
        int temp_point = 0;

        for (int i = 0; i < SummedCards.size(); i++) {

            temp_point += SummedCards.get(i).getPoint();
            Novicepoint += temp_point;
        }

        Novicepoint += tempnumber;
    }
}
