package WebTest;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Web.Web;
public class WebTest {
	private Web web;

    @Before
    public void setUp() {
        web = new Web();
        web.invokeBrowser();
    }

    @After
    public void tearDown() {
      web.closeBrowser();
    }

    @Test
    public void testTestingWebsiteTitle() {
        String expectedTitle = "Boutique de chaussures et d'articles de sport en Tunisie";
        String actualTitle = web.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }
    @Test
    public void testLoginSuccessfully() {
        web.login("aimenguedhami6@gmail.com", "Aymen123");
        assertEquals("Mon compte", web.getTitle());
    }

  @Test
    public void testLoginWithFalsePassword() {
        web.login("aimenguedhami6@gmail.com", "Aymen1234");
        assertEquals("Identifiant", web.getTitle());

    }

    @Test
    public void testEditingAccountInformation() {
        web.login("aimenguedhami6@gmail.com", "Aymen123");
        web.modify("Aimen","Medtech","Aymen123");
        assertEquals("Identité", web.getTitle());
    }
    
    @Test
    public void testLogoutFeature() {
        web.login("aimenguedhami6@gmail.com", "Aymen123");
        web.logout();
        assertEquals("Identifiant", web.getTitle());
    }
    
}
