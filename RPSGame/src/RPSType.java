/**
 * じゃんけん出し手 列挙型
 */
public enum RPSType {
  ROCK(1),      // グー
  PAPER(2),     // パー
  SCISSORS(3);  // チョキ

  private final int id;

  /**
   * コンストラクタ
   * @param id ID
   */
  private RPSType(final int id) {
    this.id = id;
  }

  /*
   * 列挙型のID取得
   * @return ID
   */
  public int getId() {
    return id;
  }
}
