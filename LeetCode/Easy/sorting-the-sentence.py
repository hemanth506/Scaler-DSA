
def sortSentence(s):
    sSplit = s.split(" ")
    
    reframe = [""] * len(sSplit)
    for i in range(len(sSplit)):
        wordList = sSplit[i]
        index = int(wordList[-1])
        reframe[index - 1] = wordList[:-1]
        
    return " ".join(reframe)


s = "is2 sentence4 This1 a3"
print(sortSentence(s))