package lt.code.academy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputPerson {
    String name;
    String surname;
    String personalNumber;

    public InputPerson(ReadFile readFile) {
        boolean userNotExist = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name: ");
        name = sc.nextLine();
        System.out.println("Input surname: ");
        surname = sc.nextLine();
        System.out.println("Input personal number: ");
        personalNumber = sc.nextLine();

        if (readFile != null) {
            for (int i = 0; i < readFile.persons.size(); i++) {
                if (name.equals(readFile.persons.get(i).name()) &&
                        surname.equals(readFile.persons.get(i).surname()) &&
                        personalNumber.equals(readFile.persons.get(i).personalNumber())) {
                    userNotExist = false;
                }
            }
        }

        if (userNotExist) {
            readFile.addPerson(new Person(name, surname, personalNumber));
            System.out.println("Person successfully added...");
        } else {
            System.out.println("User already exist...");
        }

    }
}
