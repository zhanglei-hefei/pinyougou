package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelService labelService;

    /**
     * 增加标签
     * @param label
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result addLabel(@RequestBody Label label){
        labelService.save(label);
        return new Result(true, StatusCode.OK,"successful operation");
    }

    /**
     * 标签全部列表
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAllLabel(){
        List<Label> all = labelService.findAll();
        return new Result(true, StatusCode.OK,"成功查询到数据",all);
    }

    /**
     * 推荐标签列表
     * @return
     */
   /* @RequestMapping(name = "/toplist",method = RequestMethod.GET)
    public Result topListLabel(){

        return new Result(true, StatusCode.OK,"成功查询到数据",);
    }
*/
    /**
     * 有效标签列表
     * @return
     */
   /* @RequestMapping(name = "/list", method = RequestMethod.GET)
    public Result listLabel(){

        return new Result(true, StatusCode.OK,"成功查询到数据",);
    }*/

    /**
     * 根据Id查询
     * @param labelId
     * @return
     */
    @RequestMapping(value = "/{labelId}", method =  RequestMethod.GET)
    public Result findById(@PathVariable String labelId){
        Optional<Label> byId = labelService.findById(labelId);
        return new Result(true, StatusCode.OK,"操作成功",byId);
    }

    /**
     * 修改标签
     * @param labelId
     * @param label
     * @return
     */
    @RequestMapping(value = "/{labelId}",method = RequestMethod.PUT)
    public Result updateById(@PathVariable String labelId , @RequestBody Label label){
        labelService.update(labelId,label);
        return new Result(true, StatusCode.OK,"修改成功");
    }

    /**
     * 根据id删除
     * @param labelId
     * @return
     */
    @RequestMapping(value = "/{labelId}",method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String labelId){
        labelService.delete(labelId);
        return new Result(true, StatusCode.OK,"操作成功");
    }

    /**
     * 标签分页
     * @param page
     * @param size
     * @param label
     * @return
     */
    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public Result searchPage(@PathVariable int page , @PathVariable int size,@RequestBody Label label){
        PageResult allPage = labelService.findAllPage(page, size, label);
        return new Result(true, StatusCode.OK,"查询成功",allPage);
    }

    /**
     * 标签分页
     * @param label
     * @return
     */
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Result search(@RequestBody Label label){
        PageResult allPage = labelService.findAllPage(label);
        return new Result(true, StatusCode.OK,"查询成功",allPage);
    }
}
