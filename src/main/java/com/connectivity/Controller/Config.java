package com.connectivity.Controller;

import com.connectivity.Controller.Commands.*;

public enum Config {
    home(new CommandMain()),
    login(new LoginForm()),
    CommandLogin(new CommandLogin()),
    register(new RegisterForm()),
    commandRegister(new CommandRegister()),
    booksList(new CommandBooksList()),
    usersList(new CommandUsersList()),
    deleteUser(new CommandDeleteUser()),
    commandGiveAdmin(new CommandGiveAdmin()),
    logOut(new CommandLogOut()),
    deleteBook(new CommandDeleteBook()),
    addBook(new CommandAddBook()),
    addGenreToBook(new CommandAddGenreToBook()),
    genresList(new CommandGenresList());


    private final ICommand command;

    Config(ICommand command) {
        this.command = command;
    }

    public ICommand getCommand() {
        return command;
    }
}
