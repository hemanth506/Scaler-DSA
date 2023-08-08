import java.util.ArrayList;

import Medium.TreeNode;

public class stepByStepDirectionBinaryTree_Q2096 {
    ArrayList<TreeNode> path;
    StringBuilder sb;

    stepByStepDirectionBinaryTree_Q2096() {
        path = new ArrayList<>();
        sb = new StringBuilder();
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        pathFromRootToStartNode(root, startValue);

        boolean pathFound = checkPathBelow(path.get(0), destValue);
        if (pathFound) {
            sb.reverse();
            System.out.println(sb.toString());
            return sb.toString();
        }

        StringBuilder upSb = new StringBuilder();
        for (int i = 1; i < path.size(); i++) {
            upSb.append("U");
            if (path.get(i).left != path.get(i - 1)) {
                pathFound = checkPathBelow(path.get(i).left, destValue);
                if (pathFound) {
                    StringBuilder wholeSB = new StringBuilder();
                    wholeSB.append(upSb);
                    wholeSB.append("L");
                    sb.reverse();
                    wholeSB.append(sb);
                    System.out.println(wholeSB.toString());
                    return wholeSB.toString();
                }
            } else if (path.get(i).right != path.get(i - 1)) {
                pathFound = checkPathBelow(path.get(i).right, destValue);
                if (pathFound) {
                    StringBuilder wholeSB = new StringBuilder();
                    wholeSB.append(upSb);
                    wholeSB.append("R");
                    sb.reverse();
                    wholeSB.append(sb);
                    System.out.println(wholeSB.toString());
                    return wholeSB.toString();
                }
            }
            if (path.get(i).val == destValue) {
                break;
            }
        }
        System.out.println(upSb.toString());
        return upSb.toString();
    }

    private boolean checkPathBelow(TreeNode start, int destValue) {
        if (start == null) {
            return false;
        }

        if (start.val == destValue) {
            return true;
        }

        if (checkPathBelow(start.left, destValue)) {
            // System.out.println("L");
            sb.append('L');
            return true;
        }
        if (checkPathBelow(start.right, destValue)) {
            // System.out.println("R");
            sb.append('R');
            return true;
        }

        return false;
    }

    private boolean pathFromRootToStartNode(TreeNode root, int startValue) {
        if (root == null) {
            return false;
        }

        if (root.val == startValue) {
            path.add(root);
            return true;
        }

        if (pathFromRootToStartNode(root.left, startValue) || pathFromRootToStartNode(root.right, startValue)) {
            path.add(root);
            return true;
        }
        return false;
    }
}
