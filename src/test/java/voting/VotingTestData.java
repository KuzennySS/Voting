package voting;

import voting.model.Voting;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.LocalDateTime.of;
import static voting.UserTestData.ADMIN_ID;
import static voting.UserTestData.USER_ID;
import static voting.model.AbstractBaseEntity.START_SEQ;

public class VotingTestData {
    public static final int VOTING_ID = START_SEQ + 14;
    public static final int BAKU = START_SEQ + 2;
    public static final int PRAGA = START_SEQ + 3;
    public static final int MAKDONALS = START_SEQ + 4;
    public static final LocalDate SEPTEMBER_30 = (of(2019, Month.SEPTEMBER, 30, 0, 0)).toLocalDate();
    public static final LocalDate SEPTEMBER_29 = (of(2019, Month.SEPTEMBER, 29, 0, 0)).toLocalDate();
    public static final LocalDate SEPTEMBER_28 = (of(2019, Month.SEPTEMBER, 28, 0, 0)).toLocalDate();

    public static final Voting VOTING1 = new Voting(VOTING_ID    , USER_ID, SEPTEMBER_30, BAKU);
    public static final Voting VOTING2 = new Voting(VOTING_ID + 1, USER_ID, SEPTEMBER_29, PRAGA);
    public static final Voting VOTING3 = new Voting(VOTING_ID + 2, ADMIN_ID, SEPTEMBER_30, MAKDONALS);
    public static final Voting VOTING4 = new Voting(VOTING_ID + 3, ADMIN_ID, SEPTEMBER_29, BAKU);

    public static final List<Voting> VOTINGS = List.of(VOTING1, VOTING2, VOTING3, VOTING4);


    public static Voting getCreated() {
        return new Voting(null, USER_ID, SEPTEMBER_28, MAKDONALS);
    }
    public static Voting getUpdated() {
        return new Voting(VOTING_ID, USER_ID, SEPTEMBER_28, PRAGA);
    }

    public static void assertMatch(Voting actual, Voting expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "user");
    }

    public static void assertMatch(Iterable<Voting> actual, Voting ... expected) {
        assertMatch(actual, List.of(expected));
    }

    public static void assertMatch(Iterable<Voting> actual, Iterable<Voting> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("user").isEqualTo(expected);
    }
}
