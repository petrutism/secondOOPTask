package lt.code.academy;

import java.io.File;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        File file = new File("persons.json");
        Test to = new Test();
        ReadFile rf = null;

        if (file.exists()) {
            rf = new ReadFile(file);
        }
        to.selectAction(file, rf);
    }

    void selectAction(File file, ReadFile rf) {
        Scanner sc = new Scanner(System.in);
        String action = "";
        do {
            menu();
            action = sc.nextLine();
            switch (action) {
                case "1" -> inputAction(rf);
                case "2" -> {
                    if (rf == null) {
                        System.out.println("There is nothing to print...");
                    } else {
                        rf.printAll();
                    }
                    ;
                }
                case "3" -> endOfProgram(file, rf);
                default -> System.out.println("There is no such action...");
            }
        } while (!action.equals("3"));
    }

    void endOfProgram(File file, ReadFile readFile) {
        if (readFile != null) {
            Users users = new Users(readFile.persons);
            new WriteFile(users, file);
        } else {
            System.out.println("Finishing without write...");
        }
        System.out.println("GOOD BYE...");
    }

    void inputAction(ReadFile rf) {
        new InputPerson(rf);
    }

    void menu() {
        String text = """
                1 -> input user
                2 -> print all users
                3 -> End
                """;
        System.out.println(text);
    }
}
