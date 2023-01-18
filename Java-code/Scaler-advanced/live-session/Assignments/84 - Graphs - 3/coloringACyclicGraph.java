
public class coloringACyclicGraph {
    public int solve(int A) {
        if(A == 1) {
            System.out.println(1);
            return 1;
        }
        if(A%2 == 0) {
            System.out.println(2);
            return 2;
        }
        System.out.println(3);
        return 3;
    }
    public static void main(String[] args) {
        coloringACyclicGraph cy = new coloringACyclicGraph();
        int A = 5;
        cy.solve(A);
    }
}
