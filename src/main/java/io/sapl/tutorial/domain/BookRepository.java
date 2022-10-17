package io.sapl.tutorial.domain;

import io.sapl.spring.method.metadata.PostEnforce;
import io.sapl.spring.method.metadata.PreEnforce;

import java.util.Optional;

public interface BookRepository {
	@PreEnforce
	Iterable<Book> findAll();

	//@PreEnforce
	@PostEnforce(subject  = "authentication.getPrincipal()",
			action   = "'read book'",
			resource = "returnObject")
	Optional<Book> findById(Long id);

	Book save(Book entity);
}