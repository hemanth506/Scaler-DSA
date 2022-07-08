def findDigits(n):

    strN = str(n)

    ct = 0
    for i in range(len(strN)):
        if int(strN[i]) != 0:
            if n % int(strN[i]) == 0:
                ct += 1
        
    return ct


n = 124
print(findDigits(n))