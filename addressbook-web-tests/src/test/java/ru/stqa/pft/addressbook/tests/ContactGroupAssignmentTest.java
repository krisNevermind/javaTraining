package ru.stqa.pft.addressbook.tests;

import net.bytebuddy.utility.RandomString;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.NewContactData;

import static net.bytebuddy.utility.RandomString.make;

public class ContactGroupAssignmentTest extends TestBase {

        @Test
        public void addContactToGroup(){
            //create new group with a unique name
            app.goTo().groupPage();
            GroupData groupForAssignment = new GroupData();
            String randomGroupPrefix = generateRandomPrefix(15);
            app.group().create(groupForAssignment.withName("Group_"+randomGroupPrefix).withHeader("header").withFooter("footer"));

            //create new contact with a unique first name
            app.contact().returnHome();
            NewContactData contactToGroup = new NewContactData();
            app.goTo().addNewContact();
            String randomFNamePrefix = generateRandomPrefix(15);
            app.contact().createContact(contactToGroup.withFirstName("Contact_"+randomFNamePrefix).withLastName("ContactToGroupLN")
                    .withMobilePhone("MobilePhone").withEmail("email@email.com").withAddress("address"));

            //add contact to group
            app.contact().returnHome();
            app.contact().selectContactByFName(randomFNamePrefix);
            app.contact().selectGroupForAssignment("Group_"+randomGroupPrefix);

            //verification

            //remove contact from group
            app.contact().returnHome();
            app.contact().selectGroupToViewAssignments("Group_"+randomGroupPrefix);
            app.contact().selectContactByFName(randomFNamePrefix);
            app.contact().removeContactFromGroup();

            //verification

        }
}