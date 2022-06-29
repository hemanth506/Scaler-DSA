import re

class Solution:
    def solve(self, cardNumber):
        cardNumberList = list(cardNumber)
        
        startsWith = False
        if re.search("^[456]+$", cardNumberList[0]):
            startsWith = True
            
        inValidEltOrSeparator = False
        InValidSeparatorPosition = False
        intrList = []
        separator = []
        count = 1
        moreSameConsecutiveDigits = False
        for i in range(0, len(cardNumberList)):
            if re.search("^[0-9]+$", cardNumberList[i]):
                intrList.append(cardNumberList[i])
                lenIntrList = len(intrList) - 1
                # print(lenIntrList % 4, intrList)
                if lenIntrList != 0 and lenIntrList > 4:
                    # print(intrList[lenIntrList], intrList[lenIntrList - 1], intrList[lenIntrList - 2], intrList[lenIntrList - 3], intrList[lenIntrList - 4])
                    if intrList[lenIntrList] == intrList[lenIntrList - 1] and intrList[lenIntrList] == intrList[lenIntrList - 2] and intrList[lenIntrList] == intrList[lenIntrList - 3]:
                        moreSameConsecutiveDigits = True   
            elif re.search("^[-]+$", cardNumberList[i]):
                if count % 5 == 0:
                    separator.append(cardNumberList[i])
                else:
                    InValidSeparatorPosition = True
            else:
                inValidEltOrSeparator = True
            count += 1
            
        onlyIntAndLengthCheck = False
        if len(intrList) == 16:
            onlyIntAndLengthCheck = True
            
        if startsWith and onlyIntAndLengthCheck and not moreSameConsecutiveDigits and not InValidSeparatorPosition and not inValidEltOrSeparator:
            return "Valid"
        else:
            return "Invalid"

            
            
sol = Solution()

# noOfCardNumbers = int(input())
noOfCardNumbers = 9
cardNumberList = ['4253625879615786', '4424424424442444', '5122-2368-7954-3214', '42536258796157867', '4424444424442444', '5122-2368-7954 - 3214', '44244x4424442444', '0525362587961578', '5133-3367-8912-3456']
# cardNumberList = ['5133-3367-8912-3456'];
for i in range(0, noOfCardNumbers):
    # cardNumber = str(input())
    cardNumber = cardNumberList[i]
    print(sol.solve(cardNumber))
        
