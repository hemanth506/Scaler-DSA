class Solution:
    def solve(self, A):
        N = len(A)
        prefix = []
        prefix.append(A[0])
        for i in range(1, N):
            prefix.append(prefix[i - 1] + A[i])

        # print(prefix)
        index = 0
        isIndexed = False
        for i in range(N):
            left = 0
            if i > 0:
                left = prefix[i - 1]

            right = prefix[N - 1] - prefix[i]

            # print(left, right)
            
            if left == right and not isIndexed:
                index = i
                isIndexed = True

        if isIndexed:
            return index
        else:
            return -1

        

A = [-7, 1, 5, 2, -4, 3, 0]
soln = Solution()
print(soln.solve(A))