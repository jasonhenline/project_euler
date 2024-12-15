is_prime = 2_000_000 * [True]
is_prime[0] = False
is_prime[1] = False
n = 2
while n * n < len(is_prime):
    d = n * n
    while d < len(is_prime):
        is_prime[d] = False
        d += n
    n += 1
    while n * n < len(is_prime) and not is_prime[n]:
        n += 1

primes = [i for (i, n) in enumerate(is_prime) if n]
print(sum(primes))
