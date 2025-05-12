n, m = map(int, input())
nums = []
for _ in range(n):
    nums.append(list(map(int, input().split())))

k = int(input())

sums = [[0 for _ in range(m)] for __ in range(n)]
sums[0] = nums[0]
for i in range(1, n):
    for j in range(m):
        sums[i][j]