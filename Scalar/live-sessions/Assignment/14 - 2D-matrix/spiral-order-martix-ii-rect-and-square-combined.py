
class Solution:
    def generateSquareMatrix(self, A):
        B = [[0 for _ in range(A)] for _ in range(A)]

        intervals = [A]
        for i in range(A - 1, 0, -1):
            for j in range(2):
                intervals.append(i)
        print(intervals)

        integer = 1
        i = 0
        j = 0
        forward = True
        downward = False
        upward = False
        backward = False
        for k in range(len(intervals)):
            iteration = intervals[k]
            for steps in range(iteration):
                if forward:
                    print(" forward", i, j, integer, steps)
                    B[i][j] = integer
                    integer += 1
                    if steps == intervals[k] - 1:
                        forward = False
                        downward = True
                        i += 1
                    else:
                        j += 1
                elif downward:
                    print(" downwards", i, j, integer, steps)
                    B[i][j] = integer
                    integer += 1
                    if steps == intervals[k] -1 :
                        downward = False
                        backward = True
                        j -= 1
                    else:
                        i += 1
                elif backward:
                    print(' backward', i, j, integer, steps)
                    B[i][j] = integer
                    integer += 1
                    if steps == intervals[k] -1 :
                        upward = True
                        backward = False
                        i -= 1
                    else:
                        j -= 1
                elif upward:
                    print(' upward', i, j, integer, steps)
                    B[i][j] = integer
                    integer += 1
                    if steps == intervals[k] -1  :
                        upward = False
                        forward = True
                        j += 1
                    else:
                        i -= 1
        return B


    def generateRectangularAndSquareMatrix(self, A, B):
        C = [[0 for _ in range(B)] for _ in range(A)]

        i = 1
        intervals = [B]
        while A > 0 and B > 0:
            if i % 2 == 1:
                A -= 1
                intervals.append(A)
            else:
                B -= 1
                intervals.append(B)
            i += 1

        integer = 1
        i = 0
        j = 0
        forward = True
        downward = False
        upward = False
        backward = False
        for k in range(len(intervals)):
            iteration = intervals[k]
            for steps in range(iteration):
                if forward:
                    C[i][j] = integer
                    integer += 1
                    if steps == intervals[k] - 1:
                        forward = False
                        downward = True
                        i += 1
                    else:
                        j += 1
                elif downward:
                    C[i][j] = integer
                    integer += 1
                    if steps == intervals[k] -1 :
                        downward = False
                        backward = True
                        j -= 1
                    else:
                        i += 1
                elif backward:
                    C[i][j] = integer
                    integer += 1
                    if steps == intervals[k] -1 :
                        upward = True
                        backward = False
                        i -= 1
                    else:
                        j -= 1
                elif upward:
                    C[i][j] = integer
                    integer += 1
                    if steps == intervals[k] -1  :
                        upward = False
                        forward = True
                        j += 1
                    else:
                        i -= 1
        return C



'''
Expected:
[1 2 3 4 ] 
[12 13 14 5 ] 
[11 16 15 6 ] 
[10 9 8 7 ]

Expected output:
[
 [1,  2,  3,  4,  5],
 [16, 17, 18, 19, 6],
 [15, 24, 25, 20, 7],
 [14, 23, 22, 21, 8],
 [13, 12, 11, 10, 9]
]


[[1, 2, 3, 4, 5, 6],
 [14, 15, 16, 17, 18, 7],
  [13, 12, 11, 10, 9, 8]]


[[1, 2, 3, 4, 5, 6, 7, 8, 9],
 [20, 21, 22, 23, 24, 25, 26, 27, 10],
  [19, 18, 17, 16, 15, 14, 13, 12, 11]]

[[1, 2, 3, 4, 5, 6, 7, 8, 9],
 [32, 33, 34, 35, 36, 37, 38, 39, 10],
  [31, 56, 57, 58, 59, 60, 61, 40, 11],
   [30, 55, 72, 73, 74, 75, 62, 41, 12],
    [29, 54, 71, 80, 81, 76, 63, 42, 13],
     [28, 53, 70, 79, 78, 77, 64, 43, 14],
      [27, 52, 69, 68, 67, 66, 65, 44, 15],
       [26, 51, 50, 49, 48, 47, 46, 45, 16],
        [25, 24, 23, 22, 21, 20, 19, 18, 17]]


[[1, 2, 3],
 [20, 21, 4],
  [19, 22, 5],
   [18, 23, 6],
    [17, 24, 7],
     [16, 25, 8],
      [15, 26, 9],
       [14, 27, 10],
        [13, 12, 11]]
'''
A = 9
B = 3
soln = Solution()
# print(soln.generateSquareMatrix(A)) 
print(soln.generateRectangularAndSquareMatrix(A, B))
