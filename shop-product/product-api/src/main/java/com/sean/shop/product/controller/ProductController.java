package com.sean.shop.product.controller;

import com.github.pagehelper.PageInfo;
import com.sean.shop.product.ProductVO;
import com.sean.shop.product.service.ProductService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping()
    @ApiOperation(value = "新增商品信息")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "新增商品信息成功", response = ProductVO.class) })
    public ProductVO save(@ApiParam(value = "商品详情", required = true) @RequestBody ProductVO product) {
        return productService.save(product);
    }

    @PutMapping("/{productId}")
    @ApiOperation(value = "根据ID,修改商品信息")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据ID,修改商品信息", response = ProductVO.class) })
    public ProductVO upadteById(
            @ApiParam(value = "商品ID", required = true) @PathVariable String productId,
            @ApiParam(value = "商品详情", required = true) @RequestBody ProductVO product) {
        return productService.modify(productId, product);
    }

    @DeleteMapping("/{productId}")
    @ApiOperation(value = "根据ID删除商品")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据ID,删除商品成功", response = ProductVO.class) })
    public ProductVO removeById(@ApiParam(value = "商品ID", required = true) @PathVariable String productId) {
        return productService.removeById(productId);
    }

    @GetMapping("/{productId}")
    @ApiOperation(value = "根据ID查询商品详情")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据ID查询商品详情", response = ProductVO.class) })
    public ProductVO getById(@ApiParam(value = "商品ID", required = true) @PathVariable String productId) {
        return productService.getById(productId);
    }

    @GetMapping("/page/info")
    @ApiOperation(value = "根据产品，名称/code进行过滤,带分页")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据产品，名称/code进行过滤成功", response = ProductVO.class) })
    public PageInfo<ProductVO> queryPage(@ApiParam(value = "商品编码", required = false) @RequestParam(required = false) String productCode,
                                              @ApiParam(value = "商品名称", required = false) @RequestParam(required = false) String productName,
                                              @ApiParam(value = "页码", required = false) @RequestParam(value = "page", required = true) int page,
                                              @ApiParam(value = "每页显示的条数", required = false) @RequestParam(value = "pageSize", required = true) int pageSize) {
        return productService.queryPage(productCode, productName, page, pageSize);
    }

    @GetMapping("")
    @ApiOperation(value = "根据产品，名称/code进行过滤")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据产品，名称/code进行过滤成功", response = ProductVO.class) })
    public List<ProductVO> query(@ApiParam(value = "商品编码", required = false) @RequestParam(required = false) String productCode,
                                      @ApiParam(value = "商品名称", required = false) @RequestParam(required = false) String productName) {
        return productService.query(productCode, productName);
    }

}
