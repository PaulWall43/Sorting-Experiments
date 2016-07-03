total_calls = 0
i = 10
j = 10
array = [[0 for x in range(i + 1)] for x in range(j + 1)]


def recursive_num_ways(rows,cols):
    global total_calls
    global array
    total_calls += 1
    if rows == 1:
        return cols + 1
    elif cols == 1:
        return rows + 1
    sum = 0
    if array[rows - 1][cols] == 0:
        array[rows - 1][cols] = recursive_num_ways(rows - 1, cols)
    # array[rows - 1][cols] = recursive_num_ways(rows - 1, cols)
    sum += array[rows - 1][cols]
    if array[rows][cols - 1] == 0:
        array[rows][cols - 1] = recursive_num_ways(rows, cols - 1)
    # array[rows][cols - 1] = recursive_num_ways(rows, cols - 1)
    sum += array[rows][cols - 1]
    array[rows][cols] = sum
    return sum


print recursive_num_ways(i,j)
print total_calls
print array