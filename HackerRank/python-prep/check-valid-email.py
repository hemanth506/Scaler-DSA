import re

def fun(s):
    splitAt = list(s.split("@"))
    # print(splitAt)
    if len(splitAt) == 2:
        # print("len is 2", splitAt[0])
        if re.search("^[a-zA-Z0-9_-]+$", splitAt[0]):
            # print("regexpAt => ",splitAt[0])
            splitDot = list(splitAt[1].split('.'))
            # print("splitDot => ",splitDot)
            if len(splitDot) == 2:
                if re.search("^[a-zA-Z0-9]+$",splitDot[0]):
                    # print("len(splitDot[1].split("")) => ", len(list(splitDot[1])))
                    if len(list(splitDot[1])) <= 3 and re.search("^[a-zA-Z]+$",splitDot[1]):
                        return s
                return False
            return False
        return False
    return False
    

def filter_mail(emails):
    return list(filter(fun, emails))

if __name__ == '__main__':
    n = int(input())
    emails = []
    for _ in range(n):
        emails.append(input())

filtered_emails = filter_mail(emails)
filtered_emails.sort()
print(filtered_emails)