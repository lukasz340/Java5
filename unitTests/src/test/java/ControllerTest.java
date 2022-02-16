import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class ControllerTest {

    @Test
    public void Test_controller_znajdz_bad() {
        BazaPiw bazaPiw = mock(BazaPiw.class);
        when(bazaPiw.znajdz("kustosz potezny")).thenReturn(Optional.empty());
        ZarzadzaniePiwami z = new ZarzadzaniePiwami(bazaPiw);
        assertThat(z.znajdz("kustosz potezny")).isEqualTo("not found");
    }

    @Test
    public void Test_controller_znajdz_ok() {
        Piwo piwo = new Piwo("kustosz mocny", 11.2);
        BazaPiw bazaPiw = mock(BazaPiw.class);
        when(bazaPiw.znajdz("kustosz mocny")).thenReturn(Optional.of(piwo));
        ZarzadzaniePiwami zarzadzaniePiwami = new ZarzadzaniePiwami(bazaPiw);
        assertThat(zarzadzaniePiwami.znajdz("kustosz mocny")).isEqualTo(piwo.toString());
    }

    @Test
    public void Test_controller_dodaj_ok() {
        BazaPiw bazaPiw = mock(BazaPiw.class);
        ZarzadzaniePiwami zarzadzaniePiwami = new ZarzadzaniePiwami(bazaPiw);
        assertThat(zarzadzaniePiwami.dodaj("Kustosz Mocny", 7)).isEqualTo("done");
    }

    @Test
    public void Test_controller_dodaj_bad() {

        BazaPiw bazaPiw = mock(BazaPiw.class);
        doNothing().doThrow(IllegalArgumentException.class).when(bazaPiw).dodaj(argThat(argument -> argument.getNazwa().equals("kustosz mocny")));
        ZarzadzaniePiwami zarzadzaniePiwami = new ZarzadzaniePiwami(bazaPiw);
        assertThat(zarzadzaniePiwami.dodaj("kustosz mocny", 6)).isEqualTo("done");
        assertThat(zarzadzaniePiwami.dodaj("kustosz potezny", 2)).isEqualTo("done");
        assertThat(zarzadzaniePiwami.dodaj("kustosz tequilla", 4)).isEqualTo("done");
        assertThat(zarzadzaniePiwami.dodaj("kustosz mocny", 7)).isEqualTo("bad request");
    }

    @Test
    public void Test_controller_usun_bad() {
        BazaPiw bazaPiw = mock(BazaPiw.class);
        doThrow(IllegalArgumentException.class).when(bazaPiw).usun("kustosz potezny");
        ZarzadzaniePiwami zarzadzaniePiwami = new ZarzadzaniePiwami(bazaPiw);
        assertThat(zarzadzaniePiwami.usun("kustosz potezny")).isEqualTo("not found");
    }

    @Test
    public void Test_controller_usun_ok() {
        BazaPiw bazaPiw = mock(BazaPiw.class);
        doNothing().when(bazaPiw).usun("kustosz mocny");
        ZarzadzaniePiwami zarzadzaniePiwami = new ZarzadzaniePiwami(bazaPiw);
        assertThat(zarzadzaniePiwami.usun("kustosz mocny")).isEqualTo("done");
    }
}