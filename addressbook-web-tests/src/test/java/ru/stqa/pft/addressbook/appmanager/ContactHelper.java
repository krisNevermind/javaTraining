package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitNewContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillInContactData(NewContactData newContactData) {
        type(By.name("firstname"), newContactData.getFirstName());
        type(By.name("lastname"), newContactData.getLastName());
        type(By.name("email"), newContactData.getEmail());
        type(By.name("mobile"), newContactData.getMobilePhone());
        type(By.name("address"), newContactData.getAddress());
 //       attach(By.xpath("//input[@name='photo']"), newContactData.getPhoto());
    }

    public void deleteSelectedContact() {

        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='"+id+"']")).click();
    }

    public void selectContactByFName(String contactPrefix) {
        wd.findElement(By.xpath("//td[contains(text(), '"+contactPrefix+"')]//preceding-sibling::td[@class='center']//input")).click();
    }

    public void openContactForEditingById(int id) {
        wd.findElement(By.xpath("//input[@value='"+id+"']//ancestor::td//following-sibling::td//img[@title='Edit']")).click();
    }

    public void openContactForEditing(int index) {
        wd.findElements(By.xpath("//img[@title='Edit']")).get(index).click();
        //click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void createContact(NewContactData contact) {
        fillInContactData(contact);
        submitNewContact();
        contactCache = null;
    }

    public boolean isThereContact() {
    return isElementPresent(By.name("selected[]"));
    }

    public List<NewContactData> getContactList() {
        List<NewContactData> contacts = new ArrayList<NewContactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.xpath(".//td[@class='center']//input")).getAttribute("value"));
            String lastName = element.findElement(By.xpath(".//td[2]")).getText();
            String firstName = element.findElement(By.xpath(".//td[3]")).getText();
            contacts.add(new NewContactData().withId(id).withFirstName(firstName).withLastName(lastName));
        }
        return contacts;
    }

    public Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.xpath(".//td[@class='center']//input")).getAttribute("value"));
            String lastName = element.findElement(By.xpath(".//td[2]")).getText();
            String firstName = element.findElement(By.xpath(".//td[3]")).getText();
//            String[] phones = element.findElement(By.xpath(".//td[6]")).getText().split("\n");
//            contactCache.add(new NewContactData().withId(id).withFirstName(firstName).withLastName(lastName).withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
            String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
            String address = element.findElement(By.xpath(".//td[4]")).getText();
            String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
            contactCache.add(new NewContactData().withId(id).withFirstName(firstName).withLastName(lastName).withAllPhones(allPhones).withAddress(address).withAllEmails(allEmails));
        }
        return new Contacts(contactCache);
    }

    public void returnHome() {
        click(By.xpath("//a[text()='home']"));
    }

    public void modifyContact(NewContactData contact) {
        openContactForEditingById(contact.getId());
        fillInContactData(contact);
        submitContactModification();
        contactCache = null;
        returnHome();
    }

    public void deleteContact(int index) {
        selectContact(index);
        deleteSelectedContact();
    }

    public void deleteContact(NewContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        contactCache = null;
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public NewContactData infoFromEditForm(NewContactData contact) {
        openContactForEditingById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        wd.navigate().back();
        return new NewContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
                .withAddress(address).withEmail(email).withEmail2(email2).withEmail3(email3);
    }

    public void selectGroupForAssignment(String groupName){
        Select ddl = new Select(wd.findElement(By.name("to_group")));
        ddl.selectByVisibleText(groupName);
        wd.findElement(By.name("add")).click();
    }

    public void selectGroupToViewAssignments(String groupName){
        Select ddl = new Select(wd.findElement(By.name("group")));
        ddl.selectByVisibleText(groupName);
    }

    public void removeContactFromGroup(){
        wd.findElement(By.xpath("//input[contains(@value, 'Remove from')]")).click();
    }
}
