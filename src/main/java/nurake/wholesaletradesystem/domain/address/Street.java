package nurake.wholesaletradesystem.domain.address;

import lombok.*;
import nurake.wholesaletradesystem.domain.Auditable;

import javax.persistence.*;

@Entity
@Table(name = "street")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Street extends Auditable {

    @Column(name = "name")
    private String name;

    @Column(name = "home")
    private String home;

}