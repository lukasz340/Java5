import org.junit.jupiter.api.Test;

import java.util.Optional;
import static org.assertj.core.api.Assertions.*;

class BaseTest {

    @Test
    public void test_znajdz_bad() {
        BazaPiw bazaPiw = new BazaPiw();
        assertThat(bazaPiw.znajdz("desperados")).isEmpty();
    }

    @Test
    public void test_znajdz_ok() {
        BazaPiw bazaPiw = new BazaPiw();
        Piwo piwo = new Piwo("desperados", 6.6);
        bazaPiw.dodaj(piwo);
        assertThat(bazaPiw.znajdz("desperados")).isEqualTo(Optional.of(piwo));
    }
    @Test
    public void test_dodaj_ok() {
        BazaPiw bazaPiw = new BazaPiw();
        bazaPiw.dodaj(new Piwo("desperados", 6.6));
        bazaPiw.dodaj(new Piwo("zubr", 6.4));
        bazaPiw.dodaj(new Piwo("tyskie", 4.4));

    }

    @Test
    public void test_dodaj_bad() {
        BazaPiw bazaPiw = new BazaPiw();
        bazaPiw.dodaj(new Piwo("desperados", 6.3));
        bazaPiw.dodaj(new Piwo("tyskie", 5.5));

        assertThatThrownBy(() -> {
            bazaPiw.dodaj(new Piwo("desperados", 6.6));
        }).isOfAnyClassIn(IllegalArgumentException.class);
    }

    @Test
    public void test_usun_bad() {
        BazaPiw bazaPiw = new BazaPiw();
        assertThatThrownBy(() -> {
            bazaPiw.usun("kustosz potezny");
        }).isOfAnyClassIn(IllegalArgumentException.class);
    }

    @Test
    public void test_dodaj_usun(){
        BazaPiw bazaPiw = new BazaPiw();
        Piwo piwo = new Piwo("desperados", 6.6);
        bazaPiw.dodaj(piwo);
        Piwo piwo2 = new Piwo("tyskie", 5.6);
        bazaPiw.dodaj(piwo2);
        Piwo piwo3 = new Piwo("zubr", 4.5);
        bazaPiw.dodaj(piwo3);
        Piwo piwo4 = new Piwo("kustosz mocne", 12);
        bazaPiw.dodaj(piwo4);
        bazaPiw.usun("zubr");
        bazaPiw.usun("tyskie");
        bazaPiw.usun("desperados");
        bazaPiw.usun("kustosz mocne");
        assertThatThrownBy(() -> {
            bazaPiw.usun("kustosz mocne");
        }).isOfAnyClassIn(IllegalArgumentException.class);
    }
}