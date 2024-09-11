package ro.ubb.abc2024.arheo.domain.section;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SectionDimensions {
    private double length;
    private double width;
    @Column(name = "depth", columnDefinition = "double precision default 0")
    private double depth;
}
