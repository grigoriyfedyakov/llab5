package com.company.Commands;

import com.company.ClientOutput;
import com.company.CommandExecuter;
import com.company.Main;
import com.company.Models.Ticket;

public class Remove_lower implements CommandExecuter {
    @Override
    public void Execute(String command)  {
        try {
            Ticket ticket = Main.get_ticket();
            if(Main.ticket.removeIf(u -> u.compareTo(ticket) < 0)){
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
