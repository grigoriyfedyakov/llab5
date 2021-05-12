package com.company.Commands;

public interface CommandExecuter {
    void Execute(String command) throws Exception;
    String getName();
}
