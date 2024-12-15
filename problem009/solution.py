def get_solution() -> int:
    for a in range(1, 1000):
        for b in range(1, 1000):
            c = 1000 - a - b
            if c > 0 and a**2 + b**2 == c**2:
                return a * b * c


print(get_solution())
