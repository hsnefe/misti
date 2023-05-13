import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Random;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
public class Card {
    public Card(int point, String rank, String suit) {
        this.point = point;
        this.rank = rank;
        this.suit = suit;
    }
    private int point;
    private String rank;
    private String suit;
    private static int turn = 1;
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
                        if (j == 0) {
                            f.format("%s,%s,%s\n","Spade","A","5");
                        }
                        else if (j == 10) {
                            f.format("%s,%s,%s\n","Spade","J","5");
                        }
                        else if (j == 11) {
                            f.format("%s,%s,%s\n","Spade","Q","5");
                        }
                        else if (j == 12) {
                            f.format("%s,%s,%s\n","Spade","K","5");
                        } else 
                        f.format("%s,%s,%s\n","Spade",j,"5");
                    }
                    if(i == 2){
                        if (j == 0) {
                            f.format("%s,%s,%s\n","Heart","A","1");
                        }
                        else if (j == 10) {
                            f.format("%s,%s,%s\n","Heart","J","1");
                        }
                        else if (j == 11) {
                            f.format("%s,%s,%s\n","Heart","Q","1");
                        }
                        else if (j == 12) {
                            f.format("%s,%s,%s\n","Heart","K","1");
                        }
                        else if (j == 3) {
                            f.format("%s,%s,%s\n","Heart",j,"-2");
                        } else

                        f.format("%s,%s,%s\n","Heart",j,"1");
                    }
                    if(i ==3 ){
                        if (j == 0) {
                            f.format("%s,%s,%s\n","Diamond","A","1");
                        }
                        else if (j == 10) {
                            f.format("%s,%s,%s\n","Diamond","J","1");
                        }
                        else if (j == 11) {
                            f.format("%s,%s,%s\n","Diamond","Q","1");
                        }
                        else if (j == 12) {
                            f.format("%s,%s,%s\n","Diamond","K","1");
                        }
                        else if (j == 3) {
                            f.format("%s,%s,%s\n","Diamond",j,"-2");
                        } else

                        f.format("%s,%s,%s\n","Diamond",j,"1");
                    }
                    if(i == 4){
                        if (j == 0) {
                            f.format("%s,%s,%s\n","Club","A","1");
                        }
                        else if (j == 10) {
                            f.format("%s,%s,%s\n","Club","J","1");
                        }
                        else if (j == 11) {
                            f.format("%s,%s,%s\n","Club","Q","1");
                        }
                        else if (j == 12) {
                            f.format("%s,%s,%s\n","Club","K","1");
                        }
                        else if (j == 3) {
                            f.format("%s,%s,%s\n","Club",j,"-2");
                        } else

                        f.format("%s,%s,%s\n","Club",j,"1");
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
        }
        catch (IOException e) {

            e.printStackTrace();
        }
        while(reader.hasNextLine()){
            String a = reader.nextLine();
            String[] arr = new String[3];
            arr = a.split(",");
            Card card = new Card(Integer.parseInt(arr[2]),arr[1],arr[0]);
            the_List.add(card);
        }
        return the_List;
    }
    public static ArrayList<Card> shuffler(ArrayList<Card> deck){
        Collections.shuffle(deck);
        return deck;
    }
    public static ArrayList<Card> cutter(ArrayList<Card> deck, int uselect){
        Random r = new Random();
        uselect = r.nextInt(1,52);
        uselect--;
        ArrayList<Card> temp1 = new ArrayList<Card>();
        ArrayList<Card> temp2 = new ArrayList<Card>();

        for(int i = 0;i< deck.size();i++){

            if(i<uselect){
                temp1.add(deck.get(i));
            }
            else temp2.add(deck.get(i));
        }
        for(int i = 0;i<deck.size();i++){

            if(i<deck.size()-uselect)deck.set(i,temp2.get(i));
            else deck.set(i,temp1.get(deck.size()-i-1));
        }
        return deck;
    }

    public static void dealer(ArrayList<Card> Table, User P1, User P2, User P3, User P4,ArrayList<Card> Deck){
        if(P3 == null){

            if(turn == 1){

                for(int i = 0;i<12;i++){

                    if(i<4){
                        Table.add(Deck.get(0));
                        Deck.remove(0);
                    }
                    else if(i%2==0){
                        P1.getPhand().add(Deck.get(0));
                        Deck.remove(0);
                    }
                    else if(i%2==1){
                        P2.getPhand().add(Deck.get(0));
                        Deck.remove(0);
                    }
                }
                turn++;
            }

            else{
                for(int i = 0; i<8;i++){

                    if(i%2==0){
                        P1.getPhand().add(Deck.get(0));
                        Deck.remove(0);
                    }
                    else{
                        P2.getPhand().add(Deck.get(0));
                        Deck.remove(0);
                    }
                }
            }
        }

        else if(P4 == null){

            if (turn == 1){

                for(int i =0;i<16;i++){

                    if (i<4){
                        Table.add(Deck.get(0));
                        Deck.remove(0);
                    }
                    else if(i%3==0){
                        P1.getPhand().add(Deck.get(0));
                        Deck.remove(0);
                    }
                    else if (i%3==1){
                        P2.getPhand().add(Deck.get(0));
                        Deck.remove(Deck.get(0));
                    }
                    else if (i%3==2){
                        P3.getPhand().add(Deck.get(0));
                        Deck.remove(0);
                    }
                }
                turn++;
            }

            else
                for (int i =0;i<12;i++){

                    if (i%3==0){
                        P1.getPhand().add(Deck.get(0));
                        Deck.remove(0);
                    }
                    if (i%3==1){
                        P2.getPhand().add(Deck.get(0));
                        Deck.remove(0);
                    }
                    if (i%3==2){
                        P3.getPhand().add(Deck.get(0));
                        Deck.remove(0);
                    }
                }
        }
        else {
            if (turn == 1) {
                for (int i = 0; i < 20; i++) {
                    if (i < 4) {
                        Table.add(Deck.get(0));
                        Deck.remove(0);

                    }
                    else if (i % 4 == 0) {
                        P1.getPhand().add(Deck.get(0));
                        Deck.remove(0);
                    }
                    else if (i % 4 == 1) {
                        P2.getPhand().add(Deck.get(0));
                        Deck.remove(Deck.get(0));
                    }
                    else if (i % 4 == 2) {
                        P3.getPhand().add(Deck.get(0));
                        Deck.remove(0);
                    }
                    else if (i % 4 == 3) {
                        P4.getPhand().add(Deck.get(0));
                        Deck.remove(0);
                    }

                }
                turn++;
            }
            else {
                for (int i = 0; i < 16; i++) {
                    if (i % 4 == 0) {
                        P1.getPhand().add(Deck.get(0));
                        Deck.remove(0);
                    }
                    else if (i % 4 == 1) {
                        P2.getPhand().add(Deck.get(0));
                        Deck.remove(Deck.get(0));
                    }
                    else if (i % 4 == 2) {
                        P3.getPhand().add(Deck.get(0));
                        Deck.remove(0);
                    }
                    else if (i % 4 == 3) {
                        P4.getPhand().add(Deck.get(0));
                        Deck.remove(0);
                    }
                }
            }
        }
    }
}
