def designerPdfViewer(h, word):
    lenWord = len(word)
    
    initial = False
    maxHeight = 0
    for i in word:
        index = ord(i) - 97
        # index = string.lowercase.index(i)
        # print(index, h[index])
        
        if initial:
            if maxHeight < h[index]:
                maxHeight = h[index]
        else:
            initial = True
            maxHeight = h[index]
        
    # print("maxHeight => ", maxHeight, lenWord)

    return lenWord * maxHeight


# h = [1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5]
# word = 'abc'

h = [1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7]
word = 'zaba'
print(designerPdfViewer(h, word))