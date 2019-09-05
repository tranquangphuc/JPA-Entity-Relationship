package jpa;

import static org.junit.Assert.assertTrue;

import jpa.entity.Customer;
import jpa.entity.Profile;
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
        TypedQuery<Profile> q = em.createQuery("SELECT p FROM Profile p", Profile.class);
        List<Profile> profiles = q.getResultList();
        System.out.println(profiles.size());
        for (Profile p : profiles) {
            System.out.println(p);
            System.out.println(p.getCustomer());
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
