import java.util.ArrayList;
import java.util.Formatter;
import java.io.FileWriter;

public class Test{   
     public static void main(String[] args) throws InterruptedException {
        ArrayList<Card>Table = new ArrayList<Card>();
        ArrayList<Card>Cardsa = new ArrayList<Card>();
        User P1 = new User();
        Expert P2 = new Expert();
        NovicePlayer P3 = new NovicePlayer();
        Regular P4 = new Regular();
        Formatter f = null;
        FileWriter fw = null;
        Card.deck_writer(f, fw);
        Cardsa = Card.deck_creator();
        Card.shuffler(Cardsa);
        Card.cutter(Cardsa, 5);
/* 
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
        System.out.println("***************");
        System.out.println("Table:");
        for(int i = 0;i<Table.size();i++){
            System.out.println(Table.get(i).getRank()+Table.get(i).getSuit()+" "+Table.get(i).getPoint());
        }*/
        Gameflow the_game = new Gameflow(Table, P1, null, P2, null, Cardsa);
        Gameflow.game(2);
    }
}
