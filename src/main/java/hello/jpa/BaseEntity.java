package hello.jpa;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * BaseEntity 클래스
 *
 * @author hrjin
 * @version 1.0
 * @since 2019-07-14
 */
@Data
@MappedSuperclass // 매핑 정보만 부모 클래스로 정의하는 어노테이션
public abstract class BaseEntity {
    private String createdBy;
    private LocalDateTime createdDate;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
}
