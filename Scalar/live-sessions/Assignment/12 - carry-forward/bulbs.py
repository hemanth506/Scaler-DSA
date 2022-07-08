class Solution:
    # O(n^2)
    def bulbsNSquare(self, A):
        N = len(A)
        c = 0
        for i in range(N):
            if A[i] != 1:
                for j in range(i+1, N):
                    if A[j] == 1:
                        A[j] = 0
                    else:
                        A[j] = 1
                c += 1
        return c

    # Get the difference when travesing from left to right
    # O(n)
    def bulbsN(self, A):
        N = len(A)

        c = 0
        state_flow = 1
        for i in range(N):
            if A[i] != state_flow:
                c += 1
            state_flow = A[i]
        return c


A = [ 1, 1, 0, 0, 1, 1, 0, 0, 1 ]
# A = [0,1,0,1]
soln = Solution()
# print(soln.bulbsNSquare(A)) 
print(soln.bulbsN(A))

