package hello.jpa;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Album 클래스
 *
 * @author hrjin
 * @version 1.0
 * @since 2019-07-13
 */
@Data
@Entity
//@DiscriminatorValue("A")
public class Album extends Item {
    private String artist;
}
