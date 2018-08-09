package com.sean.shop.product.controller;

import com.github.pagehelper.PageInfo;
import com.sean.shop.product.VersionVO;
import com.sean.shop.product.service.VersionService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: sean
 * @Date: 2018/8/9 16:22
 */
@Api(tags = { "商品版本管理接口" }, value = "商品版本管理接口")
@RestController
@RequestMapping("/versions")
public class VersionController {

    @Autowired
    private VersionService versionService;

    @PostMapping()
    @ApiOperation(value = "新增商品版本信息")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "新增商品版本信息成功", response = VersionVO.class) })
    public VersionVO save(@ApiParam(value = "商品详情", required = true) @RequestBody VersionVO version) {
        return versionService.save(version);
    }

    @PutMapping("/{versionId}")
    @ApiOperation(value = "根据ID,修改商品版本信息")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据ID,修改商品版本信息成功", response = VersionVO.class) })
    public VersionVO upadteById(
            @ApiParam(value = "商品ID", required = true) @PathVariable String versionId,
            @ApiParam(value = "商品详情", required = true) @RequestBody VersionVO version) {
        return versionService.modify(versionId, version);
    }

    @DeleteMapping("/{versionId}")
    @ApiOperation(value = "根据ID删除商品版本")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据ID,删除商品版本成功", response = VersionVO.class) })
    public VersionVO removeById(@ApiParam(value = "商品ID", required = true) @PathVariable String versionId) {
        return versionService.removeById(versionId);
    }

    @GetMapping("/{versionId}")
    @ApiOperation(value = "根据ID查询商品版本详情")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据ID查询商品版本详情", response = VersionVO.class) })
    public VersionVO getById(@ApiParam(value = "商品ID", required = true) @PathVariable String versionId) {
        return versionService.getById(versionId);
    }

    @GetMapping("/page/info")
    @ApiOperation(value = "根据 code，name, productId 过滤产品版本,带分页")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据 code，name, productId 过滤产品版本,带分页成功", response = VersionVO.class) })
    public PageInfo<VersionVO> queryPage(@ApiParam(value = "商品版本编码", required = false) @RequestParam(required = false) String versionCode,
                                         @ApiParam(value = "商品版本名称", required = false) @RequestParam(required = false) String versionName,
                                         @ApiParam(value = "商品ID", required = false) @RequestParam(required = false) String productId,
                                         @ApiParam(value = "页码", required = false) @RequestParam(value = "page", required = true) int page,
                                         @ApiParam(value = "每页显示的条数", required = false) @RequestParam(value = "pageSize", required = true) int pageSize) {
        return versionService.queryPage(versionCode, versionName, productId, page, pageSize);
    }

    @GetMapping("")
    @ApiOperation(value = "根据 code，name, productId 过滤产品版本")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据 code，name, productId 过滤产品版本成功", response = VersionVO.class) })
    public List<VersionVO> query(@ApiParam(value = "商品版本编码", required = false) @RequestParam(required = false) String versionCode,
                                      @ApiParam(value = "商品版本名称", required = false) @RequestParam(required = false) String versionName,
                                      @ApiParam(value = "商品ID", required = false) @RequestParam(required = false) String productId) {
        return versionService.query(versionCode, versionName, productId);
    }

}
