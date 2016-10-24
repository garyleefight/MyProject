package com.lsr.entity;

/**
 * Created by lsr on 16/10/3.
 */
public class Player {
    private int p_id;
    private String p_name;
    private Playerdata playerdata;
    private int num;
    private String pos;
    private String height;
    private int weight;
    private String birthdate;
    private int age;
    private String exp;
    private String team;
    private String semster;
    
    public void setPlayerdata(Playerdata playerdata) {
        this.playerdata = playerdata;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public Playerdata getPlayerdata() {
        return playerdata;
    }

    public int getNum() {
        return num;
    }

    public String getPos() {
        return pos;
    }

    public String getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public int getAge() {
        return age;
    }

    public String getExp() {
        return exp;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public void setTeam(String team) {
        this.team=team;
    }

    public void setSemester(String semester) {
        this.semster=semester;
    }

    public void setGameplay(int gameplay) {
        this.playerdata.setGameplay(gameplay);
    }

    public void setRebound(float rebound) {
        this.playerdata.setRebound(rebound);
    }

    public void setAssist(float assist) {
        this.playerdata.setAssist(assist);
    }

    public void setTurnover(float turnover) {
        this.playerdata.setTurnover(turnover);
    }

    public void setSteal(float steal) {
        this.playerdata.setSteal(steal);
    }

    public void setBlock(float block) {
        this.playerdata.setBlock(block);
    }

    public void setFoul(float foul) {
        this.playerdata.setFoul(foul);
    }

    public void setScore(float score) {
        this.playerdata.setScore(score);
    }

    public int getP_id() {
        return p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public String getTeam() {
        return this.team;
    }

    public String getSemester() {
        return this.semster;
    }

    public int getGameplay() {
        return playerdata.getGameplay();
    }

    public float getRebound() {
        return playerdata.getRebound();
    }

    public float getAssist() {
        return playerdata.getAssist();
    }

    public float getTurnover() {
        return playerdata.getTurnover();
    }

    public float getSteal() {
        return playerdata.getSteal();
    }

    public float getBlock() {
        return playerdata.getBlock();
    }

    public float getFoul() {
        return playerdata.getFoul();
    }

    public float getScore() {
        return playerdata.getScore();
    }

    public Player(){
            playerdata=new Playerdata();
    }


}
