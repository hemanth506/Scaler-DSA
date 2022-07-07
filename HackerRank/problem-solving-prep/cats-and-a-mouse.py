def catAndMouse(x, y, z):

    distanceOfCatA = abs(x - z)
    distanceOfCatB = abs(y - z)

    if distanceOfCatA > distanceOfCatB:
        return "Cat B"
    elif distanceOfCatB > distanceOfCatA:
        return "Cat A"
    else:
        return "Mouse C" 



x = 2
y = 5
z = 4
print(catAndMouse(x,y,z))