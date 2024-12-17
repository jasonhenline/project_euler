result = 0
modulus = 10_000_000_000
for i in range(1, 1001):
    result += pow(i, i, modulus)
    result %= modulus
print(result)
