package com.company.Commands;

import com.company.CommandExecuter;
import com.company.Parser;

public class Save implements CommandExecuter {
    @Override
    public void Execute(String command)  {
        Parser.getInstance().SetObject();
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
