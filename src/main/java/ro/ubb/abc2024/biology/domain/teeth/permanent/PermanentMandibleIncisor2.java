package ro.ubb.abc2024.biology.domain.teeth.permanent;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PermanentMandibleIncisor2 extends PermanentIncisor{

}
