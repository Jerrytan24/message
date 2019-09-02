package org.lanqiao.mapper;

import org.lanqiao.entity.Msg;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MsgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Msg record);

    int insertSelective(Msg record);

    Msg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Msg record);

    int updateByPrimaryKey(Msg record);

    List<Msg> getAllmsg();


}