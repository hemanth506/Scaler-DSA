
def repeatedString(s, n):
    sLen = len(s)

    if sLen == 1:
        if s[0] == 'a':
            return n
        else:
            return 0

    i = 0
    count = 0
    j = 0
    while j < n:
        if i == (sLen - 1):
            i = -1
        
        if s[i] == 'a':
            count += 1

        i += 1
        j += 1

    return count

def repeatedStringNew(s, n):
    sLen = len(s)

    if sLen == 1:
        if s[0] == 'a':
            return n
        else:
            return 0

    aCount = 0
    indexOfA = []
    for i in range(sLen):
        if s[i] == 'a':
            indexOfA.append(i+1)
            aCount += 1

    print(indexOfA)

    if sLen <= n:
        diff = n % sLen
        print("diff =>", diff)
        totalA = diff * aCount
        print("if", diff, totalA)
    else:
        print("else")
        diff = sLen % n
    print(sLen, n, diff)
    return int(totalA)

s = "aba"
n = 10

# s = "a"
# n = 1000000000000

# s = 'kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm'
# n = 736778906400
print(repeatedStringNew(s, n))