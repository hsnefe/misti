import java.util.Objects;
import java.util.ArrayList;

public class NovicePlayer extends User {
    private int tempnumber;
    private ArrayList<Card>Novice_Collected_card = new ArrayList<Card>();
    private int Novicepoint;
    private int temp_point;

    public int getNovicepoint() {
        return Novicepoint;
    }
    
    
    public void play_card( ArrayList<Card> Table, int index) {
         System.out.println("**********");
        System.out.println("ai eli:");
        super.printAiHand(super.getPhand());
        
        if(super.getPhand().get(index) != null) {
            if (super.getPhand().get(index).getRank().equals("10")) {
                Table.add(super.getPhand().get(index));
                super.jchecker(Table);
                //super.getPhand().remove(index);
                if (Table.size() > 1) {
                for(int j=0;j<Table.size();j++){
                    Novice_Collected_card.add(Table.get(j));
                }
                super.getUser_Collected_card().addAll(Table);
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
                Table.clear();
            }
            super.getUser_Collected_card().addAll(Table);
            Table.clear();
            
        }
    }
    super.getPhand().remove(index);
   
    System.out.println("**********");
    System.out.println("ai eli:");
    super.printAiHand(super.getPhand());
    }

    @Override
    public void point_sum(ArrayList<Card> SummedCards){

        for (int i = 0; i < SummedCards.size(); i++) {

            temp_point += SummedCards.get(i).getPoint();
        }
        super.setPpoint(temp_point+super.getPpoint());
        super.setPpoint(Novicepoint+super.getPpoint());
        temp_point=0;
    }
}