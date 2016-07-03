import collections

def is_palindrome(char_array):
    return str(char_array) == str(char_array)[::-1]


#assume array is list of characters
def recursive_longest_palindrome(array, list_of_remaining_chars):
    counter = collections.Counter(array)
    scope_bool = is_palindrome(list_of_remaining_chars)
    if not list(counter.elements()):
        return (len(list_of_remaining_chars), scope_bool)

    longest = (float('-inf'), scope_bool) 
    for key in counter:
        #decrement value at that key
        if counter[key] > 0:
            counter[key] -= 1
        else:
            continue
        list_of_remaining_chars.append(key)
        temp = recursive_longest_palindrome(list(counter.elements()), list_of_remaining_chars)
        if temp[1]:
            longest = max(longest, temp)
        list_of_remaining_chars.pop()
        counter[key] += 1
    return longest

        #add that value back 
    # for char in array:
    #     temp_arr = del array[array.index(char)
    #     recursive_longest_palindrome(array[1:], list_of_remaining_chars.append(char))



array = ['d','a','d']
recursive_longest_palindrome(array, [])
# print reversed(dad)[0:-1]
