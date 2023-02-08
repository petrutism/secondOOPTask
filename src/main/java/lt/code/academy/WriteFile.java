package lt.code.academy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class WriteFile {
    Users users;

    public WriteFile(Users users, File file) {
        this.users = users;

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(file, users);
        } catch (IOException e) {
            System.out.println("Cannot write file " + e.getMessage());
        }
    }
}

