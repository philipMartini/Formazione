package org.filippo.formazione.methodreference;



import java.util.function.Supplier;

import org.filippo.formazione.data.Student;

public class SupplierMethodReferenceExample {

    static Supplier<Student> studentSupplier = Student::new;

    public static void main(String[] args) {

        System.out.println(studentSupplier.get());

    }
}
