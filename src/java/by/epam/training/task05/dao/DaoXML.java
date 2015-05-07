package by.epam.training.task05.dao;

import by.epam.training.task05.entity.Bank;

import java.util.List;


public interface DaoXML {
    public List<Bank.Deposit> read(String fileName) throws DaoException;

}
