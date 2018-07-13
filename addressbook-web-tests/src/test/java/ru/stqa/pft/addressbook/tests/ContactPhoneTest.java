package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NewContactData;

public class ContactPhoneTest extends TestBase {

    @Test
    public void testContactPhones(){
        app.goTo().goToToHomePage();
        NewContactData contact = app.contact().all().iterator().next();
        NewContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    }

}
