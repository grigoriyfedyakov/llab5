package com.company.Commands;

import com.company.ClientOutput;
import com.company.Models.TicketManager;


public class Clear implements CommandExecuter {
    @Override
    public void Execute(String command) throws Exception {
        TicketManager.ticket.clear();
        ClientOutput.print("Список очищен");
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
