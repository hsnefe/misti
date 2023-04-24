
import java.util.ArrayList;
import java.util.Formatter;
import java.io.FileWriter;
import java.util.Scanner;

public class test{

    public static void main(String[] args){
        Scanner sc= new Scanner (System.in);
        ArrayList<Card>P1 = new ArrayList<Card>();
        ArrayList<Card>P2 = new ArrayList<Card>();
        ArrayList<Card>P3 = new ArrayList<Card>();
        ArrayList<Card>P4 = new ArrayList<Card>();
        ArrayList<Card>Table = new ArrayList<Card>();
        ArrayList<Card>Cardsa = new ArrayList<Card>();

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

        for (int i=0;i<P1.size();i++){
            System.out.println(P1.get(i).getRank()+P1.get(i).getSuit()+" "+P1.get(i).getPoint());
        }
        System.out.println("************");
        for (int i=0;i<P2.size();i++){
            System.out.println(P2.get(i).getRank()+P2.get(i).getSuit()+" "+P2.get(i).getPoint());
        }
        System.out.println("************");
        for (int i=0;i<P3.size();i++){
            System.out.println(P3.get(i).getRank()+P3.get(i).getSuit()+" "+P3.get(i).getPoint());
        }
        System.out.println("************");
        for (int i=0;i<P4.size();i++){
            System.out.println(P4.get(i).getRank()+P4.get(i).getSuit()+" "+P4.get(i).getPoint());
        }

        System.out.println("************");

    }
}
