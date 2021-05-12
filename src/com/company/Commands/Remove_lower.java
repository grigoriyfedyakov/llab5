package com.company.Commands;

import com.company.ClientOutput;
import com.company.Models.TicketManager;
import com.company.Models.Ticket;

public class Remove_lower implements CommandExecuter {
    @Override
    public void Execute(String command)  {
        try {
            TicketManager tm = new TicketManager();
            Ticket ticket = tm.get_ticket();
            if(TicketManager.ticket.removeIf(u -> u.compareTo(ticket) < 0)){
                ClientOutput.print("Успешно");
            }
            else{
                ClientOutput.print("Неудачно");
            }
        }
        catch (Exception e){
            ClientOutput.print("Ошибка команды");
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
