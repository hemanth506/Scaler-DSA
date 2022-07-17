import java.lang.Math;

public class findTwoOverlapArea {

    int solve(int A,int B,int C,int D,int E,int F,int G,int H) {
        
        if (G > A & H > B & D > F & C > E) {
            int ans = 0;
            // int area1 = 0;
            // int area2 = 0;
            int areaI = 0;
            if (A == E & B == F & C == G & D == H) {
                ans = Math.abs((A - H) * (C - E));
            } 
            else {
                // when finding area:
                // area1 = Math.abs(A-C) * Math.abs(B-D);
                // area2 = Math.abs(E-G) * Math.abs(F-H);
                
                // System.out.println(area1+ " " + area2);

                // Fining intersection:
                int xDist = (Math.min(C,G) - Math.max(A, E));
                int yDist = (Math.min(D,H) - Math.max(B, F));
                
                if (xDist > 0 & yDist > 0) {
                    areaI = xDist * yDist;
                }
                // System.out.println(areaI);
    
                // to find overlapping cube:
                ans = areaI;

                // to find overlapping area:
                // ans = area1 + area2 - areaI
            }
            return ans;
        }
        return 0;
    }
    public static void main(String[] args) {
        findTwoOverlapArea soln = new findTwoOverlapArea();

        // int  A= 6;
        // int  B= 3;
        // int  C= 9;
        // int  D= 4;
        // int  E= 2;
        // int  F= 6;
        // int  G= 5;
        // int  H =10;


    //    int  A= 6;
    //    int  B= 8;
    //    int C =10;
    //    int  D= 9;
    //    int  E= 6;
    //    int  F= 1;
    //    int  G= 9;
    //    int  H= 6;


    //    int  A= 6;
    //    int  B= 8;
    //    int C =10;
    //    int  D= 9;
    //    int  E= 6;
    //    int  F= 1;
    //    int  G= 9;
    //    int  H= 6;

        // int A = 0;
        // int B = 0;
        // int C = 4;
        // int D = 4;
        // int E = 2;
        // int F = 2;
        // int G = 3;
        // int H = 3;
        //  ot = 1

        // int A = 3;
        // int B = 4;
        // int C = 7;
        // int D = 5;
        // int E = 2;
        // int F = 3;
        // int G = 6;
        // int H = 5;

        // int A = 4;
        // int B = 4;
        // int C = 7;
        // int D = 5;
        // int E = 4;
        // int F = 4;
        // int G = 7;
        // int H = 5;

        int A = 0;
        int B = 0;
        int C = 4;
        int D = 4;
        int E = 2;
        int F = 2;
        int G = 6;
        int H = 6;


        System.out.println(soln.solve(A,B,C,D,E,F,G,H)); 
    }
}