from math import lcm

result = 1
for n in range(1, 21):
    result = lcm(result, n)

print(result)
