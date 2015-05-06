package by.epam.training.task05.dao;

import by.epam.training.task05.dao.impl.DomDaoXML;
import by.epam.training.task05.dao.impl.SaxDaoXML;
import by.epam.training.task05.dao.impl.StaxDaoXML;

/**
 * Created by higgs on 03.05.15.
 */
public class DaoXMLFactory {
    private final static DaoXMLFactory instance = new DaoXMLFactory();

    private DaoXMLFactory() {
    }

    public static DaoXMLFactory getInstance() {
        return instance;
    }

    public DaoXML getDAO(String parserType) throws DaoException {
        switch (parserType) {
            case "DOM":
                return DomDaoXML.getInstance();
            case "SAX":
                return SaxDaoXML.getInstance();
            case "STAX":
                return StaxDaoXML.getInstance();
            default:
                throw new DaoException("No such parser: " + parserType);
        }
    }

}
