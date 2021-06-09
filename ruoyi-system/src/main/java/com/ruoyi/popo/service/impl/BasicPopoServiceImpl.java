package com.ruoyi.popo.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.popo.mapper.BasicPopoMapper;
import com.ruoyi.popo.domain.BasicPopo;
import com.ruoyi.popo.service.IBasicPopoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 测试用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-09
 */
@Service
public class BasicPopoServiceImpl implements IBasicPopoService 
{
    @Autowired
    private BasicPopoMapper basicPopoMapper;

    /**
     * 查询测试用户
     * 
     * @param id 测试用户ID
     * @return 测试用户
     */
    @Override
    public BasicPopo selectBasicPopoById(Long id)
    {
        return basicPopoMapper.selectBasicPopoById(id);
    }

    /**
     * 查询测试用户列表
     * 
     * @param basicPopo 测试用户
     * @return 测试用户
     */
    @Override
    public List<BasicPopo> selectBasicPopoList(BasicPopo basicPopo)
    {
        return basicPopoMapper.selectBasicPopoList(basicPopo);
    }

    /**
     * 新增测试用户
     * 
     * @param basicPopo 测试用户
     * @return 结果
     */
    @Override
    public int insertBasicPopo(BasicPopo basicPopo)
    {
        basicPopo.setCreateTime(DateUtils.getNowDate());
        return basicPopoMapper.insertBasicPopo(basicPopo);
    }

    /**
     * 修改测试用户
     * 
     * @param basicPopo 测试用户
     * @return 结果
     */
    @Override
    public int updateBasicPopo(BasicPopo basicPopo)
    {
        basicPopo.setUpdateTime(DateUtils.getNowDate());
        return basicPopoMapper.updateBasicPopo(basicPopo);
    }

    /**
     * 删除测试用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBasicPopoByIds(String ids)
    {
        return basicPopoMapper.deleteBasicPopoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除测试用户信息
     * 
     * @param id 测试用户ID
     * @return 结果
     */
    @Override
    public int deleteBasicPopoById(Long id)
    {
        return basicPopoMapper.deleteBasicPopoById(id);
    }
}
