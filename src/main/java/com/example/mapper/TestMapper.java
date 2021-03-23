package com.example.mapper;

import com.example.domain.PersonPo;
import com.example.domain.UserEngineerPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author 郝少杰
 * @date 2021/2/10 11:58
 */
@Repository
@Mapper
public interface TestMapper {
    String getSql1(@Param("table")String table);


    void insertSql(List<PersonPo> personPos);

    Object insertUser();

    void insertEngineerUserList(@Param("param1")List<String> list);

    void insertUserList(@Param("userEngineerPOS") List<UserEngineerPO> userEngineerPOS);

    void insertDemo();
}
