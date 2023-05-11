package nurake.wholesaletradesystem.domain.address;

import lombok.*;
import nurake.wholesaletradesystem.domain.Auditable;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Address extends Auditable {


    @ManyToOne
    @JoinTable(name = "region_id",
            joinColumns = {@JoinColumn(name = "address_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "region_id", referencedColumnName = "id")}
    )
    private Region region;



}