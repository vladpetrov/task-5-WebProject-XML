package by.epam.training.task05.logic.impl;

import by.epam.training.task05.dao.DaoException;
import by.epam.training.task05.dao.DaoXML;
import by.epam.training.task05.dao.DaoXMLFactory;
import by.epam.training.task05.entity.Bank;
import by.epam.training.task05.logic.Command;
import by.epam.training.task05.logic.CommandException;
import by.epam.training.task05.util.FileXML;
import by.epam.training.task05.util.JspPage;
import by.epam.training.task05.util.RequestParameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by higgs on 03.05.15.
 */
public class LoadCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        DaoXML dao;
        String parserType = request.getParameter(RequestParameters.PARSER_TYPE);
        try {
            dao = DaoXMLFactory.getInstance().getDAO(parserType);
        } catch (DaoException e) {
            throw new CommandException("Load command file access problem!", e);
        }

        List<Bank.Deposit> deposits;
        try {
            deposits = dao.read(FileXML.FILE_ABS_LOCATION);
        } catch (DaoException e) {
            throw new CommandException("Load command file read problem!", e);
        }

        request.setAttribute(RequestParameters.PARSER_TYPE, parserType);
        request.setAttribute(RequestParameters.DEPOSITS_LIST, deposits);

        return JspPage.TABLE_PAGE;
    }

}
