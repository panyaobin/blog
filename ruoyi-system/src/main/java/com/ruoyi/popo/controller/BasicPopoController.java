package com.ruoyi.popo.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.popo.domain.BasicPopo;
import com.ruoyi.popo.service.IBasicPopoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 测试用户Controller
 * 
 * @author ruoyi
 * @date 2021-06-09
 */
@Controller
@RequestMapping("/popo/test")
public class BasicPopoController extends BaseController
{
    private String prefix = "popo/test";

    @Autowired
    private IBasicPopoService basicPopoService;

    @RequiresPermissions("popo:test:view")
    @GetMapping()
    public String test()
    {
        return prefix + "/test";
    }

    /**
     * 查询测试用户列表
     */
    @RequiresPermissions("popo:test:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BasicPopo basicPopo)
    {
        startPage();
        List<BasicPopo> list = basicPopoService.selectBasicPopoList(basicPopo);
        return getDataTable(list);
    }

    /**
     * 导出测试用户列表
     */
    @RequiresPermissions("popo:test:export")
    @Log(title = "测试用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BasicPopo basicPopo)
    {
        List<BasicPopo> list = basicPopoService.selectBasicPopoList(basicPopo);
        ExcelUtil<BasicPopo> util = new ExcelUtil<BasicPopo>(BasicPopo.class);
        return util.exportExcel(list, "测试用户数据");
    }

    /**
     * 新增测试用户
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存测试用户
     */
    @RequiresPermissions("popo:test:add")
    @Log(title = "测试用户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BasicPopo basicPopo)
    {
        return toAjax(basicPopoService.insertBasicPopo(basicPopo));
    }

    /**
     * 修改测试用户
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        BasicPopo basicPopo = basicPopoService.selectBasicPopoById(id);
        mmap.put("basicPopo", basicPopo);
        return prefix + "/edit";
    }

    /**
     * 修改保存测试用户
     */
    @RequiresPermissions("popo:test:edit")
    @Log(title = "测试用户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BasicPopo basicPopo)
    {
        return toAjax(basicPopoService.updateBasicPopo(basicPopo));
    }

    /**
     * 删除测试用户
     */
    @RequiresPermissions("popo:test:remove")
    @Log(title = "测试用户", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(basicPopoService.deleteBasicPopoByIds(ids));
    }
}
