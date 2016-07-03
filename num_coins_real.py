

def recursive_num_coins_real(coin_arr, total, glob_array):
    #guarenteed coin_arr has 1
    #guraenteed total is greater than -1
    # if coin_arr[-1] == 1:
    #     return total 

    #check if 
    if total == 1:
        return (1,[1])
    elif total == 0:
        return (0,[])

    # #find the largest vaild coins for the job
    if glob_array[total - 1][0] == 0:
        smallest = (float('inf'), [])
        coin_used = 0
        for coin in [x for x in coin_arr if x <= total]:
            temp = recursive_num_coins_real(coin_arr, total - coin, glob_array)
            temp = (temp[0] + 1, temp[1])

            print temp
            if temp[0] < smallest[0]:
                smallest = temp
                coin_used = coin
                
            #smallest = min(smallest, recursive_num_coins_real(coin_arr, total - coin, glob_array)[0] + 1)
        smallest[1].append(coin_used)
        glob_array[total - 1] = smallest
    print glob_array
    return glob_array[total - 1]




    # sum = 0
    # print recursive_num_coins(coin_arr[:-1], total)
    # print recursive_num_coins(coin_arr, total - coin_to_use)
    # sum += min(recursive_num_coins(coin_arr[:-1], total), recursive_num_coins(coin_arr, total - coin_to_use) + 1)
    # return sum

    #we're taking the part without the 


array = [1,3,4,5]
glob_array = [(0,[])] * 10
print recursive_num_coins_real(array, 10, glob_array) #5