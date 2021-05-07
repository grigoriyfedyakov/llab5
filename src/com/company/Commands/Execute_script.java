package com.company.Commands;

import com.company.ClientOutput;
import com.company.CommandExecuter;
import com.company.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

import static com.company.Main.commands;

public class Execute_script implements CommandExecuter {
    @Override
    public void Execute(String command) throws Exception {
        try{
            Scanner scanner = new Scanner(new File( command.split(" ",2)[1] ));

            while (scanner.hasNext()){
                String next = scanner.nextLine().trim();
                for (CommandExecuter commands : commands) {
                    if (next.startsWith(commands.getName()) || next.startsWith(commands.getName().toLowerCase(Locale.ROOT))) {
                        commands.Execute(next);
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            ClientOutput.print("Файла нет или доступ к нему запрещен. Повторите ввод");
            Execute(getName() + "," + Main.scanner.nextLine());
        }
        catch (IndexOutOfBoundsException e){
            ClientOutput.print("Введите путь");
            Execute(getName() + "," + Main.scanner.nextLine());
        }
        catch (Exception e){
            ClientOutput.print("Команда работает неверно");
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
