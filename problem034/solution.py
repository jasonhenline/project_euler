from math import factorial

d = 1
while d * factorial(9) >= 10**d - 1:
    d += 1
d -= 1

result = 0
for n in range(10, 10**d):
    s = sum(factorial(int(c)) for c in str(n))
    if n == s:
        result += n
print(result)
