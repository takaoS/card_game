package util;

import java.util.ArrayList;
import java.util.List;

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

  /**
   * まずはカードを引き、そのカードの番号を出力した後、ハイ＆ローゲームに挑戦するかどうかユーザーに入力を求め、ゲームを実行する (A) 。
   * 終了する場合は、獲得したコインを数を返して終了し、挑戦する場合は、次に引くカードの番号の方が大きいかどうかを予想してもらい、その結果に応じてコインを獲得し、Aに戻る。
   * 
   * @return ゲームによって最終的に獲得したコイン数
   */
  public int execute() {
    while (true) {
      // 現在の獲得コイン数が最大獲得コイン数を超えている場合：ゲーム終了
      if (this.earnedCoinCount > this.maxWinCoin) return this.earnedCoinCount;
      
      // まずはカードを引き、そのカードの番号を出力する
      List<Integer> cardList = new ArrayList<Integer>();
      cardList = this.getCard(cardList);

      // ゲームを開始するかどうかユーザーに入力を求める
      while (true) {
        System.out.println("ハイ＆ローゲームに挑戦しますか？ y/n");
        String startButton = GameUtils.getInputString();

        if (startButton.equals("y")) break; // ゲーム開始
        else if (startButton.equals("n")) return this.earnedCoinCount; // ゲーム終了
        else System.out.println("開始の場合は y を、終了の場合は n を入力してください"); // 入力エラーの処理
      }

      // ゲーム開始後の処理
      boolean isHigh;
      while (true) {
        System.out.print("\n");
        System.out.println("次に引くカードの番号の方が、大きいと思う？小さいと思う？ h/l");
        String ans = GameUtils.getInputString();

        if (ans.equals("h")) {
          isHigh = true;
          break;

        } else if (ans.equals("l")) {
          isHigh = false;
          break;

        } else {
          System.out.println("大きいと思う場合は h を、小さいと思う場合は l を入力してください"); // 入力エラーの処理
        }
      }

      // カードを引く
      cardList = this.getCard(cardList);

      // 結果判定
      boolean isWinner = this.judgeCard(cardList, isHigh);
      if (isWinner) this.earnedCoinCount *= 2; // 勝ち：獲得コインを２倍にする
      else this.earnedCoinCount = 0;             // 負け：獲得コインを０にする

      // ゲームを続けるかどうかの判定
      if (this.earnedCoinCount == 0) {
        System.out.println("あなたの負け（笑） 獲得コイン：0枚");
        return this.earnedCoinCount;
      } else if (this.earnedCoinCount > 0) {
        System.out.println("あなたの勝ち！ 獲得コイン：" + this.earnedCoinCount + "枚");
      } else {
        // Not Reachable
      }
    }
  }

  /**
   * カードセットの中から、ランダムにカードを1枚引く。
   * 
   * @param cardList 現在の引いたカードリスト
   * @return カードリスト
   */
  private List<Integer> getCard(List<Integer> cardList) {
    // カードは、それぞれのカードセットから1枚ずつしか引けない
    // そのため、引いたカードの合計枚数が、カードセット数よりも多くなってはダメ
    if (cardList.size() + 1 <= deckSetCount) {
      final int MAX_CARD_VALUE = 10; // カードの番号の最大値

      // カードを1枚、カードセットから引く
      int cardA = 0;
      while (cardA == 0) { // カードの番号に 0 は存在しないため
        cardA = GameUtils.getRandomInt(MAX_CARD_VALUE);
      }
      cardList.add(cardA);

      // 引いたカードを表示する
      int lastIdx = cardList.size()-1;
      System.out.print("\n");
      System.out.println("引いたカードの番号：" + cardList.get(lastIdx));

    } else { // Not Reachable
      System.out.println("それぞれのカードセットからカードを引き終わっているため、これ以上引けません");
    }

    return cardList;
  }

  /**
   * 引数に引き渡された cardList, pickChoice を元に大小比較判定を行い、その結果を返却する。
   * 最後に引いたカードの番号が、一つ前に引いたカードより大きい場合に勝ち。
   * 
   * @param cardList カードリスト
   * @param pickChoice 最後に引いたカードの番号が、一つ前に引いたカードより大きいかどうか (大きい：true , 小さい：false)
   * @return 判定結果 (勝ち：true , 負け：false)
   */
  private boolean judgeCard(List<Integer> cardList, boolean pickChoice) {
    int lastIdx = cardList.size()-1;

    int cardA = cardList.get(lastIdx);   // カードリストの最後のカード
    int cardB = cardList.get(lastIdx-1); // 一つ前のカード

    // 結果を判定
    if (cardA == cardB) return false;
    else if (cardA > cardB) return (pickChoice) ? true : false;
    else if (cardA < cardB) return (!pickChoice) ? true : false;
    else return false; // Not Reachable
  }
}
