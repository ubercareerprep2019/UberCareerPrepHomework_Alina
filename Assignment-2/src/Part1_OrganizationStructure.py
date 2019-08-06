from __future__ import annotations
from typing import Type

class Employee:
    name: str = None
    title: str = None
    directReports: list<Type[Employee]>() = None

class OrganizationStructure:
    ceo: Employee = None

    def __init__(self):

