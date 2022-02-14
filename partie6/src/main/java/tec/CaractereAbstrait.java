package tec;

abstract class CaractereAbstrait implements CaracterePassager {
    protected EtatCaractere etatCaractere;

    protected CaractereAbstrait(EtatCaractere etatCaractere) {
        this.etatCaractere = etatCaractere;
    }

    @Override
    public EtatCaractere getEtatCaractere() {
        return etatCaractere;
    }
}
