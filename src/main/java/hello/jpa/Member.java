package hello.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String username;

    // 기간 임베디드 객체
    @Embedded
    private Period period;

    // 집 주소 임베디드 객체
    @Embedded
    private Address homeAddress;

    // 회사 주소 임베디드 객체
    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "city", column = @Column(name = "com_city")),
            @AttributeOverride(name = "street", column = @Column(name = "com_street")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "com_zipCode"))
    })
    private Address companyAddress;

    @ElementCollection
    @CollectionTable(name = "favorite_food", joinColumns = @JoinColumn(name = "member_id"))
    @Column(name = "food_name")
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name = "address", joinColumns = @JoinColumn(name = "member_id"))
//    private List<Address> addressHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "member_id")
    private List<AddressEntity> addressHistory = new ArrayList<>();

    private Integer age;

    @ManyToOne(fetch = FetchType.LAZY)
    //@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Lob // 많은 양의 text 일 경우
    private String description;

    @Transient // SQL에 영향 X. 메모리에서만 사용.
    private String temp;
}
