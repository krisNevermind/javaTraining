package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander= new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex){
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<NewContactData> contacts = generateContacts(count);
        save(contacts, new File(file));
    }

    private void save(List<NewContactData> contacts, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (NewContactData contact : contacts){
            writer.write(String.format("%s;%s;%s;%s;%s\n", contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getMobilePhone(), contact.getAddress()));
        }
        writer.close();
    }

    private List<NewContactData> generateContacts(int count) {
        List<NewContactData> contacts = new ArrayList<NewContactData>();
        for (int i = 0; i < count; i++){
            contacts.add(new NewContactData().withFirstName(String.format("firstName %s", i)).withLastName(String.format("lastName %s", i))
                    .withEmail(String.format("email %s", i)).withMobilePhone(String.format("mobilPhone %s", i)).withAddress(String.format("address %s", i)));
        }
        return contacts;
    }
}
