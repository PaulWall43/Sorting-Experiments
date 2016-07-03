#Written by Paul Wallace March 8th, 2016 

class Writer:
    """ 
    Method to write n (num_addresses) addresses to a new file while incrementing 
    """
    def writeAddresses(self, num_addresses, old_file_name, new_file_name):
        #initialize constants to avoid hard coding
        ONE = 1 
        TWO = 2
        TWO_FIFTY_SIX = 256
        try:
            with open(old_file_name) as curr_file: 
                try:
                    with open(new_file_name, "w") as new_file:
                        for address in curr_file:
                            (key, val) = address.split() #assume file is correct
                            address_list = map(int, val.split('.')) #[1, 0, 0, 2]
                            count = 0 #start a count to be checked to the num_addresses param
                            for i in range(TWO_FIFTY_SIX): #outer loop 
                                if count == num_addresses: break #
                                address_list[ONE] = i
                                for j in range(TWO_FIFTY_SIX): #inner loop
                                    #increment then write to the file
                                    if count == num_addresses: break #reached param?
                                    address_list[TWO] = j 
                                    string = key + ' ' + '.'.join(str(x) for x in address_list) + '\n'
                                    new_file.write(string)
                                    count += 1
                except IOError:
                    print "Unable to open file: ", new_file_name
        except IOError:
            print "Unable to read file:", old_file_name
            print "Please enter an existing file"

writer = Writer()
char = ''
while(char != 'n'):
    print "Do you want to enter parameters or go with default? (e or d)"
    char = raw_input()
    if char == 'd':
        print "Running program..."
        writer.writeAddresses(1000, "addresses.txt" ,"new_addresses.txt")
        print "Program finished do you want to continue? (y or n)"
        char = raw_input()

    elif char == 'e':
        print "How many times do you want to increment each R* address?"
        n = raw_input()
        print "Please enter the read file"
        old_file = raw_input()
        print "Please enter the file to be written to"
        new_file = raw_input()
        print "Thank you, program is running..."
        writer.writeAddresses(n, old_file, new_file)
        print "Program is finished, do you want to continue? (y or n)"
        char = raw_input()
    else:
        print "Not a valid character"

print "Thanks Pamela!"



