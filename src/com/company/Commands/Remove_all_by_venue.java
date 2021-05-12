package com.company.Commands;

import com.company.ClientOutput;
import com.company.Main;
import com.company.Models.TicketManager;
import com.company.Models.Venue;
import com.company.Models.VenueType;

public class Remove_all_by_venue implements CommandExecuter {
    @Override
    public void Execute(String command) throws Exception {
        ClientOutput.print("Вводится Venue");
        String name1 = TicketManager.getString("name");
        int capacity = TicketManager.getInt("capacity");
        VenueType type1 = null;
        while (true){
            try{
                ClientOutput.print("Введите TicketType");
                for (VenueType VenueType: VenueType.values()) {
                    System.out.print("\t\t\t\t" + VenueType);
                }
                String next = Main.scanner.nextLine();
                if(next.equals("null") || next.equals("")){
                    break;
                }
                type1 = VenueType.valueOf(next);
                break;
            }
            catch (Exception ignored){

            }
        }
        Venue v = new Venue(name1, capacity, type1);
        if(TicketManager.ticket.removeIf(u -> u.getVenue().equals(v))){
            ClientOutput.print("Успешно");
        }
        else{
            ClientOutput.print("Неудачно");
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
