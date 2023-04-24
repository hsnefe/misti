import java.util.ArrayList;

public interface Player {
    public abstract void play_card(ArrayList<Card> Hand, ArrayList<Card> Table, int index);
    public abstract void point_sum(ArrayList<Card> SummedCards);
}