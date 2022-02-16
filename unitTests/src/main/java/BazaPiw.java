import java.util.*;

public class BazaPiw {
    private final List <Piwo> piwa=new ArrayList<>();

    public Optional<Piwo> znajdz(String nazwa) {
        Piwo piwko=null;
                for(Piwo piwo:piwa){
                    if(piwo.getNazwa().equals(nazwa)){
                        piwko=piwo;
                        break;
                    }
                }

        return Optional.ofNullable(piwko);
    }

    public void usun(String nazwa) throws IllegalArgumentException
    {
        if (!this.piwa.isEmpty()) {
            for (Piwo piwo: piwa)
                if (piwo.getNazwa().equals(nazwa)) {
                    piwa.remove(piwo);
                    return;
                }
        }
        throw new IllegalArgumentException ();

    };

        public void dodaj (Piwo piwo) {
            List<Piwo> piwos;
            piwos = piwa;
            boolean flag=false;
            for (Piwo piwko : piwos) {
                if (piwo.getNazwa().equals(piwko.getNazwa())) {
                    flag=true;
                    break;
                }

            }
            if(!flag)
            piwa.add(piwo);
            else
                throw new IllegalArgumentException();

        }

}
