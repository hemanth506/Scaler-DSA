
def hurdleRace(k, height):
    N = len(height)
    maxValue = height[0]
    for i in range(1, N):
        if height[i] > maxValue:
            maxValue = height[i]

    if k >= maxValue:
        return 0
    else:
        return maxValue - k


k = 4
height = [1, 6, 3, 5, 2]

k = 7
height = [2, 5, 4, 5, 2]
print(hurdleRace(k, height))