package hello.jpa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Lob // 많은 양의 text 일 경우
    private String description;

    @Transient // SQL에 영향 X. 메모리에서만 사용.
    private String temp;
}
