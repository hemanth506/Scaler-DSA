def breakingRecords(scores):
    highScore = 0
    lowScore = 0
    initial = False
    high = 0
    low = 0
    for i in range(len(scores)):
        if initial:
            if scores[i] > highScore:
                highScore = scores[i]
                high += 1
                print("inside highScore", scores[i], highScore, high)
            elif scores[i] < lowScore:
                lowScore = scores[i]
                low += 1
                print("inside lowScore", scores[i], lowScore, low)
        else:
            highScore = scores[i]
            lowScore = scores[i]
            initial = True
    
    return [high, low]


scores = [10, 5, 20, 20, 4, 5, 2, 25, 1]
print(breakingRecords(scores))