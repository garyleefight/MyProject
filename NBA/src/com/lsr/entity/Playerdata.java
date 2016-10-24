package com.lsr.entity;

/**
 * Created by lsr on 16/10/7.
 */
public class Playerdata {
    private int p_s_id;
    private int gameplay;
    private float rebound;
    private float assist;
    private float turnover;
    private float steal;
    private float block;
    private float foul;
    private float score;
    private int p_id;
    private int s_id;
    private int t_id;

    public int getP_id() {
        return p_id;
    }

    public int getS_id() {
        return s_id;
    }

    public int getT_id() {
        return t_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public int getP_s_id() {
        return p_s_id;
    }

    public void setP_s_id(int p_s_id) {
        this.p_s_id = p_s_id;
    }

    public int getGameplay() {
        return gameplay;
    }

    public float getRebound() {
        return rebound;
    }

    public float getAssist() {
        return assist;
    }

    public float getTurnover() {
        return turnover;
    }

    public float getSteal() {
        return steal;
    }

    public float getBlock() {
        return block;
    }

    public float getFoul() {
        return foul;
    }

    public float getScore() {
        return score;
    }

    public void setGameplay(int gameplay) {
        this.gameplay = gameplay;
    }

    public void setRebound(float rebound) {
        this.rebound = rebound;
    }

    public void setAssist(float assist) {
        this.assist = assist;
    }

    public void setTurnover(float turnover) {
        this.turnover = turnover;
    }

    public void setSteal(float steal) {
        this.steal = steal;
    }

    public void setBlock(float block) {
        this.block = block;
    }

    public void setFoul(float foul) {
        this.foul = foul;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
