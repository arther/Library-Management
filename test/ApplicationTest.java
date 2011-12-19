import org.junit.*;
import play.test.*;
import play.mvc.*;
import play.mvc.Http.*;
import models.*;

public class ApplicationTest extends FunctionalTest {

    @Test
    public void testThatIndexPageWorks() {
        Response response = GET("/");
        assertIsOk(response);
        assertContentType("text/html", response);
        assertCharset(play.Play.defaultWebEncoding, response);
    }
    
    @Test
    public void testThatGetCreatorForSearchWorks(){
    	Response response = GET("/getcreatorforsearch");
    	assertIsOk(response);
    }
    
    @Test
    public void testThatGetItemListByCreatorWorks(){
    	Response response = GET("/getitemlistbycreator");
    	assertIsOk(response);
    }
}