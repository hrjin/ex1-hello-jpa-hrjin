package hello.jpa;

import lombok.Data;

import javax.persistence.*;

/**
 * Child 클래스
 *
 * @author hrjin
 * @version 1.0
 * @since 2019-07-17
 */
@Data
@Entity
public class Child {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;
}
