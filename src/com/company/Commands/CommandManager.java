package com.company.Commands;

import java.util.ArrayList;

public class CommandManager {
    public static ArrayList<CommandExecuter> commands = new ArrayList<>();
    public static void serializeCommands() {
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
    }

}
