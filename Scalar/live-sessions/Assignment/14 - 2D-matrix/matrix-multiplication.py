class Solution:
    def solve(self, A, B):
        
        M = len(A)
        N = len(A[0])
        P = len(B[0])
        
        totalArr = []
        for i in range(M):
            elt = []
            for j in range(P):
                addition = 0
                for k in range(N):
                    addition += A[i][k] * B[k][j]
                    # print(A[i][k] * B[k][j])
                elt.append(addition)
            totalArr.append(elt)
        return totalArr

A = [[1, 2], [3, 4]]        
B = [[5, 6], [7, 8]]

A = [[1,2,3],
     [4,5,6],
     [7,8,9]]
B = [[10,11,12],
     [13,14,15],
     [16,17,18]]

A = [[94, 91]]
B = [[35, -52, -12, 26, -93, -61],
     [29, -20, -36, -9, 66, 15]]
soln = Solution()
print(soln.solve(A,B))
