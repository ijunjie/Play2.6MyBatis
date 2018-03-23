package mapper;


import entities.Opportunity;
import org.apache.ibatis.annotations.Param;

public interface OppMapper {
    Opportunity getById(@Param("id") final String id);
}
