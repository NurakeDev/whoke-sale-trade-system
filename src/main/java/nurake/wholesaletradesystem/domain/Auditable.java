/**
 * Created By: NurakeBackendDeveloper
 * Date: 20.02.2023 понедельник
 * Time: 23:27:58
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import nurake.wholesaletradesystem.utils.LocalDateTimeConverter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass

@FieldDefaults(level = PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Auditable implements BaseDomain, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    Long id;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP default NOW()")
    @Convert(converter = LocalDateTimeConverter.class)
    LocalDateTime createdAt;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP default NOW()")
    @Convert(converter = LocalDateTimeConverter.class)
    LocalDateTime updatedAt;

    @CreatedBy
    Long createdBy;

    @LastModifiedBy
    Long updatedBy;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || Hibernate.getClass(this) != Hibernate.getClass(obj)) return false;
        Auditable auditable = (Auditable) obj;
        return id != null && Objects.equals(id, auditable.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
