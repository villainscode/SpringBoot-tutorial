package cc.subnote.springboot.tutorial.jpa.repository;

import cc.subnote.springboot.tutorial.jpa.entity.MyNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author CodeVillains
 */
@Repository
public interface MyNoteRepository extends JpaRepository<MyNoteEntity, Long> {
    List<MyNoteEntity> getMyNoteEntitiesByCreatedAtBetween(Date from, Date to);
    MyNoteEntity findByTitle(String title);
}
