import time
from Part1_PhoneBook import ListPhoneBook, BinarySearchTreePhoneBook

"""
[Trees - Ex6] Exercise: Unsorted lists v.s. Binary search trees

Write a program that takes in as input two files, data.csv and search.txt:

    - data.csv is a CSV file consisting of a 1000000 lines, where each line is a name (technically a UUID) followed by a
    phone number.

    - search.txt is a file consisting of 1000 lines, where each line is a name (technically a UUID). Each name in
    search.txt is guaranteed to be present in data.csv.

In this program, you will:
    1. Create a PhoneBook.
        In the first version of the program, the PhoneBook will be a ListPhoneBook.
        In the second version of the program, the PhoneBook will be a BinarySearchTreePhoneBook.
    2. Read each line of data.csv and insert() it into the PhoneBook created. Print out the total time (in milliseconds) 
    it takes to insert() a million name and phone number entries.
    3. Print out the size() of the PhoneBook and ensure that it is 1000000. This is a basic test to ensure that you’ve 
    successfully read all the data. If the size if not 1000000 you should terminate your program with an error message.
    4. Read each line of search.txt and find() it in the PhoneBook you created. Ensure that the find() method never 
    returns -1, as each name in search.txt is present in data.csv. If find() ever returns -1, you should terminate your 
    5. program with an error message. Print the number of times that find() is called, and ensure that it is exactly 1000. 
    If it isn’t, you should terminate your program with an error message. Print out the total time (in milliseconds) 
    it takes to find() a thousand names in your PhoneBook.
"""

def get_bigO_of_unordered_list(data_file: str, search_file: str) -> None:
    print("Printing out unordered list info...")
    data = open(data_file, "r")
    search_data = open(search_file, "r")

    phone_book = ListPhoneBook()

    start_time = time.time()
    for line in data:
        line = line.strip()
        name, number = line.split(",")
        phone_book.insert(name, number)
    print("Insert took {} milliseconds.".format((time.time() - start_time) * 1000))

    assert phone_book.size() == 1000000
    print("The size of the PhoneBook is 1000000.")

    num_of_finds: int = 0
    start_time = time.time()
    for line in search_data:
        line = line.strip()
        assert phone_book.find(line) != -1
        num_of_finds += 1

    assert num_of_finds == 1000
    print("find() was called 1000 times.")

    print("Search took {} milliseconds.".format((time.time() - start_time) * 1000))
    print()

def get_bigO_of_bst(data_file: str, search_file: str) -> None:
    print("Printing out bst info...")
    data = open(data_file, "r")
    search_data = open(search_file, "r")

    phone_book = BinarySearchTreePhoneBook()

    start_time = time.time()
    for line in data:
        line = line.strip()
        name, number = line.split(",")
        phone_book.insert(name, number)
    print("Insert took {} milliseconds.".format((time.time() - start_time) * 1000))

    assert phone_book.size() == 1000000
    print("The size of the PhoneBook is 1000000.")

    num_of_finds: int = 0
    start_time = time.time()
    for line in search_data:
        line = line.strip()
        assert phone_book.find(line) != -1
        num_of_finds += 1

    assert num_of_finds == 1000
    print("find() was called 1000 times.")

    print("Search took {} milliseconds.".format((time.time() - start_time) * 1000))

def main():
    get_bigO_of_unordered_list("..\\data\\data.csv", "..\\data\\search.txt")
    get_bigO_of_bst("..\\data\\data.csv", "..\\data\\search.txt")

if __name__ == "__main__":
    main()

"""
What is the output of your program when you use a ListPhoneBook? --> 
     Printing out unordered list info...
    Insert took 2128.3249855041504 milliseconds.
    The size of the PhoneBook is 1000000.
    find() was called 1000 times.
    Search took 104192.5060749054 milliseconds.
     
What is the output of your program when you use a BinarySearchTreePhoneBook? --> 
    Printing out bst info...
    Insert took 29027.835845947266 milliseconds.
    The size of the PhoneBook is 1000000.
    find() was called 1000 times.
    Search took 37.2004508972168 milliseconds.
    
Why is there a difference in the running times for the two implementations? -->
    This is because finding an element in a BST is O(logN) vs. whereas finding an element in an unordered list is O(n).
    BSTs' cut down time by ordering the inserts and allowing comparisons to choose which node (left or right) to 
    traverse down at every node.
"""



