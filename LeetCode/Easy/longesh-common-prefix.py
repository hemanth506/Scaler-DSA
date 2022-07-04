class Solution:
    def longestCommonPrefix(self, strs):
        
        strs.sort(key = len)
        # print(strs)

        for i in range(len(strs)):
            listStr = list(strs[i])
            strs[i] = listStr
                
        maxLen = len(strs[0])
        # print(strs)
        # print(maxLen)

        prefixChar = ""
        broke = False
        for i in range(maxLen):
            iterated = False
            character = ""
            for j in range(len(strs)):
                if iterated:
                    if character != strs[j][i]:
                        broke = True
                        break
                    character = strs[j][i]
                else:
                    character = strs[j][i]
                    iterated = True

            if broke:
                break
            else:
                prefixChar += character

            
        # print(prefixChar)  
        return prefixChar

        





strs = ["flower","flow","flight"]
soln = Solution()
print(soln.longestCommonPrefix(strs))
        