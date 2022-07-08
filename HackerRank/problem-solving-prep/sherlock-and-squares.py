def squares(a, b):

    aSquareLimit = a ** 0.5
    bSquareLimit = b ** 0.5

    print(aSquareLimit, bSquareLimit)
    perfectASquare = aSquareLimit - int(aSquareLimit) == 0

    intASquareRoot = int(aSquareLimit)
    intBSquareRoot = int(bSquareLimit)
    print(intASquareRoot, intBSquareRoot)

    if perfectASquare:
        return intBSquareRoot - (intASquareRoot - 1)
    else:
        return intBSquareRoot - intASquareRoot



a, b = [3, 9]

a, b = [100, 1000]


print(squares(a, b))