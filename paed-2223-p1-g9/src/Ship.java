

/**
 * ID: enter que identifica el vaixell. És únic.
 * nom: cadena amb el nom del vaixell.
 * tipus: cadena que conté el tipus de vaixell.
 * pes: real que indica el pes en kg.
 * eslora: real que indica la longitud en metres.
 * capacitat: enter que indica quantes persones caben al vaixell.
 * n_competicions: enter amb el nombre de competicions guanyades amb el vaixell.
 * estat: cadena que indica si el vaixell és nou, està restaurat, està trencat o no està disponible.
 * velocitat: enter que indica la velocitat màxima en nusos.
 * centre: cadena amb el nom del centre on està el vaixell.
 */

public class Ship {
    private int id;
    private String nom;
    private String tipus;
    private float pes;
    private float eslora;
    private int capacitat;
    private int n_competicions;
    private String estat;
    private int velocitat;
    private String centre;

    public Ship(int id, String nom, String tipus, float pes, float eslora, int capacitat,
                int n_competicions, String estat, int velocitat, String centre) {
        this.id = id;
        this.nom = nom;
        this.tipus = tipus;
        this.pes = pes;
        this.eslora = eslora;
        this.capacitat = capacitat;
        this.n_competicions = n_competicions;
        this.estat = estat;
        this.velocitat = velocitat;
        this.centre = centre;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getTipus() {
        return tipus;
    }

    public float getPes() {
        return pes;
    }

    public float getEslora() {
        return eslora;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public int getN_competicions() {
        return n_competicions;
    }

    public String getEstat() {
        return estat;
    }

    public int getVelocitat() {
        return velocitat;
    }

    public String getCentre() {
        return centre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public void setPes(float pes) {
        this.pes = pes;
    }

    public void setEslora(float eslora) {
        this.eslora = eslora;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public void setN_competicions(int n_competicions) {
        this.n_competicions = n_competicions;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    public void setVelocitat(int velocitat) {
        this.velocitat = velocitat;
    }

    public void setCentre(String centre) {
        this.centre = centre;
    }

}
