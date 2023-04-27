import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
public class Gameflow{

    static Random r = new Random(System.currentTimeMillis());
private static boolean a=true;

private static ArrayList<Card>Table;
private static ArrayList<Card>Deck;

public Gameflow(ArrayList<Card> table, User user, Regular regular, Expert expert, NovicePlayer novicePlayer,ArrayList<Card>deck) {
    Deck=deck;
    Table = table;
    this.user = user;
    this.regular = regular;
    this.expert = expert;
    this.novicePlayer = novicePlayer;
}


private static User user;
private static Regular regular;
private static Expert expert;
private static NovicePlayer novicePlayer;


public ArrayList<Card> getTable() {
    return Table;
}


public void setTable(ArrayList<Card> table) {
    Table = table;
}


public User getUser() {
    return user;
}


public void setUser(User user) {
    this.user = user;
}


public Regular getRegular() {
    return regular;
}


public void setRegular(Regular regular) {
    this.regular = regular;
}


public Expert getExpert() {
    return expert;
}


public void setExpert(Expert expert) {
    this.expert = expert;
}


public NovicePlayer getNovicePlayer() {
    return novicePlayer;
}


public void setNovicePlayer(NovicePlayer novicePlayer) {
    this.novicePlayer = novicePlayer;
}
static Scanner sc= new Scanner (System.in);

public static  void choose_card(User P1,ArrayList<Card> Table){
         int rand= r.nextInt(P1.getPhand().size());
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



    public static void game (int player_number){
         if(player_number==2){
            while(true){
            Card.dealer(Table, user, regular, novicePlayer, expert, Deck, a);
            for(int i = 0;i<4;i++){
                choose_card(user, Table);
                System.out.println("*******");
                printOutTable();
                System.out.println("********");
                choose_card(regular, Table);
                System.out.println("AI played");
                System.out.println("*********");
                printOutTable();
            }
            if(Deck == null) break;
        }

    }
    
}

}