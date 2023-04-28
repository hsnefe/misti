import java.util.ArrayList;
import java.util.Objects;

public class Regular extends User {
    private static int tempnumber;
    private ArrayList<Card>Regular_Collected_card;
    private static int Regularpoint;
    private  ArrayList<Card>Templist = new ArrayList<Card>();


    @Override
    public void play_card( ArrayList<Card> Table, int index){
        System.out.println("**********");
        System.out.println("ai eli:");
        super.printAiHand(super.getPhand());
        if (Table!=null){
        for (int i=0;i<super.getPhand().size();i++){
                if(Table.size() != 0&& super.getPhand()!=null){
                    if (Objects.equals(Table.get(Table.size() - 1).getRank(), super.getPhand().get(i).getRank())){
                        if (Table.size()==2){
                            System.out.println("!!!!!!!!!!!!!MİŞTİ!!!!!!!!!!!!!");
                            for (int j=0;j<2;j++){
                                tempnumber+=Table.get(j).getPoint();
                            }
                            tempnumber*=5;
                            point_sum(Templist);
                        for(int j=0;j<Table.size();j++){
                            Regular_Collected_card.add(Table.get(j));
                        }
                        }
                        Table.add(super.getPhand().get(i));
                        Table.clear();
                    }
    
                    else if(super.getPhand().get(i).getRank()=="10"){
                        Table.add(super.getPhand().get(i));
                        for(int j=0;j<Table.size();j++){
                            Regular_Collected_card.add(Table.get(j));
                        }
                        Table.clear();
                    }
                }
        }
        if(Table != null&& super.getPhand()!=null){
            if(super.getPhand().get(index) != null){
                Table.add(super.getPhand().get(index));
                super.getPhand().remove(index);
            }
        }
        }
        System.out.println("***********");
        System.out.println("ai eli:");
        super.printAiHand(super.getPhand());
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
