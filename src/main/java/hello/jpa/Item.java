package hello.jpa;

import lombok.Data;

import javax.persistence.*;

/**
 * Item 클래스
 *
 * @author hrjin
 * @version 1.0
 * @since 2019-07-13
 */
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;
}
