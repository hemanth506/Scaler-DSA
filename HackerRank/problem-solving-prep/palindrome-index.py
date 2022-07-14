'''
Return error for large inputs
'''



def palindromeIndex(s):
    elt = []
    for i in range(len(s)):
        word = ''
        if i == 0:
            word = s[i+1:]
            # print(i, '',s[i+1:])
        else:
            word = s[:i] + s[i+1:]
            # print(i, s[:i], s[i+1:])

        elt.append(word)
    
    for i in range(len(elt)):
        word = elt[i]
        N = len(word)

        # l = 0
        # h = N - 1
        # notAPalindrome = False
        # while l <= h:
        #     if word[h] != word[l]:
        #         notAPalindrome = True
        #         break
        #     l += 1
        #     h -= 1

        checkPali = word == word[::-1]
        # print(word, word[::-1], checkPali)

        if checkPali:
            return i 


s = 'steponnopets'
print(palindromeIndex(s))
