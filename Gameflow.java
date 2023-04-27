import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
public class Gameflow{

    static Random r = new Random(System.currentTimeMillis());
//private boolean a=true;

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
         int rand= r.nextInt(4);
        if(P1.getClass()==user.getClass()){
            for(int i=0;i<P1.getPhand().size();i++){
                System.out.println((i+1)+") "+ P1.getPhand().get(i).getRank()+P1.getPhand().get(i).getSuit());
            }
    int choosed = sc.nextInt()-1;
    P1.play_card(Table, choosed);
        }

        else P1.play_card(Table,rand);
}
    



    public static void game (int player_number){
         if(player_number==2){
            while(true){
            Card.dealer(Table, user, regular, novicePlayer, expert, Deck, true);
            for(int i = 0;i<4;i++){
                choose_card(user, Table);
                choose_card(regular, Table);
            }
            if(Deck == null) break;
        }

    }
    
}

}