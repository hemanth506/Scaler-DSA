
def isPalindrome(x):
    
    if x > 0:
        xList = list(str(x))
        xReverseList = xList
        xReverseList.reverse()

        xList = "".join(xList)
        xReverseList = "".join(xReverseList)

        if xList == xReverseList:
            return "true"
        else:
            return "false"
        
    return "false"


print(isPalindrome(-121))