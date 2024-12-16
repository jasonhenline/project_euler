from collections import defaultdict


def count_solutions(perimeter: int) -> int:
    solutions: set[tuple[int, ...]] = set()

    # We will search for side length with c >= a >= b
    for c in range(1, perimeter + 1):
        for b in range(1, c + 1):
            for a in range(1, b + 1):
                if a**2 + b**2 == c**2:
                    solution = tuple(sorted([a, b, c]))
                    solutions.add(solution)

    return len(solutions)


def main():
    perimeter_to_solutions = defaultdict(set)

    # Search with c being the largest, b the second largest.
    for c in range(1, 1001):
        for b in range(1, 1001 - c):
            for a in range(1, 1001 - b - c):
                if a**2 + b**2 == c**2:
                    solution = tuple(sorted([a, b, c]))
                    perimeter_to_solutions[a + b + c].add(solution)

    best_count = 0
    best_perimeter = 0
    for perimeter, solutions in perimeter_to_solutions.items():
        count = len(solutions)
        if count > best_count:
            best_count = count
            best_perimeter = perimeter

    print(best_perimeter)


main()
