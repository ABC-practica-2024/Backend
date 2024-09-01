package ro.ubb.abc2024.biology.mapper.append;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ro.ubb.abc2024.biology.domain.appendicular.Appendicular;
import ro.ubb.abc2024.biology.dto.appendicular.AppendicularDto;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AppendicularMapper {
    AppendicularDto toDto(Appendicular entity);

    Appendicular toEntity(AppendicularDto dto);

    Appendicular updateEntityFromDto(AppendicularDto dto, @MappingTarget Appendicular entity);

}
