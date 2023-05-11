package nurake.wholesaletradesystem.domain.address;

import lombok.*;
import nurake.wholesaletradesystem.domain.Auditable;

import javax.persistence.*;

@Entity
@Table(name = "region")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Region extends Auditable {


    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street street;


}