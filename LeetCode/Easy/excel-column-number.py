
def titleToNumber(columnTitle):
    N = len(columnTitle)
    loopValue = 0
    iteration = 0
    for i in range(N-1, -1, -1):
        # print(columnTitle[i], columnTitle[i].lower(), ord(columnTitle[i].lower()) - 96, iteration, ord(columnTitle[i]) ** iteration)
        loopValue += (ord(columnTitle[i].lower()) - 96) * (26 ** iteration)
        iteration += 1
    return loopValue


A = 'AB'
print(titleToNumber(A))        