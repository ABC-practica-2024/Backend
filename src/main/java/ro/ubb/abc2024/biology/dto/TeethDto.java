package ro.ubb.abc2024.biology.dto;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class TeethDto {

    @Nullable
    private Long id;

    @Nullable
    private UUID artefactId;

}