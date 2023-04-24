import java.util.ArrayList;

public interface Player {
    public void play_card(ArrayList<Card> Hand, ArrayList<Card> Table, int index);
    public void point_sum(ArrayList<Card> SummedCards);
}
