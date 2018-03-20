package module.domain.mapper;

import module.domain.Opportunity;
import org.apache.ibatis.annotations.*;

public interface OppMapper {

    @Select("select id,name from OPPORTUNITIES where id=#{id}")
    @Options(flushCache =  Options.FlushCachePolicy.FALSE, fetchSize = 1)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name")
    })
    public Opportunity getById(@Param("id") final String id);
}
