def libraryFine(d1, m1, y1, d2, m2, y2):
    
    daysDiff = d1 == d2
    mthDiff = m1 == m2
    yearDiff = y1 == y2

    amountToBePaid = 0
    if yearDiff:
        if mthDiff and daysDiff:
            return 0

        if not mthDiff:
            if m1 < m2:
                # mthDiff = m1 - m2
                # amountToBePaid += mthDiff * 500
                return 0
            else:
                # print("hemanth")
                mthDiff = m2 - m1
                amountToBePaid += abs(mthDiff * 500)

            
            if not daysDiff:
                dateDifference = d1 - d2
                amountToBePaid += daysDiff * 15
        else:
            if d1 < d2:
                return 0
            else:
                dateDifference = d1 - d2
                amountToBePaid += dateDifference * 15
            
        return amountToBePaid

    else:
        if y1 < y2:
            return 0
        return 10000

    


d1, m1, y1 = [6, 6, 2015]
d2, m2, y2 = [9, 6, 2016]

d1, m1, y1 = [2, 7, 1014]
d2, m2, y2 = [1, 1, 1015]

d1, m1, y1 = [2, 6, 2014]
d2, m2, y2 = [5, 7, 2014]

print(libraryFine(d1, m1, y1, d2, m2, y2))