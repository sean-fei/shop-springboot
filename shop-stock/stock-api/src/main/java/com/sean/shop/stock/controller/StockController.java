package com.sean.shop.stock.controller;

import com.github.pagehelper.PageInfo;
import com.sean.shop.stock.StockVO;
import com.sean.shop.stock.service.StockService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping()
    @ApiOperation(value = "新增库存")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "新增库存成功", response = StockVO.class) })
    public StockVO save(@ApiParam(value = "库存详情", required = true) @RequestBody StockVO stock) {
        return stockService.saveStock(stock);
    }

    @PutMapping("/{stockId}")
    @ApiOperation(value = "根据ID,修改库存")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据ID,修改库存成功", response = StockVO.class) })
    public StockVO upadteById(
            @ApiParam(value = "库存ID", required = true) @PathVariable String stockId,
            @ApiParam(value = "库存详情", required = true) @RequestBody StockVO stock) {
        return stockService.updateStock(stockId, stock);
    }

    @DeleteMapping("/{stockId}")
    @ApiOperation(value = "根据ID删除库存")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据ID,删除库存成功", response = StockVO.class) })
    public StockVO removeById(@ApiParam(value = "库存ID", required = true) @PathVariable String stockId) {
        return stockService.deleteStockById(stockId);
    }

    @GetMapping("/{stockId}")
    @ApiOperation(value = "根据ID查询库存详情")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据ID查询库存详情", response = StockVO.class) })
    public StockVO getById(@ApiParam(value = "库存ID", required = true) @PathVariable String stockId) {
        return stockService.deleteStockById(stockId);
    }

    @GetMapping("/page/info")
    @ApiOperation(value = "根据商品，版本code进行过滤")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据商品，版本code进行过滤成功", response = StockVO.class) })
    public PageInfo<StockVO> queryStockPage(@ApiParam(value = "商品名称", required = false) @RequestParam(required = false) String productName,
                                            @ApiParam(value = "版本CODE", required = false) @RequestParam(required = false) String versionCode,
                                            @ApiParam(value = "页码", required = false) @RequestParam(value = "page", required = true) int page,
                                            @ApiParam(value = "每页显示的条数", required = false) @RequestParam(value = "pageSize", required = true) int pageSize) {
        return stockService.queryStockPage(productName, versionCode, page, pageSize);
    }

    @GetMapping("")
    @ApiOperation(value = "根据商品，版本code进行过滤")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "根据商品，版本code进行过滤成功", response = StockVO.class) })
    public List<StockVO> queryStock(@ApiParam(value = "商品名称", required = false) @RequestParam(required = false) String productName,
                                    @ApiParam(value = "版本CODE", required = false) @RequestParam(required = false) String versionCode) {
        return stockService.queryStock(productName, versionCode);
    }

}
