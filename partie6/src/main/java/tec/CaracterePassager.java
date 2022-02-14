package tec;

public interface CaracterePassager {
    void choixChangerPlace(int numeroArret) throws UsagerInvalideException;
    EtatCaractere getEtatCaractere();
}
