package com.company.Commands;

import com.company.ClientOutput;
import com.company.CommandExecuter;
import com.company.Main;

public class Clear implements CommandExecuter {
    @Override
    public void Execute(String command) throws Exception {
        Main.ticket.clear();
        ClientOutput.print("Список очищен");
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
