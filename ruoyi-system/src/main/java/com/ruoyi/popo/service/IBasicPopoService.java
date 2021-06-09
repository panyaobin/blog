package com.ruoyi.popo.service;

import java.util.List;
import com.ruoyi.popo.domain.BasicPopo;

/**
 * 测试用户Service接口
 * 
 * @author ruoyi
 * @date 2021-06-09
 */
public interface IBasicPopoService 
{
    /**
     * 查询测试用户
     * 
     * @param id 测试用户ID
     * @return 测试用户
     */
    public BasicPopo selectBasicPopoById(Long id);

    /**
     * 查询测试用户列表
     * 
     * @param basicPopo 测试用户
     * @return 测试用户集合
     */
    public List<BasicPopo> selectBasicPopoList(BasicPopo basicPopo);

    /**
     * 新增测试用户
     * 
     * @param basicPopo 测试用户
     * @return 结果
     */
    public int insertBasicPopo(BasicPopo basicPopo);

    /**
     * 修改测试用户
     * 
     * @param basicPopo 测试用户
     * @return 结果
     */
    public int updateBasicPopo(BasicPopo basicPopo);

    /**
     * 批量删除测试用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBasicPopoByIds(String ids);

    /**
     * 删除测试用户信息
     * 
     * @param id 测试用户ID
     * @return 结果
     */
    public int deleteBasicPopoById(Long id);
}
