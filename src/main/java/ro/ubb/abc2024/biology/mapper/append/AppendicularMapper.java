package ro.ubb.abc2024.biology.mapper.append;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ro.ubb.abc2024.biology.domain.appendicular.Appendicular;
import ro.ubb.abc2024.biology.dto.appendicular.AppendicularDto;

@Mapper(componentModel = "spring")
public interface AppendicularMapper {
    AppendicularDto toDto(Appendicular entity);

    Appendicular toEntity(AppendicularDto dto);

    Appendicular updateEntityFromDto(AppendicularDto dto, @MappingTarget Appendicular entity);

}
