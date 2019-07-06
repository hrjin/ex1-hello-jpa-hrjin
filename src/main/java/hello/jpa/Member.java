package hello.jpa;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Member {

    @Id
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate createdLocalDate;

    private LocalDateTime createdLocalDateTime;


    @Lob // 많은 양의 text 일 경우
    private String description;

    @Transient // SQL에 영향 X. 메모리에서만 사용.
    private String temp;
}
