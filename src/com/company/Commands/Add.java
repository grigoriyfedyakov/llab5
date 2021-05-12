package com.company.Commands;

import com.company.ClientOutput;
import com.company.Models.TicketManager;

public class Add implements CommandExecuter {

    @Override
    public void Execute(String command)  {
        TicketManager tm = new TicketManager();
        TicketManager.ticket.add(tm.get_ticket());
        ClientOutput.print("Успешно");
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
