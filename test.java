import java.util.ArrayList;
import java.util.Formatter;
import java.io.FileWriter;
public class Test{
     public static void main(String[] args) throws InterruptedException {
        ArrayList<Card>Table = new ArrayList<Card>();
        ArrayList<Card>Cardsa = new ArrayList<Card>();
        User user = new User();
        Formatter f = null;
        FileWriter fw = null;
        Card.deck_writer(f, fw);
        Cardsa = Card.deck_creator();
        Card.shuffler(Cardsa);
        Card.cutter(Cardsa, 5);
        Gameflow the_game= new Gameflow(Table, user, new NovicePlayer(), new NovicePlayer(), new NovicePlayer(), Cardsa);
        Gameflow.set_game();
    }
}
