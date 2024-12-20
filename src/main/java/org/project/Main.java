package org.project;

import org.project.model.Director;
import org.project.model.Employee;
import org.project.model.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {


        Employee employee = new Employee.EmployeeBuilder()
                .id(1)
                .name("Jessica")
                .birthday(LocalDate.of(1971,12,01))
                .gender(Gender.MALE)
                .salary(11000)
                .build();

        Employee employee2 = new Employee.EmployeeBuilder()
                .id(1)
                .name("Morgan")
                .birthday(LocalDate.of(1999,05,29))
                .gender(Gender.MALE)
                .salary(10000)
                .build();

        Director director = (Director) new Director.DirectorBuilder()
                .id(2)
                .name("Josh")
                .birthday(LocalDate.of(1970,02,15))
                .gender(Gender.MALE)
                .salary(20000)
                .build();
        /**
         * В основной программе создайте руководителя и поместите его в общий массив сотрудников.
         */
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee2);
        employees.add(director);
        /**
         * Написать прототип компаратора - метод внутри класса сотрудника,
         * сравнивающий две даты, представленные в виде трёх чисел гггг-мм-дд,
         * без использования условного оператора.
         * И  СОБСТВЕННО РЕАЛИЗАЦИЯ
         */
        employees.sort(Employee::compareTo);
        System.out.println("Before raising the salary");
        employees.forEach(System.out::println);
        System.out.println("After raising the salary");
        /**
         * Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась.
         */
        for (Employee emp : employees) {
            Director.updateSalary(emp);
            System.out.println(emp.toString());
        }

    }


}