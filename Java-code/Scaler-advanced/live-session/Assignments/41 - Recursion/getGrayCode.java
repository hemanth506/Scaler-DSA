import java.util.ArrayList;

public class getGrayCode {
    public ArrayList<Integer> grayCode(int a) {
        if(a == 1) {
            ArrayList<Integer> initialGrayCode = new ArrayList<Integer>();
            initialGrayCode.add(0);
            initialGrayCode.add(1);
            return initialGrayCode;
        }
        ArrayList<Integer> subGrayCode = grayCode(a - 1);
        System.out.println(subGrayCode);
        ArrayList<Integer> currentGrayCode = new ArrayList<Integer>();
        for(int i = 0; i < subGrayCode.size(); i++) {
            currentGrayCode.add(subGrayCode.get(i));
        }
        for(int j = subGrayCode.size() - 1; j >= 0; j--) {
            System.out.println(1<<(a-1));
            currentGrayCode.add(subGrayCode.get(j) + (1<<(a-1)));
        } 
        return currentGrayCode;
	}
    public static void main(String[] args) {
        getGrayCode gc = new getGrayCode();
        int a = 4;
        System.out.println(gc.grayCode(a));
    }
}
