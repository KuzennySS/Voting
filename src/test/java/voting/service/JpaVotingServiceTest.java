package voting.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import voting.model.Voting;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static voting.UserTestData.USER_ID;
import static voting.VotingTestData.SEPTEMBER_30;
import static voting.VotingTestData.VOTING1;
import static voting.VotingTestData.VOTING2;
import static voting.VotingTestData.VOTING3;
import static voting.VotingTestData.VOTING4;
import static voting.VotingTestData.VOTINGS;
import static voting.VotingTestData.VOTING_ID;
import static voting.VotingTestData.assertMatch;
import static voting.VotingTestData.getCreated;
import static voting.VotingTestData.getUpdated;

public class JpaVotingServiceTest extends AbstractServiceTest  {

    @Autowired
    protected VotingService service;

    @Test
    void create() throws Exception {
        Voting newVoting = getCreated();
        Voting created = service.create(newVoting);
        newVoting.setId(created.getId());
        assertMatch(newVoting, created);
//        assertMatch(service.getAll(), created, VOTINGS);
    }

    @Test
    void delete() throws Exception {
        service.delete(VOTING_ID);
        System.out.println(service.getAll());
        assertMatch(service.getAll(), VOTING2, VOTING3, VOTING4);
    }

    @Test
    void deletedNotFound() throws Exception {
        assertThrows(EmptyResultDataAccessException.class, () ->
                service.delete(1));
    }

    @Test
    void get() throws Exception {
        Voting voting = service.get(VOTING_ID);
        assertMatch(voting, VOTING1);
    }

    @Test
    void getNotFound() throws Exception {
        assertThrows(NoSuchElementException.class, () ->
                service.get(1));
    }

    @Test
    void getByDate() throws Exception {
        Voting voting30september = service.getByDate(SEPTEMBER_30,USER_ID);
        assertMatch(voting30september, VOTING1);
    }

    @Test
    void update() throws Exception {
        Voting updated = getUpdated();
        service.update(updated, VOTING_ID);
        assertMatch(service.get(VOTING_ID), updated);
    }

    @Test
    void getAllByUser() throws Exception {
        assertMatch(service.getAll(), VOTINGS);
    }
}
