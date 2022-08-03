package az.course.model;

import java.sql.Date;
import java.time.LocalDate;

public class Student {
    int id;
    String  ad;
    String soyad;
    int yas;
    LocalDate dogumTarixi;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", yas=" + yas +
                ", dogumTarixi=" + dogumTarixi +
                '}';
    }

    public Student(int id, String ad, String soyad, int yas, LocalDate dogumTarixi) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.dogumTarixi = dogumTarixi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public LocalDate getDogumTarixi() {
        return dogumTarixi;
    }

    public void setDogumTarixi(LocalDate dogumTarixi) {
        this.dogumTarixi = dogumTarixi;
    }

    public Student() {
    }
}
