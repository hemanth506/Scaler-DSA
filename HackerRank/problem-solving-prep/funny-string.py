
def reverse(s):
    str = ""
    for i in s:
        str = i + str
    return str


def funnyString(s):
    reverseS = s
    reverseS = reverse(reverseS)
    
    orderS = ord(s[0])
    orderSElt = []
    for i in range(1, len(s)):
        orderSElt.append(abs(orderS - ord(s[i])))
        orderS = ord(s[i])
    print(orderSElt)

    orderReverseS = ord(reverseS[0])
    orderReverseSElt = []
    for i in range(1, len(s)):
        orderReverseSElt.append(abs(orderReverseS - ord(reverseS[i])))
        orderReverseS = ord(reverseS[i])
    print(orderReverseSElt)

    j = 0
    notFunny = False
    for k in range(len(orderSElt)):
        if orderSElt[k] != orderReverseSElt[j]:
            notFunny = True
        j += 1

    if notFunny:
        return 'Not Funny'

    return 'Funny'


s = 'acxz'
print(funnyString(s))