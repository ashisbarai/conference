package com.pluralsight.conference.mapper;

import com.pluralsight.conference.model.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PersonMapper {
    @Select("SELECT person_id as personId ,first_name as firstName, last_name as lastName from persons WHERE person_id = #{personId}")
    Person findById(@Param("personId") int personId);
}
