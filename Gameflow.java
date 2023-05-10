import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.w3c.dom.ls.LSException;
public class Gameflow{

static Random r = new Random(System.currentTimeMillis());

private static ArrayList<Card>Table;
private static ArrayList<Card>Deck;
private static User last_taker;
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
    public static void end_game(User user,User P3, User P4, User P2){
        user.point_sum(user.getUser_Collected_card());
        P3.point_sum(P3.getUser_Collected_card());
        if(P4!= null)P4.point_sum(P4.getUser_Collected_card());
        if(P2!=null)P2.point_sum(P2.getUser_Collected_card());
        System.out.println("Your Point:"+user.getPpoint());
        System.out.println("AI1's Point:"+P3.getPpoint());
        if(P4!=null)System.out.println("AI2's Point:"+P4.getPpoint());
        if(P2!=null)System.out.println("AI3's Point:"+P2.getPpoint());
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
                Expert.expertstart();
                while(true){
                    Card.dealer(Table, user,P3 , P4, P2, Deck);
                    for(int i = 0;i<4;i++){
                        System.out.println("*******");
                        printOutTable();
                        System.out.println("*******");
                        choose_card(user, Table);
                        if(Table.size()==0) last_taker =user;
                        System.out.println("*******");
                        printOutTable();
                        System.out.println("********");
                        choose_card(P3, Table);
                        if(Table.size()==0) last_taker = P3;
                        System.out.println("*********");
                        System.out.println("AI played");
                        System.out.println("*********");
                        printOutTable();
                        System.out.println("*********");
                    }
                    if(Deck.size() == 0) {
                        last_taker.getUser_Collected_card().addAll(Table);
                        break;
                    }
                }
            }
            else if(player_size==3){
                if(difficulty1==1){
                    P3 = new NovicePlayer();
                    if(difficulty2==1) P4 = new NovicePlayer();
                    else if(difficulty2==2) P4 = new Regular();
                    else if(difficulty2 ==3) {
                        P4 = new Expert();
                        Expert.expertstart();
                    }
                    P2 = null;
                    while(true){
                        Card.dealer(Table, user,P3 , P4, P2, Deck);
                        for(int i = 0;i<4;i++){
                            System.out.println("*******");
                            printOutTable();
                            System.out.println("*******");
                            choose_card(user, Table);
                            if(Table.size()==0) last_taker =user;
                            System.out.println("*******");
                            printOutTable();
                            System.out.println("********");
                            choose_card(P3, Table);
                            if(Table.size()==0) last_taker =P3;
                            System.out.println("*********");
                            System.out.println("AI1 played");
                            System.out.println("*********");
                            printOutTable();
                            System.out.println("*********");
                            choose_card(P4, Table);
                            if(Table.size()==0) last_taker =P4;
                            System.out.println("*********");
                            System.out.println("AI2 played");
                            System.out.println("*********");
                            printOutTable();
                            System.out.println("*********");
                        }
                        if(Deck.size() == 0) {
                            last_taker.getUser_Collected_card().addAll(Table);
                            break;
                        }
                    }
                }
                else if(difficulty1==2){
                    P3 = new Regular();
                    if(difficulty2==1) P4 = new NovicePlayer();
                    else if(difficulty2==2) P4 = new Regular();
                    else if(difficulty2 ==3) {
                        P4 = new Expert();
                        Expert.expertstart();
                    }
                    P2 = null;
                    while(true){
                        Card.dealer(Table, user,P3 , P4, P2, Deck);
                        for(int i = 0;i<4;i++){
                            System.out.println("*******");
                            printOutTable();
                            System.out.println("*******");
                            choose_card(user, Table);
                            if(Table.size()==0) last_taker =user;
                            System.out.println("*******");
                            printOutTable();
                            System.out.println("********");
                            choose_card(P3, Table);
                            if(Table.size()==0) last_taker =P3;
                            System.out.println("*********");
                            System.out.println("AI1 played");
                            System.out.println("*********");
                            printOutTable();
                            System.out.println("*********");
                            choose_card(P4, Table);
                            if(Table.size()==0) last_taker =P4;
                            System.out.println("*********");
                            System.out.println("AI2 played");
                            System.out.println("*********");
                            printOutTable();
                            System.out.println("*********");
                        }
                        if(Deck.size() == 0) {
                            last_taker.getUser_Collected_card().addAll(Table);
                            break;
                        }
                    }
                }
                else if(difficulty1==3){
                    P3 = new Expert();
                    if(difficulty2==1) P4 = new NovicePlayer();
                    else if(difficulty2==2) P4 = new Regular();
                    else if(difficulty2 ==3) P4 = new Expert();
                    Expert.expertstart();
                    P2 = null;
                    while(true){
                        Card.dealer(Table, user,P3 , P4, P2, Deck);
                        for(int i = 0;i<4;i++){
                            System.out.println("*******");
                            printOutTable();
                            System.out.println("*******");
                            choose_card(user, Table);
                            if(Table.size()==0) last_taker =user;
                            System.out.println("*******");
                            printOutTable();
                            System.out.println("********");
                            choose_card(P3, Table);
                            if(Table.size()==0) last_taker = P3;
                            System.out.println("*********");
                            System.out.println("AI1 played");
                            System.out.println("*********");
                            printOutTable();
                            System.out.println("*********");
                            choose_card(P4, Table);
                            if(Table.size()==0) last_taker =P4;
                            System.out.println("*********");
                            System.out.println("AI2 played");
                            System.out.println("*********");
                            printOutTable();
                            System.out.println("*********");
                        }
                        if(Deck.size() == 0) {
                            last_taker.getUser_Collected_card().addAll(Table);
                            break;
                        }
                    }
                }
            } else if(player_size==4){
                if(difficulty1==1){
                    P3 = new NovicePlayer();
                    if(difficulty2==1){
                        P4 = new NovicePlayer();
                        if(difficulty3==1) P2= new NovicePlayer();
                        else if(difficulty3==2) P2 = new Regular();
                        else if(difficulty3==3) {
                            P2 = new Expert();
                            Expert.expertstart();
                        }
                    }
                    if(difficulty2==2){
                        P4 = new Regular();
                        if(difficulty3==1) P2= new NovicePlayer();
                        else if(difficulty3==2) P2 = new Regular();
                        else if(difficulty3==3) {
                            P2 = new Expert();
                            Expert.expertstart();
                        }
                    }
                    if(difficulty2==3){
                        P4 = new Expert();
                        if(difficulty3==1) P2= new NovicePlayer();
                        else if(difficulty3==2) P2 = new Regular();
                        else if(difficulty3==3) {
                            P2 = new Expert();
                            Expert.expertstart();
                        }
                    }
                    while(true){
                        Card.dealer(Table, user,P3 , P4, P2, Deck);
                        for(int i = 0;i<4;i++){
                            System.out.println("*******");
                            printOutTable();
                            System.out.println("*******");
                            choose_card(user, Table);
                            if(Table.size()==0) last_taker =user;
                            System.out.println("*******");
                            printOutTable();
                            System.out.println("********");
                            choose_card(P3, Table);
                            if(Table.size()==0) last_taker =P3;
                            System.out.println("*********");
                            System.out.println("AI1 played");
                            System.out.println("*********");
                            printOutTable();
                            System.out.println("*********");
                            choose_card(P4, Table);
                            if(Table.size()==0) last_taker =P4;
                            System.out.println("*********");
                            System.out.println("AI2 played");
                            System.out.println("*********");
                            printOutTable();
                            System.out.println("*********");
                            choose_card(P2, Table);
                            if(Table.size()==0) last_taker =P2;
                            System.out.println("*********");
                            System.out.println("AI3 played");
                            System.out.println("*********");
                            printOutTable();
                            System.out.println("*********");
                        }
                        if(Deck.size() == 0) {
                            last_taker.getUser_Collected_card().addAll(Table);
                            break;
                        }
                    }
                }
                else if(difficulty1==2){
                    P3 = new Regular();
                    if(difficulty2==1){
                        P4 = new NovicePlayer();
                        if(difficulty3==1) P2= new NovicePlayer();
                        else if(difficulty3==2) P2 = new Regular();
                        else if(difficulty3==3) {
                            P2 = new Expert();
                            Expert.expertstart();
                        }
                    }
                    else if(difficulty2==2){
                        P4 = new Regular();
                        if(difficulty3==1) P2= new NovicePlayer();
                        else if(difficulty3==2) P2 = new Regular();
                        else if(difficulty3==3) {
                            P2 = new Expert();
                            Expert.expertstart();
                        }
                    }
                    else if(difficulty2==3){
                        P4 = new Expert();
                        if(difficulty3==1) P2= new NovicePlayer();
                        else if(difficulty3==2) P2 = new Regular();
                        else if(difficulty3==3) P2 = new Expert();
                        Expert.expertstart();
                    }
                    while(true){
                        Card.dealer(Table, user,P3 , P4, P2, Deck);
                        for(int i = 0;i<4;i++){
                            System.out.println("*******");
                            printOutTable();
                            System.out.println("*******");
                            choose_card(user, Table);
                            if(Table.size()==0) last_taker =user;
                            System.out.println("*******");
                            printOutTable();
                            System.out.println("********");
                            choose_card(P3, Table);
                            if(Table.size()==0) last_taker =P3;
                            System.out.println("*********");
                            System.out.println("AI1 played");
                            System.out.println("*********");
                            printOutTable();
                            System.out.println("*********");
                            choose_card(P4, Table);
                            if(Table.size()==0) last_taker = P4;
                            System.out.println("*********");
                            System.out.println("AI2 played");
                            System.out.println("*********");
                            printOutTable();
                            System.out.println("*********");
                            choose_card(P2, Table);
                            if(Table.size() == 0) last_taker =P2;
                            System.out.println("*********");
                            System.out.println("AI3 played");
                            System.out.println("*********");
                            printOutTable();
                            System.out.println("*********");
                        }
                        if(Deck.size() == 0){
                            last_taker.getUser_Collected_card().addAll(Table);
                            break;
                        }
                    }
                }
                else if(difficulty1==3){
                    P3 = new Expert();
                    if(difficulty2==1){
                        P4 = new NovicePlayer();
                        if(difficulty3==1) P2= new NovicePlayer();
                        else if(difficulty3==2) P2 = new Regular();
                        else if(difficulty3==3) P2 = new Expert();
                    }
                    else if(difficulty2==2){
                        P4 = new Regular();
                        if(difficulty3==1) P2= new NovicePlayer();
                        else if(difficulty3==2) P2 = new Regular();
                        else if(difficulty3==3) P2 = new Expert();
                    }
                    else if(difficulty2==3){
                        P4 = new Expert();
                        if(difficulty3==1) P2= new NovicePlayer();
                        else if(difficulty3==2) P2 = new Regular();
                        else if(difficulty3==3) P2 = new Expert();
                    }
                    Expert.expertstart();
                while(true){
                    Card.dealer(Table, user,P3 , P4, P2, Deck);
                    for(int i = 0;i<4;i++){
                        System.out.println("*******");
                        printOutTable();
                        System.out.println("*******");
                        choose_card(user, Table);
                        if(Table.size()==0) last_taker =user;
                        System.out.println("*******");
                        printOutTable();
                        System.out.println("********");
                        choose_card(P3, Table);
                        if(Table.size()==0) last_taker =P3;
                        System.out.println("*********");
                        System.out.println("AI1 played");
                        System.out.println("*********");
                        printOutTable();
                        System.out.println("*********");
                        choose_card(P4, Table);
                        if(Table.size()==0) last_taker =P4;
                        System.out.println("*********");
                        System.out.println("AI2 played");
                        System.out.println("*********");
                        printOutTable();
                        System.out.println("*********");
                        choose_card(P2, Table);
                        if(Table.size()==0) last_taker =P2;
                        System.out.println("*********");
                        System.out.println("AI3 played");
                        System.out.println("*********");
                        printOutTable();
                        System.out.println("*********");
                    }
                    if(Deck.size() == 0) {
                        last_taker.getUser_Collected_card().addAll(Table);
                        break;
                    }
                }
            }
        }
        end_game(user, P3, P4, P2);            
    }
}