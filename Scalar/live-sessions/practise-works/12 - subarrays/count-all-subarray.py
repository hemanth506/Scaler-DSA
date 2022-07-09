'''
For understanding purpose 
'''

def subarray(arr):
    count = 0
    for i in range(len(arr)):
        for j in range(i, len(arr)):
            for k in range(i, j+1):
                print(arr[i], arr[k])
                count += 1
            
            print("break")
    return count


arr = [3, 4,2,7,4]
print(subarray(arr))