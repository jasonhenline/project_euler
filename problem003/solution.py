result = 1

n = 600851475143

d = 2
while d * d <= n != 1:
    if n % d == 0:
        result = d
        while n % d == 0:
            n //= d
    d += 1

print(max(result, n))