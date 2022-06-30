class Solution:
    def solve(self, A, B):

        # ---------- upper part -----------
        # for i in range(len(A)):
        #     for j in range(i+1, len(A)):
        #         # print(i, j)
        #         if A[i] + A[j] == B:
        #             return 1
        # return 0

        # ---------- lower part -----------
        for i in range(1, len(A)):
            j = i - 1
            for _ in range(len(A)):
                if i < len(A):
                    print(i, j, len(A))
                    if A[i] + A[j] == B:
                        return 1
                    i += 1
        return 0


if __name__ == "__main__":
    soln = Solution()
    A = list(map(int, input().split()))
    B = int(input())
    print(soln.solve(A, B))