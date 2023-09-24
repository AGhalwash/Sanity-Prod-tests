package com.stacks.bdd.restassured.models;

public class CommandControl implements Sort{
    Command cmd;

    public CommandControl() {

    }

    public void setCommand(Command cmd){
        this.cmd = cmd;
    }

    public void sort(){
        cmd.execute();
    }
}
