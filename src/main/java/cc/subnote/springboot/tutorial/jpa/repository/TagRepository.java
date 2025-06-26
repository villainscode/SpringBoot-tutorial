package cc.subnote.springboot.tutorial.jpa.repository;

import cc.subnote.springboot.tutorial.jpa.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long> {

}