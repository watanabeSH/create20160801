import java.util.Scanner;

/**
 * じゃんけんゲームメインクラス
 */
public class RPSGame {

  /**
   * じゃんけんゲームのエントリーポイント
   */
  public static void main(String[] args) {

    System.out.println("じゃんけんゲームを開始します。");
    System.out.println("以下から遊ぶモードを入力してください。");
    System.out.println("　- マニュアルじゃんけん : m");
    System.out.println("　- オートじゃんけん　　 : a");
    System.out.println("　- ゲーム終了　　　　　 : e");
    System.out.println("");

    boolean isError;
    Scanner scan = new Scanner(System.in);
    String input;

    do {
      isError = false;
      System.out.print("( m / a / e ) : ");

      // ユーザー入力
      input = scan.next();

      System.out.println("");

      if (input.equals("m")) {
        System.out.println("マニュアルじゃんけんを開始します。");
        manual();

      } else if (input.equals("a")) {
        System.out.println("オートじゃんけんを開始します。");
        auto();

      } else if (input.equals("e")) {
        System.out.println("ゲームを終了します。");

      } else {
        System.out.println(" m / a /e のうちどれかを入力してください。");
        isError = true;

      }
      System.out.println("");

    } while (isError);
    scan.close();
  }

  /**
   * じゃんけんゲーム マニュアル
   */
  private static void manual() {
    RPSPlayerBase user  = new RPSPlayerUser();
    RPSPlayerBase enemy = new RPSPlayerCom();

    user.setName("あなた");
    enemy.setName("あいて");

    int round = 0;
    int result = 0; // 0:あいこ   1:引数1プレイヤーの勝ち   2:引数2プレイヤーの勝ち

    System.out.println("");
    System.out.println("じゃんけんで勝負！");
    System.out.println("");

    do {

      System.out.println("最初はグー！");
      System.out.println("じゃんけん...");
      System.out.println("");

      do {
        result = judge(user,enemy);

        if (result == 0) {
          System.out.println("");
          System.out.println("あいこで...");
          System.out.println("");
        }
      } while (result == 0);

      System.out.println("");
      System.out.println("■■■■■■■■■■■■");
      System.out.println(user.getName() + "の勝ち数：" + user.getWin());
      System.out.println(enemy.getName() + "の勝ち数：" + enemy.getWin());
      System.out.println("■■■■■■■■■■■■");
      System.out.println("");

    } while(1==1);
  }

  private static int judge(RPSPlayerBase player1, RPSPlayerBase player2) {

    RPSType hand1 = player1.go();
    RPSType hand2 = player2.go();

    handMessage(player1.getName(), hand1);
    handMessage(player2.getName(), hand2);

    // p1がグー
    if(hand1 == RPSType.ROCK) {
      if (hand2 == RPSType.SCISSORS) {
          System.out.println(player1.getName() + "の勝ち！！");
          player1.onResult(true);
          player2.onResult(false);
          return 1;

      } else if (hand2 == RPSType.PAPER) {
        System.out.println(player2.getName() + "の勝ち！！");
        player1.onResult(false);
        player2.onResult(true);
        return 2;

      }

    // p1がパー
    } else if(hand1 == RPSType.PAPER) {
      if (hand2 == RPSType.ROCK) {
        System.out.println(player1.getName() + "の勝ち！！");
        player1.onResult(true);
        player2.onResult(false);
        return 1;

      } else if (hand2 == RPSType.SCISSORS) {
        System.out.println(player2.getName() + "の勝ち！！");
        player1.onResult(false);
        player2.onResult(true);
        return 2;
      }

   // p1がチョキ
    } else if(hand1 == RPSType.SCISSORS) {
      if (hand2 == RPSType.PAPER) {
        System.out.println(player1.getName() + "の勝ち！！");
        player1.onResult(true);
        player2.onResult(false);
        return 1;

      } else if (hand2 == RPSType.ROCK) {
        System.out.println(player2.getName() + "の勝ち！！");
        player1.onResult(false);
        player2.onResult(true);
        return 2;
      }

    }

    return 0;
  }

  private static void handMessage(String name, RPSType type) {
    String hand = null;
    if (type == RPSType.ROCK) {
      hand = "グー";
    } else if(type == RPSType.PAPER) {
      hand = "パー";
    } else if(type == RPSType.SCISSORS){
      hand = "チョキ";
    }
    System.out.println(name + "が出したのは「"+ hand +"」です！");
  }

  /**
   * じゃんけんゲーム オート
   */
  private static void auto() {
    RPSPlayerBase p1  = new RPSPlayerCom();
    RPSPlayerBase p2 = new RPSPlayerCom();

    p1.setName("COM1");
    p2.setName("COM2");

    int round = 0;
    int result = 0; // 0:あいこ   1:引数1プレイヤーの勝ち   2:引数2プレイヤーの勝ち

    System.out.println("");
    System.out.println("オートじゃんけん！");
    System.out.println("");

    do {

      System.out.println("最初はグー！");
      System.out.println("じゃんけん...");
      System.out.println("");

      do {
        result = judge(p1,p2);

        if (result == 0) {
          System.out.println("");
          System.out.println("あいこで...");
          System.out.println("");
        }
      } while (result == 0);

      round++;

      System.out.println("");
      System.out.println("■■■■■■■■■■■■");
      System.out.println(p1.getName() + "の勝ち数：" + p1.getWin());
      System.out.println(p2.getName() + "の勝ち数：" + p2.getWin());
      System.out.println("■■■■■■■■■■■■");
      System.out.println("");

    } while(round<=50);

    System.out.println("50戦終了!");
    System.out.println("~");
    System.out.println("~");
    System.out.println("~");
    System.out.println("~");
    System.out.println("~");
    System.out.println("~");
    System.out.println("~");
    System.out.println("~");
    System.out.println("~");
    System.out.println("~");
    System.out.println("~");
    System.out.println("~");
    System.out.println("~");
    System.out.println("~");
    System.out.println("~");
    System.out.println("~");
    System.out.println("~");
    System.out.println("~");
    System.out.println("★☆★☆最終結果★☆★☆");
    System.out.println("");
    if(p1.getWin() > p2.getWin()) {
      System.out.println( "WINNER...  " + p1.getName() + "!!　　(勝ち数：" + p1.getWin() +")" );
    } else if (p2.getWin() > p1.getWin()) {
      System.out.println( "WINNER...  " + p2.getName() + "!!　　(勝ち数：" + p2.getWin() + ")");
    } else {
      System.out.println("引きわけ！");
    }


  }

}