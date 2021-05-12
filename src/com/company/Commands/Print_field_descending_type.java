package com.company.Commands;

import com.company.ClientOutput;
import com.company.Models.TicketManager;
import com.company.Models.Ticket;
import java.util.ArrayList;

public class Print_field_descending_type implements CommandExecuter {
    @Override
    public void Execute(String command) {
        ArrayList<Ticket> a = new ArrayList<>();
        TicketManager.ticket.iterator().forEachRemaining(a::add);
        a.sort(new Comparator());
        for (Ticket ticket : a){
            ClientOutput.print(ticket.getType().toString());
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
