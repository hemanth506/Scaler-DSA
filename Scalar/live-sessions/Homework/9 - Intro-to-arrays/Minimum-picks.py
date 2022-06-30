class Solution:
    def solve(self, A):
        notFirstEven = False
        notFirstOdd = False
        for i in range(len(A)):
            if A[i] % 2 == 0:
                if notFirstEven:
                    if maxEven < A[i]:
                        maxEven = A[i]
                else:
                    maxEven = A[i]
                    notFirstEven = True
            else:
                if notFirstOdd:
                    if minOdd > A[i]:
                        minOdd = A[i]
                else:
                    minOdd = A[i]
                    notFirstOdd = True

        print("maxEven => ",maxEven)
        print("minOdd => ",minOdd)
        return maxEven - minOdd

# A = [ -98, 54, -52, 15, 23, -97, 12, -64, 52, 85 ]
A = [ 74, 9, 51, 51, 75, 0, 35, 89, 96, 77 ]
soln = Solution()
print(soln.solve(A))