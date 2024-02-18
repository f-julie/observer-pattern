package observerpattern;

public interface Subject {

    void attach(Observer o);

    void detach(Observer o);

    void updateAll(); //Cannot call it notify because top hierarchy notify is already defined and labeled final
}
