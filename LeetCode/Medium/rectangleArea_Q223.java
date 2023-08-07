public class rectangleArea_Q223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int rect1Actual = Math.abs(ax1 - ax2) * Math.abs(ay1 - ay2);
        int rect2Actual = Math.abs(bx1 - bx2) * Math.abs(by1 - by2);

        int total = rect1Actual + rect2Actual;
        System.out.println(total);
        System.out.println(rect1Actual + " " + rect2Actual);

        int overLap = Integer.max(Integer.min(bx2, ax2) - Integer.max(ax1, bx1), 0)
                * Integer.max(Integer.min(ay2, by2) - Integer.max(ay1, by1), 0);
        System.out.println(overLap);

        total -= overLap;
        System.out.println(total);
        return total;
    }

    public static void main(String[] args) {
        rectangleArea_Q223 rc = new rectangleArea_Q223();
        int ax1 = -3;
        int ay1 = 0;
        int ax2 = 3;
        int ay2 = 4;
        int bx1 = 0;
        int by1 = -1;
        int bx2 = 9;
        int by2 = 2;

        // int ax1 = 0;
        // int ay1 = 0;
        // int ax2 = 0;
        // int ay2 = 0;
        // int bx1 = -1;
        // int by1 = -1;
        // int bx2 = 1;
        // int by2 = 1;
        rc.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
    }
}

/*
 * boolean isDot = false;
 * if((ax1 == ax2) && (ay1 == ay2) && (ax2 == ay1)) {
 * isDot = true;
 * }
 * 
 * if((bx1 == bx2) && (by1 == by2) && (bx1 == by2)) {
 * isDot = true;
 * }
 * 
 * if(!isDot) {
 * int innerRect = 0;
 * if(ax2 >= bx1 && ay1 <= by2 && bx2 >= ax1 && ay2 >= by1) { // case 1
 * innerRect = Math.abs(ax2-bx1) * Math.abs(ay1-by2);
 * System.out.println(ax2 + " " + bx1 + " " + ay1 + " " + by2);
 * System.out.println("case 1 = " + innerRect);
 * } else if (ax2 >= bx1 && ay2 >= by1 && bx1 >= ax1 && by1 >= ay1) { // case 2
 * innerRect = Math.abs(ax2-bx1) * Math.abs(ay2-by1);
 * System.out.println("case 2 = " + innerRect);
 * } else if (bx2 >= ax1 && ay2 >= by1 && bx1 <= ax2 && by2 <= ay2) { // case 3
 * innerRect = Math.abs(bx2-ax1) * Math.abs(ay2-by1);
 * System.out.println("case 3 = " + innerRect);
 * } else if (bx2 >= ax1 && by2 >= ay1 && ax2 >= bx1 && ay2 >= by1) { // case 4
 * innerRect = Math.abs(bx2-ax1) * Math.abs(by2-ay1);
 * System.out.println("case 4 = " + innerRect);
 * }
 * 
 * total -= innerRect;
 * }
 */