package voting;

import voting.model.Menu;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.of;
import static org.assertj.core.api.Assertions.assertThat;
import static voting.model.AbstractBaseEntity.START_SEQ;

public class MenuTestData {
    public static final int MENU_ID = START_SEQ + 5;
    public static final int BAKU = START_SEQ + 2;
    public static final int PRAGA = START_SEQ + 3;
    public static final int MAKDONALS = START_SEQ + 4;
    public static final LocalDate SEPTEMBER_30 = (of(2019, Month.SEPTEMBER, 30, 0, 0)).toLocalDate();
    public static final LocalDate SEPTEMBER_29 = (of(2019, Month.SEPTEMBER, 29, 0, 0)).toLocalDate();
    public static final LocalDate SEPTEMBER_28 = (of(2019, Month.SEPTEMBER, 28, 0, 0)).toLocalDate();
    public static final LocalDate SEPTEMBER_27 = (of(2019, Month.SEPTEMBER, 27, 0, 0)).toLocalDate();

    public static final Menu MENU1 = new Menu(MENU_ID    , BAKU, "пити",    180.02F, SEPTEMBER_29);
    public static final Menu MENU2 = new Menu(MENU_ID + 1, BAKU, "борщ",    160.00F, SEPTEMBER_28);
    public static final Menu MENU3 = new Menu(MENU_ID + 2, BAKU, "боз-баш", 160.00F, SEPTEMBER_27);
    public static final List<Menu> MENU_BAKU = List.of(MENU1, MENU2, MENU3);
    public static final Menu MENU4 = new Menu(MENU_ID + 3, PRAGA, "чахохбили", 300.52F, SEPTEMBER_29);
    public static final Menu MENU5 = new Menu(MENU_ID + 4, PRAGA, "запеченая свиная рулька", 480.00F, SEPTEMBER_28);
    public static final Menu MENU6 = new Menu(MENU_ID + 5, PRAGA, "сочная свиная корейка на кости", 390.00F, SEPTEMBER_27);
    public static final List<Menu> MENU_PRAGA = List.of(MENU4, MENU5, MENU6);
    public static final Menu MENU7 = new Menu(MENU_ID + 6, MAKDONALS, "Биг Мак МакКомбо", 215.80F, SEPTEMBER_29);
    public static final Menu MENU8 = new Menu(MENU_ID + 7, MAKDONALS, "Гамбургер", 48.00F, SEPTEMBER_28);
    public static final Menu MENU9 = new Menu(MENU_ID + 8, MAKDONALS, "пирожок по итальянски", 49.00F, SEPTEMBER_27);
    public static final List<Menu> MENU_MAKDONALS = List.of(MENU4, MENU5, MENU6);

    public static Menu getCreated() {
        return new Menu(null, BAKU, "селедка слабосоленая", 120.20F, SEPTEMBER_30);
    }
    public static Menu getUpdated() {
        return new Menu(MENU_ID, BAKU, "БикМаг", 360.01F,  SEPTEMBER_29);
    }

    public static void assertMatch(Menu actual, Menu expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "user");
    }

    public static void assertMatch(Iterable<Menu> actual, Menu ... expected) {
        assertMatch(actual, List.of(expected));
    }

    public static void assertMatch(Iterable<Menu> actual, Iterable<Menu> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("user").isEqualTo(expected);
    }
}
