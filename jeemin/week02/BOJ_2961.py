import math

n = int(input())
ingrd = []
min_food = math.inf
visited = [False for _ in range(n)]

for _ in range(n):
    ingrd.append(list(map(int, input().split())))

def solution(sour, bitter):
    global min_food
    if min_food > abs(sour - bitter):
        min_food = abs(sour - bitter)
    
    for i in range(1, n):
        if visited[i] == False:
            visited[i] = True
            solution(sour * ingrd[i][0], bitter + ingrd[i][1])
            visited[i] = False

if n == 1:
    print(abs(ingrd[0][0] - ingrd[0][1]))
else: 
    for i in range(n):
        visited[i] = True
        solution(ingrd[i][0], ingrd[i][1])
        visited[i] = False
    print(min_food)