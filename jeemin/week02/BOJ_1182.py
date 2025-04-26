n, s = map(int, input().split())
seq = list(map(int,input().split()))

save = 0
cnt = 0

def solution(idx, save):
    global cnt
    if save == s: 
        cnt += 1

    for i in range(idx, n):
        solution(i + 1, save + seq[i])
    

for i in range(n):
    solution(i + 1, save + seq[i])

print(cnt)