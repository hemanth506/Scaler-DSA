class Solution:
    def solve(self, A):
        # print(A)
        newArr = []
        for i in range(len(A[0])):
            add = 0
            for j in range(len(A)):
                # print(A[j][i])
                add += A[j][i]
            newArr.append(add)
        return newArr


A = [[1,2,3,4],
[5,6,7,8],
[9,2,3,4]]
soln = Solution()
print(soln.solve(A))
