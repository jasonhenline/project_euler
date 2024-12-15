from functools import cache


@cache
def number_of_ways(denominations: tuple[int, ...], target: int) -> int:
    if target == 0:
        return 1
    if not denominations:
        return 0
    result = 0
    value = denominations[0]
    rest = denominations[1:]
    n = 0
    while True:
        new_target = target - n * value
        if new_target < 0:
            break
        result += number_of_ways(rest, new_target)
        n += 1
    return result


def main():
    denominations = (200, 100, 50, 20, 10, 5, 2, 1)
    print(number_of_ways(denominations, 200))


main()
