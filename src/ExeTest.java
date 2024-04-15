import java.util.ArrayList;
import java.util.List;

import util.CardPickGame;
import util.GameUtils;
import util.HighAndLowGame;

public class ExeTest {
  public static void main(String[] args) {
    HighAndLowGame obj = new HighAndLowGame(100, 2);

    List<Integer> cardList = new ArrayList<Integer>();

    cardList = obj.getCard(cardList);
    System.out.println(cardList);

    cardList = obj.getCard(cardList);
    System.out.println(cardList);

    // カードセットは 2つに設定しているので、引けないはず
    cardList = obj.getCard(cardList);
    System.out.println(cardList);
  }
 }