package com.company.Commands;

import com.company.ClientOutput;
import com.company.CommandExecuter;
import com.company.Main;

public class Add implements CommandExecuter {
    @Override
    public void Execute(String command)  {
        Main.ticket.add(Main.get_ticket());
        ClientOutput.print("Успешно");
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
