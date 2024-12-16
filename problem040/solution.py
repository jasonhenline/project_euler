todo = [
    1,
    10,
    100,
    1_000,
    10_000,
    100_000,
    1_000_000,
]

result = 1
index = 0
n = 0
while todo:
    s = str(n)
    for c in s:
        if index == todo[0]:
            result *= int(c)
            todo.pop(0)
            if not todo:
                break
        index += 1
    n += 1

print(result)
