class Solution:
    def countEven(self, A, Q):
        # print(A)
        for i in range(len(A)):
            if A[i] % 2 == 0:
                A[i] = 1
            else:
                A[i] = 0
        print(A)

        # prefix sum with extra space
        prefix = [0] * len(A)
        prefix[0] = A[0]
        for i in range(1, len(A)):
            prefix[i] = prefix[i - 1] + A[i]
        print(prefix)


        evenCount = []
        for i in range(len(Q)):
            l = Q[i][0]
            r = Q[i][1]

            count = prefix[r] 
            if l!= 0:
                count -= prefix[l - 1]
            evenCount.append(count)

        
        return evenCount

A = [2,4,3,7,9,8,6,5,4,9]
Q = [[0,4], [4,8], [3,7], [8,9]]
soln = Solution()
print(soln.countEven(A, Q))