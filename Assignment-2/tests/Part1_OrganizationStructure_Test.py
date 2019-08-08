from unittest import TestCase
from Part1_OrganizationStructure import OrganizationStructure
from Part1_OrganizationStructure import Employee


class Part1_OrganizationStructure_Test(TestCase):
    def test_printLevelByLevel(self):
        sales_intern = Employee("K", "Sales Intern", None)

        sales_rep = Employee("J", "Sales Representative", [sales_intern])
        engineer_f = Employee("F", "Engineer", None)
        engineer_g = Employee("G", "Engineer", None)
        engineer_h = Employee("H", "Engineer", None)

        director = Employee("I", "Director", [sales_rep])
        manager_d = Employee("D", "Manager", [engineer_f, engineer_g, engineer_h])
        manager_e = Employee("E", "Manager", None)

        cfo = Employee("B", "CFO", [director])
        cto = Employee("C", "CTO", [manager_d, manager_e])

        ceo = Employee("A", "CEO", [cfo, cto])

        test_structure = OrganizationStructure(ceo)
        test_structure.printLevelByLevel()

    def test_printNumLevels(self):
        sales_intern = Employee("K", "Sales Intern", None)

        sales_rep = Employee("J", "Sales Representative", [sales_intern])
        engineer_f = Employee("F", "Engineer", None)
        engineer_g = Employee("G", "Engineer", None)
        engineer_h = Employee("H", "Engineer", None)

        director = Employee("I", "Director", [sales_rep])
        manager_d = Employee("D", "Manager", [engineer_f, engineer_g, engineer_h])
        manager_e = Employee("E", "Manager", None)

        cfo = Employee("B", "CFO", [director])
        cto = Employee("C", "CTO", [manager_d, manager_e])

        ceo = Employee("A", "CEO", [cfo, cto])

        test_structure = OrganizationStructure(ceo)
        test_structure.printNumLevels()
