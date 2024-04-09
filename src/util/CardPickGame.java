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
}
