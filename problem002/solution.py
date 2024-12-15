result = 0

a = 0
b = 1

while a < 4_000_000:
    if a % 2 == 0:
        result += a
    a, b = b, a + b

print(result)