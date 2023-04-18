import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.Formatter;
import java.io.FileWriter;
import java.util.ArrayList;
public class Card {
public Card(int point, String rank, String suit) {
        this.point = point;
        this.rank = rank;
        this.suit = suit;
    }
private int point;
private String rank;
private String suit;
public int getPoint() {
    return point;
}
public void setPoint(int point) {
    this.point = point;
}
public String getRank() {
    return rank;
}
public void setRank(String rank) {
    this.rank = rank;
}
public String getSuit() {
    return suit;
}
public void setSuit(String suit) {
    this.suit = suit;
}
    public static void deck_writer(Formatter f, FileWriter fw){
    try{
        fw = new FileWriter("deck.txt",false);
        f = new Formatter(fw);
        for(int i = 1;i<5;i++){
            for(int j = 0;j<13;j++){
                if(j ==3){}
                if(i==1){
                    f.format("%s,%s,%s\n","Spade",j,"5");
                }
                if(i == 2){
                    if(j ==3)f.format("%s,%s,%s\n","Heart",j,"-2");
                    else f.format("%s,%s,%s\n","Heart",j,"1");
                }
                if(i ==3 ){
                    if(j ==3)f.format("%s,%s,%s\n","Diamond",j,"-2");
                    else f.format("%s,%s,%s\n","Diamond",j,"1");
                }
                if(i == 4){
                    if(j ==3)f.format("%s,%s,%s\n","Club",j,"-2");
                    else f.format("%s,%s,%s\n","Club",j,"1");
                }
            }
        }
    }catch(IOException e){
        System.err.println("Something wrong with the formatter");
    }
    finally{
        if(f != null) f.close();
    }
}
public static ArrayList<Card> deck_creator(){
    ArrayList<Card> the_List = new ArrayList<Card>();
    Scanner reader = null;
    try {
        reader = new Scanner(Paths.get("deck.txt"));
    } catch (IOException e) {

        e.printStackTrace();
    }
    int i = 0;
    while(reader.hasNextLine()){
        String a = reader.nextLine();
        String[] arr = new String[3];
        arr = a.split(",");
      Card card = new Card(Integer.parseInt(arr[1]),arr[0],arr[2]);
      the_List.add(card);
      i++;
    }
    return the_List;
}
}
