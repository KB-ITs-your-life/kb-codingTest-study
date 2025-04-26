t = int(input())
cnt = 0
def solution(r, n):
    global cnt
    if r == n:
        cnt += 1
        return
    
    for i in range(1, 4):
        if n - r >= i:
            solution(r + i, n)

for _ in range(t):
    n = int(input())
    cnt = 0
    solution(0, n)
    print(cnt)