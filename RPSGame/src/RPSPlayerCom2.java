import java.util.Random;

public class RPSPlayerCom2 extends RPSPlayerBase  {

  @Override
  public RPSType go() {
    Random random = new Random();
    RPSType type = null;

    int num = random.nextInt(3) + 1;

    if (num==RPSType.ROCK.getId()) {
      type = RPSType.ROCK;

    } else if (num==RPSType.PAPER.getId()) {
      type = RPSType.PAPER;

    } else if (num==RPSType.SCISSORS.getId()) {
      type = RPSType.SCISSORS;
    }

    return type;
  }

}
