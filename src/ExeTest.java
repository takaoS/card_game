import util.GameUtils;

public class ExeTest {
  public static void main(String[] args) {
    Integer randomInt = GameUtils.getRandomInt(30);
    System.out.println("乱数：" + randomInt);
  }
 }