package nyc.c4q.leighdouglas.ufeed.grateful_card.gratitude_model;

/**
 * Created by shannonalexander-navarro on 12/23/16.
 */

public class GratitudeCard {

    private Long _id;

    String first;
    String second;
    String third;
    String fourth;
    String fifth;
    String sixth;
    String seventh;
    String eighth;
    String ninth;
    String tenth;
    String date;

    public GratitudeCard() {
    }

    public GratitudeCard(String first, String second, String third, String fourth, String fifth, String sixth, String seventh, String eighth, String ninth, String tenth, String date) {
       // this._id = _id;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.seventh = seventh;
        this.eighth = eighth;
        this.ninth = ninth;
        this.tenth = tenth;
        this.date = date;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public String getFourth() {
        return fourth;
    }

    public void setFourth(String fourth) {
        this.fourth = fourth;
    }

    public String getFifth() {
        return fifth;
    }

    public void setFifth(String fifth) {
        this.fifth = fifth;
    }

    public String getSixth() {
        return sixth;
    }

    public void setSixth(String sixth) {
        this.sixth = sixth;
    }

    public String getSeventh() {
        return seventh;
    }

    public void setSeventh(String seventh) {
        this.seventh = seventh;
    }

    public String getEighth() {
        return eighth;
    }

    public void setEighth(String eighth) {
        this.eighth = eighth;
    }


    public String getNinth() {
        return ninth;
    }

    public void setNinth(String ninth) {
        this.ninth = ninth;
    }

    public String getTenth() {
        return tenth;
    }

    public void setTenth(String tenth) {
        this.tenth = tenth;
    }
}
