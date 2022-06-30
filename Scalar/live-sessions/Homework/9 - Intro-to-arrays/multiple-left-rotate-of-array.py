class Solution:
    def reverseArr(self, eltList, f, e):
        while f < e:
            temp = eltList[f]
            eltList[f] = eltList[e]
            eltList[e] = temp
            f += 1
            e -= 1
        return eltList
    def solve(self, A, B):
        matrix = []
        for i in range(len(B)):
            tempA = A.copy()

            f = 0
            e = len(A) - 1
            eltList = self.reverseArr(tempA, f, e)
            # print(eltList)

            k = B[i] % len(tempA)
            # print(k)
            f = len(A) - k
            e = len(A) - 1
            eltList = self.reverseArr(tempA, f, e)
            # print(eltList)

            f = 0
            e = len(A) - k - 1
            eltList = self.reverseArr(tempA, f, e)
            # print(eltList)
            matrix.append(eltList)
        return matrix 

listElt = [1, 2, 3, 4, 5]
timesRot = [2, 3]
soln = Solution()
print(soln.solve(listElt, timesRot))