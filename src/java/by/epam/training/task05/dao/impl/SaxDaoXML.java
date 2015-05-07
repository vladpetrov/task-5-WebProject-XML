package by.epam.training.task05.dao.impl;

import by.epam.training.task05.dao.DaoException;
import by.epam.training.task05.dao.DaoXML;
import by.epam.training.task05.entity.Bank;
import by.epam.training.task05.entity.DepositType;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SaxDaoXML extends DefaultHandler implements DaoXML {
    private static DaoXML instance = new SaxDaoXML();

    public static DaoXML getInstance() {
        return instance;
    }

    private SaxDaoXML(){
    }

    private String depositId;
    private String bankName;
    private String registrationCountry;
    private DepositType depositType;
    private String depositor;
    private Integer accountId;
    private Double amountOfDeposit;
    private Double profitability;
    private String timeConstraints;
    private List<Bank.Deposit> deposits;
    private String currentElement;

    @Override
    public List<Bank.Deposit> read(String fileName) throws DaoException {
        deposits = new ArrayList<>();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File(fileName), this);
        } catch (ParserConfigurationException e){
            throw new DaoException("Sax dao parser bad configuration!", e);
        } catch (SAXException e){
            throw new DaoException("Sax dao parser problem!", e);
        } catch (IOException e){
            throw new DaoException("Sax dao io problem!", e);
        }
        return deposits;
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        currentElement = qName;
        if (qName.equals("deposit")){
            depositId = atts.getValue("deposit_id");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement.equals("bank_name")) {
            bankName = String.valueOf(new String(ch, start, length));
        }
        if (currentElement.equals("registration_country")) {
            registrationCountry = String.valueOf(new String(ch, start, length));
        }
        if (currentElement.equals("deposit_type")) {
            depositType = DepositType.valueOf(new String(ch, start, length).toUpperCase());
        }
        if (currentElement.equals("depositor")) {
            depositor = String.valueOf(new String(ch, start, length));
        }
        if (currentElement.equals("account_id")) {
            accountId = Integer.parseInt(new String(ch, start, length));
        }
        if (currentElement.equals("amount_of_deposit")) {
            amountOfDeposit = Double.valueOf(new String(ch, start, length));
        }
        if (currentElement.equals("profitability")) {
            profitability = Double.valueOf(new String(ch, start, length));
        }
        if (currentElement.equals("time_constraints")) {
            timeConstraints = String.valueOf(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        currentElement = "";
        if (qName.equals("deposit")) {
            Bank.Deposit deposit = new Bank.Deposit();
            deposit.setDepositId(depositId);
            deposit.setBankName(bankName);
            deposit.setRegistrationCountry(registrationCountry);
            deposit.setDepositType(depositType);
            deposit.setDepositor(depositor);
            deposit.setAccountId(accountId);
            deposit.setAmountOfDeposit(amountOfDeposit);
            deposit.setProfitability(profitability);
            deposit.setTimeConstraints(timeConstraints);
            deposits.add(deposit);
        }
    }

}
