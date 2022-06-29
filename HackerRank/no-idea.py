# partially correct approach => get one one elt from "arr" and check if there is any occuracne of that in givesHappiness and givesorrow list

# line1 = list(map(int, input().split()))
line1 = [45, 9]
n = line1[0]
m = line1[1]

# arr = list(map(int, input().split()))
arr = [99999082, 99997648, 99997739, 99995871, 99995042, 99997648, 99999213, 99999885, 99995558, 99997382, 99996408, 99998454, 99995000, 99999763, 99996010, 99998757, 99997324, 99996723,99999628, 99999622, 99999616, 99999608, 99999606, 99999597, 99999592, 99996714, 99996940, 99995772, 99997724, 99995697, 99999448, 99995799, 99997211, 99999488, 99999500, 99998706, 99995494, 99996324]
arr.sort()
# print(len(arr), arr)

# givesHappiness = list(map(int, input().split()))
givesHappiness = [99999082, 99997648, 99997739, 99995871, 99998948, 99999216, 99997382, 99995042, 99999213]
givesHappiness.sort()
# print(len(givesHappiness), givesHappiness)

# givesSorrow = list(map(int, input().split()))
givesSorrow = [99998757, 99997359, 99998424, 99999629, 99996307, 99997640, 99997011, 99996349, 99996853]
givesSorrow.sort()
# print(len(givesSorrow), givesSorrow)


def binarySearch(emotions, toFind):
    # print("toFind => ", toFind, emotions)
    l = 0
    h = len(emotions) - 1
    while l <= h:
        # mid = l + ((h - l) // 2)
        
        mid = (h + l) // 2 
        # print(l, h, mid)
        # print("mid => ", mid, emotions[mid], toFind)
        if emotions[mid] < toFind:
            l = mid + 1
        elif emotions[mid] > toFind:
            h = mid - 1
        else:
            return 1
    return 0

eltCheck = []
duplicate = []
totalHappiness = 0
for i in range(0, len(arr)):
    happinessExist = False
    if arr[i] not in eltCheck:
        eltCheck.append(arr[i])
        
        # print("happiness => ", arr[i], givesHappiness, arr[i] in givesHappiness)
        happyStatus = binarySearch(givesHappiness, arr[i])
        # print("happyStatus => ", happyStatus)
        if happyStatus:
            totalHappiness += 1
            happinessExist = True
        # print("happinessExist => ", happinessExist)
        


        if not happinessExist:
            # print("sorrowness => ", arr[i] in givesSorrow)
            sorrowStatus = binarySearch(givesSorrow, arr[i])
            # print("sorrowStatus => ", sorrowStatus)
            if sorrowStatus:
                totalHappiness -= 1
    else: 
        duplicate.append(arr[i])
    
    # print("======= totalHappiness ======> ", totalHappiness)

# print(duplicate)
print(totalHappiness)
    