package com.company.Commands;

import com.company.ClientOutput;
import com.company.Main;
import com.company.Models.TicketManager;

public class Info implements CommandExecuter {
    @Override
    public void Execute(String command)  {

        ClientOutput.print("Начало старта: " + Main.start.toString() + "\r\nКол-во элементов: " + TicketManager.ticket.size());
    }
    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
