
class Solution:
    def generateMatrix(self, A):
        B = [[0 for _ in range(A)] for _ in range(A)]

        interationValue = [A]
        for i in range(A - 1, 0, -1):
            for j in range(2):
                interationValue.append(i)
        # print(interationValue)

        integer = 1
        i = 0
        j = 0
        forward = True
        downward = False
        upward = False
        backward = False
        for k in range(len(interationValue)):
            iteration = interationValue[k]
            for steps in range(iteration):
                if forward:
                    # print(" forward", i, j, integer, steps)
                    B[i][j] = integer
                    integer += 1
                    if steps == interationValue[k] - 1:
                        forward = False
                        downward = True
                        i += 1
                    else:
                        j += 1
                elif downward:
                    # print(" downwards", i, j, integer, steps)
                    B[i][j] = integer
                    integer += 1
                    if steps == interationValue[k] -1 :
                        downward = False
                        backward = True
                        j -= 1
                    else:
                        i += 1
                elif backward:
                    # print(' backward', i, j, integer, steps)
                    B[i][j] = integer
                    integer += 1
                    if steps == interationValue[k] -1 :
                        upward = True
                        backward = False
                        i -= 1
                    else:
                        j -= 1
                elif upward:
                    # print(' upward', i, j, integer, steps)
                    B[i][j] = integer
                    integer += 1
                    if steps == interationValue[k] -1  :
                        upward = False
                        forward = True
                        j += 1
                    else:
                        i -= 1
        return B


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
'''
A = 7
soln = Solution()
print(soln.generateMatrix(A)) 
