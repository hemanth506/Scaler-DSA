import re
import string

def minimumNumber(n, password):
    upperCheck = lowerCheck = numberCheck = False

    special_chars = string.punctuation
    specialCheck = list(map(lambda char: char in special_chars, password))
    for i in range(n):
        # if re.search("^[!@#$%^&*()-+ .]+$", password[i]):
        #     specialCheck = True

        if password[i].isupper():
            upperCheck = True

        if password[i].islower():
            lowerCheck = True

        if password[i].isnumeric():
            numberCheck = True

    print(specialCheck)
    print(upperCheck)
    print(lowerCheck)
    print(numberCheck)
    difference = 0
    if n <= 6:
        difference = 6 - n

    toAdd = 0
    if not any(specialCheck):
        toAdd += 1

    if not upperCheck:
        toAdd += 1

    if not lowerCheck:
        toAdd += 1

    if not numberCheck:
        toAdd += 1

    print(difference, toAdd)
    if difference < toAdd:
        return toAdd
    else:
        return difference



n = 4
password = '4700'

n = 7
password = 'AUzs-nV'
print(minimumNumber(n, password))