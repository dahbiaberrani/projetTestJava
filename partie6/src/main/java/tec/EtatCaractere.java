package tec;

public class EtatCaractere {
    private  Bus bus;
    private  PassagerAbstrait passager;

    public EtatCaractere(Bus bus) {
        this.bus = bus;
    }

    public void setPassagee(PassagerAbstrait passager) {
        this.passager = passager;
    }

    public Bus getBus() {
        return bus;
    }

    public PassagerAbstrait getPassager() {
        return passager;
    }
}
