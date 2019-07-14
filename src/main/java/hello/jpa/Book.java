package hello.jpa;

import lombok.Data;

import javax.persistence.Entity;

/**
 * Book 클래스
 *
 * @author hrjin
 * @version 1.0
 * @since 2019-07-13
 */
@Data
@Entity
public class Book extends Item {
    private String author;
    private String isbn;
}
