import java.util.ArrayList;
import java.util.Objects;
public class Regular extends User {
    private static int tempnumber;
    private ArrayList<Card>Regular_Collected_card = new ArrayList<Card>();
    private static int Regularpoint;
    public static int getRegularpoint() {
        return Regularpoint;
    }
    private  ArrayList<Card>Templist = new ArrayList<Card>();
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
                            point_sum(Templist);
                            Regular_Collected_card.add(Table.get(0));
                        }
                        Table.add(super.getPhand().get(i));
                        super.getPhand().remove(i);
                        Table.clear();
                        return;
                    }    
                    else if(super.getPhand().get(i).getRank().equals("10")){
                        Table.add(super.getPhand().get(i));
                        super.getPhand().remove(i);
                        for(int j=0;j<Table.size();j++){
                            Regular_Collected_card.add(Table.get(j));
                        }
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
        int temp_point = 0;
        for (int i = 0; i < SummedCards.size(); i++) {
            temp_point += SummedCards.get(i).getPoint();
            Regularpoint += temp_point;
        }
        Regularpoint += tempnumber;
    }
}
