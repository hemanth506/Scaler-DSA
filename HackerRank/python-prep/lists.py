if __name__ == '__main__':
    # N = int(input())
    N = 29
    
    commands = ["append 1", "append 6", "append 10", "append 8", "append 9", "append 2", "append 12", "append 7", "append 3", "append 5", "insert 8 66", "insert 1 30", "insert 6 75", "insert 4 44", "insert 9 67", "insert 2 44", "insert 9 21", "insert 8 87", "insert 1 75", "insert 1 48", "print","reverse", "print", "sort", "print", "append 2", "append 5", "remove 2", "print"]
    newArr = []
    for i in range(N):
        # command = list(map(str, input().split()))
        command = commands[i].split(" ")
        
        if command[0] == "insert":
            newArr.insert(int(command[1]), int(command[2]))
        elif command[0] == "append":
            newArr.append(int(command[1]))
        elif command[0] == "remove":
            newArr.remove(int(command[1]))
        elif command[0] == "sort":
            newArr.sort()
        elif command[0] == "print":
            print(newArr)
        elif command[0] == "pop":
            newArr.pop()
        elif command[0] == "reverse":
            newArr.sort(reverse = True)
            