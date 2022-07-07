class Solution:
    def solve(self, A):
        N = len(A)

        # get max value
        maxValue = A[0]
        for i in range(1, N):
            if A[i] > maxValue:
                maxValue = A[i]

        # get min value
        minValue = A[0]
        for i in range(1, N):
            if A[i] < minValue:
                minValue = A[i]

        print(minValue, maxValue)

        if minValue == maxValue:
            return 1

        length = N
        maxI = -1
        minI = -1
        for i in range(N-1, -1, -1):
            if A[i] == minValue:
                minI = i
                if maxI != -1 and length > (maxI - minI + 1):
                    length = maxI - minI + 1
                # print(f'minimun => iteration => {i} minI => {minI} maxI => {maxI} length => {length}')
            elif A[i] == maxValue:
                maxI = i
                if minI != -1 and length > (minI - maxI + 1):
                    length = minI - maxI + 1
                # print(f'maximum => iteration => {i} minI => {minI} maxI => {maxI} length => {length}')

        return length



A = [1, 2, 3, 1, 3, 4, 6, 4, 6, 3]
# A = [8,8,8,8,8,8,8]
# A = [2,2,6,4,5,1,5,2,6,4,1,3,4]
soln = Solution()
print(soln.solve(A))
