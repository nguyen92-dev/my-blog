package top.nguyennd.blog.author.dto;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import top.nguyennd.blog.author.Author;

@Mapper(componentModel = "spring")
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AuthorMapper {

  @Mapping(target = "uuid", ignore = true)
  @Mapping(target = "createdDate", ignore = true)
  @Mapping(target = "lastModifiedDate", ignore = true)
  Author toEntity(AuthorRequest requestDto);

  AuthorResponse toResponseDto(Author author);
}
