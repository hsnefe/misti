import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.io.FileWriter;
public class Test{
   
    public static void main(String[] args){
        ArrayList<Card>cardsa = new ArrayList<Card>();
        Formatter f = null;
        FileWriter fw = null;
        Card.deck_writer(f, fw);
        cardsa = Card.deck_creator();
        for(int i=0;i<cardsa.size();i++){
            System.out.println(cardsa.get(i).getRank()+cardsa.get(i).getSuit()+" "+cardsa.get(i).getPoint());
        }
    }
}