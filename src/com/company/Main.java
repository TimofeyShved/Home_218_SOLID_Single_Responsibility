package com.company;

public class Main {

    public static void main(String[] args) {
        EmployeeFacade employeeUneversal = new EmployeeFacade();
        employeeUneversal.cleanFood();
    }
}

/* Так делать нельзя, принцип 1й - класс должен иметь только одну причину для изменения

// в нашем случае сотрудник имеет зп, готовит и убирается, то-есть 3 причины для изменения,
// поэтому нужно разделить на насколько классов

class Employee{
    int getSalary(){return 10000;};
    void cook();
    void cleanFood();
}
 */

// теперь у нас по 1 классу на изменения
interface Employee {
    int getSalary();
}

class Cook implements Employee{
    @Override
    public int getSalary() {
        return 30000;
    }
    void cook(){
        System.out.println("cook");
    }
}

class Janitor implements Employee{
    @Override
    public int getSalary() {
        return 15000;
    }
    void cleanFood(){
        System.out.println("janitor clean food");
    }
}

// если же нужно объеденить работу для сотрудника, то можно применить паттерн (фасад)
class EmployeeFacade{
    Cook cook = new Cook();
    Janitor janitor = new Janitor();

    void cook(){
        cook.cook();
    }

    void cleanFood(){
        janitor.cleanFood();
    }
}
