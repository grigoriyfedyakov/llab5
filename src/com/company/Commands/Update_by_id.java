package com.company.Commands;

import com.company.ClientOutput;
import com.company.CommandExecuter;
import com.company.Main;
import com.company.Models.Ticket;

import java.util.Arrays;

public class Update_by_id implements CommandExecuter {
    @Override
    public void Execute(String command)  {
        try {
            if(command.split(",",2).length >= 2) {
                Long id = Long.parseLong(command.split(",", 2)[1].trim());
                Ticket[] tickets = new Ticket[Main.ticket.size()];
                Main.ticket.toArray(tickets);
                boolean isb = false;
                for (int i = 0; i < tickets.length; i++){
                    if(id.equals(tickets[i].getId())){
                        ClientOutput.print("Введите значение");
                        tickets[i] = Main.get_ticket();
                        tickets[i].setId(id);
                        isb = true;
                        break;
                    }
                }

                Main.ticket.clear();
                Main.ticket.addAll(Arrays.asList(tickets));
                if(isb){
                    ClientOutput.print("Успешно");
                }
                else{
                    ClientOutput.print("ID не найден");
                }
            }
            else{
                ClientOutput.print("Введите ID");
                Execute(getName() + "," + Main.scanner.nextLine());
            }
        }
        catch (NumberFormatException w){
            ClientOutput.print("Неверный ID");
            Execute(getName() + "," + Main.scanner.nextLine());
        }

    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
