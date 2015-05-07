package by.epam.training.task05.dao.impl;

import by.epam.training.task05.dao.DaoException;
import by.epam.training.task05.dao.DaoXML;
import by.epam.training.task05.entity.Bank;
import by.epam.training.task05.entity.DepositType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DomDaoXML implements DaoXML {
    private static DaoXML instance = new DomDaoXML();

    public static DaoXML getInstance() {
        return instance;
    }

    private DomDaoXML() {
    }

    @Override
    public List<Bank.Deposit> read(String fileName) throws DaoException {
        List<Bank.Deposit> deposits = new ArrayList<>();

        File xmlFile = new File(fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        Document doc;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
        } catch (ParserConfigurationException e) {
            throw new DaoException("Dom dao parser configuration problem!", e);
        } catch (SAXException e) {
            throw new DaoException("Dom dao parser problem!", e);
        } catch (IOException e) {
            throw new DaoException("Dom dao io problems!", e);
        }

        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("deposit");

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                deposits.add(parseSingleDeposit((Element) nNode));
            }
        }
        return deposits;
    }

    public Bank.Deposit parseSingleDeposit(Element element) {
        Bank.Deposit result = new Bank.Deposit();

        String deposit_id = element.getAttribute("deposit_id");
        result.setDepositId(deposit_id);
        String bankName = String.valueOf(element.getElementsByTagName("bank_name").item(0).getTextContent());
        result.setBankName(bankName);
        String registrationCountry = String.valueOf(element.getElementsByTagName("registration_country").item(0).getTextContent());
        result.setRegistrationCountry(registrationCountry);
        DepositType depositType = DepositType.valueOf(element.getElementsByTagName("deposit_type").item(0).getTextContent().toUpperCase());
        result.setDepositType(depositType);
        String depositor = String.valueOf(element.getElementsByTagName("depositor").item(0).getTextContent());
        result.setDepositor(depositor);
        Integer account_id = Integer.parseInt(element.getElementsByTagName("account_id").item(0).getTextContent());
        result.setAccountId(account_id);
        Double amount_of_deposit = Double.valueOf(element.getElementsByTagName("amount_of_deposit").item(0).getTextContent());
        result.setAmountOfDeposit(amount_of_deposit);
        Double profitability = Double.valueOf(element.getElementsByTagName("profitability").item(0).getTextContent());
        result.setProfitability(profitability);
        String timeConstraints = String.valueOf(element.getElementsByTagName("time_constraints").item(0).getTextContent());
        result.setTimeConstraints(timeConstraints);

        return result;
    }
}
