package by.epam.training.task05.logic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by higgs on 03.05.15.
 */
public interface Command {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException;
}
