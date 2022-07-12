def jumpingOnClouds(c, k):
    n = len(c)
    index = 0
    energy = 100
    iterating = True
    while iterating:
        index = (index + k) % n
        value = 2 + 1 if c[index] == 1 else 1
        energy = energy - value
        # print(energy)
        if index <= 0:
            iterating = False 

    return energy


c, k = [[0, 0, 1, 0, 0, 1, 1, 0], 2]
print(jumpingOnClouds(c, k))