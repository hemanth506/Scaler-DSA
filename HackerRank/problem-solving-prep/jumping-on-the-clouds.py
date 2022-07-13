
def jumpingOnClouds(c):
    N = len(c)
    j = 0
    jumps = 1
    currentJump = 0
    while j < N - 1:
        print("j index => ",j, "Jumps => ",jumps)
        currentJump = jumps
        if j + 2 < N and c[j + 2] == 1:
            j += 1
            jumps += 1
        else:
            j += 2
            jumps += 1
        
    return currentJump

c = [0, 0, 1, 0, 0, 1, 0]
# c = [0, 0, 1, 0, 0, 0, 0, 1, 0, 0]
print(jumpingOnClouds(c))