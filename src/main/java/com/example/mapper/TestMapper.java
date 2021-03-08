package com.example.mapper;

import com.example.domain.PersonPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 郝少杰
 * @date 2021/2/10 11:58
 */
@Repository
@Mapper
public interface TestMapper {
    String getSql1();


    void insertSql(List<PersonPo> personPos);
}
