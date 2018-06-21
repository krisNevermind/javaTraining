package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {

        goToGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("testGroup1", "testDataHeader", "testDataFooter"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
