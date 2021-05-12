package com.company.Models;

import com.company.ClientOutput;
import com.company.Main;
import com.company.Parser;

import java.util.ArrayDeque;

public class TicketManager implements Validator {
    public static Long ids_ticket = (long)0;
    public static Long ids_Venue = (long)0;

    public static String getString(String name){
        String str = "";
        while (str.equals("")){
            ClientOutput.print("Введите поле " + name);
            str = Main.scanner.nextLine();
        }
        return str;
    }
    public static int getInt(String name){
        int str;
        while (true){
            try {
                ClientOutput.print("Введите поле " + name);
                str = Integer.parseInt(Main.scanner.nextLine());
                break;
            }
            catch (Exception ignored){

            }
        }
        return str;
    }
    public static long getLong(String name){
        long str;
        while (true){
            try {
                ClientOutput.print("Введите поле " + name);
                str = Long.parseLong(Main.scanner.nextLine());
                break;
            }
            catch (Exception ignored){

            }
        }
        return str;
    }
    public static ArrayDeque<Ticket> ticket = new ArrayDeque<>();

    public static void put() {
        TicketManager.ticket.add(Parser.getInstance().getObject());
        TicketManager.ids_ticket++;
        TicketManager.ids_Venue++;
    }
    public static void keep() {

    }
    public Ticket get_ticket(){

        String name = TicketManager.getString("name");
        while (validationName(name)) {
            ClientOutput.invalidValue();
            name = TicketManager.getString("name");
        }

        int price = TicketManager.getInt("price");
        while (validationPrice(price)) {
            ClientOutput.invalidValue();
            price = TicketManager.getInt("price");
        }

        int discount = TicketManager.getInt("discount");
        while (validationDiscount(discount)) {
            ClientOutput.invalidValue();
            discount = TicketManager.getInt("discount");
        }

        TicketType type = null;
        while (true){
            try{
                ClientOutput.print("Введите TicketType");
                for (TicketType ticketType: TicketType.values()) {
                    System.out.print("\t\t\t\t" + ticketType);
                }
                ClientOutput.print("\n");
                String next = Main.scanner.nextLine();
                if(next.equals("null") || next.equals("")){
                    break;
                }
                type = TicketType.valueOf(next);
                break;
            }
            catch (Exception ignored){

            }
        }
        ClientOutput.print("Вводится coordinate");

        int x = TicketManager.getInt("X");
        while (validationX(x)) {
            ClientOutput.invalidValue();
            x = TicketManager.getInt("X");
        }

        long y = TicketManager.getLong("Y");
        while (validationY(y)) {
            ClientOutput.invalidValue();
            y = TicketManager.getLong("Y");
        }

        ClientOutput.print("Вводится Venue");

        String name1 = TicketManager.getString("name");
        while (validationName(name1)) {
            ClientOutput.invalidValue();
            name1 = TicketManager.getString("name");
        }

        int capacity = TicketManager.getInt("capacity");
        while (validationCapacity(capacity)) {
            ClientOutput.invalidValue();
            capacity = TicketManager.getInt("capacity");
        }

        VenueType type1 = null;
        while (true){
            try{
                ClientOutput.print("Введите VenueType");
                for (VenueType VenueType: VenueType.values()) {
                    System.out.print("\t\t\t\t" + VenueType);
                }
                ClientOutput.print("\n");
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
        return new Ticket(name, new Coordinates(x,y), price, discount, type, new Venue(name1, capacity, type1));
    }
    public boolean validationY(long y) {
        if(y>292) return true;
        else return false;
    }
    public boolean validationX(int x){
        return false;
    }
    public boolean validationName(String s){
        if (s==null || s.equals("")) return true;
        else return false;
    }
    public boolean validationPrice(int x){
        if (x<=0) return true;
        else return false;
    }
    public boolean validationDiscount(int x){
        if (x<=0 || x>100) return true;
        else return false;
    }
    public boolean validationCapacity(int x){
        if (x<=0) return true;
        else return false;
    }
}
