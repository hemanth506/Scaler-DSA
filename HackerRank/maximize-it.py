def solve():
    KM = list(map(int, input().split()))
    
    maxElt = 0
    for _ in range(KM[0]):
        iterInput = list(map(int, input().split()))
        N = iterInput[0]
        iterInput.pop(0)
        
        iterated = False
        
        maxVal = 0
        for i in range(N):
            if iterated:
                if maxVal < iterInput[i]:
                    maxVal = iterInput[i]
            else:
                maxVal = iterInput[i]
                iterated = True
                
        print(maxVal)
        print((maxVal ** maxVal))
        maxElt += (maxVal ** maxVal)
        
    print(maxElt)
    return maxElt % 1000




if __name__ == "__main__": 
    print(solve())