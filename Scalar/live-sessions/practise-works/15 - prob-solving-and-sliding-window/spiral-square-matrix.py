

class Solution:
    def solveClockWise(self, n):
        matrix = [[0 for i in range(n)] for i in range(n)]
        # print(matrix)

        integer = 1
        j = 0
        i = 0
        while n > 1:
            # print(i, j)
            for _ in range(n - 1):
                matrix[i][j] = integer
                integer += 1
                j += 1

            for _ in range(n - 1):
                matrix[i][j] = integer
                integer += 1
                i += 1

            for _ in range(n - 1):
                matrix[i][j] = integer
                integer += 1
                j -= 1

            for _ in range(n - 1):
                matrix[i][j] = integer
                integer += 1
                i -= 1
            
            i += 1
            j += 1
            n -= 2
        
        print(n, integer,i,j)
        if n == 1:
            matrix[i][j] = integer

            # print(i, j)

        return matrix
    
    def solveAntiClockWise(self, n):
        matrix = [[0 for i in range(n)] for i in range(n)]

        i = 0
        j = 0
        integer = 1
        while n > 1:
            for k in range(n - 1):
                matrix[i][j] = integer
                i += 1
                integer += 1

            for k in range(n - 1):
                matrix[i][j] = integer
                j += 1
                integer += 1

            for k in range(n - 1):
                matrix[i][j] = integer
                i -= 1
                integer += 1

            for k in range(n - 1):
                matrix[i][j] = integer
                j -= 1
                integer += 1

            i += 1
            j += 1
            n -= 2

        if n == 1:
            matrix[i][j] = integer
        print(matrix)

n = 5
soln = Solution()
# print(soln.solveClockWise(n))
print(soln.solveAntiClockWise(n))



'''
[[1, 2, 3, 4, 5],
 [16, 17, 18, 19, 6],
  [15, 24, 0, 20, 7],
   [14, 23, 22, 21, 8],
    [13, 12, 11, 10, 9]]

[[1, 2, 3, 4, 5],
 [16, 17, 0, 0, 6],
  [15, 0, 0, 0, 7],
   [14, 0, 0, 0, 8],
    [13, 12, 11, 10, 9]]


[[1, 20, 19, 18, 17, 16],
 [2, 0, 0, 0, 0, 15],
  [3, 0, 0, 0, 0, 14],
   [4, 0, 0, 0, 0, 13],
    [5, 0, 0, 0, 0, 12],
     [6, 7, 8, 9, 10, 11]]

[[1, 20, 19, 18, 17, 16],
 [2, 21, 32, 31, 30, 15],
  [3, 22, 33, 36, 29, 14],
   [4, 23, 34, 35, 28, 13],
    [5, 24, 25, 26, 27, 12],
     [6, 7, 8, 9, 10, 11]]


'''