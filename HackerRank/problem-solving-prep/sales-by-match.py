
def sockMerchant(n, ar):
    dictionary = {}
    pairs = 0
    for i in range(len(ar)):
        if ar[i] in dictionary:
            pairs += 1
            dictionary[ar[i]] += 1
            dictionary.pop(ar[i])
        else:
            dictionary[ar[i]] = 1
    return pairs

n = 7
ar = [1,2,1,2,1,3,2]

print(sockMerchant(n, ar))
