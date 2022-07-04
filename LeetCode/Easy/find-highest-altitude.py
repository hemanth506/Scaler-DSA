class Solution:
    def largestAltitude(self, gain):
        
        N = len(gain)
        
        prefix = [0] * N
        prefix[0] = gain[0]
        for i in range(1, N):
            prefix[i] = prefix[i - 1] + gain[i]
            
        print(prefix)
        maxAltitude = 0
        for i in range(N):
            print("i => ", i)
            if maxAltitude < prefix[i]:
                maxAltitude = prefix[i]
                
        return maxAltitude


gain = [44,32,-9,52,23,-50,50,33,-84,47,-14,84,36,-62,37,81,-36,-85,-39,67,-63,64,-47,95,91,-40,65,67,92,-28,97,100,81]
soln = Solution()
print(soln.largestAltitude(gain))


