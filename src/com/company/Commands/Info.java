package com.company.Commands;

import com.company.ClientOutput;
import com.company.CommandExecuter;
import com.company.Main;

public class Info implements CommandExecuter {
    @Override
    public void Execute(String command)  {
        ClientOutput.print("Начало старта: " + Main.start.toString() + "\r\nКол-во элементов: " + Main.ticket.size());
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
