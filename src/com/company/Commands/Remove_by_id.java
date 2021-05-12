package com.company.Commands;

import com.company.ClientOutput;
import com.company.Main;
import com.company.Models.TicketManager;


public class Remove_by_id implements CommandExecuter {
    @Override
    public void Execute(String command)  {
        if(command.split(" ",2).length == 2) {
            try {
                if(TicketManager.ticket.removeIf(u -> u.getId() == Long.parseLong(command.split(" ", 2)[1]))){
                    ClientOutput.print("Удаление успешно");
                }
                else{
                    ClientOutput.print("ID не найден");
                }
            }
            catch (NumberFormatException e){
                ClientOutput.print("Введено не число. Введите число");
                Execute(getName() + "," + Main.scanner.nextLine());
            }
        }
        else {
            ClientOutput.print("Неверные аргументы");
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
