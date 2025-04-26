n = int(input())

vedio = []
for _ in range(n):
    vedio.append(input())

result = ''
def solution(a, b, size):
    global result
    
    for i in range(a, a + size):
        for j in range(b, b + size):
            if vedio[i][j:j + 1] != vedio[a][b:b + 1]:
                result += '('
                
                solution(a, b, size // 2)
                solution(a, b + size // 2, size // 2)
                solution(a + size // 2, b, size // 2)
                solution(a + size // 2, b + size // 2, size // 2)
                result += ')'
                return
    result += vedio[a][b:b + 1]

solution(0, 0, n)
print(result)