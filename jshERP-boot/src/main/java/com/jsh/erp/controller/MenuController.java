package com.jsh.erp.controller;

import com.jsh.erp.datasource.entities.Menu;
import com.jsh.erp.service.menu.MenuService;
import com.jsh.erp.utils.BaseResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Xiazy
 * @date 2024年7月2日16:03:40
 */
@RestController
@RequestMapping(value = "/menu")
@Api(tags = {"菜谱管理"})
public class MenuController {
    private Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Resource
    private MenuService menuService;

    /**
     * 查询所有菜谱信息
     */
    @GetMapping(value = "/getMenuList")
    @ApiOperation(value = "菜谱信息")
    public BaseResponseInfo getAllMenu(HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<Menu> menuList = menuService.getAllList();
            res.code = 200;
            res.data = menuList;
        } catch(Exception e){
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

}
