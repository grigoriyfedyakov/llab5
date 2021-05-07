package com.company.Commands;

import com.company.ClientOutput;
import com.company.CommandExecuter;

public class Exit implements CommandExecuter {
    @Override
    public void Execute(String command) {
        try {
            System.exit(0);
        }
        catch (Exception e){
            ClientOutput.print(e.getMessage());
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
