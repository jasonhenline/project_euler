def factorial(n: int) -> int:
    result = 1
    for k in range(2, n + 1):
        result *= k
    return result


def split_for_permutation(items: list, n: int):
    """
    Returns a tuple with the following three pieces of information:
     0. the next item to place in the permutation,
     1. the list of remaining items to place,
     2. the remaining count after that item is placed.

    The input is the list of items to permute and the number of times to permute them.
    """
    item_count = len(items)

    if item_count == 1:
        return items[0], [], n

    # The index is the total number of times we permute all the other elements.
    # The remaining_n is the number of permutations we have left over after we choose the first index.
    index, remaining_n = divmod(n, factorial(item_count - 1))
    remaining_items = items[:index] + items[index + 1 :]
    return items[index], remaining_items, remaining_n


def get_permutation(items: list, n: int):
    result = []
    remaining_items = items[:]
    remaining_n = n
    while remaining_items:
        item, remaining_items, remaining_n = split_for_permutation(
            remaining_items, remaining_n
        )
        result.append(item)
    return result


def main():
    items = list(range(10))
    permutation = get_permutation(items, 1_000_000 - 1)
    print("".join(str(n) for n in permutation))


main()
