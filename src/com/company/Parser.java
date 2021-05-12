package com.company;

import com.company.Models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Parser {
    private static String path;
    private static Parser instance;

    public static Parser getInstance() {
        if (instance == null) {
            instance = new Parser();
        }
        synchronized (instance) { return instance; }
    }
    public Parser(){ path = System.getenv("laba"); }

    public void SetObject(){
        try{
            FileOutputStream stream = new FileOutputStream(path);
            for (Ticket ticket : TicketManager.ticket) {
                String str = ticket.getName() + "," + ticket.getDiscount() + "," + ticket.getCoordinates().getX() + "," + ticket.getCoordinates().getY() + "," +
                        ticket.getCreationDate().toString() + "," + ticket.getVenue().getName() + "," + ticket.getVenue().getCapacity() + "," +
                        ticket.getVenue().getType() + "," + ticket.getType() + "," + ticket.getPrice() + "\r\n";
                stream.write(str.getBytes(StandardCharsets.UTF_8));
            }
        }
        catch (Exception e){
            ClientOutput.print("Данные не сохранены");
        }
    }

    public Ticket getObject(){
        try {
            ClientOutput.print(path);
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNext()){
                String[] strs = scanner.nextLine().split(",");
                String name = strs[0];
                int discount = Integer.parseInt(strs[1]);
                int x = Integer.parseInt(strs[2]);
                Long y = Long.parseLong(strs[3]);
                ZonedDateTime creationTime = ZonedDateTime.parse(strs[4]);
                String name1 = strs[5];
                int capacity = Integer.parseInt(strs[6]);
                VenueType venueType = null;
                if(!strs[7].equals("null")){
                    venueType = VenueType.valueOf(strs[7]);
                }
                TicketType type = null;
                if(!strs[8].equals("null")){
                    type = TicketType.valueOf(strs[8]);
                }
                int price = Integer.parseInt(strs[9]);
                return new Ticket(TicketManager.ids_ticket ,name,new Coordinates(x,y),creationTime, price, discount,
                        type,new Venue(TicketManager.ids_Venue, name1, capacity, venueType));
            }
        } catch (FileNotFoundException e) {
            ClientOutput.print("Файл не найден");
        }
        catch (IllegalArgumentException e){
            ClientOutput.print("Обьект введен неверно. Он пропускается");
        }
        catch (DateTimeParseException e){
            ClientOutput.print("Время введено не по формату. Обьект пропускается");
        }
        catch (IndexOutOfBoundsException e){
            ClientOutput.print("В обьекте были не все значения. Обьект пропускается");
        }
        catch (Exception e){
            ClientOutput.print(e.getMessage());
        }
        return null;
    }
}
