package by.epam.training.task05.logic.impl;

import by.epam.training.task05.logic.Command;
import by.epam.training.task05.logic.CommandException;
import by.epam.training.task05.util.JspPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by higgs on 03.05.15.
 */
public class ErrorCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        return JspPage.ERROR_PAGE;
    }

}
