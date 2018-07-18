package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.xml"));
        String xml = "";
        String line = reader.readLine();
        while (line != null){
            xml += line;
 //           String[] split = line.split(";");
 //           list.add(new Object[] {new NewContactData().withFirstName(split[0]).withLastName(split[1]).withEmail(split[2]).withMobilePhone(split[3]).withAddress(split[4])});
            line = reader.readLine();
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(NewContactData.class);
        List<NewContactData> contacts = (List<NewContactData>) xstream.fromXML(xml);
        return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
  //      return list.iterator();
    }

    @Test (dataProvider = "validContacts")
    public void testContactCreation(NewContactData contact) {
        Contacts before = app.contact().all();
        app.goTo().addNewContact();
        File photo = new File ("src/test/resources/picture.png");
        app.contact().createContact(contact);
        app.returnToHomePage();
        assertThat(app.contact().count(), equalTo(before.size() +1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }

    @Test (enabled = false)
    public void testCurrentDir(){ File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File ("src/test/resources/picture.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }

}