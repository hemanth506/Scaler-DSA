def birthday(s, d, m):
    pairs = 0

    if len(s) == 1:
        if s[0] == d:
            return 1


    for i in range(len(s)):
        sumValue = 0
        if i + m <= len(s):
            for j in range(i, i + m):
                sumValue += s[j]

            # print('sumValue => ', sumValue, d)
            if sumValue == d:
                pairs += 1

    return pairs


s,d,m = [[1, 2, 1, 3, 2], 3, 2]
s,d,m = [[4], 4, 1]

s,d,m = [[2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1], 18, 7]
print(birthday(s,d,m))