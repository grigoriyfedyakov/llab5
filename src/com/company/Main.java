package com.company;

import com.company.Commands.*;
import com.company.Models.*;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayDeque<Ticket> ticket = new ArrayDeque<>();
    //public static ArrayDeque_Ticket ticket = new ArrayDeque_Ticket();
    public static Long ids_ticket = (long)0;
    public static Long ids_Venue = (long)0;
    public static LocalDateTime start;
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<CommandExecuter> commands = new ArrayList<>();

    public static String getString(String name){
        String str = "";
        while (str.equals("")){
            ClientOutput.print("Введите поле " + name);
            str = scanner.nextLine();
        }
        return str;
    }
    public static int getInt(String name){
        int str;
        while (true){
            try {
                ClientOutput.print("Введите поле " + name);
                str = Integer.parseInt(scanner.nextLine());
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
                str = Long.parseLong(scanner.nextLine());
                break;
            }
            catch (Exception ignored){

            }
        }
        return str;
    }

    public static Ticket get_ticket(){

        String name = getString("name");
        while (Validator.validationName(name)) {
            ClientOutput.invalidValue();
            name = getString("name");
        }

        int price = getInt("price");
        while (Validator.validationPrice(price)) {
            ClientOutput.invalidValue();
            price = getInt("price");
        }

        int discount = getInt("discount");
        while (Validator.validationDiscount(discount)) {
            ClientOutput.invalidValue();
            discount = getInt("discount");
        }

        TicketType type = null;
        while (true){
            try{
                ClientOutput.print("Введите TicketType");
                for (TicketType ticketType: TicketType.values()) {
                    System.out.print("\t\t\t\t" + ticketType);
                }
                ClientOutput.print("\n");
                String next = scanner.nextLine();
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

        int x = getInt("X");
        while (Validator.validationX(x)) {
            ClientOutput.invalidValue();
            x = getInt("X");
        }

        long y = getLong("Y");
        while (Validator.validationY(y)) {
            ClientOutput.invalidValue();
            y = getLong("Y");
        }

        ClientOutput.print("Вводится Venue");

        String name1 = getString("name");
        while (Validator.validationName(name1)) {
            ClientOutput.invalidValue();
            name1 = getString("name");
        }

        int capacity = getInt("capacity");
        while (Validator.validationCapacity(capacity)) {
            ClientOutput.invalidValue();
            capacity = getInt("capacity");
        }

        VenueType type1 = null;
        while (true){
            try{
                ClientOutput.print("Введите VenueType");
                for (VenueType VenueType: VenueType.values()) {
                    System.out.print("\t\t\t\t" + VenueType);
                }
                ClientOutput.print("\n");
                String next = scanner.nextLine();
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

    public static void main(String[] args){

        start = LocalDateTime.now();

        commands.add(new Help());
        commands.add(new Info());
        commands.add(new Show());
        commands.add(new Clear());
        commands.add(new Exit());
        commands.add(new Remove_by_id());
        commands.add(new Remove_first());
        commands.add(new Head());
        commands.add(new Add());
        commands.add(new Update_by_id());
        commands.add(new Save());
        commands.add(new Remove_lower());
        commands.add(new Execute_script());
        commands.add(new Remove_all_by_venue());
        commands.add(new Print_field_descending_type());
        commands.add(new Group_counting_by_coordinates());

        Parser.getInstance().getObject();


        while (true){
            try {
                ClientOutput.print("Введите команду");
                String next = scanner.nextLine().trim();
                boolean isCommand = false;
                for (CommandExecuter command : commands) {
                    if (next.startsWith(command.getName()) || next.startsWith(command.getName().toLowerCase())) {
                        command.Execute(next);
                        isCommand = true;
                    }
                }
                if (!isCommand) {
                    ClientOutput.print("Неизвестная команда");
                }
            }
            catch (Exception e){
                ClientOutput.print("Произошла ошибка. Произведено сохранение");
                Parser.getInstance().SetObject();
            }
        }
    }
}
