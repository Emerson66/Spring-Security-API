package com.buritiscript.springSecurityAPI.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buritiscript.springSecurityAPI.domain.model.User;

@Repository
@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User, Long> {

	@CacheEvict(allEntries = true)
	<S extends User> List<S> saveAll(Iterable<S> entities);

	@Caching(evict = { @CacheEvict(key = "#p0.id"), @CacheEvict(key = "#p0.usuario") })
	<S extends User> S save(S entity);
	
	@Cacheable
    Optional<User> findById(Long id);
	
	@Cacheable
    Optional<User> findByUsername(String usuario);
	
}
