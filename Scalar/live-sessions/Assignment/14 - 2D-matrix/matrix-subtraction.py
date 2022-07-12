class Solution:
    def solve(self, A, B):


        for i in range(len(A)):
            for j in range(len(A[0])):
                # print(A[i][j]- B[i][j])
                A[i][j] = A[i][j]- B[i][j]

        return A

# A = [[1, 2], [3, 4]]        
# B = [[5, 6], [7, 8]]


A = [[1, 2], 
     [4, 5], 
     [7, 8]] 

B = [[9, 8], 
     [6, 5], 
     [3, 2]]
soln = Solution()
print(soln.solve(A,B))
