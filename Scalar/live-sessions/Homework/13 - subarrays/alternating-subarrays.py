
class Solution:
    def solve(self, A, B):
        length = 2 * B + 1
        N = len(A)
        print("length =>",length, "N =>",N)
        indexes = []

        if length != 1:
            if length < N:
                startingIndex = length // 2
                print('startingIndex => ',startingIndex)
                for i in range(startingIndex, N):
                    if i + startingIndex < N:
                        
                        leftSubIndex = i - startingIndex
                        rightSubIndex = i + startingIndex
                        # print(leftSubIndex, i, rightSubIndex)
                        print(A[leftSubIndex:rightSubIndex+1])
                        notIndexed = False
                        for k in range(leftSubIndex, rightSubIndex):
                            print("check => ",A[k], A[k+1])
                            if A[k] == A[k + 1]:
                                notIndexed = True
                                break
                        
                        if not notIndexed:
                            indexes.append(i)
            else:
                return indexes
        else:
            for i in range(N):
                indexes.append(i)

        return indexes



A = [0,0,0,1,0,0,0,1,0,1,1]
B = 1

A = [ 1, 1, 1, 1, 1, 0, 1 ]
B = 0

# A = [ 1, 1, 0, 1, 1, 0, 1 ]
# B = 3


# A = [ 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0 ]
# B = 2
soln = Solution()
print(soln.solve(A, B))