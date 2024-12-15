a = 0
b = 1
index = 1
while len(str(b)) < 1_000:
    a, b = b, a + b
    index += 1
print(index)
