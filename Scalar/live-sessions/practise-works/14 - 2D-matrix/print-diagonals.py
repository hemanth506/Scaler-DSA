
class Solution:
    def solve(self, A):
        N = len(A)
        M = len(A[0])
        for i in range(N):
            x = 0
            z = i
            elt = []
            while x <= i:
                # print(x,z)
                elt.append(A[x][z])
                x += 1
                z -= 1
            print(elt)


        for l in range(1, N):
            x = l
            z = M - 1
            eltLast = []
            while x < N and z >= 0:
                # print(x,z)
                eltLast.append(A[x][z])
                x += 1
                z -= 1
            print(eltLast)
        return





A = [[1,2,3],
    [4,5,6],
    [7,8,9]]

soln = Solution()
print(soln.solve(A))