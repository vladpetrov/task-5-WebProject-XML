package by.epam.training.task05.dao.impl;

import by.epam.training.task05.dao.DaoException;
import by.epam.training.task05.dao.DaoXML;
import by.epam.training.task05.entity.Bank;
import by.epam.training.task05.entity.DepositType;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by higgs on 03.05.15.
 */
public class StaxDaoXML implements DaoXML {
    private static DaoXML instance = new StaxDaoXML();

    public static DaoXML getInstance() {
        return instance;
    }

    private StaxDaoXML() {
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

    @Override
    public List<Bank.Deposit> read(String fileName) throws DaoException {
        List<Bank.Deposit> deposits = new ArrayList<>();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(
                    new FileInputStream(fileName));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("deposit")) {
                        Attribute idAttr = startElement.getAttributeByName(new QName("deposit_id"));
                        if (idAttr != null) {
                            depositId = idAttr.getValue();
                        }
                    } else if (startElement.getName().getLocalPart().equals("bank_name")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        bankName = String.valueOf(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("registration_country")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        registrationCountry = String.valueOf(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("deposit_type")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        depositType = DepositType.valueOf(xmlEvent.asCharacters().getData().toUpperCase());
                    } else if (startElement.getName().getLocalPart().equals("depositor")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        depositor = String.valueOf(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("account_id")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        accountId = Integer.parseInt(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("amount_of_deposit")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        amountOfDeposit = Double.valueOf(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("profitability")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        profitability = Double.valueOf(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("time_constraints")) {
                        xmlEvent = xmlEventReader.nextEvent();
                        timeConstraints = String.valueOf(xmlEvent.asCharacters().getData());
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("deposit")) {
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

        } catch (FileNotFoundException e) {
            throw new DaoException("Stax dao incorrect file path!", e);
        } catch (XMLStreamException e) {
            throw new DaoException("Stax dao xml stream problem!", e);
        }
        return deposits;
    }

}
