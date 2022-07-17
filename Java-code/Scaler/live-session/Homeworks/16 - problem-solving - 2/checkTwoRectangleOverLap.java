public class checkTwoRectangleOverLap {

    int solve(int A,int B,int C,int D,int E,int F,int G,int H) {
        if (G > A & H > B & D > F & C > E) {
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        checkTwoRectangleOverLap soln = new checkTwoRectangleOverLap();

        // int  A= 6;
        // int  B= 3;
        // int  C= 9;
        // int  D= 4;
        // int  E= 2;
        // int  F= 6;
        // int  G= 5;
        // int H =10;


    //    int  A= 6;
    //    int  B= 8;
    //     int C =10;
    //    int  D= 9;
    //    int  E= 6;
    //    int  F= 1;
    //    int  G= 9;
    //    int  H= 6;


    //   int  A= 6;
    //    int  B= 8;
    //     int C =10;
    //    int  D= 9;
    //    int  E= 6;
    //    int  F= 1;
    //    int  G= 9;
    //    int  H= 6;

       int A = 0;
        int B = 0;
        int C = 1;
        int D = 1;
        int E = 1;
        int F = 1;
        int G = 6;
        int H = 6;

        // int A = 0;
        // int B = 0;
        // int C = 4;
        // int D = 4;
        // int E = 2;
        // int F = 2;
        // int G = 3;
        // int H = 3;
        //  ot = 1

        // int A = 0;
        // int B = 0;
        // int C = 4;
        // int D = 4;
        // int E = 2;
        // int F = 2;
        // int G = 6;
        // int H = 6;


        System.out.println(soln.solve(A,B,C,D,E,F,G,H)); 
    }
}