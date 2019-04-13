package com.fang.demo.service.impl;

import com.fang.demo.dao.DictDao;
import com.fang.demo.model.SysDict;
import com.fang.demo.service.DictService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictDao dictDao;

    @Override
    public SysDict findById(Long id) {
        return dictDao.selectByPrimaryKey(id);
    }

    @Override
    public List<SysDict> findBySysDict(SysDict sysDict, Integer offset, Integer limit) {

        RowBounds rowBounds = RowBounds.DEFAULT;

        if (offset != null && limit != null) {
            rowBounds = new RowBounds(offset, limit);
        }
        return dictDao.selectBySysDict(sysDict, rowBounds);
    }

    @Override
    public boolean saveOrUpdate(SysDict sysDict) {
        if (sysDict.getId() == null) {
            return dictDao.insert(sysDict) == 1;
        } else {
            return dictDao.updateById(sysDict) == 1;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        return dictDao.deleteById(id) == 1;
    }
}
