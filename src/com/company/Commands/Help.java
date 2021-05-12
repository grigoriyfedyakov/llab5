package com.company.Commands;

import com.company.ClientOutput;

public class Help implements CommandExecuter {
    @Override
    public void Execute(String command) {
        for (CommandExecuter a: CommandManager.commands) {
            ClientOutput.print("Команда: " + a.getName());
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
