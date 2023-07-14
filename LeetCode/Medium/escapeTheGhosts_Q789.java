public class escapeTheGhosts_Q789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int N = ghosts.length;

        int distTotarget = Integer.max(0, target[0]) - Integer.min(0, target[0]);
        distTotarget += Integer.max(0, target[1]) - Integer.min(0, target[1]);

        System.out.println(distTotarget);

        for (int i = 0; i < N; i++) {
            int curGhostSteps = Integer.max(target[0], ghosts[i][0]) - Integer.min(target[0], ghosts[i][0]);
            curGhostSteps += Integer.max(target[1], ghosts[i][1]) - Integer.min(target[1], ghosts[i][1]);

            if(distTotarget >= curGhostSteps) {
                System.out.println(false);
                return false;
            }
        }

        System.out.println(true);
        return true;
    }

    public static void main(String[] args) {
        escapeTheGhosts_Q789 eg = new escapeTheGhosts_Q789();
        int[][] ghosts = { { 1, 0 }, { 0, 3 } };
        int[] target = { 0, 1 };
        eg.escapeGhosts(ghosts, target);
    }
}
