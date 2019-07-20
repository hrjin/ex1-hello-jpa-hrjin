package hello.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * Address 임베디드 객체
 *
 * @author hrjin
 * @version 1.0
 * @since 2019-07-20
 */
@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String city;
    private String street;
    private String zipCode;

}
