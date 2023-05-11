import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public  class User implements Player, Serializable {
    public User() {
    }
    public User(String name, int ppoint) {
        this.name = name;
        Ppoint = ppoint;
    }


    private String name;
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


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
    static Scanner sc= new Scanner(System.in);

    private static boolean verbose;
    private static String sifre="123";

    public static  void verbosemode(User P2,User P3,User P4,int player_size){
        System.out.println(" If you want verbose mode please enter a password:");
        System.out.println(" Or you can press q and start playing");
        String password = sc.nextLine();
        if(password.equals(sifre)){
            verbose=true;
            if(player_size==2){
                for(int i =0;i<P2.getPhand().size();i++){
                    System.out.printf("%s%s",P2.getPhand().get(i).getSuit(), P2.getPhand().get(i).getRank());
                    if(P2.getPhand().size()>i+1){System.out.print(",");}
                }
            }
            if(player_size==3){
                for(int a =0;a<P2.getPhand().size();a++){
                   System.out.printf("%s%s",P2.getPhand().get(a).getSuit() , P2.getPhand().get(a).getRank());
                   if(P2.getPhand().size()>a+1){System.out.print(",");}
                }
                for(int i=0 ; i<P3.getPhand().size() ;i++){
                    System.out.printf("%s%s",P3.getPhand().get(i).getSuit(),P3.getPhand().get(i).getRank());
                    if(P3.getPhand().size()>i+1){System.out.print(",");}
                }
            }
            if(player_size==4){
                for(int a =0;a<P2.getPhand().size();a++){
                    System.out.printf("%s%s",P2.getPhand().get(a).getSuit() , P2.getPhand().get(a).getRank());
                    if(P2.getPhand().size()>a+1){System.out.print(",");}
                 }
                 for(int i=0 ; i<P3.getPhand().size() ;i++){
                     System.out.printf("%s%s",P3.getPhand().get(i).getSuit(),P3.getPhand().get(i).getRank());
                     if(P3.getPhand().size()>i+1){System.out.print(",");}
                 }
                 for(int a =0;a<P4.getPhand().size();a++){
                    System.out.printf("%s%s",P4.getPhand().get(a).getSuit() , P4.getPhand().get(a).getRank());
                    if(P4.getPhand().size()>a+1){System.out.print(",");}
                 }
            }
        }
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
        if(verbose){
        for (int i=0;i<aihand.size();i++) {
            //System.out.println(aihand.get(i).getRank() + aihand.get(i).getSuit());
            System.out.printf("%s%s",aihand.get(i).getSuit(),aihand.get(i).getRank());
            if(aihand.size()>i+1){System.out.print(",");
        }
        }
    }
    }
}