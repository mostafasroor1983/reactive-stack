package com.okta.developer.blog.repository;

import com.okta.developer.blog.domain.Blog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data Neo4j reactive repository for the Blog entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BlogRepository extends ReactiveNeo4jRepository<Blog, String> {
    @Query("MATCH (n:Blog)<-[]-(m) RETURN n,m")
    Flux<Blog> findAllWithEagerRelationships(Pageable pageable);

    @Query("MATCH (n:Blog)<-[]-(m) RETURN n,m")
    Flux<Blog> findAllWithEagerRelationships();

    @Query("MATCH (e:Blog {id: $id}) RETURN e")
    Mono<Blog> findOneWithEagerRelationships(String id);
}
