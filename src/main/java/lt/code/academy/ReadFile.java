package lt.code.academy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    List<Person> persons = new ArrayList<>();

    public ReadFile(File file) {

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Cannot create new file " + e.getMessage());
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            persons = mapper.readValue(file, Users.class).users();
        } catch (IOException e) {
            System.out.println("Cannot read file " + e.getMessage());
        }
    }

    void printAll() {
        for (int i = 0; i < persons.size(); i++) {
            System.out.println(persons.get(i));
        }
    }

    void addPerson(Person person) {
        persons.add(person);
    }
}
