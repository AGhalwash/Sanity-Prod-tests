package com.stacks.bdd.restassured.models;

import java.util.Collections;
import java.util.List;

public class SortCommand implements Command {
    List list;
    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }


    @Override
    public void execute() {
        Collections.sort(list);
    }


}
