n = int(input())
nums = list(map(int, input().split()))

m = int(input())
ranges = []
for _ in range(m):
    ranges.append(list(map(int, input().split())))

sums = [0 for _ in range(n + 1)]
sums[1] = nums[0]
for i in range(2, n + 1):
    sums[i] = nums[i - 1] + sums[i - 1]

for r in ranges:
    print(sums[r[1]] - sums[r[0] - 1])