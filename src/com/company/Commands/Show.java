package com.company.Commands;

import com.company.ClientOutput;
import com.company.CommandExecuter;
import com.company.Main;
import com.company.Models.Ticket;

public class Show implements CommandExecuter {
    @Override
    public void Execute(String command) {
        if(Main.ticket.size() != 0) {
            for (Ticket ticket : Main.ticket) {
                ClientOutput.print(ticket.toString());
            }
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
