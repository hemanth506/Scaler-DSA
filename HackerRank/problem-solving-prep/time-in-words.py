
def convertToDigit(n, h):
    Empty = ''
    connect = 'past '
    minutes = ''
    X = ["o' clock", 'one ', 'two ', 'three ', 'four ', 'five ','six ', 'seven ','eight ','nine ','ten ', 'eleven ','twelve ','thirteen ','fourteen ','quarter ','sixteen ','seventeen ','eighteen ','nineteen ']

    Y = [Empty, Empty, 'twenty ', 'half ']
    if n == 0:
        return X[h] + X[n]
    elif n == 1:
        minutes = "minute "
    elif n > 30:
        n = 60 - n
        connect = 'to '
        h += 1

    if n != 15 and n != 30 and n != 1:
        minutes = "minutes "
    

    if n > 19:
        string = Y[n // 10]
        if n % 10 != 0:
            string += X[n % 10] + minutes

    else:
        string =  X[n] + minutes

    string += connect + X[h]
    return string


def timeInWords(h, m):
    result = convertToDigit((m % 100), h)
    return result


print(timeInWords(5, 30))