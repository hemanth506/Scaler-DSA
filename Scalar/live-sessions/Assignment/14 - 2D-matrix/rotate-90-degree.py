class Solution:
    def solve(self, A):
        
        n = len(A)
        m = len(A[0])

        # B = [[0 for i in range(n)] for i in range(m)]

        # for i in range(m):
        #     for j in range(n):
        #         B[i][j] = A[j][i]

        # transpose the 2D array
        for i in range(n):
            for j in range(i, m):
                temp = A[i][j]
                A[i][j] = A[j][i]
                A[j][i] = temp

        # reversing using swap
        for i in range(len(A)):
            l = 0
            h = len(A[i]) - 1
            while l < h:
                temp = A[i][h]
                A[i][h] = A[i][l]
                A[i][l] = temp
                l += 1
                h -= 1

        return A




A = [
  [24, 63, 39, 81, 84, 30],
  [21, 64, 95, 6, 88, 73],
  [33, 6, 63, 96, 86, 66],
  [62, 88, 23, 52, 94, 77],
  [81, 58, 74, 18, 16, 25],
  [26, 40, 88, 64, 72, 23],
  [45, 44, 86, 92, 50, 26],
  [64, 34, 83, 26, 29, 68],
  [43, 42, 7, 17, 45, 52],
  [94, 25, 62, 19, 95, 77]
]
A = [[1, 2, 3, 4],
     [5, 6, 7, 8],
     [9,10,11,12], 
     [13,14,15,16]]

A = [
  [1, 2],
  [3, 4]
]
soln = Solution()
print(soln.solve(A))