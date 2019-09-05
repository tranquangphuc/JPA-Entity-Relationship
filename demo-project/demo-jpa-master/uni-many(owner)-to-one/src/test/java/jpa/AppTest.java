package jpa;

import static org.junit.Assert.assertTrue;

import jpa.entity.LineItem;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private static final String PERSISTENCE_UNIT_NAME = "order_database";

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
    public void testDatabase() {
        TypedQuery<LineItem> q = em.createQuery("SELECT i FROM LineItem i", LineItem.class);
        List<LineItem> items = q.getResultList();
        System.out.println(items.size());
//        for (LineItem i : items) {
//            System.out.println(i);
//        }
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
