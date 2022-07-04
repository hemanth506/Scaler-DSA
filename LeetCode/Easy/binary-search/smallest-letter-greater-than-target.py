'''
Given a characters array letters that is sorted in non-decreasing order and a character target, return the smallest character in the array that is larger than target.

Note that the letters wrap around.

For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
 

Example 1:
Input: letters = ["c","f","j"], target = "a"
Output: "c"

Example 2:
Input: letters = ["c","f","j"], target = "c"
Output: "f"

Example 3:
Input: letters = ["c","f","j"], target = "d"
Output: "f"
 

Constraints:

2 <= letters.length <= 104
letters[i] is a lowercase English letter.
letters is sorted in non-decreasing order.
letters contains at least two different characters.
target is a lowercase English letter.
'''


class Solution:
    def nextGreatestLetter(self, letters, target):

        l = 0
        h = len(letters) - 1

        while l <= h:
            m = l + ((h - l) // 2)
            # print(letters[m], target)
            if letters[m] > target:
                h = m - 1
            elif letters[m] < target:
                    l = m + 1
            else:
                if m + 1 < len(letters):
                    print("inside m + 1")
                    if letters[m] == letters[m + 1]:
                        l = m + 1
                    else:
                        return letters[m + 1]
                else:
                    print("outside m + 1")
                    return letters[0]
                
        if l < len(letters):
            return letters[l]
        else:
            return letters[0]

letters = ["c","f","j"]
target = "c"

letters = ["e","e","e","e","e","e","n","n","n","n"]
target = "e"
soln = Solution()
print(soln.nextGreatestLetter(letters, target))
        