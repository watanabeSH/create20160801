import java.util.Scanner;

public class RPSPlayerUser extends RPSPlayerBase  {

  @Override
  public RPSType go() {
    Scanner scan = new Scanner(System.in);
    String input;
    boolean isError;
    RPSType type = null;

      do {
        isError = false;

        System.out.println("どの手を出す？");
        System.out.print(" 1:グー / 2:パー / 3:チョキ / (e:ゲーム終了) : ");
        // ユーザー入力
        input = scan.next();

        System.out.println("");

        if (input.equals("1")) {
          type = RPSType.ROCK;

        } else if (input.equals("2")) {
          type = RPSType.PAPER;

        } else if (input.equals("3")) {
          type = RPSType.SCISSORS;

        } else if (input.equals("e")) {
          System.out.print("ゲームを終了します。");
          System.exit(0);

        } else {
          System.out.println(" 1:グー / 2:パー / 3:チョキ のうちどれかを入力してください。");
          isError = true;
        }
      System.out.println("");
    } while (isError);

    return type;
  }

}
