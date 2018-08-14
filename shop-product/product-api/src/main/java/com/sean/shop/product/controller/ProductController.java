package com.sean.shop.product.controller;

import com.github.pagehelper.PageInfo;
import com.sean.shop.constant.CommonStatus;
import com.sean.shop.product.ProductVO;
import com.sean.shop.product.service.ProductService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: sean
 * @Date: 2018/8/9 15:04
 */
@Api(tags = { "商品管理接口" }, value = "商品管理接口")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "新增商品信息")
    @ApiResponses(value = { @ApiResponse(code = CommonStatus.OK, message = "新增商品信息成功", response = ProductVO.class) })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "ProductVO", name = "product", value = "商品对象", required = true)
    })
    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ProductVO save(@RequestBody ProductVO product) {
        return productService.save(product);
    }

    @ApiOperation(value = "根据ID,修改商品信息")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据ID,修改商品信息", response = ProductVO.class) })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "productId", value = "商品ID", required = true),
            @ApiImplicitParam(paramType = "body", dataType = "ProductVO", name = "product", value = "商品对象", required = true)
    })
    @RequestMapping(value = "/{productId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ProductVO modifyById(@PathVariable String productId, @RequestBody ProductVO product) {
        return productService.modify(productId, product);
    }

    @ApiOperation(value = "根据ID删除商品")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据ID,删除商品成功", response = ProductVO.class) })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "productId", value = "商品ID", required = true)
    })
    @RequestMapping(value = "/{productId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ProductVO removeById(@PathVariable String productId) {
        return productService.removeById(productId);
    }

    @ApiOperation(value = "根据ID查询商品详情")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据ID查询商品详情", response = ProductVO.class) })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "productId", value = "商品ID", required = true)
    })
    @RequestMapping(value = "/{productId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ProductVO getById(@PathVariable String productId) {
        return productService.getById(productId);
    }

    @ApiOperation(value = "根据产品，名称/code进行过滤,带分页")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据产品，名称/code进行过滤成功", response = ProductVO.class) })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "productCode", value = "商品编码", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "productName", value = "商品名称", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "Int", name = "page", value = "页码", required = true, defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", dataType = "Int", name = "pageSize", value = "每页显示的条数", required = true, defaultValue = "10")
    })
    @RequestMapping(value = "/page/info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageInfo<ProductVO> queryPage(@RequestParam(required = false) String productCode, @RequestParam(required = false) String productName,
                                         @RequestParam(value = "page", required = true) int page, @RequestParam(value = "pageSize", required = true) int pageSize) {
        return productService.queryPage(productCode, productName, page, pageSize);
    }

    @ApiOperation(value = "根据产品，名称/code进行过滤")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据产品，名称/code进行过滤成功", response = ProductVO.class) })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "productCode", value = "商品编码", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "productName", value = "商品名称", required = false)
    })
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ProductVO> query(@RequestParam(required = false) String productCode,
                                 @RequestParam(required = false) String productName) {
        return productService.query(productCode, productName);
    }

}
