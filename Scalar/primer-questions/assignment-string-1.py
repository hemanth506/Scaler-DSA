class Solution:
    def solve(self, A):
        txt = A
        listTxt = list(txt)
        
        zeroArray = [];
        oneArray = [];
        totalSeparation = 0;
        id = 0;
        for i in listTxt:
            if i == "0":
                zeroArray.insert(id, i)
                id = id + 1
            elif i == "1":
                oneArray.insert(id, i)
                id = id + 1;
                
            if len(zeroArray) == len(oneArray):
                totalSeparation = totalSeparation + 1
                zeroArray = [];
                oneArray = [];
                id = 0
            
        
        return totalSeparation
        
        
string = input("ENter a value")
sol = Solution()
print(sol.solve(string))
