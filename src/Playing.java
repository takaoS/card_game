import util.GameUtils;

public class Playing {
  /**
   * ゲーム開始から結果表示までの処理を行う。
   * 
   * @param args
   */
  public static void main(String[] args) {
    String username = "";

    System.out.println("ようこそ！");

    System.out.println("ユーザー名を入力してください");
    boolean checkResult;
    do {
      username = GameUtils.getInputString();
      checkResult = GameUtils.checkPattern(username);
      if (!checkResult) System.out.println("4〜12文字の半角アルファベットで入力してください");
    } while (!checkResult);

    System.out.println(username + "さん、こんにちは！");
  }
}
