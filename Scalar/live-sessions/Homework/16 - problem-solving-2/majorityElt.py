class Solution:
    def majorityElement(self, A):
        N = len(A)
        print(type(A))

        dictionary = {}
        for i in range(N):
            if A[i] in dictionary:
                dictionary[A[i]] += 1
            else:
                dictionary[A[i]] = 1

        print(dictionary)

        half = N//2
        halfValue = 0
        for key, value in dictionary.items():
            if value >= half:
                halfValue = key
                break
        return halfValue


A = (2, 1, 2, 1)
soln = Solution()
print(soln.majorityElement(A))