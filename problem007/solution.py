primes = [2]
n = 3
while len(primes) < 10001:
    is_prime = True
    for p in primes:
        if p * p > n:
            break
        if n % p == 0:
            is_prime = False
            break
    if is_prime:
        primes.append(n)
    n += 2
print(primes[-1])
