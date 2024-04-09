package util;

public class CardPickGame {
  private int maxBetCoin = 100;  // 最大ベット枚数
  private int deckSetCount = 2;  // カードセット数
  private int possessionCoin;    // 所持コイン数

  /**
   * コンストラクタ：引数で引き渡された possessionCoin を同名のフィールドにセットする。
   * 
   * @param _possessionCoin 所持コイン数
   */
  public CardPickGame(int _possessionCoin) {
    this.possessionCoin = _possessionCoin;
  }

  public void execute() {
    getCard();
  }

  /**
   * 1〜10を1組とした2つのカードデッキから、それぞれ1枚カードを引き、その結果と合計値を表示。また、その合計値を返却する。
   * 
   * @return 引いた2枚のカードの合計値
   */
  private int getCard() {
    int maxCardValue = 10;
    int[][] deck = new int[deckSetCount][maxCardValue];

    // 1〜10を1組とし、deckSetCount の数分の組で構成されたデッキを生成する
    for (int i=0; i<deckSetCount; i++) {
      for (int j=0; j<maxCardValue; j++) {
        deck[i][j] = j + 1;
      }
    }

    // カードを1枚ずつ、それぞれのデッキから引く
    int cardA = deck[0][GameUtils.getRandomInt(maxCardValue)];
    int cardB = deck[1][GameUtils.getRandomInt(maxCardValue)];

    // 引いたそれぞれのカードと合計値を出力し、合計値を返す
    int total = cardA + cardB;
    System.out.println("引いたカード：" + cardA + " & " + cardB + " | 合計値：" + total);
    return total;
  }
}
