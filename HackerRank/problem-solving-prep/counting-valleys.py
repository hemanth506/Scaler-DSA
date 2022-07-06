def countingValleys(steps, path):
    
    valleys = 0
    seaLevel = 1
    touchedDownLevel = False
    for i in range(steps):
        if path[i] == 'U':
            seaLevel += 1
            print("U", touchedDownLevel, seaLevel)
            if touchedDownLevel and seaLevel == 1:
                valleys += 1
                touchedDownLevel = False
        else:
            seaLevel -= 1
            touchedDownLevel = True
            print("D", touchedDownLevel, seaLevel)
    return [seaLevel, valleys]


steps = 8
path = 'UDDDUDUU'

print(countingValleys(steps, path))
