#!/bin/python3

import math
import os
import random
import re
import sys
import operator

if __name__ == '__main__':
    # s = input()
    # s = "szrmtbttyyaymadobvwniwmozojggfbtswdiocewnqsjrkimhovimghixqryqgzhgbakpncwupcadwvglmupbexijimonxdowqsjinqzytkooacwkchatuwpsoxwvgrrejkukcvyzbkfnzfvrthmtfvmbppkdebswfpspxnelhqnjlgntqzsprmhcnuomrvuyolvzlni"
    # s = "aabbbccde"
    s = "qwertyuiopasdfghjklzxcvbnm"
    sList = list(s)
    
    newDict = {}
    for i in range(0, len(sList)):
        if sList[i] not in newDict:
            newDict[sList[i]] = 1
        else: 
            newDict[sList[i]] += 1 

# print(len(list(set(list(newDict.values())))))
allEqual = False
if len(list(set(list(newDict.values())))) == 1:
    newDict = dict(sorted(newDict.items(), key=lambda kv:(kv[1], kv[0])))
    newDictKeys = [i for i in newDict.keys()]
    newDictValues = [i for i in newDict.values()]
    allEqual = True
else:
    newDict = dict(sorted(newDict.items(), key=operator.itemgetter(1),reverse=True))
    newDictKeys = [i for i in newDict.keys()]
    newDictValues = [i for i in newDict.values()]

print(newDict)
# print(newDictKeys)
# print(newDictValues)

if not allEqual:
    change = 0
    compressedDict = {}
    count = 1
    tempDict = {}
    for key, values in newDict.items():
        if change < 3 and len(newDict) > count:
            # print(key, values)
            if newDict[newDictKeys[count]] == values:
                # compressedDict[change] = values
                tempDict[key] = values
            else:
                tempDict[key] = values
                compressedDict[change] = tempDict
                change += 1
                tempDict = {}
        else:
            break
        count += 1

    # print(compressedDict)

    newDict = {}
    for values in compressedDict.values():
        newDict.update(dict(sorted(values.items(), key=lambda kv:(kv[1], kv[0]))))

# print(newCompressedDict)

count = 0
for key, values in newDict.items():
    if count < 3:
        print(key + " " + str(values))
    else:
        break
    count += 1
