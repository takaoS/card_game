package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameUtils {
  private static final String REGEX_ALPHABET = "^[A-Za-z]{4,12}$"; // アルファベットのみで4~12文字

  /**
   * コンストラクタ
   */
  private GameUtils() {}

  /**
   * コンソールにてユーザーに入力を求め、その入力された文字列の値を取得する。
   * 
   * @return 入力値
   */
  public static String getInputString() {
    String inputStr = null;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("文字列を入力してください");
    try {
      inputStr = br.readLine();

    } catch (IOException e) {
      e.getStackTrace();
      System.out.println("入力エラー…再度 入力してください");
      getInputString();
    }

    return inputStr;
  }
}
