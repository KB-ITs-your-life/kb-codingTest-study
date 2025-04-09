n = int(input())

paper = []
for _ in range(n):
    paper.append(list(map(int, input().split())))

result = [0, 0, 0]
def solution(x, y, size):
    n = paper[x][y]
    # size가 1일 경우 종이 개수 추가
    if size == 1:
        result[n + 1] += 1
        return

    for i in range(x, x + size):
        for j in range(y, y + size):
            # 내부에 다른 수가 존재할 경우 9등분
            if paper[i][j] != n:
                for k in range(3):
                    solution(x + size // 3 * k, y, size // 3)
                    solution(x + size // 3 * k, y + size // 3, size // 3)
                    solution(x + size // 3 * k, y + size // 3 * 2, size // 3)
                return
    # 모든 값이 같을 경우 종이 개수 추가
    result[n + 1] += 1

solution(0, 0, n)   
for r in result:
    print(r)