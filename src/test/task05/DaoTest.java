package task05;

import by.epam.training.task05.dao.DaoException;
import by.epam.training.task05.dao.impl.DomDaoXML;
import by.epam.training.task05.dao.impl.SaxDaoXML;
import by.epam.training.task05.dao.impl.StaxDaoXML;
import by.epam.training.task05.entity.Bank;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by higgs on 05.05.15.
 */
@Ignore
public class DaoTest {

    @Test
    public void testDomDao() {
        List<Bank.Deposit> deposits = new ArrayList<>();
        try {
            deposits = DomDaoXML.getInstance().read("src/main/webapp/xml/bank.xml");
        } catch (DaoException e) {
            fail("Dom dao test fails. Reason - " + e);
        }

        for(Bank.Deposit deposit : deposits) {
            assertNotNull("Deposit is null!", deposit);
        }
    }

    @Test
    public void testSaxDao() {
        List<Bank.Deposit> deposits = new ArrayList<>();
        try {
            deposits = SaxDaoXML.getInstance().read("src/main/webapp/xml/bank.xml");
        } catch (DaoException e) {
            fail("Dom dao test fails. Reason - " + e);
        }

        for(Bank.Deposit deposit : deposits) {
            assertNotNull("Deposit is null!", deposit);
        }
    }

    @Test
    public void testStaxDao() {
        List<Bank.Deposit> deposits = new ArrayList<>();
        try {
            deposits = StaxDaoXML.getInstance().read("src/main/webapp/xml/bank.xml");
        } catch (DaoException e) {
            fail("Dom dao test fails. Reason - " + e);
        }

        for(Bank.Deposit deposit : deposits) {
            assertNotNull("Deposit is null!", deposit);
        }
    }

}
