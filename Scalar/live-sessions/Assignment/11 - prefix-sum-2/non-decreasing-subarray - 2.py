class Solution:
    def solve(self, A, B):
        aLen = len(A)
        prefix = [0] * aLen
        for i in range(1, aLen):
            if A[i - 1] <= A[i]:
                prefix[i] = 0
            else:
                prefix[i] = 1
            prefix[i] += prefix[i - 1]

        print(prefix)

        bLen = len(B)
        resp = []
        for i in range(bLen):
            if prefix[B[i][1] - 1] - prefix[B[i][0] - 1] == 0:
                resp.append(1)
            else:
                resp.append(0)

        return resp



A = [ 7, 7, 1, 6, 9 ]
B = [[1, 3],[4, 5], [1, 2], [3, 4], [1, 5]]

'''
     0  1  2  3  4  5  6  7  8  9
    [0,  0, 0,  1,  1,  2,  3,  3, 4,  4] '''
A = [ 3, 5, 19, 15, 17, 14, 2, 20, 2, 15 ]
B = [[3, 10], [7, 9], [5, 9], [6, 10], [3, 7], [7, 8], [3, 4], [3, 8], [2, 4], [5, 6]]

# A = [1, 7, 3, 4, 9]
# B = [[1, 2], [2, 4]]
soln = Solution()
print(soln.solve(A, B))


