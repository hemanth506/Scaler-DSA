
def marsExploration(s):

    checkSOS = ['S','O','S']
    ct = 0
    count = 0
    for i in range(len(s)):
        if s[i] != checkSOS[ct]:
            count += 1
        ct += 1
        if ct == 3:
            ct = 0
        

    return count


s = 'SOSOOSSOSSOP'
print(marsExploration(s))