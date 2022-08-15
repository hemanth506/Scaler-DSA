import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class repeatAndMissingNumber {
    // My Approach - Binary Search
    public int binarySearch(List<Integer> A, int f, int e, int toFind) {
        while (f <= e) {
            int mid = f + (e - f) / 2;
            if (A.get(mid) < toFind) {
                f = mid + 1;
            } else if (A.get(mid) > toFind) {
                e = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public ArrayList<Integer> repeatedNumberBinarySearch(final List<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        int N = A.size();
        Collections.sort(A);
        // System.out.println(A);


        int toFind = A.get(0);
        int found = 0;
        int findDup = 0;
        int duplicate = 0;
        boolean foundDup = false;
        boolean foundMiss = false;
        for(int i = 0; i < N; i++) {
            int index = binarySearch(A, i, N - 1, toFind);
            if (findDup == A.get(i) && !foundDup) {
                duplicate = A.get(i);
                foundDup = true;
                // System.out.println(duplicate);
            }
            if (index == -1 && !foundMiss) {
                // System.out.println(toFind);
                found = toFind;
                foundMiss = true;
                toFind++;
            }
            findDup = A.get(i);
            // System.out.println(index+ " " +A.get(i) +" "+ toFind + " " + duplicate);
            toFind++;
        }
        B.add(duplicate);
        B.add(found);

        return B;
    }

    // My approach  - O(NLogN)
    public ArrayList<Integer> repeatedNumberNew(final List<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        Collections.sort(A);
        // System.out.println(A);
        

        int prevVal = -1;
        int duplicate = 0;
        int missing = 1;
        int missVal = 0;
        boolean missFlag = false;
        for (int values: A) {
            if (prevVal == values) {
                duplicate = values;
                missing--;
            }

            if (missing != values && !missFlag) {
                missVal = missing;
                missFlag = true;

            }
            prevVal = values;
            // System.out.println(values + " " + missing + " " + duplicate + " " + missVal);
            missing++;
        }
        // System.out.println(A.size());
        if (A.size() == 2) {
            missVal = missVal == 0 ? duplicate + 1: missVal;
        }
        B.add(duplicate);
        B.add(missVal);
        return B;
    }
    
    // given total and given squares approach
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        int N = A.size();

        long total = N * (N+1) / 2;
        long givenTotal = 0;
        long squares = 0;
        long givenSquares = 0;
        for (int i = 0; i < N; i++) {
            givenTotal += A.get(i);
            squares += (i+1) * (i+1);
            givenSquares += (A.get(i) * A.get(i));
        }
        System.out.println("ActualSums => " +total + " GivenSums => " + givenTotal);

        System.out.println("ActualSquares => " + squares + " GivenSquares => " + givenSquares);

        long r = (givenSquares - squares)/(givenTotal - total);
        System.out.println("squares => " + (givenSquares-squares) + " sums => " + (givenTotal-total));
        
        long t = r + (givenTotal - total);
        System.out.println(t);
        t = t>>1;
        long p = t - (givenTotal - total);
        System.out.println("r => " + r + " t => " + t + " p => " + p);
        return B;
    }

    
    public static void main(String[] args) {
        repeatAndMissingNumber rp = new repeatAndMissingNumber();

        List<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 1, 2, 5, 3));

        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(1,1));
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(2,2));

        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(389, 299, 65, 518, 361, 103, 342, 406, 24, 79, 192, 181, 178, 205, 38, 298, 218, 143, 446, 324, 82, 41, 312, 166, 252, 59, 91, 6, 248, 395, 157, 332, 352, 57, 106, 246, 506, 261, 16, 470, 224, 228, 286, 121, 193, 241, 203, 36, 264, 234, 386, 471, 225, 466, 81, 58, 253, 468, 31, 197, 15, 282, 334, 171, 358, 209, 213, 158, 355, 243, 75, 411, 43, 485, 291, 270, 25, 100, 194, 476, 70, 402, 403, 109, 322, 421, 313, 239, 327, 238, 257, 433, 254, 328, 163, 436, 520, 437, 392, 199, 63, 482, 222, 500, 454, 84, 265, 508, 416, 141, 447, 258, 384, 138, 47, 156, 172, 319, 137, 62, 85, 154, 97, 18, 360, 244, 272, 93, 263, 262, 266, 290, 369, 357, 176, 317, 383, 333, 204, 56, 521, 502, 326, 353, 469, 455, 190, 393, 453, 314, 480, 189, 77, 129, 439, 139, 441, 443, 351, 528, 182, 101, 501, 425, 126, 231, 445, 155, 432, 418, 95, 375, 376, 60, 271, 74, 11, 419, 488, 486, 54, 460, 321, 341, 174, 408, 131, 115, 107, 134, 448, 532, 292, 289, 320, 14, 323, 61, 481, 371, 151, 385, 325, 472, 44, 335, 431, 187, 51, 88, 105, 145, 215, 122, 162, 458, 52, 496, 277, 362, 374, 26, 211, 452, 130, 346, 10, 315, 459, 92, 531, 467, 309, 34, 281, 478, 477, 136, 519, 196, 240, 12, 288, 302, 119, 356, 503, 527, 22, 27, 55, 343, 490, 127, 444, 308, 354, 278, 497, 191, 294, 117, 1, 396, 125, 148, 285, 509, 208, 382, 297, 405, 245, 5, 330, 311, 133, 274, 275, 118, 463, 504, 39, 99, 442, 337, 169, 140, 104, 373, 221, 499, 413, 124, 510, 159, 465, 80, 276, 83, 329, 524, 255, 387, 259, 397, 491, 517, 23, 4, 230, 48, 349, 412, 142, 114, 487, 381, 164, 35, 67, 498, 73, 440, 108, 226, 96, 132, 144, 207, 235, 33, 69, 128, 236, 364, 198, 475, 173, 493, 150, 90, 515, 111, 68, 232, 340, 112, 526, 492, 512, 495, 429, 146, 336, 17, 350, 251, 7, 184, 76, 380, 359, 293, 19, 49, 345, 227, 212, 430, 89, 474, 279, 201, 398, 347, 273, 37, 185, 177, 102, 304, 295, 422, 94, 426, 514, 116, 183, 180, 494, 42, 305, 152, 390, 30, 247, 451, 32, 388, 331, 78, 424, 368, 394, 188, 306, 449, 8, 214, 120, 179, 280, 511, 409, 338, 153, 507, 370, 461, 217, 161, 483, 147, 242, 86, 417, 268, 71, 462, 420, 167, 513, 379, 307, 522, 435, 113, 296, 457, 525, 45, 529, 423, 427, 2, 438, 64, 316, 46, 40, 13, 516, 367, 233, 110, 318, 250, 283, 216, 186, 310, 237, 377, 365, 175, 479, 378, 66, 414, 473, 165, 210, 50, 348, 372, 363, 339, 20, 168, 284, 415, 505, 206, 53, 223, 434, 202, 123, 399, 400, 135, 269, 428, 219, 456, 28, 464, 267, 489, 98, 391, 195, 366, 300, 484, 533, 229, 213, 149, 160, 256, 303, 530, 301, 29, 404, 344, 401, 220, 287, 9, 407, 170, 450, 523, 249, 72, 410, 3, 21, 200, 260));

        rp.repeatedNumber(A);
        // System.out.println(rp.repeatedNumberNew(A));

        
    }
}
