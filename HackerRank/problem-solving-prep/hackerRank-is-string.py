
def hackerrankInString(s):

    findName = list('hackerrank')
    # print(findName, len(findName))
    j = 0
    for i in range(len(s)):
        # print(i, j)
        if s[i] == findName[j]:
            j += 1
            if j == 10:
                break

    # print(j)
    if len(findName) == j:
        return 'YES'
    return 'NO'


s = 'hereiamstackerrank', 
s = ['knarrekcah', 'hackerrank', 'hackeronek', 'abcdefghijklmnopqrstuvwxyz', 'rhackerank', 'ahankercka', 'hacakaeararanaka', 'hhhhaaaaackkkkerrrrrrrrank', 'crackerhackerknar','hhhackkerbanker']
for i in range(len(s)):
    print(hackerrankInString(s[i]), i)