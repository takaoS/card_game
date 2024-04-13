package util;

public class HighAndLowGame {
  private int earnedCoinCount;    // 獲得コイン枚数
  private int maxWinCoin = 10000; // 最大獲得コイン数
  private int deckSetCount;       // カードセット数

  /**
   * コンストラクタ：引き渡された earnedCoinCount と deckSetCount をそれぞれ同名のフィールドにセットする。
   * 
   * @param _earnedCoinCount 獲得コイン数
   * @param _deckSetCount カードセット数
   */
  public HighAndLowGame(int _earnedCoinCount, int _deckSetCount) {
    this.earnedCoinCount = _earnedCoinCount;
    this.deckSetCount = _deckSetCount;
  }
}
