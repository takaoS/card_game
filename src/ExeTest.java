import util.GameUtils;

public class ExeTest {
  public static void main(String[] args) {
    String testStr = GameUtils.getInputString();
    boolean result = GameUtils.checkPattern(testStr);
    System.out.println("チェック結果：" + result);
  }
 }