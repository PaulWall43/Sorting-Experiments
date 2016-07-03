

def recursive_num_coins(coin_arr, total, glob_array):
    #guarenteed coin_arr has 1
    #guraenteed total is greater than -1
    # if coin_arr[-1] == 1:
    #     return total 

    #check if 
    if total == 1:
        return 1
    elif total == 0:
        return 0

    # #find the largest vaild coins for the job
    if glob_array[total - 1] == 0:
        smallest = float('inf')
        for coin in [x for x in coin_arr if x <= total]:
            smallest = min(smallest, recursive_num_coins(coin_arr, total - coin, glob_array) + 1)
        glob_array[total - 1] = smallest
    return glob_array[total - 1]




    # sum = 0
    # print recursive_num_coins(coin_arr[:-1], total)
    # print recursive_num_coins(coin_arr, total - coin_to_use)
    # sum += min(recursive_num_coins(coin_arr[:-1], total), recursive_num_coins(coin_arr, total - coin_to_use) + 1)
    # return sum

    #we're taking the part without the 


array = [1,10,22]
glob_array = [0] * 50
print recursive_num_coins(array, 50, glob_array) #5