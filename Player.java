import java.util.ArrayList;

public interface Player {
    public  void play_card(ArrayList<Card> Table, int index);
    public abstract void point_sum(ArrayList<Card> SummedCards);
}