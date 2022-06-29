class Solution:
    def solve(self, A):
        txt = A
        textList = list(txt)
        
        vowelsList = ['a', 'e', 'i', 'o', 'u']
        
        newString = ''
        for i in textList:
            if i in vowelsList:
                newString += i
        
        return newString
        
        
        
string = input("Enter a value: ")
sol = Solution()
print(sol.solve(string))