package LabV.classes;

import java.util.Date;

public class Winner {

    private String name;
    private Date date;
    private String word;

    public Winner(String name, Date date, String word) {
        this.name = name;
        this.date = date;
        this.word = word;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Winner{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", word='" + word + '\'' +
                '}';
    }
}
