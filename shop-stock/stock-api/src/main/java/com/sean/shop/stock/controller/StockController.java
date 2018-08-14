package com.sean.shop.stock.controller;

import com.github.pagehelper.PageInfo;
import com.sean.shop.stock.StockVO;
import com.sean.shop.stock.service.StockService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: sean
 * @CreateDate: 2018/8/8 14:06
 */
@Api(tags = { "库存管理接口" }, value = "库存管理接口")
@RestController()
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @ApiOperation(value = "新增库存")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "新增库存成功", response = StockVO.class) })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "StockVO", name = "stock", value = "库存对象", required = true)
    })
    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public StockVO save(@RequestBody StockVO stock) {
        return stockService.saveStock(stock);
    }

    @ApiOperation(value = "根据ID,修改库存")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据ID,修改库存成功", response = StockVO.class) })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "stockId", value = "库存ID", required = true),
            @ApiImplicitParam(paramType = "body", dataType = "StockVO", name = "stock", value = "库存对象", required = true)
    })
    @RequestMapping(value = "/{stockId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public StockVO modifyById(@PathVariable String stockId, @RequestBody StockVO stock) {
        return stockService.updateStock(stockId, stock);
    }

    @ApiOperation(value = "根据ID删除库存")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据ID,删除库存成功", response = StockVO.class) })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "stockId", value = "库存ID", required = true)
    })
    @RequestMapping(value = "/{stockId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public StockVO removeById(@PathVariable String stockId) {
        return stockService.deleteStockById(stockId);
    }

    @ApiOperation(value = "根据ID查询库存详情")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据ID查询库存详情", response = StockVO.class) })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "stockId", value = "库存ID", required = true)
    })
    @RequestMapping(value = "/{stockId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public StockVO getById(@PathVariable String stockId) {
        return stockService.getById(stockId);
    }

    @ApiOperation(value = "根据商品，版本code进行过滤")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据商品，版本code进行过滤成功", response = StockVO.class) })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "productName", value = "商品名称", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "versionCode", value = "版本CODE", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "Int", name = "page", value = "页码", required = true, defaultValue = "1"),
            @ApiImplicitParam(paramType = "query", dataType = "Int", name = "pageSize", value = "每页显示的条数", required = true, defaultValue = "10")
    })
    @RequestMapping(value = "/page/info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageInfo<StockVO> queryStockPage(String productName, String versionCode, int page, int pageSize) {
        return stockService.queryStockPage(productName, versionCode, page, pageSize);
    }

    @ApiOperation(value = "根据商品，版本code进行过滤")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据商品，版本code进行过滤成功", response = StockVO.class) })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "productName", value = "商品名称", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "versionCode", value = "版本CODE", required = false)
    })
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<StockVO> queryStock(@RequestParam(required = false) String productName, @RequestParam(required = false) String versionCode) {
        return stockService.queryStock(productName, versionCode);
    }

}
