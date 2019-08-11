from __future__ import annotations
from typing import Type
import collections

"""
    Class that represents employee of an organization.
"""
class Employee:
    name: str = None    # name of employee
    title: str = None   # title of employee
    directReports: list<Type[Employee]>() = None    # underling-employees that report to employee

    def __init__(self, name: str, title: str, direct_reports: list<Type[Employee]>()):
        self.name = name
        self.title = title
        self.directReports = direct_reports

    def __str__(self):
        return "Name: {name}, Title: {title}".format(name=self.name, title=self.title)


"""
    An organization class, which only understands hierarchy levels.
"""
class OrganizationStructure:
    ceo: Employee = None    # head employee
    employees_by_levels: collections.deque = None    # queue with all employees in level order
    current_position: int = None    # current position in queue
    level_count: int = None         # global count variable for collecting employees in queue

    def __init__(self, highest_authority: Employee):
        self.ceo = highest_authority
        self.current_position = 0
        self.level_count = 1
        self.employees_by_levels = collections.deque([{self.ceo: 1}])

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
        self.collectEmployeesInQueue(self.ceo, 2)

        while self.employees_by_levels:
            popped_node = self.employees_by_levels.popleft()
            popped_employee = list(popped_node.keys())[0]
            popped_level = popped_node.get(popped_employee)

            if popped_level > self.level_count:
                print()
                self.level_count += 1

            print(popped_employee)

        # clean up: sets current position to 0 again
        self.current_position = 0


    """
    [Trees - Ex3] Exercise: Printing the number of levels
    Implement a method called printNumLevels() for the class OrganizationStructure that prints the number of levels.
    """
    def printNumLevels(self):
        self.collectEmployeesInQueue(self.ceo, 2)
        popped_node = self.employees_by_levels.pop()
        popped_employee = list(popped_node.keys())[0]
        popped_level = popped_node.get(popped_employee)
        print(popped_level)

        # clean up: makes sure queue is empty.
        while self.employees_by_levels:
            self.employees_by_levels.popleft()

        # clean up: sets current position to 0 again
        self.current_position = 0

    """
        Add all employees into employees_by_levels queue.
        
        note: uses tail recursion, which is the same as a loop
    """
    def collectEmployeesInQueue(self, root_employee: Employee, current_level: int):
        if root_employee.directReports is not None:
            for underling in root_employee.directReports:
                self.employees_by_levels.append({underling: current_level})

        self.current_position += 1
        if self.current_position < len(self.employees_by_levels):
            current_node: dict = list(self.employees_by_levels)[self.current_position]
            current_employee = list(current_node.keys())[0]
            self.collectEmployeesInQueue(current_employee, current_node.get(current_employee) + 1)
