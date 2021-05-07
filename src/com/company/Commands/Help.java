package com.company.Commands;

import com.company.ClientOutput;
import com.company.CommandExecuter;
import com.company.Main;

public class Help implements CommandExecuter {
    @Override
    public void Execute(String command) {
        for (CommandExecuter a: Main.commands) {
            ClientOutput.print("Команда: " + a.getName());
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
