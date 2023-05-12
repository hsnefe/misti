import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Expert extends User  {
    private boolean misti;
    private static ArrayList<Integer> card_counter = new ArrayList<Integer>();
    private int tempnumber;
    private ArrayList<Card> Expert_Collected_card= new ArrayList<Card>();
    private int Expertpoint;
    private int temp_point;

    public int getExpertpoint() {
        return Expertpoint;
    }
    private ArrayList<Card> ExperTemplist = new ArrayList<Card>();// card trackerlist;

    public static  void expertstart(){
        for(int i =0;i<13;i++) card_counter.add(0);
    }

    @Override
    public void play_card( ArrayList<Card> Table, int index) {
        System.out.println("**********");
        System.out.println("ai eli:");
        super.printAiHand(super.getPhand());

        

        int tempsize=Table.size();

        int Tablepointexpert = super.calculateTablePoint(Table);      
        
        for (int i = 0; i < super.getPhand().size(); i++) {
            if (Table.size() > 0) {
                if(Table.size()!= 0&& super.getPhand()!=null){
                    calculateTablePoint(Table);
                    if (Objects.equals(Table.get(Table.size() - 1).getRank(), super.getPhand().get(i).getRank()) && Tablepointexpert +super.getPhand().get(i).getPoint()>0) {
                        if (Table.size() == tempsize) {
                        if (Table.size() == 1) {
                        System.out.println("!!!!!!!!!!!!!MİŞTİ!!!!!!!!!!!!!");
                        misti=true;
                        tempnumber += Table.get(0).getPoint()+ super.getPhand().get(i).getPoint();
                        tempnumber *= 5;
                        Expertpoint+=tempnumber;
                        tempnumber=0;
                        Table.get(0).setPoint(0);
                        super.getPhand().get(i).setPoint(0);
                        }
                        else {
                            misti=false;
                            Expert_Collected_card.addAll(Table);
                            Expert_Collected_card.add(super.getPhand().get(i));
                            //Table.clear();                            
                        }
                        Table.add(super.getPhand().get(i));
                        super.getPhand().remove(i);
                        super.getUser_Collected_card().addAll(Table);
                        Table.clear();
                        break;
                    }
                    }
                }
            }
            else{
                for (int b=0;b<super.getPhand().size();b++){
                    for(int j= 0;j<13;j++){
                        if (card_counter.get(j)==3){
                            if(j==Integer.parseInt(super.getPhand().get(b).getRank())){
                                Table.add(super.getPhand().get(b));
                                super.getPhand().remove(b);
                                break;
                            }
                        }
                        if(Table.size()!=tempsize) break;
                    }
                    if(Table.size()==0&& misti==false){//mişti yapınca burdan hata veriyo
                        Table.add(super.getPhand().get(index));
                        super.getPhand().remove(index);
                        break;
                    }
                }
            } 
        }   

        if(Table.size()==tempsize){
            for(int i=0;i<super.getPhand().size();i++){
                if(super.getPhand().get(i).getRank().equals("10") && Table.size() > 0){
                    if(Table.size()!=0 && super.getPhand().get(i).getRank().equals("10")){
                    Table.add(super.getPhand().get(i));
                    super.getPhand().remove(i);
                    Expert_Collected_card.addAll(Table);
                    ExperTemplist.addAll(Expert_Collected_card);
                    super.getUser_Collected_card().addAll(Table);
                    Table.clear();
                    System.out.println("masa temizlendi");}
                }
            }
           

        }
        if(Table.size() == tempsize&& super.getPhand()!=null){
            if(super.getPhand().size()>0){ 
                if(super.getPhand().get(index) != null){
                    if(super.getPhand().get(index).getRank()!=("10")){
                        Table.add(super.getPhand().get(index));
                        super.getPhand().remove(index);
                    }
               }
            }
        }
    

        System.out.println("**********");
        System.out.println("ai eli:");
        super.printAiHand(super.getPhand());
    }


    @Override
    public void point_sum(ArrayList<Card> SummedCards) {

        for (int i = 0; i < SummedCards.size(); i++) {

            temp_point += SummedCards.get(i).getPoint();
        }
        super.setPpoint(temp_point+super.getPpoint());
        super.setPpoint(Expertpoint+super.getPpoint());
        temp_point=0;
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




//puana göre atma regulara gidiyo 
//table tracker a puana göre saydırcaz expert el puanı göstermece masa puanı göstermece 
//try catch 