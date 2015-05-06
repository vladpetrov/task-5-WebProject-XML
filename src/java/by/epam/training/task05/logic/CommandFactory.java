package by.epam.training.task05.logic;

import by.epam.training.task05.dao.DaoException;
import by.epam.training.task05.logic.impl.ErrorCommand;
import by.epam.training.task05.logic.impl.LoadCommand;

/**
 * Created by higgs on 03.05.15.
 */
public class CommandFactory {
    private static CommandFactory instance = new CommandFactory();

    public static CommandFactory getInstance() {
        return instance;
    }

    private CommandFactory() {
    }

    private static final String LOAD_COMMAND = "load";

    public Command getCommand(String commandName) throws DaoException {
        switch (commandName) {
            case LOAD_COMMAND:
                return new LoadCommand();
            default:
                return new ErrorCommand();
        }
    }


}
