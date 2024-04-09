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

  /**
   * 現在の所持コイン数を表示し、ゲームを開始するかどうかユーザーに入力を求め、ゲームを実行する (A) 。
   * 終了する場合は、現在の所持コイン数を返して終了し、開始する場合は、コインをベットしてもらい勝敗に応じてコインを獲得・喪失し、Aに戻る。
   * @return
   */
  public int execute() {
    // 所持コイン数が 0枚の場合：ゲーム終了
    if (this.possessionCoin == 0) return this.possessionCoin;

    // ゲームを開始するかどうかユーザーに入力を求める
    while (true) {
      System.out.println("現在の所持コイン数：" + this.possessionCoin + "枚 … ゲームを開始しますか？ y / n");
      String startButton = GameUtils.getInputString();

      if (startButton == "y") break; // ゲーム開始
      else if (startButton == "n") return this.possessionCoin; // ゲーム終了
      else System.out.println("開始の場合は y を、終了の場合は n を入力してください"); // 入力エラーの処理
    }

    // ゲーム開始後の処理

    return 0; // エラー回避用の仮のreturn文
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
    return (getCardResult >= WINNING_THRESHOLD) ? true : false;
  }
}
