from functools import cache


@cache
def get_chain_length(n: int) -> int:
    if n == 1:
        return 1
    elif n % 2 == 0:
        return 1 + get_chain_length(n // 2)
    else:
        return 1 + get_chain_length(3 * n + 1)


result = 0
longest_chain = 0
for n in range(1, 1_000_000):
    chain_length = get_chain_length(n)
    if chain_length > longest_chain:
        result = n
        longest_chain = chain_length
print(result)
