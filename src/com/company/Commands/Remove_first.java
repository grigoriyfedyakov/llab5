package com.company.Commands;

import com.company.ClientOutput;
import com.company.Models.TicketManager;

public class Remove_first implements CommandExecuter {
    @Override
    public void Execute(String command)  {
        if(TicketManager.ticket.size() != 0) {
            TicketManager.ticket.removeFirst();
        }
        else{
            ClientOutput.print("Ни одного элемента нет");
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
