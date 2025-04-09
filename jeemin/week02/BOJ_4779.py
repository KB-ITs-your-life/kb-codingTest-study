def solution(s, e):
    a, b = s + (e - s) // 3, s + ((e - s) // 3) * 2
    if e - s == 1:
        return 
    
    for i in range(a ,b):
        line[i] = ' '
    solution(s, a)
    solution(b, e)

while True:
    try:
        n = int(input())

        line = ['-' for _ in range(3**n)]
        if n == 0:
            print('-')
            continue
        
        solution(0, 3**n)
        print(''.join(line))
    
    except: break