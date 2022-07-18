public class leadersArray {


    int leaders (int[] arr) {
        int N = arr.length;
        int lead = arr[0];
        int leadCt = 1;
        for(int i = 1; i < N; i++) {
            if (arr[i] > lead) {
                lead = arr[i];
                leadCt += 1;
            }
        }

        return leadCt;
    }
    public static void main(String[] args) {
        
        leadersArray ld = new leadersArray();
        int[] arr = {3,2,4,5,2,7,-1,15};
        System.out.println(ld.leaders(arr));
    
    }
}
