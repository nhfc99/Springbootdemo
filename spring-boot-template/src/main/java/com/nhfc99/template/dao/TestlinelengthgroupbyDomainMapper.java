package com.nhfc99.template.dao;

import com.nhfc99.template.domain.TestlinelengthgroupbyDomain;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface TestlinelengthgroupbyDomainMapper {

    ArrayList<TestlinelengthgroupbyDomain> selectBy(ArrayList<String> tunnelInfoIds);

    /**
     *
     * @mbggenerated 2020-06-23
     */
    int insert(TestlinelengthgroupbyDomain record);

    /**
     *
     * @mbggenerated 2020-06-23
     */
    int insertSelective(TestlinelengthgroupbyDomain record);
}