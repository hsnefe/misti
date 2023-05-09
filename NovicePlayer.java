import java.util.Objects;
import java.util.ArrayList;

public class NovicePlayer extends User {
    private static int tempnumber;
    private ArrayList<Card>Novice_Collected_card = new ArrayList<Card>();
    
    public ArrayList<Card> getNovice_Collected_card() {
        return Novice_Collected_card;
    }
    public void setNovice_Collected_card(ArrayList<Card> novice_Collected_card) {
        Novice_Collected_card = novice_Collected_card;
    }

    private static int Novicepoint;
    private static int novice_collection_count = 0;

    public static int getNovicepoint() {
        return Novicepoint;
    }

    private  ArrayList<Card>Templist = new ArrayList<Card>();



    @Override
    public void jchecker(ArrayList<Card> Cardlist) {
        if (Cardlist.size() == 2) {
            if (Cardlist.get(0).getRank().equals("10")) {
                System.out.println("!!!!!!!!!!!!!MİŞTİ!!!!!!!!!!!!!");
            for (int i=0;i<2;i++){
                tempnumber+=Cardlist.get(i).getPoint();
            }
            tempnumber*=5;
            Novicepoint+=tempnumber;
            tempnumber=0;
            }
        }
    }
    public void play_card( ArrayList<Card> Table, int index) {
        System.out.println("**********");
        System.out.println("ai eli:");
        super.printAiHand(super.getPhand());
        
        if(super.getPhand().get(index) != null) {
            if (super.getPhand().get(index).getRank().equals("10")) {
                Table.add(super.getPhand().get(index));
                jchecker(Table);
                //super.getPhand().remove(index);
                if (Table.size() > 1) {
                for(int j=0;j<Table.size();j++){
                    Novice_Collected_card.add(Table.get(j));
                }
                Table.clear();
            }
            } 
            else {
            Table.add(super.getPhand().get(index));
            }
        }
        
        if (Table.size() > 1) {    

        if (Objects.equals(Table.get(Table.size() - 1).getRank(), Table.get(Table.size() - 2).getRank())){
            if (Table.size()==2){
                System.out.println("!!!!!!!!!!!!!MİŞTİ!!!!!!!!!!!!!");
                tempnumber+=Table.get(0).getPoint()+super.getPhand().get(index).getPoint();
                tempnumber*=5;
                Novicepoint+=tempnumber;
                tempnumber=0;
                if (novice_collection_count > 0) {
                Templist.remove(Templist.size()-1);
                Templist.remove(Templist.size()-2);
                }
            }

            else {
                for(int i=0;i<Table.size();i++){
                    Templist.add(Table.get(i));
                    Novice_Collected_card.add(Table.get(i));
                    novice_collection_count++;
                }
            }
            point_sum(Templist);
            Table.clear();
            
        }
    }
    super.getPhand().remove(index);
   
    System.out.println("**********");
        System.out.println("ai eli:");
        super.printAiHand(super.getPhand());
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