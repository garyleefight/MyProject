package com.lsr.entity;

/**
 * Created by lsr on 16/10/3.
 */
public class Team {
    int t_id;
    String t_name;
    String t_loc;
    String t_div;

    public Team(int t_id, String t_name, String t_loc, String t_div) {
        this.t_id = t_id;
        this.t_name = t_name;
        this.t_loc = t_loc;
        this.t_div = t_div;
    }

    public Team(){

    }

    public int getT_id() {
        return t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public String getT_loc() {
        return t_loc;
    }

    public String getT_div() {
        return t_div;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public void setT_loc(String t_loc) {
        this.t_loc = t_loc;
    }

    public void setT_div(String t_div) {
        this.t_div = t_div;
    }
}
