import java.util.ArrayList;
import java.util.Objects;

public class Expert extends User  {
    private static ArrayList<Integer> card_counter = new ArrayList<Integer>();
    private static int tempnumber;
    private ArrayList<Card> Expert_Collected_card= new ArrayList<Card>();
    private static int Expertpoint;
    private ArrayList<Card> Templist = new ArrayList<Card>();
    private ArrayList<Card> ExperTemplist = new ArrayList<Card>();// card trackerlist
    public static  void expertstart(){
        for(int i =0;i<13;i++) card_counter.add(0);
    }
    @Override
    public void play_card( ArrayList<Card> Table, int index) {
        /*if(PHand.get(index) != null){
            Table.add(PHand.get(index));
            PHand.remove(index);
        }*/
        System.out.println("**********");
        System.out.println("ai eli:");
        super.printAiHand(super.getPhand());



        int tempsize=Table.size();
        for (int i = 0; i < super.getPhand().size(); i++) {
            Table_tracker(Table,ExperTemplist);
            if (Table.size() > 0) {
                if(Table.size()!= 0&& super.getPhand()!=null){
                    if (Objects.equals(Table.get(Table.size() - 1).getRank(), super.getPhand().get(i).getRank())) {
                        if (Table.size() == 1) {
                        System.out.println("!!!!!!!!!!!!!MİŞTİ!!!!!!!!!!!!!");
                        tempnumber += Table.get(0).getPoint()+ super.getPhand().get(i).getPoint();
                        tempnumber *= 5;
                        }
                        else {
                            Templist.addAll(Table);
                            Templist.add(super.getPhand().get(i));
                            Expert_Collected_card.addAll(Table);
                            Expert_Collected_card.add(super.getPhand().get(i));
                            point_sum(Templist);
                        }
                        Table.add(super.getPhand().get(i));
                        super.getPhand().remove(i);
                        Table.clear();
                    }
                }
            }
            else{
                for (int b=0;b<super.getPhand().size();b++){
                    for(int j= 0;j<13;j++){
                        if (card_counter.get(j)==3){
                            Table.add(super.getPhand().get(b));
                            super.getPhand().remove(b);
                            break;
                        }
                        if(Table.size()!=tempsize) break;
                    }
                    if(Table.size()==0){
                        Table.add(super.getPhand().get(index));
                        super.getPhand().remove(index);
                        break;
                    }
                }
            }
            
        }
        

        if(Table.size()==tempsize){
            for(int i=0;i<super.getPhand().size();i++){
                if(super.getPhand().get(i).getRank().equals("10")){
                    Table.add(super.getPhand().get(i));
                    super.getPhand().remove(i);
                    Expert_Collected_card.addAll(Table);
                    ExperTemplist.addAll(Expert_Collected_card);
                    point_sum(Expert_Collected_card);
                    Table.clear();
                    System.out.println("masa temizlendi");
                }
            }
        }





        if(Table.size() == tempsize&& super.getPhand()!=null){
            if(super.getPhand().size()>0){ 
                if(super.getPhand().get(index) != null){
                Table.add(super.getPhand().get(index));
                super.getPhand().remove(index);
               }
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
            Expertpoint += temp_point;
        }
        Expertpoint += tempnumber;
    }
    
    public static void Table_tracker(ArrayList<Card>Table,ArrayList<Card>ExperTemplist){
        ExperTemplist.addAll(Table);
        for (int i =0; i<Table.size();i++){
            int temp =card_counter.get(Integer.parseInt(Table.get(i).getRank()));
            card_counter.remove(Integer.parseInt(Table.get(i).getRank()));
            temp++;
            card_counter.add(temp);
        }
    }
}
