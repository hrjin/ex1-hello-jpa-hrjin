package hello.jpa;

import lombok.Data;

import javax.persistence.Entity;

/**
 * Movie 클래스
 *
 * @author hrjin
 * @version 1.0
 * @since 2019-07-13
 */
@Data
@Entity
public class Movie extends Item {
    private String director;
    private String actor;
}
