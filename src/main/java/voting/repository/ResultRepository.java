package voting.repository;

import voting.model.Result;

import java.util.List;

public interface ResultRepository {
    // null if not found, when updated
    Result save(Result result);

    // false if not found
    void delete(Integer id);

    // null if not found
    Result get(Integer id);

    List<Result> getAll();
}
