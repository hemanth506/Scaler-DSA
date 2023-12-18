public class MinimumFlips {
  public int minFlips(int a, int b, int c) {
    int count = 0;
    for (int i = 0; i < 32; i++) {
      int aBit = ((a >> i) & 1);
      int bBit = ((b >> i) & 1);
      int cBit = ((c >> i) & 1);

      if (cBit == 0) {
        if (aBit == 1 && bBit == 1) {
          count += 2;
        } else if (aBit == 1 || bBit == 1) {
          count += 1;
        }
      } else {
        if (aBit == 0 && bBit == 0) {
          count += 1;
        }
      }
      System.out.println(i + " a = " + ((a >> i) & 1) + " b = " + ((b >> i) & 1) + " c = " + ((c >> i) & 1));
      System.out.println("================");
    }

    System.out.println("count = " + count);
    return count;
  }

  public static void main(String[] args) {
    MinimumFlips mf = new MinimumFlips();
    int a = 4;
    int b = 2;
    int c = 7;
    mf.minFlips(a, b, c);
  }
}
