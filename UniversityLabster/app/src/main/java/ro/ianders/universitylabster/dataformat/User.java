package ro.ianders.universitylabster.dataformat;

/**
 * Created by paul.iusztin on 08.12.2017.
 */

public class User {

    protected String facultate;
    protected Profil profil;
    protected String userName;
    protected int an;

    public User(String facultate, Profil profil, String userName,int an) {
        this.facultate = facultate;
        this.profil = profil;
        this.userName = userName;
        this.an = an;
    }

    public User(String facultate, String email, String prenume, String numeFamilie, String userName, int an) {
        this.facultate = facultate;
        this.profil = new Profil(email, prenume, numeFamilie);
        this.userName = userName;
        this.an = an;
    }

    public class Profil {
        private String email;
        private String prenume;
        private String numeFamilie;

        private Profil(String email, String prenume, String numeFamilie) {
            this.email = email;
            this.prenume = prenume;
            this.numeFamilie = numeFamilie;
        }

        public String getEmail() {
            return email;
        }

        public String getPrenume() {
            return prenume;
        }

        public String getNumeFamilie() {
            return numeFamilie;
        }
    }

    public String getFacultate() {
        return facultate;
    }

    public Profil getProfil() {
        return profil;
    }

    public String getUserName() {
        return userName;
    }

    public int getAn() {
        return an;
    }
}
