/**
 * Created By: NurakeBackendDeveloper
 * Date: 21.02.2023 вторник
 * Time: 3:36:03
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.domain.product;

import lombok.*;
import nurake.wholesaletradesystem.domain.Auditable;
import nurake.wholesaletradesystem.enums.MeasurementName;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "measurements")
public class Measurement extends Auditable {

    @Enumerated(EnumType.STRING)
    private MeasurementName measurementName;

    @Column(name = "description")
    private String description;

}
