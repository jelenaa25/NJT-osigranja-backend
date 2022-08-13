/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.osiguranja.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Korisnik
 */
public class PolisaTest {
    
    public PolisaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPolisaID method, of class Polisa.
     */
    @Test
    public void testGetPolisaID() {
        System.out.println("getPolisaID");
        Polisa instance = new Polisa();
        int expResult = 0;
        int result = instance.getPolisaID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKlijent method, of class Polisa.
     */
    @Test
    public void testGetKlijent() {
        System.out.println("getKlijent");
        Polisa instance = new Polisa();
        Klijent expResult = null;
        Klijent result = instance.getKlijent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPovrsinaStana method, of class Polisa.
     */
    @Test
    public void testGetPovrsinaStana() {
        System.out.println("getPovrsinaStana");
        Polisa instance = new Polisa();
        BigDecimal expResult = null;
        BigDecimal result = instance.getPovrsinaStana();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVrednostPoKvM method, of class Polisa.
     */
    @Test
    public void testGetVrednostPoKvM() {
        System.out.println("getVrednostPoKvM");
        Polisa instance = new Polisa();
        BigDecimal expResult = null;
        BigDecimal result = instance.getVrednostPoKvM();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGradjevinskaVrednost method, of class Polisa.
     */
    @Test
    public void testGetGradjevinskaVrednost() {
        System.out.println("getGradjevinskaVrednost");
        Polisa instance = new Polisa();
        BigDecimal expResult = null;
        BigDecimal result = instance.getGradjevinskaVrednost();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUkupnaPremija method, of class Polisa.
     */
    @Test
    public void testGetUkupnaPremija() {
        System.out.println("getUkupnaPremija");
        Polisa instance = new Polisa();
        BigDecimal expResult = null;
        BigDecimal result = instance.getUkupnaPremija();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDatumOD method, of class Polisa.
     */
    @Test
    public void testGetDatumOD() {
        System.out.println("getDatumOD");
        Polisa instance = new Polisa();
        Date expResult = null;
        Date result = instance.getDatumOD();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDatumDO method, of class Polisa.
     */
    @Test
    public void testGetDatumDO() {
        System.out.println("getDatumDO");
        Polisa instance = new Polisa();
        Date expResult = null;
        Date result = instance.getDatumDO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAgentOsiguranja method, of class Polisa.
     */
    @Test
    public void testGetAgentOsiguranja() {
        System.out.println("getAgentOsiguranja");
        Polisa instance = new Polisa();
        Agent expResult = null;
        Agent result = instance.getAgentOsiguranja();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStavkePolise method, of class Polisa.
     */
    @Test
    public void testGetStavkePolise() {
        System.out.println("getStavkePolise");
        Polisa instance = new Polisa();
        List<StavkaPolise> expResult = null;
        List<StavkaPolise> result = instance.getStavkePolise();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPolisaID method, of class Polisa.
     */
    @Test
    public void testSetPolisaID() {
        System.out.println("setPolisaID");
        int polisaID = 0;
        Polisa instance = new Polisa();
        instance.setPolisaID(polisaID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKlijent method, of class Polisa.
     */
    @Test
    public void testSetKlijent() {
        System.out.println("setKlijent");
        Klijent klijent = null;
        Polisa instance = new Polisa();
        instance.setKlijent(klijent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPovrsinaStana method, of class Polisa.
     */
    @Test
    public void testSetPovrsinaStana() {
        System.out.println("setPovrsinaStana");
        BigDecimal povrsinaStana = null;
        Polisa instance = new Polisa();
        instance.setPovrsinaStana(povrsinaStana);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVrednostPoKvM method, of class Polisa.
     */
    @Test
    public void testSetVrednostPoKvM() {
        System.out.println("setVrednostPoKvM");
        BigDecimal vrednostPoKvM = null;
        Polisa instance = new Polisa();
        instance.setVrednostPoKvM(vrednostPoKvM);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGradjevinskaVrednost method, of class Polisa.
     */
    @Test
    public void testSetGradjevinskaVrednost() {
        System.out.println("setGradjevinskaVrednost");
        BigDecimal gradjevinskaVrednost = null;
        Polisa instance = new Polisa();
        instance.setGradjevinskaVrednost(gradjevinskaVrednost);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUkupnaPremija method, of class Polisa.
     */
    @Test
    public void testSetUkupnaPremija() {
        System.out.println("setUkupnaPremija");
        BigDecimal ukupnaPremija = null;
        Polisa instance = new Polisa();
        instance.setUkupnaPremija(ukupnaPremija);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDatumOD method, of class Polisa.
     */
    @Test
    public void testSetDatumOD() {
        System.out.println("setDatumOD");
        Date datumOD = null;
        Polisa instance = new Polisa();
        instance.setDatumOD(datumOD);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDatumDO method, of class Polisa.
     */
    @Test
    public void testSetDatumDO() {
        System.out.println("setDatumDO");
        Date datumDO = null;
        Polisa instance = new Polisa();
        instance.setDatumDO(datumDO);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAgentOsiguranja method, of class Polisa.
     */
    @Test
    public void testSetAgentOsiguranja() {
        System.out.println("setAgentOsiguranja");
        Agent agentOsiguranja = null;
        Polisa instance = new Polisa();
        instance.setAgentOsiguranja(agentOsiguranja);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStavkePolise method, of class Polisa.
     */
    @Test
    public void testSetStavkePolise() {
        System.out.println("setStavkePolise");
        List<StavkaPolise> stavkePolise = null;
        Polisa instance = new Polisa();
        instance.setStavkePolise(stavkePolise);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Polisa.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Polisa instance = new Polisa();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of canEqual method, of class Polisa.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        Polisa instance = new Polisa();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Polisa.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Polisa instance = new Polisa();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Polisa.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Polisa instance = new Polisa();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
