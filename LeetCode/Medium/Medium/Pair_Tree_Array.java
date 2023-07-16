package Medium;

public class Pair_Tree_Array {
    public TreeNode node; 
    public int[] index = new int[2];
    public Pair_Tree_Array(TreeNode node, int i, int j) {
        this.index[0] = i;
        this.index[1] = j;
        this.node = node;
    }
}
