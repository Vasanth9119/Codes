#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Employee {
    int EmployeeID;
    char Name[50];
    double Salary;
    char Designation[10];
    struct Employee *next;
};

struct Employee *head = NULL; 
struct Employee *temp = NULL; 

struct Employee* AddEmployee(struct Employee *head) {
    struct Employee *newEmployee = (struct Employee *)malloc(sizeof(struct Employee));
    printf("Enter the name, Employee-ID, salary, Designation[IT/HR]:\n");
    scanf("%s %d %lf %s", newEmployee->Name, &newEmployee->EmployeeID, &newEmployee->Salary, newEmployee->Designation);
    newEmployee->next = head;
    return newEmployee;
}

void Display() {
    temp = head;
    if (temp == NULL) {
        printf("No employees to display.\n");
        return;
    }
    while (temp != NULL) { 
        printf("\nName: %s\nEmployee-ID: %d\nSalary: %.2lf\nDesignation: %s\n",temp->Name, temp->EmployeeID, temp->Salary, temp->Designation);
        temp = temp->next; 
    }
}

void Search() {
    printf("Enter the employee ID to display the details: ");
    int ID;
    scanf("%d", &ID);
    temp = head;
    while (temp != NULL) {  
        if (temp->EmployeeID == ID) {
            printf("\nName: %s\nSalary: %.2lf\nDesignation: %s\n",
                   temp->Name, temp->Salary, temp->Designation);
            return;    
        }
        temp = temp->next;
    }
    printf("Employee ID not found.\n");
}

void Salary() {
    printf("Enter the employee ID to update salary: ");
    int ID;
    scanf("%d", &ID);
    temp = head;
    while (temp != NULL) { 
        if (temp->EmployeeID == ID) {
            printf("Enter the updated salary: ");
            scanf("%lf", &temp->Salary);
            printf("Salary updated successfully.\n");
            return;
        }
        temp = temp->next;
    }
    printf("Employee ID not found.\n");
}

void Highest() {
    if (head == NULL) {
        printf("No employees available.\n");
        return;
    }
    double High = head->Salary; 
    int ID = head->EmployeeID;
    temp = head->next;
    while (temp != NULL) {
        if (temp->Salary > High) {
            High = temp->Salary;
            ID = temp->EmployeeID;
        }
        temp = temp->next;
    }
    printf("Employee-ID: %d has the Highest Salary of %.2lf\n", ID, High);
}

void average() {
    if (head == NULL) {
        printf("No employees available.\n");
        return;
    }
    double totalsal = 0;
    int num = 0;
    temp = head;
    while (temp != NULL) { 
        totalsal += temp->Salary;
        num++;
        temp = temp->next;
    }
    printf("Average salary of all employees is: %.2lf\n", totalsal / num);
}

int main() {
    int ch;
    do {
        printf("\nEnter choice:\n");
        printf("1. Add employee\n2. Display all employee details\n3. Search an employee by ID\n");
        printf("4. Update an employee salary\n5. Find the employee with the highest salary\n");
        printf("6. Calculate the average salary of all employees\n7. Exit\n");
        scanf("%d", &ch);
        switch (ch) {
            case 1:
                head = AddEmployee(head);
                break;
            case 2:
                Display();
                break;
            case 3:
                Search();
                break;
            case 4:
                Salary();
                break;
            case 5:
                Highest();
                break;
            case 6:
                average();
                break;
            case 7:
                printf("Exiting program...\n");
                break;
            default:
                printf("Invalid choice. Try again.\n");
        }
    } while (ch != 7);
    return 0;
}
