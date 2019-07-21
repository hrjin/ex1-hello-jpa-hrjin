package hello.jpa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Address 값 타입을 포장한 Address Entity 클래스
 *
 * @author hrjin
 * @version 1.0
 * @since 2019-07-21
 */
@Data
@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue
    private Long id;

    // 값 타입
    private Address address;

    public AddressEntity(String city, String street, String zipCode) {
        this.address = new Address(city, street, zipCode);
    }
}
