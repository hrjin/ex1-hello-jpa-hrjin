package hello.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

/**
 * Period 임베디드 객체
 *
 * @author hrjin
 * @version 1.0
 * @since 2019-07-20
 */
@Data
@Embeddable
@AllArgsConstructor
public class Period {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Period() {
        this.startDate = LocalDateTime.now();
        this.endDate = LocalDateTime.now();
    }
}
