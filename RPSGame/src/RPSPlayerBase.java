/**
 * じゃんけんゲームプレイヤーの抽象クラス
 */
public abstract class RPSPlayerBase {
  private String name;
  private int win = 0;
  private int lose = 0;
  public abstract RPSType go();

  public void onResult(boolean isWinner) {
    if (isWinner) {
      this.win ++;
    } else {
      this.lose ++;
    }
  }

  public int getWin() {
    return this.win;
  }

  public int getLose() {
    return this.lose;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
