package com.company.Commands;

import com.company.ClientOutput;
import com.company.CommandExecuter;
import com.company.Main;

public class Head implements CommandExecuter {
    @Override
    public void Execute(String command)  {
        if(Main.ticket.size() != 0) {
            ClientOutput.print(Main.ticket.getFirst().toString());
        }
        else{
            ClientOutput.print("Ни одного элемента нет");
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
