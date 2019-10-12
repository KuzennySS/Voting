package voting.web.result;

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
import voting.model.Result;
import voting.service.ResultService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = voting.web.result.ResultRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ResultRestController {

        protected final Logger log = LoggerFactory.getLogger(getClass());

        @Autowired
        protected ResultService service;

        public static final String REST_URL = "/rest/result";

        @GetMapping
        public List<Result> getAll() {
            log.info("getAll");
            return service.getAll();
        }

        @GetMapping("/{id}")
        public Result get(@PathVariable int id) {
            return service.get(id);
        }

        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Result> createWithLocation(@RequestBody Result result) {
            log.info("create {}", result);
            Result created = service.create(result);
            URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path(REST_URL + "/{id}")
                    .buildAndExpand(created.getId()).toUri();
            return ResponseEntity.created(uriOfNewResource).body(created);
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void delete(@PathVariable int id) {
            service.delete(id);
        }

        @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(value = HttpStatus.NO_CONTENT)
        public void update(@RequestBody Result result, @PathVariable int id) {
            service.update(result, id);
        }
    }
