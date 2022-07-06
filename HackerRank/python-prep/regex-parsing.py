# N = int(input())
N = 12
# N = 1

testStrings = ["a = 1;", "b = input();", "", "if a + b > 0 && a - b < 0:", "    start()", "elif a*b > 10 || a/b < 1:", "    stop()", "print set(list(a)) | set(list(b)) ", "#Note do not change &&& or ||| or & or |", "#Only change those '&&' which have space on both sides.", "#Only change those '|| which have space on both sides.", "n && && && && && &&n"]
# testStrings = []
newText = ""
for i in range(0, N):
    # text = str(input())
    text = testStrings[i]
    textList = list(text)
    
    lenTextList = len(textList)
    for k in range(0, lenTextList):
        # print(k, lenTextList - 4)
        if k <= (lenTextList - 3):
            if i == 11:
                print(textList[k] + textList[k + 1]+ textList[k + 2]+ textList[k + 3])
            if textList[k] == " " and textList[k + 1] == "&" and textList[k + 2] == "&" and textList[k + 3] == " ":
                textList.pop(k + 1)
                textList.insert(k + 1, "a")
                
                textList.pop(k + 2)
                textList.insert(k + 2, "n")
                
                textList.insert(k + 3, "d")
            elif textList[k] == " " and textList[k + 1] == "|" and textList[k + 2] == "|" and textList[k + 3] == " ":
                textList.pop(k + 1)
                textList.insert(k + 1, "o")
                
                textList.pop(k + 2)
                textList.insert(k + 2, "r")
            
    newText += "".join(textList)
    # print(k, lenTextList - 3)
    if i < N - 1:
        newText += "\n"

print("\n")
print(newText)