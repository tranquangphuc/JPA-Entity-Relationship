package one.one.bi;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class OneToOneBiTest
{
    private static final String PERSISTENCE_UNIT_NAME = "one-one-bi";

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
        TypedQuery<Customer> q = em.createQuery("SELECT c FROM Customer c", Customer.class);
        List<Customer> customers = q.getResultList();
        System.out.println(customers.size());
        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    @Test
    @Transactional
    public void testInsert() {
        long countBefore = countCustomer();

        em.getTransaction().begin();

        Customer c = new Customer();
        c.setName("Henry");
        c.setEmail("henry@mail.com");
        c.setCreatedDate(Date.valueOf(LocalDate.now()));

        em.persist(c);
        em.getTransaction().commit();

        long countAfter = countCustomer();

        assertEquals(1, countAfter - countBefore);

        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    @Test
    @Transactional
    public void testInsertCascade() {
        long countBefore = countCustomer();

        em.getTransaction().begin();

        Customer c = new Customer();
        c.setName("Henry");
        c.setEmail("henry@mail.com");
        c.setCreatedDate(Date.valueOf(LocalDate.now()));

        Profile p = new Profile();
        p.setStreetName("CMT8");
        p.setStreetNumber("379");
        p.setCity("TDM");
        p.setDistrict("HT");

        p.setCustomer(c);
        c.setProfile(p);

        em.persist(c);
        em.getTransaction().commit();

        long countAfter = countCustomer();

        assertEquals(1, countAfter - countBefore);

        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    private long countCustomer() {
        return em.createQuery("SELECT COUNT(c) FROM Customer c", Long.class).getSingleResult();
    }
}
