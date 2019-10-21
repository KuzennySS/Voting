package voting.web.voting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import voting.model.Voting;
import voting.service.VotingService;
import voting.util.VotingUtil;
import voting.web.SecurityUtil;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = VotingRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VotingRestController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected VotingService service;

    public static final String REST_URL = "/rest/voting";

    @GetMapping
    public List<Voting> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Voting get(@PathVariable int id) {
        return service.get(id);
    }

    @GetMapping("/today/{userId}")
    public Voting getByDate(@PathVariable int userId) {
//        int userId = SecurityUtil.authUserId();
        return service.getByDate(LocalDate.now(), userId);
    }

    @GetMapping("vote/{restaurantId}")
    public Voting vote(@PathVariable int restaurantId) {
        int userId = SecurityUtil.authUserId();
        Voting votingToday = service.getByDate(LocalDate.now(), userId);
        Voting voteToday = null;
        if (VotingUtil.pollByTime(votingToday)){
            log.info("your vote was calculate");
            voteToday = service.create(new Voting(userId, LocalDate.now(), restaurantId));
        }
        else {
            log.info("voting is impossible today");
        }
        return voteToday;
    }

/*    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Voting voting, @PathVariable int id) {
        int userId = SecurityUtil.authUserId();
        Voting votingToday = service.getByDate(LocalDate.now(), userId);
        if (VotingUtil.pollByTime(votingToday)){
            log.info("voting is possible today");
            service.update(voting, id);
        }
        log.info("voting is impossible today");
    }*/
}

