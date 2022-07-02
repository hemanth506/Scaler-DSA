#  this is some what confusting, since they have given the number which should start from, not the index value

'''
Problem Description
You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (1 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.



Problem Constraints
1 <= N, M <= 105
1 <= A[i] <= 109
1 <= L <= R <= N


Input Format
The first argument is the integer array A.
The second argument is the 2D integer array B.


Output Format
Return an integer array of length M where ith element is the answer for ith query in B.


Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = [[1, 4], [2, 3]]

Input 2:
A = [2, 2, 2]
B = [[1, 1], [2, 3]]


Example Output
Output 1:
[10, 5]

Output 2:
[2, 4]


Example Explanation
Explanation 1:
The sum of all elements of A[1 ... 4] = 1 + 2 + 3 + 4 = 10.
The sum of all elements of A[2 ... 3] = 2 + 3 = 5.

Explanation 2:
The sum of all elements of A[1 ... 1] = 2 = 2.
The sum of all elements of A[2 ... 3] = 2 + 2 = 4.

'''


class Solution:
    def rangeSum(self, A, B):
        
        for i in range(1, len(A)):
            A[i] = A[i - 1] + A[i]
        
        # print(A)
        total = []
        for i in range(len(B)):
            # print("======================")
            # print("B", B[i])
            l = B[i][0] - 1
            r = B[i][1] - 1
            # print("l=>", l, " r=> ", r)

            if l == 0:
                left = A[l]
            else:
                left = A[l - 1] 

            right = A[r]
            # print("l-2 =>", l, " r-2 => ", r)
            if l == 0:
                total.append(right)
            else:
                total.append(right - left)
        return total

# A = [1, 2, 3, 4, 5]
A = [5, 6, 8, 9, 6]
B = [[1, 4], [2, 3]]
soln = Solution()
print(soln.rangeSum(A, B))