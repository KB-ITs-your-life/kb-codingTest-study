n = int(input())
students = list(map(int, input().split()))
students.reverse()
line = []
num = 1

while (num <= n):
    if len(line) > 0 and line[-1] == num:
        line.pop()
        num += 1
    elif students[-1] == num :
        students.pop()
        num += 1
    else:
        flag = 0
        for i in range(len(students)):
            s = students.pop()
            if s == num:
                num += 1
                flag = 1
                break
            line.append(s)
        if flag == 0:
            print("Sad")
            break

print("Nice")
        