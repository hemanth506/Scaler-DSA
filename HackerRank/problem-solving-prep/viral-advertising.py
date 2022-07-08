def viralAdvertising(n):
    shared = 5
    totalShare = 0
    for _ in range(n):
        # print(shared)
        # shared = newShared
        shared = shared // 2
        # print("shared => ",shared)
        totalShare += shared
        shared = shared * 3
    return totalShare

n = 3
print(viralAdvertising(n))
