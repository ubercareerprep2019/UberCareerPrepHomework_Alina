from unittest import TestCase
from Part1_PhoneBook import ListPhoneBook, BinarySearchTreePhoneBook


class Part1_PhoneBook_Test(TestCase):
    def test_size(self):
        phone_book = ListPhoneBook()

        assert phone_book.size() == 0
        phone_book.insert("ABC", 1111111111)
        assert phone_book.size() == 1

        phone_book.insert("XYZ", 9999999999)
        assert phone_book.size() == 2

        phone_book.insert("DEF", 2222222222)
        assert phone_book.size() == 3

    def test_find(self):
        phone_book = ListPhoneBook()
        phone_book.insert("ABC", 1111111111)
        phone_book.insert("XYZ", 9999999999)
        phone_book.insert("DEF", 2222222222)

        assert phone_book.find("ABC") == 1111111111
        assert phone_book.find("DEF") == 2222222222
        assert phone_book.find("XYZ") == 9999999999
        assert phone_book.find("PQR") == -1

    def test_binary_size(self):
        phone_book = BinarySearchTreePhoneBook()
        assert phone_book.size() == 0

        phone_book.insert("ABC", 1111111111)
        assert phone_book.size() == 1

        phone_book.insert("XYZ", 9999999999)
        assert phone_book.size() == 2

        phone_book.insert("DEF", 2222222222)
        assert phone_book.size() == 3

    def test_binary_find(self):
        phone_book = BinarySearchTreePhoneBook()
        phone_book.insert("ABC", 1111111111)
        phone_book.insert("XYZ", 9999999999)
        phone_book.insert("DEF", 2222222222)

        assert phone_book.find("ABC") == 1111111111
        assert phone_book.find("DEF") == 2222222222
        assert phone_book.find("XYZ") == 9999999999
        assert phone_book.find("PQR") == -1
