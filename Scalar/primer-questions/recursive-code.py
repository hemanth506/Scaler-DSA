class Solution:
    def solve(self, A, B):
        rows, columns = (A, B)

        res = [[i*j for j in range(A)] for i in range(B)]
        print(type(res))
        print(res)
        res[0][0] = 24
        res[1][1] = 24
        return res
        
        
sol = Solution()
print(sol.solve(2,2))
