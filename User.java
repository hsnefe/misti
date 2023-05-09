import java.util.ArrayList;
import java.util.Objects;

public  class User implements Player {
    private static int tempnumber;
    private ArrayList<Card>User_Collected_card = new ArrayList<Card>();
    public ArrayList<Card> getUser_Collected_card() {
        return User_Collected_card;
    }


    public void setUser_Collected_card(ArrayList<Card> user_Collected_card) {
        User_Collected_card = user_Collected_card;
    }


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

    public  void jchecker(ArrayList<Card>Cardlist){
        if(Cardlist.get(Cardlist.size()-1).getRank().equals("10")){
             if (Cardlist.size() > 1 && Cardlist.size() != 2) {
                Cardlist.clear();
            } else if (Cardlist.size() == 2) {
                if (Cardlist.get(0).getRank().equals("10")) {
                } else Cardlist.clear();
            }
        }
    }



    public void play_card(ArrayList<Card> Table, int index){
        if(PHand.get(index) != null){
            Table.add(PHand.get(index));
            PHand.remove(index);
            jchecker(Table);
        }

        
        if (Table.size() > 1) {
            if (Objects.equals(Table.get(Table.size() - 1).getRank(), Table.get(Table.size() - 2).getRank())){
                if (Table.size()==2){
                System.out.println("!!!!!!!!!!!!!MİŞTİ!!!!!!!!!!!!!");
                for (int i=0;i<2;i++){
                    tempnumber+=Table.get(i).getPoint();
                }
                tempnumber*=5;
                Ppoint+=tempnumber;
                tempnumber=0;

            }


            else {
                for(int i=0;i<Table.size();i++){

                Templist.add(Table.get(i));
                User_Collected_card.add(Table.get(i));

                }
            }
            point_sum(Templist);
            getUser_Collected_card().addAll(Table);
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

    public void printAiHand(ArrayList <Card> aihand) {
        for (int i=0;i<aihand.size();i++) {
            System.out.println(aihand.get(i).getRank() + aihand.get(i).getSuit());
        }
    }
}
