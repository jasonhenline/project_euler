# First find the maximum number of digits for which this could happen.
#
# The maximum digit is 9, so for d digits the maximum sum of fifth powers of digits is d*9**5.
#
# The minimum d-digit number is 10**d - 1.
#
# The maximum digit sum must be no less than the minimum value for equality to be possible.
d = 1
while d * 9**5 >= 10**d - 1:
    d += 1

result = 0
for n in range(2, 10**d):
    digits = [int(c) for c in str(n)]
    digit_sum = sum(digit**5 for digit in digits)
    if digit_sum == n:
        result += n
print(result)
