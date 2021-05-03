package ejbLookupExample;


import junit.framework.TestCase;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

//START SNIPPET: code
public class EjbDependencyTest extends TestCase {

    private Context context;

    protected void setUp() throws Exception {
        context = EJBContainer.createEJBContainer().getContext();
        System.out.println(context);
    }

    public void testRed() throws Exception {

        final Friend red = (Friend) context.lookup("java:global/ejbLookupExample/RedBean");

        assertNotNull(red);
        assertEquals("Red says, Hello!", red.sayHello());
        assertEquals("My friend Blue says, Hello!", red.helloFromFriend());

    }

    public void testBlue() throws Exception {

        final Friend blue = (Friend) context.lookup("java:global/ejbLookupExample/BlueBean");

        assertNotNull(blue);
        assertEquals("Blue says, Hello!", blue.sayHello());
        assertEquals("My friend Red says, Hello!", blue.helloFromFriend());

    }

}