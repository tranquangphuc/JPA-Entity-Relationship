package many.many.bi;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private static final String PERSISTENCE_UNIT_NAME = "many-many-bi";

    private static EntityManagerFactory factory;
    private EntityManager em;

    @BeforeClass
    public static void setup() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    @Before
    public void init() {
        em = factory.createEntityManager();
    }

    @Test
    public void testSelect() {
        TypedQuery<Tag> q = em.createQuery("SELECT t FROM Tag t", Tag.class);
        List<Tag> tags = q.getResultList();
        System.out.println(tags.size());
        for (Tag t : tags) {
            System.out.println(t);
        }
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
