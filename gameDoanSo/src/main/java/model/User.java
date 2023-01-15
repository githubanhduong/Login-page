package model;

public class User {
    public String name;
    public int countTurn;
    public int achievement;

    public int getAchievement() {
        return achievement;
    }

    public void setAchievement(int achievement) {
        this.achievement = achievement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountTurn() {
        return countTurn;
    }

    public void setCountTurn(int countTurn) {
        this.countTurn = countTurn ;
    }
}
