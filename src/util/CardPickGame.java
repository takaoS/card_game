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
    boolean result = judgeCard(getCard());

    if (result) System.out.println("判定：勝ち");
    else System.out.println("判定：負け");
  }

  /**
   * 1〜10を1組とした2つのカードデッキから、それぞれ1枚カードを引き、その結果と合計値を表示。また、その合計値を返却する。
   * 
   * @return 引いた2枚のカードの合計値
   */
  private int getCard() {
    final int MAX_CARD_VALUE = 10; // カードの番号の最大値
    int[][] deck = new int[deckSetCount][MAX_CARD_VALUE];

    // 1〜10を1組とし、deckSetCount の数分の組で構成されたデッキを生成する
    for (int i=0; i<deckSetCount; i++) {
      for (int j=0; j<MAX_CARD_VALUE; j++) {
        deck[i][j] = j + 1;
      }
    }

    // カードを1枚ずつ、それぞれのデッキから引く
    int cardA = deck[0][GameUtils.getRandomInt(MAX_CARD_VALUE)];
    int cardB = deck[1][GameUtils.getRandomInt(MAX_CARD_VALUE)];

    // 引いたそれぞれのカードと合計値を出力し、合計値を返す
    int total = cardA + cardB;
    System.out.println("引いたカード：" + cardA + " & " + cardB + " | 合計値：" + total);
    return total;
  }

  /**
   * 引数の値 (カード合計値) を利用し勝敗を判定する。
   * 
   * @param getCardResult カード合計値
   * @return 勝敗判定
   */
  private boolean judgeCard(int getCardResult) {
    final int WINNING_THRESHOLD = 11; // 勝利条件：カードの合計値が11以上

    if (getCardResult < WINNING_THRESHOLD) return false; // 負け
    else return true; // 勝ち
  }
}
