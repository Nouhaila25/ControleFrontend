package ma.khabbachi.controle_frontend;

public class Servece {

    private int id;

    private String nom;

    public Servece(String nom) {

        this.nom = nom;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "\nNom: " + nom +  "\n";
    }
}
