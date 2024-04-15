import util.CardPickGame;
import util.GameUtils;

public class Playing {
  /**
   * ゲーム開始から結果表示までの処理を行う。
   * 
   * @param args お約束の引数
   */
  public static void main(String[] args) {
    String username = "";
    int possessionCoin = 1000;

    // ゲーム開始
    System.out.println("ようこそ！");

    // ユーザー名の入力
    System.out.println("ユーザー名を入力してください");
    while (true) {
      username = GameUtils.getInputString();
      
      boolean isMatched = GameUtils.checkPattern(username);
      if (isMatched) break;
      else System.out.println("4〜12文字の半角アルファベットで入力してください");
    }

    // ユーザー名の入力完了
    System.out.println(username + "さん、こんにちは！");

    // ゲームを実行し、所持コインを更新
    CardPickGame objCardPickGame = new CardPickGame(possessionCoin);
    possessionCoin = objCardPickGame.execute();

    // ゲーム終了 (結果表示)
    System.out.println(username + "さんの最終的な所持コイン：" + possessionCoin + "枚");
  }
}
