package hello.jpa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Member {

    @Id
    private Long id;
    private String name;
}
