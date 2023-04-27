import java.util.ArrayList;
import java.util.Objects;

public  class User implements Player {
    private static boolean misti;
    private static int tempnumber;
    private ArrayList<Card>User_Collected_card = new ArrayList<Card>();
    private ArrayList<Card> PHand = new ArrayList<Card>();
    private static int Ppoint;
    public ArrayList<Card> getPhand() {
        return PHand;
    }


    public void setPhand(ArrayList<Card> pPhand) {
        PHand = pPhand;
    }


    public static int getPpoint() {
        return Ppoint;
    }


    public static void setPpoint(int ppoint) {
        Ppoint = ppoint;
    }


    public ArrayList<Card> Templist = new ArrayList<Card>();



    public   void play_card(ArrayList<Card> Table, int index){
        if(PHand.get(index) != null){
            Table.add(PHand.get(index));
            PHand.remove(index);
        }
        
        if (Table.size() > 1) {
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
                for(int i=0;i<Table.size();i++){

                Templist.add(Table.get(i));
                User_Collected_card.add(Table.get(i));

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
    }


    public void point_sum(ArrayList <Card> SummedCards) {

        int temp_point=0;

        for (int i =0;i<SummedCards.size();i++){

            temp_point+=SummedCards.get(i).getPoint();
            Ppoint+=temp_point;

        }
        Ppoint+=tempnumber;

    }
}
