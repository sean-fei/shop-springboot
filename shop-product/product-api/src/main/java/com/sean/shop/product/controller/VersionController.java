package com.sean.shop.product.controller;

import com.github.pagehelper.PageInfo;
import com.sean.shop.product.VersionVO;
import com.sean.shop.product.service.VersionService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @ApiOperation(value = "新增商品版本信息")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "新增商品版本信息成功", response = VersionVO.class) })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "VersionVO", name = "version", value = "商品版本对象", required = true)
    })
    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VersionVO save(@RequestBody VersionVO version) {
        return versionService.save(version);
    }

    @ApiOperation(value = "根据ID,修改商品版本信息")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据ID,修改商品版本信息成功", response = VersionVO.class) })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "versionId", value = "商品版本ID", required = true),
            @ApiImplicitParam(paramType = "body", dataType = "VersionVO", name = "version", value = "商品版本对象", required = true)
    })
    @RequestMapping(value = "/{versionId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VersionVO modifyById(@PathVariable String versionId, @RequestBody VersionVO version) {
        return versionService.modify(versionId, version);
    }

    @ApiOperation(value = "根据ID删除商品版本")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据ID,删除商品版本成功", response = VersionVO.class) })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "versionId", value = "商品版本ID", required = true)
    })
    @RequestMapping(value = "/{versionId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VersionVO removeById(@PathVariable String versionId) {
        return versionService.removeById(versionId);
    }

    @ApiOperation(value = "根据ID查询商品版本详情")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据ID查询商品版本详情", response = VersionVO.class) })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "versionId", value = "商品版本ID", required = true)
    })
    @RequestMapping(value = "/{versionId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VersionVO getById(@ApiParam(value = "商品ID", required = true) @PathVariable String versionId) {
        return versionService.getById(versionId);
    }

    @ApiOperation(value = "根据 code，name, productId 过滤产品版本,带分页")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据 code，name, productId 过滤产品版本,带分页成功", response = VersionVO.class) })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "versionCode", value = "商品版本编码", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "versionName", value = "商品版本名称", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "productId", value = "商品ID", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "Int", name = "page", value = "页码", required = true, defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", dataType = "Int", name = "pageSize", value = "每页显示的条数", required = true, defaultValue = "10")
    })
    @RequestMapping(value = "/page/info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageInfo<VersionVO> queryPage(@RequestParam(required = false) String versionCode, @RequestParam(required = false) String versionName,
                                         @RequestParam(required = false) String productId,
                                         @RequestParam(value = "page", required = true) int page,
                                         @RequestParam(value = "pageSize", required = true) int pageSize) {
        return versionService.queryPage(versionCode, versionName, productId, page, pageSize);
    }

    @ApiOperation(value = "根据 code，name, productId 过滤产品版本")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据 code，name, productId 过滤产品版本成功", response = VersionVO.class) })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "versionCode", value = "商品版本编码", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "versionName", value = "商品版本名称", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "productId", value = "商品ID", required = false)
    })
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<VersionVO> query(@ApiParam(value = "商品版本编码", required = false) @RequestParam(required = false) String versionCode,
                                      @ApiParam(value = "商品版本名称", required = false) @RequestParam(required = false) String versionName,
                                      @ApiParam(value = "商品ID", required = false) @RequestParam(required = false) String productId) {
        return versionService.query(versionCode, versionName, productId);
    }

}
