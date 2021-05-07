package com.company;

public interface CommandExecuter {
    public void Execute(String command) throws Exception;
    public String getName();
}
