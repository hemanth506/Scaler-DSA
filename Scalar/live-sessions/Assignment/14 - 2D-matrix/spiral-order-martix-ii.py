class Solution:
    def generateMatrix(self, A):
        B = [[0 for _ in range(A)] for _ in range(A)]

        towardsRight = True
        integer = 0
        i = 0
        j = 0
        rightArr = []
        downwardArr = []
        leftArr = []
        upwardArr = []
        tempA = A
        while integer <= tempA**2:
            if towardsRight:
                print("towards right",i, j, integer, A)
                integer += 1
                B[i][j] = integer
                rightArr.append(integer)
                if len(rightArr) == A:
                    downwards = True
                    towardsRight = False
                    rightArr = []
                else:
                    j += 1
                # break
            elif downwards:
                print("towards downward",i, j, integer, A)
                B[i][j] = integer
                downwardArr.append(integer)
                if len(downwardArr) == A:
                    downwards = False
                    towardsLeft = True
                    downwardArr = []
                else:
                    i += 1
                    integer += 1
                # break
            elif towardsLeft:
                print("towards left",i,j, integer, A)
                B[i][j] = integer
                leftArr.append(integer)
                if len(leftArr) == A:
                    towardsLeft = False
                    upwards = True
                    leftArr = []
                    A -= 1
                else:
                    j -= 1
                    integer += 1
                # break
            elif upwards:
                print("towards upwards",i, j, integer, A)
                B[i][j] = integer
                upwardArr.append(integer)
                if len(upwardArr) == A:
                    upwards = False
                    upwardArr = []
                    towardsRight =True
                    # A -= 1
                    # break
                else:
                    i -= 1
                    integer += 1
                # break


            
            

        return B


'''
expected:
[1 2 3 4 ] 
[12 13 14 5 ] 
[11 16 15 6 ] 
[10 9 8 7 ]



[[1, 2, 3, 4, 5],
 [17, 18, 19, 20, 6],
  [15, 0, 0, 21, 7],
   [14, 0, 0, 22, 8],
   [13, 25, 24, 23, 9]]


[[1, 2, 3, 4, 5],
 [17, 18, 19, 20, 6],
  [15, 0, 0, 21, 7],
   [14, 0, 0, 22, 8],
    [13, 25, 24, 23, 9]]
'''
A = 5
soln = Solution()
print(soln.generateMatrix(A)) 
