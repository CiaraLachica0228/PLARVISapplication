package com.cmclachicaplarvis.plarvis.Admin;

/**
 * Created by CMLachica on 05/12/2017.
 */

public class Data {

    String key;
    String name;
    String uses;
    String sname;
    String steps;
    String tech;

    public Data(String key, String name, String sname, String uses,  String steps, String tech) {
        this.key = key;
        this.name = name;
        this.sname = sname;
        this.uses = uses;
        this.steps = steps;
        this.tech = tech;
    }

    public Data() {

    }


    public String getKey() {
        return key;
    }
    public String getName() {
        return name;
    }
    public String getSName() {
        return sname;
    }
    public String getUses() {
        return uses;
    }
    public String getSteps() {
        return steps;
    }
    public String getTech() {return tech;}
}
