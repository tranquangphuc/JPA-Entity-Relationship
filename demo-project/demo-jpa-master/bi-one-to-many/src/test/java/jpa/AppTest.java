package jpa;

import static org.junit.Assert.assertTrue;

import jpa.entity.CustomerOrder;
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
        TypedQuery<CustomerOrder> q = em.createQuery("SELECT o FROM CustomerOrder o", CustomerOrder.class);
        List<CustomerOrder> orders = q.getResultList();
        System.out.println(orders.size());
        for (CustomerOrder o : orders) {
            System.out.println(o);
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
