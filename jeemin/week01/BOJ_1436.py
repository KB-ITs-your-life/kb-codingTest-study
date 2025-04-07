# https://www.acmicpc.net/problem/1436

n = int(input())

cnt = 0
result = 0
while(1):
    if '666' in str(result):
        cnt += 1
        if cnt == n:
            print(result)
            break
    result += 1