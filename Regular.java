import java.util.ArrayList;
import java.util.Objects;

public class Regular implements Player{
    private static boolean misti;
    private static int tempnumber;
    private ArrayList<Card>Regular_Collected_card;
    private static int Regularpoint;
    private ArrayList<Card>RegularHand = new ArrayList<Card>();
    private  ArrayList<Card>Templist = new ArrayList<Card>();


    @Override
    public void play_card(ArrayList<Card> RegularHand, ArrayList<Card> Table, int index) {
        index--;
        for (int i=0;i<RegularHand.size();i++){

            if (Table.get(0)!=null){

                if (Objects.equals(Table.get(Table.size() - 1).getRank(), RegularHand.get(i).getRank())){
                Table.add(RegularHand.get(i));
                }

                else if(RegularHand.get(i).getRank()=="11"){
                    Table.add(RegularHand.get(i));
                }

                else if(RegularHand.get(index) != null){
                    Table.add(RegularHand.get(index));
                    RegularHand.remove(index);
                }

            }

            else if(RegularHand.get(index) != null){
                Table.add(RegularHand.get(index));
                RegularHand.remove(index);
            }
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
                    Regular_Collected_card.add(Table.get(i));

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
            Regularpoint += temp_point;
        }

        Regularpoint += tempnumber;
    }
}
