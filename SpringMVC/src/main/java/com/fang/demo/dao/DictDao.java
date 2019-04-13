package com.fang.demo.dao;

import com.fang.demo.model.SysDict;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface DictDao {

    SysDict selectByPrimaryKey(Long id);

    List<SysDict> selectBySysDict(SysDict sysDict, RowBounds rowBounds);

    int insert(SysDict sysDict);

    int updateById(SysDict sysDict);

    int deleteById(Long id);
}
