public class noOfOneBits {
  public int numSetBits(int A) {
    int ct = 0;
    while (A > 0) {
      System.out.println(A >> 1);
      if (((A >> 1)& 1) != 0) {
        ct += 1;
      }
      A = A >> 1;
    }
    System.out.println("count = " + ct);
    return ct;
  }

  public static void main(String[] args) {
    noOfOneBits no = new noOfOneBits();
    int A = 11;
    no.numSetBits(A);
  }
}


/*
 */