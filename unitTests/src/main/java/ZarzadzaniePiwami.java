import java.util.Optional;

public class ZarzadzaniePiwami {

    final private BazaPiw baza;
    public ZarzadzaniePiwami (BazaPiw baza)
    {
        this.baza=baza;
    }

    public String znajdz(String nazwa)
    {  Optional<Piwo> piwo = baza.znajdz(nazwa);
        if( piwo.isEmpty())
            return("not found");
        else return piwo.get().toString();
    }


    public String usun(String nazwa)
    {
        try {
        baza.usun(nazwa);
    } catch (IllegalArgumentException illegalArgumentException) {
        return "not found";
    }
        return "done";

    }
    public String dodaj(String nazwa, float procenty)
    {  try {
        Piwo piwo = new Piwo(nazwa, procenty);
        baza.dodaj(piwo);
        return "done";
    } catch (IllegalArgumentException illegalArgumentException){
        return "bad request"; }
    }
}
