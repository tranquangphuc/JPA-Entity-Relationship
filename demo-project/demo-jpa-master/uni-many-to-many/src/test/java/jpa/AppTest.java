package jpa;

import static org.junit.Assert.assertTrue;

import jpa.entity.Product;
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
        TypedQuery<Product> q = em.createQuery("SELECT p FROM Product p", Product.class);
        List<Product> products = q.getResultList();
        System.out.println(products.size());
        for (Product p : products) {
            System.out.println(p);
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
