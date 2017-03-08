#Program used to create all permutations of lowercase/uppercase letters combinations based on a solicited input
#rules: must find all combos for letters that are repeated (twice or more)



#this set is represented by binary 1's and 0's to keep track
#of which indices need to be permutated


def sort_letters(char_set, text):
    numb_set = [0]*len(text);

    # fill up with 1's
    #independent letters have separate indices
    for letter in char_set:
        index = 0;
        out = 1;
        count = 1;
        while (index < len(text)) & out :
            index = text.find(letter, index);
            if index != -1:
                numb_set[index] = 1;
            else:
                out = 0;
            index += 1;
    return numb_set 


#generate all power sets

def power_set(nums, text):
    #first, strip out the indices of the 1's in order
    perm = [];
    str2char_list = [];
    str2char_copy = [];

    for k in range(0,len(nums)):
        if nums[k]==1:
            perm.append(k);
        str2char_list.append(text[k]);  #this is done to avoid pointers to the same list
        str2char_copy.append(text[k]);

        #convert string to a char array simultaneously

    #then, cycle through all combinations of indices
    subsets = [[]];
    word_list = [text];
    count = 1;
    for element in perm:
        for ind in xrange(len(subsets)):
            subsets.append(subsets[ind] + [element]);
            for k in subsets[count]:

                # changes lowercase to uppercase and vice versa
                sc = ord(str2char_list[k]);
                a = ((sc >= 65) & (sc <= 90));
                b = ((sc >= 97) & (sc <= 122));
                
                str2char_copy[k] = chr(sc +  32*a - 32*b);
                
                #add the new word to the list
            new_entry = ''.join(str2char_copy);
            word_list.append(new_entry);
            count += 1;

            for k in range(0,len(nums)):
                str2char_copy[k] = text[k];

    return word_list


word = input("Please enter a word: ");
rule_char_set = input("Create permutations for which enumerated letters?: ");


print power_set(sort_letters(rule_char_set, word), word)



