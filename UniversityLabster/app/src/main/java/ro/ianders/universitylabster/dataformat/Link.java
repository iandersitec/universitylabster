package ro.ianders.universitylabster.dataformat;

import java.util.HashMap;

/**
 * Created by daniel on 12/10/17.
 */

public class Link {
    private String destinatar;
    private String expeditor;
    private String mesaj;

    public Link() {
    }

    public Link(String destinatar, String expeditor, String mesaj) {
        this.destinatar = destinatar;
        this.expeditor = expeditor;
        this.mesaj = mesaj;
    }

    public String getDestinatar() {
        return destinatar;
    }

    public String getExpeditor() {
        return expeditor;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setDestinatar(String destinatar) {
        this.destinatar = destinatar;
    }

    public void setExpeditor(String expeditor) {
        this.expeditor = expeditor;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public HashMap<String, Object> toMap() {

        HashMap<String, Object> c = new HashMap<>();

        c.put("expeditor", expeditor);
        c.put("destinatar", destinatar);
        c.put("mesaj", mesaj);
        return  c;
    }
}
