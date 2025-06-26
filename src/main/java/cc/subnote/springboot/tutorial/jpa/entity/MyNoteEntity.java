package cc.subnote.springboot.tutorial.jpa.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "my_note", indexes = {
        @Index(name = "idx_created_at", columnList = "created_at")
})
@ToString
@EqualsAndHashCode
public class MyNoteEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "done")
    private boolean done;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "my_note_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<TagEntity> tag;

    @Override
    public String toString() {
        return "MyNoteEntity{" + "id=" + id + ", title='" + title + '\'' + ", content='" + content + '\'' + ", done=" + done + ", createdAt=" + createdAt + '}';
    }

}