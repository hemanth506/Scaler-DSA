# insertion sort

givenArray = [4,2,8,5,9,7]

def insertionSort(givenArray):
    for i in range(0, len(givenArray)):
        value = givenArray[i]
        
        j = i - 1
       
        # swaps the values here
        while j >= 0 and value < givenArray[j]:
            givenArray[j + 1] = givenArray[j]
            print("inside => ", j)
            j -= 1
        
        print("outside => ", j)
        # Assigns the current value here
        givenArray[j+1] = value
        
        print(givenArray)
        
    print(givenArray)
        
insertionSort(givenArray)