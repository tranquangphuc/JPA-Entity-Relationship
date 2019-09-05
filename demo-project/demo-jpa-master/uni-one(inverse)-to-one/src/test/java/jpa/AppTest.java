package jpa;

import static org.junit.Assert.assertTrue;

import jpa.entity.Customer;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.*;
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
        TypedQuery<Customer> q = em.createQuery("SELECT c FROM Customer c", Customer.class);
        List<Customer> customers = q.getResultList();
        System.out.println(customers.size());
        for (Customer c : customers) {
            System.out.println(c.getProfile());
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
