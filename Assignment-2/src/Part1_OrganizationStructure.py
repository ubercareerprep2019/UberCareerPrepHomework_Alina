from __future__ import annotations
from typing import Type
import collections

class Employee:
    name: str = None
    title: str = None
    directReports: list<Type[Employee]>() = None #employees that report to them

    def __init__(self, name: str, title: str, direct_reports: list<Type[Employee]>()):
        self.name = name
        self.title = title
        self.directReports = direct_reports

    def __str__(self):
        return "Name: {name}, Title: {title}".format(name=self.name, title=self.title)

class OrganizationStructure:
    ceo: Employee = None
    levels: collections.deque = None
    current_position: int = None

    def __init__(self, highest_authority: Employee):
        self.ceo = highest_authority
        self.levels = collections.deque([self.ceo])
        self.current_position = 0

    """
    [Trees - Ex2] Exercise: Printing a tree level by level
    Implement a method called printLevelByLevel() for the class OrganizationStructure that prints it level by level. 
    For example, running printLevelByLevel() on the OrganizationStructure above should produce the following output:

    Name: A, Title: CEO

    Name: B, Title: CFO
    Name: C, Title: CTO

    Name: I, Title: Director
    Name: D, Title: Manager
    Name: E, Title: Manager

    Name: J, Title: Sales Representative
    Name: F, Title: Engineer
    Name: G, Title: Engineer
    Name: H, Title: Engineer

    Name: K, Title: Sales Intern
    """
    def printLevelByLevel(self):
        self.current_position = 0
        self.collectEmployeesInQueue(self.ceo)
        while self.levels:
            print(self.levels.popleft())

    def collectEmployeesInQueue(self, root_employee: Employee):
        if root_employee.directReports is not None:
            for underling in root_employee.directReports:
                self.levels.append(underling)

        self.current_position += 1
        if self.current_position < len(self.levels):
            self.collectEmployeesInQueue(list(self.levels)[self.current_position])
