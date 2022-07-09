class Solution:
    def subarraySum(self, A):
        N = len(A)
        contribution = 0
        for i in range(N):
            freq = (i + 1) * (N - i)
            contribution += A[i] * freq
            
        return contribution



A = [1,2,3]
soln = Solution()
print(soln.subarraySum(A))