import java.util.ArrayList;
import java.util.Objects;

public  class User implements Player {
    private int tempnumber;
    private int temp_point;
    private ArrayList<Card>User_Collected_card = new ArrayList<Card>();
    
    public ArrayList<Card> getUser_Collected_card() {
        return User_Collected_card;
    }


    public void setUser_Collected_card(ArrayList<Card> user_Collected_card) {
        User_Collected_card = user_Collected_card;
    }


    private ArrayList<Card> PHand = new ArrayList<Card>();
    private  int Ppoint;

    public ArrayList<Card> getPhand() {
        return PHand;
    }


    public void setPhand(ArrayList<Card> pPhand) {
        PHand = pPhand;
    }


    public  int getPpoint() {
        return Ppoint;
    }


    public  void setPpoint(int ppoint) {
        Ppoint = ppoint;
    }


    public  void jchecker(ArrayList<Card>Cardlist){
        if(Cardlist.get(Cardlist.size()-1).getRank().equals("10")){
             if (Cardlist.size() > 1 && Cardlist.size() != 2) {
                User_Collected_card.addAll(Cardlist);
                Cardlist.clear();
            } else if (Cardlist.size() == 2) {
                if (Cardlist.get(0).getRank().equals("10")) {
                } else {
                User_Collected_card.addAll(Cardlist);
                Cardlist.clear();
                }
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
                User_Collected_card.addAll(Table);
            }

            Table.clear();
        }
        }
    }


    public void point_sum(ArrayList <Card> SummedCards) {

        for (int i =0;i<SummedCards.size();i++){

            temp_point+=SummedCards.get(i).getPoint();

        }
        Ppoint+=temp_point+tempnumber;
        temp_point = 0;

    }

    public void printAiHand(ArrayList <Card> aihand) {
        for (int i=0;i<aihand.size();i++) {
            System.out.println(aihand.get(i).getRank() + aihand.get(i).getSuit());
        }
    }
}