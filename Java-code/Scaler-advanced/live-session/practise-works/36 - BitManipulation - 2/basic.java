
// multiples of 2      => i<<1 [ 0,2,4,6,8,10,12,14,16,...]
// multiply ans with 2 => 1<<i [ 1,2,4,8,16,32,64,128,...]
public class basic {
    public static void main(String[] args) {
        for(int i = 0; i < 20; i++) {
            System.out.println("=================" + (1<<i));
            System.out.println("+++" + (i<<1));
        }
    }
}
