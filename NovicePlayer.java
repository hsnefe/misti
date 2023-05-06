import java.util.Objects;
import java.util.ArrayList;

public class NovicePlayer extends User {
    private static int tempnumber;
    private ArrayList<Card>Novice_Collected_card = new ArrayList<Card>();
    private static int Novicepoint;

    public static int getNovicepoint() {
        return Novicepoint;
    }

    private  ArrayList<Card>Templist = new ArrayList<Card>();



    @Override
    public void play_card( ArrayList<Card> Table, int index) {
        System.out.println("**********");
        System.out.println("ai eli:");
        super.printAiHand(super.getPhand());
        
        if(super.getPhand().get(index) != null) {
            if (super.getPhand().get(index).getRank().equals("10")) {
                Table.add(super.getPhand().get(index));
                super.getPhand().remove(index);
                for(int j=0;j<Table.size();j++){
                    Novice_Collected_card.add(Table.get(j));
                }
                Table.clear();
            } 
            else {
            Table.add(super.getPhand().get(index));
            super.getPhand().remove(index);
            }
        }
        
        if (Table.size() > 1) {    

        if (Objects.equals(Table.get(Table.size() - 1).getRank(), Table.get(Table.size() - 2).getRank())){
            if (Table.size()==1){
                System.out.println("!!!!!!!!!!!!!MİŞTİ!!!!!!!!!!!!!");
                tempnumber+=Table.get(0).getPoint()+super.getPhand().get(index).getPoint();
                tempnumber*=5;
                Templist.remove(Templist.size()-1);
                Templist.remove(Templist.size()-2);
            }

            else {
                for(int i=0;i<Table.size();i++){
                    Templist.add(Table.get(i));
                    Novice_Collected_card.add(Table.get(i));
                }
            }
            point_sum(Templist);
            Table.clear();
            
        }
    }
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