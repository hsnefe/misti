import java.util.ArrayList;
import java.util.Objects;

public class Expert implements Player {
    private static int Counter_1=0;//A
    private static int Counter_2=0;
    private static int Counter_3=0;
    private static int Counter_4=0;
    private static int Counter_5=0;
    private static int Counter_6=0;
    private static int Counter_7=0;
    private static int Counter_8=0;
    private static int Counter_9=0;
    private static int Counter_10=0;
    private static int Counter_11=0;//J
    private static int Counter_12=0;//Q
    private static int Counter_13=0;//K
    private static boolean misti;
    private static int tempnumber;
    private ArrayList<Card> Expert_Collected_card;
    private static int Expertpoint;
    private ArrayList<Card> ExpertHand = new ArrayList<Card>();
    private ArrayList<Card> Templist = new ArrayList<Card>();
    private ArrayList<Card> ExperTemplist = new ArrayList<Card>();// card trackerlist

    @Override
    public void play_card(ArrayList<Card> ExpertHand, ArrayList<Card> Table, int index) {
        index--;
        for (int i = 0; i < ExpertHand.size(); i++) {
            Table_tracker(Table,ExperTemplist);
            if (Objects.equals(Table.get(Table.size() - 1).getRank(), Table.get(Table.size() - 2).getRank())) {
                if (Table.size() == 2) {
                    System.out.println("!!!!!!!!!!!!!MİŞTİ!!!!!!!!!!!!!");
                    for (int j = 0; j < 2; j++) {
                        tempnumber += Table.get(j).getPoint();
                    }
                    misti = true;
                    tempnumber *= 5;

                }


                else {
                    for (int k = Table.size(); k < Table.size(); k++) {

                        Templist.add(Table.get(k));
                        Expert_Collected_card.add(Table.get(k));

                    }
                }

                if (misti) {
                    Templist.remove(Templist.size() - 1);
                    Templist.remove(Templist.size() - 2);
                }


                point_sum(Templist);
                Table.clear();
            }

            else if (Table.get(0) != null) {
                    for (int b=0;b<4;b++){
                        if (Counter_1==3){
                            Table.add(ExpertHand.get(b));
                        }
                        else if (Counter_2==3){
                            Table.add(ExpertHand.get(b));
                        }
                        else if (Counter_3==3){
                            Table.add(ExpertHand.get(b));
                        }
                        else if (Counter_4==3){
                            Table.add(ExpertHand.get(b));
                        }
                        else if (Counter_5==3){
                            Table.add(ExpertHand.get(b));
                        }
                        else if (Counter_6==3){
                            Table.add(ExpertHand.get(b));
                        }
                        else if (Counter_7==3){
                            Table.add(ExpertHand.get(b));
                        }
                        else if (Counter_8==3){
                            Table.add(ExpertHand.get(b));
                        }
                        else if (Counter_9==3){
                            Table.add(ExpertHand.get(b));
                        }
                        else if (Counter_10==3){
                            Table.add(ExpertHand.get(b));
                        }
                        else if (Counter_11==3){
                            Table.add(ExpertHand.get(b));
                        }
                        else if (Counter_12==3){
                            Table.add(ExpertHand.get(b));
                        }
                        else if (Counter_13==3){
                            Table.add(ExpertHand.get(b));
                        }

                    }

                if (Objects.equals(Table.get(Table.size() - 1).getRank(), ExpertHand.get(i).getRank())) {
                    Table.add(ExpertHand.get(i));

                }

                else if (Table.size()>3 && ExpertHand.size()>1 && ExpertHand.get(i).getRank() == "11") {// 11==J
                    Table.add(ExpertHand.get(i));
                }
            }
            else  {
                Table.add(ExpertHand.get(index));
                ExpertHand.remove(index);
            }
        }
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
            if (Table.get(i).getRank()=="1"){
                Counter_1++;
            }
            if (Table.get(i).getRank()=="2"){
                Counter_2++;
            }
            if (Table.get(i).getRank()=="3"){
                Counter_3++;
            }
            if (Table.get(i).getRank()=="4"){
                Counter_4++;
            }
            if (Table.get(i).getRank()=="5"){
                Counter_5++;
            }
            if (Table.get(i).getRank()=="6"){
                Counter_6++;
            }
            if (Table.get(i).getRank()=="7"){
                Counter_7++;
            }
            if (Table.get(i).getRank()=="8"){
                Counter_8++;
            }
            if (Table.get(i).getRank()=="9"){
                Counter_9++;
            }
            if (Table.get(i).getRank()=="10"){
                Counter_10++;
            }
            if (Table.get(i).getRank()=="11"){
                Counter_11++;
            }
            if (Table.get(i).getRank()=="12"){
                Counter_12++;
            }
            if (Table.get(i).getRank()=="13"){
                Counter_13++;
            }
        }
    }
}
