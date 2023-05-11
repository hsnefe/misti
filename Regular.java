import java.util.ArrayList;
import java.util.Objects;
public class Regular extends User {
    private int tempnumber;
    private int temp_point;
    private ArrayList<Card>Regular_Collected_card = new ArrayList<Card>();
    private int Regularpoint;
    public int getRegularpoint() {
        return Regularpoint;
    }
    @Override
    public void play_card( ArrayList<Card> Table, int index){
        int temp_size = Table.size();
        System.out.println("**********");
        System.out.println("ai eli:");
        super.printAiHand(super.getPhand());
        if (Table!=null){
            for (int i=0;i<super.getPhand().size();i++){
                if(Table.size() != 0&& super.getPhand()!=null){
                    if (Objects.equals(Table.get(Table.size() - 1).getRank(), super.getPhand().get(i).getRank())){
                        if (Table.size()==1){
                            System.out.println("!!!!!!!!!!!!!MİŞTİ!!!!!!!!!!!!!");
                            tempnumber+=Table.get(0).getPoint()+super.getPhand().get(i).getPoint();
                            tempnumber*=5;
                            Regularpoint+=tempnumber;
                            tempnumber=0;
                            Regular_Collected_card.add(Table.get(0));
                            Table.get(0).setPoint(0);
                            super.getPhand().get(i).setPoint(0);
                        }
                        Table.add(super.getPhand().get(i));
                        super.getPhand().remove(i);
                        super.getUser_Collected_card().addAll(Table);
                        Table.clear();
                        return;
                    }    
                    else if(super.getPhand().get(i).getRank().equals("10") && Table.size() > 0){
                        Table.add(super.getPhand().get(i));
                        super.getPhand().remove(i);
                        for(int j=0;j<Table.size();j++){
                            Regular_Collected_card.add(Table.get(j));
                        }
                        super.getUser_Collected_card().addAll(Table);
                        Table.clear();
                    }
                }
            }
            if(Table.size()== temp_size){
                if(Table.size()>=0&& super.getPhand()!=null){
                    if(super.getPhand().get(index) != null){
                    Table.add(super.getPhand().get(index));
                    super.getPhand().remove(index);
                    }
                }
            }
        }
        System.out.println("***********");
        System.out.println("ai eli:");
        super.printAiHand(super.getPhand());
    }

    @Override
    public void point_sum(ArrayList<Card> SummedCards) {

        for (int i = 0; i < SummedCards.size(); i++) {

            temp_point += SummedCards.get(i).getPoint();
        }
        super.setPpoint(temp_point+super.getPpoint());
        super.setPpoint(Regularpoint+super.getPpoint());
        temp_point=0;
    }
}