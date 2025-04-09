n, m = map(int, input().split())

visited = [False for _ in range(n + 1)]
save = [0 for _ in range(m)]

cnt = 0
def solution(cnt):
    if cnt == m:
        for s in save:
            print(s, end=" ")
        print()
        return 

    for i in range(1, n + 1):
        if visited[i] == False:
            save[cnt] = i
            visited[i] = True

            solution(cnt + 1)

            save[cnt]= 0
            visited[i] = False

solution(cnt)