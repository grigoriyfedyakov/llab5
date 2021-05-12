package com.company.Commands;

import com.company.ClientOutput;
import com.company.Models.TicketManager;
import com.company.Models.Ticket;

import java.util.ArrayList;

public class Group_counting_by_coordinates implements CommandExecuter {
    @Override
    public void Execute(String command) {//сортируем, и прохрдим массив, ищя одинаковые, и считаем количество каждого
        try {
            ArrayList<Ticket> tickets = new ArrayList<>();
            TicketManager.ticket.iterator().forEachRemaining(tickets::add);
            tickets.sort(new Comparator_by_coordinates());
            int sch = 1;
            for (int i = 1; i < tickets.size(); i++) {
                if (tickets.get(i - 1).getCoordinates().equals(tickets.get(i).getCoordinates())) {
                    sch++;
                } else {
                    ClientOutput.print(tickets.get(i - 1).getCoordinates() + "\t\nколичество = " + sch);
                    sch = 1;
                }
            }
            ClientOutput.print(tickets.get(tickets.size() - 1).getCoordinates() + "\t\nколичество = " + sch);
        }
        catch (Exception w){
            ClientOutput.print("Ошибка в команде");
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
