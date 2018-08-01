package ru.stqa.pft.mantis.tests;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangePasswordByAdmin extends TestBase {

    @BeforeMethod
    public void startMailServer(){
        app.mail().start();
    }

    @Test
    //login as admin, select a user, reset user password
    public void testChangePasswordByAdmin () throws IOException, MessagingException {
    app.passwordHelper().loginUI("administrator", "root");
    app.passwordHelper().navigateToUserManagement();
    app.passwordHelper().selectSomeUser();
    String userEmail = app.passwordHelper().extractUserEmail();
    String userName = app.passwordHelper().extractUserName();
    app.passwordHelper().resetUserPassword();

    //extract confirmation link
    String newPassword = "password2";
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = findConfirmationLink(mailMessages, userEmail);
    app.registration().resetPassword(confirmationLink, newPassword);

    //verify user login with new password
    HttpSession session = app.newSession();
    assertTrue(session.login(userName, newPassword));
    assertTrue(session.isLoggedInAs(userName));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }
}
