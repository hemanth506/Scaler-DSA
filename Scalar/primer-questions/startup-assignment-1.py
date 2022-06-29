
class Solution():
    def solve(self, A):
        A.sort()
        lst = []
        for i in range(len(A)):
            j = i + 1

            if (j <= len(A) - 1 and A[i] > 1):
                lst.append(A[i] % A[j])

        return max(lst)


inputLst = [3, 6, 8, 4, 2]

sol = Solution()
print(sol.solve(inputLst))
