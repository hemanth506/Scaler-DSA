def utopianTree(n):
    height = 0
    for i in range(0, n + 1):
        if i % 2 == 0:
            height += 1
            # print("if => ", i, height)
        else:
            height *= 2
            # print("else => ", i, height)
    return height


n = 6
print(utopianTree(n))