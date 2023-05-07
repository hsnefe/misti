import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Gameflow{

static Random r = new Random(System.currentTimeMillis());

private static ArrayList<Card>Table;
private static ArrayList<Card>Deck;

public Gameflow(ArrayList<Card> table, User uter, User regular, User expert, User novicePlayer,ArrayList<Card>deck) {
    Deck=deck;
    Table = table;
    user = uter;
    P2 = regular;
    P3 = expert;
    P4 = novicePlayer;
}


private static User user;
private static User P2;
public static User getP2() {
    return P2;
}


public static void setP2(User p2) {
    P2 = p2;
}


private static User P3;
public static User getP3() {
    return P3;
}


public static void setP3(User p3) {
    P3 = p3;
}


private static User P4;


public static User getP4() {
    return P4;
}


public static void setP4(User p4) {
    P4 = p4;
}


public ArrayList<Card> getTable() {
    return Table;
}


public void setTable(ArrayList<Card> table) {
    Table = table;
}


public User getUser() {
    return user;
}


public void setUser(User uter) {
    user = uter;
}
static Scanner sc= new Scanner (System.in);

public static  void choose_card(User P1,ArrayList<Card> Table){
        int rand=0;
        if(P1.getPhand().size()!=0)  rand= r.nextInt(P1.getPhand().size());
        if(P1.getClass()==user.getClass()){
            for(int i=0;i<P1.getPhand().size();i++){
                System.out.println((i+1)+") "+ P1.getPhand().get(i).getRank()+P1.getPhand().get(i).getSuit());
            }
    int choosed = sc.nextInt()-1;
    P1.play_card(Table, choosed);
        }
        else P1.play_card(Table,rand);
}
    public static void printOutTable(){
        System.out.println("Table:");
        for(int i = 0;i<Table.size();i++){
            System.out.println(Table.get(i).getRank()+Table.get(i).getSuit()+" "+Table.get(i).getPoint());}
    }
    public static void set_game(){
        int difficulty1 = 0;
        int difficulty2=0;
        int difficulty3=0;
        System.out.println("Choose number of players(2 to 4):");
        int player_size = sc.nextInt();
        switch(player_size){
            case(4):
            System.out.println("Choose a difficulty for AI");
            difficulty3 = sc.nextInt();
            case(3):
            System.out.println("Choose a difficulty for AI"); 
            difficulty2 = sc.nextInt();
            case(2):
            System.out.println("Choose a difficulty for AI");
            difficulty1 = sc.nextInt();
            break;
        }
        game(player_size,difficulty1,difficulty2,difficulty3);
    }
    public static void game (int player_size,int difficulty1,int difficulty2,int difficulty3){
            if(player_size==2){
                if(difficulty1==3){
                    P3 = new Expert();
                    P4 = null;
                    P2 = null;
                }
                else if(difficulty1==2){
                    P3 = new Regular();
                    P4 = null;
                    P2 = null;
                }
                else if(difficulty1 ==1){
                    P3 = new NovicePlayer();
                    P4 = null;
                    P2 = null;
                }
                while(true){
                    Card.dealer(Table, user,P3 , P4, P2, Deck);
                    for(int i = 0;i<4;i++){
                        System.out.println("*******");
                        printOutTable();
                        System.out.println("*******");
                        choose_card(user, Table);
                        System.out.println("*******");
                        printOutTable();
                        System.out.println("********");
                        choose_card(P3, Table);
                        System.out.println("*********");
                        System.out.println("AI played");
                        System.out.println("*********");
                        printOutTable();
                        System.out.println("*********");
                    }
                    if(Deck.size() == 0) break;
                }
            }
    }
}