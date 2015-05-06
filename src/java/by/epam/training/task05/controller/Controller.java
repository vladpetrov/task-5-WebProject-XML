package by.epam.training.task05.controller;

import by.epam.training.task05.dao.DaoException;
import by.epam.training.task05.logic.Command;
import by.epam.training.task05.logic.CommandException;
import by.epam.training.task05.logic.CommandFactory;
import by.epam.training.task05.util.JspPage;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by higgs on 03.05.15.
 */
public class Controller extends HttpServlet {
    private static Logger log = Logger.getLogger(Controller.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.getRequestDispatcher(JspPage.INDEX_PAGE).forward(request, response);
        } catch (ServletException | IOException e) {
            log.error("Error when forwarding page - " + JspPage.INDEX_PAGE, e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = null;
        try {
            command = CommandFactory.getInstance().getCommand(request.getParameter("command"));
        } catch (DaoException e) {
            log.error("Error when getting a command!", e);
        }

        String page;
        try {
            page = command.execute(request, response);
        } catch (CommandException e) {
            log.error("Error when executing command! " + e);
            request.setAttribute("error", e.getMessage());
            page = JspPage.ERROR_PAGE;
        }

        try {
            request.getRequestDispatcher(page).forward(request, response);
        } catch (ServletException | IOException e) {
            log.error("Error when forwarding page - " + page);
        }
    }

}
