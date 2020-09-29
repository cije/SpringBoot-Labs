package com.ce.lab8webfluxmongodb.dao;

import com.ce.lab8webfluxmongodb.dataobject.UserDO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * @author c__e
 * @date Created in 2020/9/29 8:55
 */
public interface UserRepository extends ReactiveMongoRepository<UserDO, Integer> {

    Mono<UserDO> findByUsername(String username);
}
