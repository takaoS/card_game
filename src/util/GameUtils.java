package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.regex.Pattern;

public class GameUtils {
  private static final String REGEX_ALPHABET = "^[A-Za-z]{4,12}$"; // アルファベットのみで4~12文字

  /**
   * コンストラクタ
   */
  private GameUtils() {}

  /**
   * コンソールにてユーザーに入力を求め、その入力された文字列の値を取得する。
   * 
   * @return 入力された文字列の値
   */
  public static String getInputString() {
    String inputStr = null;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    try {
      inputStr = br.readLine();

    } catch (IOException e) {
      e.getStackTrace();
      System.out.println("入力エラー：再度入力してください");
      getInputString();
    }

    return inputStr;
  }

  /**
   * コンソールにてユーザーに入力を求め、その入力された整数値を取得する。
   * 
   * @return 入力された整数値
   */
  public static int getInputInt() {
    int inputInt = 0;

    try {
      inputInt = Integer.parseInt(getInputString());

      // 文字列を数値型に変換しようとしたとき、文字列の形式が正しくない場合にスロー
    } catch (NumberFormatException e) {
      e.getStackTrace();
      System.out.println("入力エラー：半角整数を入力してください");
      inputInt = getInputInt();
    }

    return inputInt;
  }

  /**
   * 整数値の乱数を生成し返却する。
   * 
   * @param maxValue 生成する乱数の最大値となる整数
   * @return 生成された乱数
   */
  public static int getRandomInt(int maxValue) {
    Random random = new Random();
    int randomInt = random.nextInt(maxValue); // 0〜指定された値未満の整数を生成
    return randomInt;
  }

  /**
   * 引数に引き渡されたチェック対象の文字列が、該当の正規表現 REGEX_ALPHABET にマッチするか確認し、結果を返却する。
   * 
   * @param targetStr チェック対象の文字列
   * @return 対象の文字列と該当の正規表現の照合結果
   */
  public static boolean checkPattern(String targetStr) {
    if (targetStr == null || targetStr == "") {
      return false;

    } else {
      boolean result = Pattern.matches(REGEX_ALPHABET, targetStr);
      return result;
    }
  }
}
