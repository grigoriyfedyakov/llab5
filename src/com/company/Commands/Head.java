package com.company.Commands;

import com.company.ClientOutput;
import com.company.Models.TicketManager;

public class Head implements CommandExecuter {
    @Override
    public void Execute(String command)  {
        if(TicketManager.ticket.size() != 0) {
            ClientOutput.print(TicketManager.ticket.getFirst().toString());
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
