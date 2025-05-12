n = int(input())

b = list(map(int, input().split()))
idx = [i for i in range(1, n + 1)]
result = []

move = b.pop(0)
curIdx = 0
result.append(idx.pop(0))

while(len(b) > 0):
    if move > 0:
        curIdx = (curIdx + move - 1 + len(b)) % len(b)
    else:
        curIdx = (curIdx + move + len(b)) % len(b)
    move = b.pop(curIdx)
    result.append(idx.pop(curIdx))

for i in range(0, n):
    print(result[i], end=" ")
print()