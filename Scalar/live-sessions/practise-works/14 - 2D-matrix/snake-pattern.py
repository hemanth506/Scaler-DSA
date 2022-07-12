class Solution:
    def generateMatrix(self, A):
        B = [[0 for _ in range(A)] for _ in range(A)]

        notForward = False
        count = 1
        for i in range(A):
            if not notForward:
                j = 0
                while j < A:
                    B[i][j] = count
                    j += 1
                    count += 1
                notForward = True
            else:
                j = A - 1
                while j >= 0:
                    B[i][j] = count
                    j -= 1
                    count += 1
                notForward = False
            
        return B


'''
Sample output:
[[1, 2, 3, 4], 
[8, 7, 6, 5], 
[9, 10, 11, 12], 
[16, 15, 14, 13]]

'''
A = 4
soln = Solution()
print(soln.generateMatrix(A)) 
