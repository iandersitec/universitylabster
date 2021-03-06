package ro.ianders.universitylabster.dataformat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by paul.iusztin on 09.12.2017.
 */

public class Curs {

    protected String nume;
    protected String zi;
    protected String endTime;
    protected String startTime;
    protected String facultate;
    protected String adresa;
    protected String an;
    protected String emailProfesor;
    protected String numeProfesor;

    protected String incercariPanaLaIntroducereInOrar ;

    protected String checkins="";

    public Curs() {
    }


    public String getCheckins() {
        return checkins;
    }

    public Curs(String name, String facultate, String adresa, String an, String endTime, String zi, String startTime, String emailProfesor, String numeProfesor, String incercariPanaLaIntroducereInOrar) {
        this.nume = name;
        this.facultate = facultate;
        this.adresa = adresa;
        this.an = an;
        this.zi = zi;
        this.endTime = endTime;
        this.startTime = startTime;
        this.emailProfesor = emailProfesor;
        this.numeProfesor = numeProfesor;
        this.incercariPanaLaIntroducereInOrar = incercariPanaLaIntroducereInOrar;
    }

    public String getIncercariPanaLaIntroducereInOrar() {
        return incercariPanaLaIntroducereInOrar;
    }


    public void setIncercariPanaLaIntroducereInOrar() {
        this.incercariPanaLaIntroducereInOrar = "5";
    }

    public void scadePanaLaIntroducereInOrar() {
        if(Integer.parseInt(incercariPanaLaIntroducereInOrar) >= 2)
        this.incercariPanaLaIntroducereInOrar = ((Integer.parseInt(incercariPanaLaIntroducereInOrar) - 1)) + "";
    }

    public void addCheckin(String numecheckin) {
        checkins += numecheckin + "#";
    }

    public void addWholeCheckin(String addWholeCheckin) {
        checkins = addWholeCheckin;
    }

    public String getZi() {
        return zi;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEmailProfesor() {
        return emailProfesor;
    }

    public String getNumeProfesor() {
        return numeProfesor;
    }

    public String getName() {
        return nume;
    }


    public String getNume() {
        return nume;
    }


    public String getFacultate() {
        return facultate;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getAn() {
        return an;
    }

    public String getCheckings() {
        return checkins;
    }

    public HashMap<String, Object> toMap() {

        HashMap<String, Object> c = new HashMap<>();

        c.put("nume", nume);
        c.put("adresa", adresa);
        c.put("an", an);
        c.put("facultate", facultate);
        c.put("checkins", checkins);
        c.put("numeProfesor", numeProfesor);
        c.put("emailProfesor", emailProfesor);
        c.put("zi", zi);
        c.put("endTime", endTime);
        c.put("startTime", startTime);
        c.put("incercariPanaLaIntroducereInOrar", incercariPanaLaIntroducereInOrar);

        return  c;
    }

}
