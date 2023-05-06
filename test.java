import java.util.ArrayList;
import java.util.Formatter;
import java.io.FileWriter;
import java.util.Scanner;

public class Test{   
     public static void main(String[] args) throws InterruptedException {
        ArrayList<Card>Table = new ArrayList<Card>();
        ArrayList<Card>Cardsa = new ArrayList<Card>();
        User user = new User();
        Expert expert = new Expert();
        NovicePlayer novicePlayer = new NovicePlayer();
        Regular regular = new Regular();
        Formatter f = null;
        FileWriter fw = null;
        Card.deck_writer(f, fw);
        Cardsa = Card.deck_creator();
        Card.shuffler(Cardsa);
        Card.cutter(Cardsa, 5);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a game difficulty...");
        int difficulty = scanner.nextInt();
        if(difficulty==1){
            NovicePlayer novicePlayer1 = new NovicePlayer();
            NovicePlayer novicePlayer2 = new NovicePlayer();
            NovicePlayer novicePlayer3 = new NovicePlayer();
            Gameflow the_game = new Gameflow(Table, user, novicePlayer1, novicePlayer2, novicePlayer3, Cardsa);
            Gameflow.game(difficulty);
        }
        if(difficulty==3){
            Expert expert1 = new Expert();
            Expert expert2 = new Expert();
            Expert expert3 = new Expert();
            Gameflow the_game = new Gameflow(Table, user, expert1, expert2, expert3, Cardsa);
            Gameflow.game(difficulty);
        }
        /*Gameflow the_game = new Gameflow(Table, user, regular, expert, novicePlayer , Cardsa);
        Gameflow.game(difficulty);*/
    
    }
}
