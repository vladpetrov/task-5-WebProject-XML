package by.epam.training.task05.dao;

import by.epam.training.task05.entity.Bank;

import java.util.List;

/**
 * Created by higgs on 03.05.15.
 */
public interface DaoXML {
    public List<Bank.Deposit> read(String fileName) throws DaoException;

}
