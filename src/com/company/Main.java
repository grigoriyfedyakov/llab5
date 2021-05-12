package com.company;

import com.company.Commands.CommandExecuter;
import com.company.Commands.CommandManager;
import com.company.Models.*;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static LocalDateTime start;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        start = LocalDateTime.now();
        CommandManager.serializeCommands();

        ClientOutput.print("Для загрузки коллекции из файла введите 1, для отказа введите что угодно");
        String next = scanner.nextLine();
        if (next.equals("1")) {
            TicketManager.put();
        }

        while (true){
            try {
                ClientOutput.print("Введите команду");
                next = scanner.nextLine().trim();
                boolean isCommand = false;
                for (CommandExecuter command : CommandManager.commands) {
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
