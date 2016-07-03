def lis(arr):
    n = len(arr)

    lis = [1]*n #intialize array of size arr all 1's, this is the table

    point_lis = [0]*n
    for i in range(0, n): #n is the length of the arrays, i is going up
        for j in range(0, i): #j is going up to i
            if arr[i] > arr[j]: #if number at the end of the subsection is greater than current number
                if lis[i] < lis[j] + 1: #and if table at end of subsection is < table and curr num inlucing end
                    lis[i] = lis[j] + 1 #update the table
                    point_lis[i] = j

    # maxi = 0

    # for i in range(n):
    #     maxi = max(maxi, lis[i])

    return_list = []
    i = int(n) - 1
    while i != point_lis[i]:
        return_list.insert(0,arr[i])
        i = point_lis[i]
    return_list.insert(0,arr[i])
    #return return_list
    print return_list
    return lis[-1]


arr = [7, 2, 8, 6, 3, 1, 9, 7, 10]
i = 5
j = 5
print arr[i:j + 1]
#print "Length of LIS is", lis(arr)
# for i in range(0, len(arr)):
#     print arr[i]
print lis(arr)

