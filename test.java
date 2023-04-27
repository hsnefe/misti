import java.util.ArrayList;
import java.util.Formatter;
import java.io.FileWriter;
import java.util.Scanner;

public class Test{
    static Scanner sc= new Scanner (System.in);
    public static  void choose_card(User P1,ArrayList<Card> Table){
        System.out.println("1)"+P1.getPhand().get(0).getRank()+P1.getPhand().get(0).getSuit()+"\n2)"+P1.getPhand().get(1).getRank()+P1.getPhand().get(1).getSuit());
        System.out.println("3)"+P1.getPhand().get(2).getRank()+P1.getPhand().get(2).getSuit()+"\n4)"+P1.getPhand().get(3).getRank()+P1.getPhand().get(3).getSuit());
        int choosed = sc.nextInt()-1;
        P1.play_card(Table, choosed);
    }
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Card>Table = new ArrayList<Card>();
        ArrayList<Card>Cardsa = new ArrayList<Card>();
        User P1 = new User();
        User P2 = new User();
        User P3 = new User();
        User P4 = new User();
        Formatter f = null;
        FileWriter fw = null;
        Card.deck_writer(f, fw);
        Cardsa = Card.deck_creator();
        Card.shuffler(Cardsa);
        Card.cutter(Cardsa, 5);

        for(int i=0;i<Cardsa.size();i++){
            System.out.println(Cardsa.get(i).getRank()+Cardsa.get(i).getSuit()+" "+Cardsa.get(i).getPoint());
        }

        Card.dealer(Table,P1,P2,P3,P4,Cardsa,true);
        System.out.println("**************************");
        System.out.println("Player 1 Hand:");
        for (int i=0;i<P1.getPhand().size();i++){
            System.out.println(P1.getPhand().get(i).getRank()+P1.getPhand().get(i).getSuit()+" "+P1.getPhand().get(i).getPoint());
        }
        System.out.println("************");
        System.out.println("Player 2 Hand:");
        for (int i=0;i<P2.getPhand().size();i++){
            System.out.println(P2.getPhand().get(i).getRank()+P2.getPhand().get(i).getSuit()+" "+P2.getPhand().get(i).getPoint());
        }
        System.out.println("************");
        System.out.println("Player 3 Hand:");
        for (int i=0;i<P3.getPhand().size();i++){
            System.out.println(P3.getPhand().get(i).getRank()+P3.getPhand().get(i).getSuit()+" "+P3.getPhand().get(i).getPoint());
        }
        System.out.println("************");
        System.out.println("Player 4 Hand:");
        for (int i=0;i<P4.getPhand().size();i++){
            System.out.println(P4.getPhand().get(i).getRank()+P4.getPhand().get(i).getSuit()+" "+P4.getPhand().get(i).getPoint());
        }
        System.out.println("************");
        System.out.println("Table:");
        for(int i = 0;i<Table.size();i++){
            System.out.println(Table.get(i).getRank()+Table.get(i).getSuit()+" "+Table.get(i).getPoint());
        }
        System.out.println("****************");
        choose_card(P1, Table);
        System.out.println("Table:");
        for(int i = 0;i<Table.size();i++){
            System.out.println(Table.get(i).getRank()+Table.get(i).getSuit()+" "+Table.get(i).getPoint());
        }
    }
}
