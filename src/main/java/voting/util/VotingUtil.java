package voting.util;

import voting.model.Voting;

import java.time.LocalTime;

public class VotingUtil {

    public VotingUtil() {
    }

    public static boolean pollByTime(Voting votingToday) {
        return votingToday == null || LocalTime.now().isBefore(LocalTime.parse("11:00:00"));
    }
}
