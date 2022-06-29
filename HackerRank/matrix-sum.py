class Solution:
    def solve(self, x, y, z, n):
        newList = []
        for i in range(x+1):
            for j in range(y+1):
                for k in range(z+1):
                    if i+j+k != n:
                        newList.append([i, j, k])
        return newList


if __name__ == '__main__':
    x = int(input())
    y = int(input())
    z = int(input())
    n = int(input())
    
    
    sol = Solution()
    print(sol.solve(x, y, z, n))
    
