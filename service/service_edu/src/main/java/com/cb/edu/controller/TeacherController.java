package com.cb.edu.controller;



import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cb.commentuils.R;
import com.cb.edu.entity.Teacher;
import com.cb.edu.entity.vo.TeacherQuery;
import com.cb.edu.service.TeacherService;
import com.cb.servicebase.exceptionhandler.CBException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author cb
 * @since 2021-07-17
 */
@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @GetMapping("findAll")
    public R findAllTeacher(){
        List<Teacher> list = teacherService.list(null);
        return R.ok().data("items",list);
    }
    @DeleteMapping("deleteTeacherById/{id}")
    public R deleteTeacher(@PathVariable String id){
        boolean b = teacherService.removeById(id);
        return b?R.ok():R.error();
    }
    @ApiOperation(value = "分页讲师列表")
    @GetMapping("TeacherPage/{current}/{size}")
    public R PageListTeacher(
            @ApiParam(name = "current", value = "当前页码", required = true)
            @PathVariable Integer current,@PathVariable Integer size){
        Page<Teacher> teacherPage = new Page<>(current,size);
        IPage<Teacher> page = teacherService.page(teacherPage, null);
        long total = page.getTotal();
        List<Teacher> records = page.getRecords();
        return R.ok().data("total",total).data("records",records);
    }
    @PostMapping("TeacherPageCondition/{current}/{size}")
    public R PageListCondition(@PathVariable Integer current, @PathVariable Integer size, @RequestBody(required = false) TeacherQuery teacherQuery){
        Integer level = teacherQuery.getLevel();
        String name = teacherQuery.getName();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        Page<Teacher> teacherpage = new Page<>(current,size);
        QueryWrapper<Teacher> teacherWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(level)){
            teacherWrapper.eq("level",level);
        }
        if (!StringUtils.isEmpty(name)){
            teacherWrapper.like("name",name);
        }
        if (!StringUtils.isEmpty(begin)){
            teacherWrapper.ge("gmt_create",begin);
        }
        if (!StringUtils.isEmpty(end)){
            teacherWrapper.le("gmt_create",end);
        }
        teacherWrapper.orderByDesc("gmt_create");
        IPage<Teacher> page = teacherService.page(teacherpage, teacherWrapper);
        long total = page.getTotal();
        List<Teacher> records = page.getRecords();
        return R.ok().data("total",total).data("records",records);
    }
    @PostMapping("saveTeacher")
    public R saveTeacher(@RequestBody Teacher teacher){
        boolean save = teacherService.save(teacher);
        return save?R.ok():R.error();
    }
    @GetMapping("getTeacherById/{id}")
    public R getTeacherById(@PathVariable String id){
        Teacher teacher = teacherService.getById(id);
        /*try {
            int i = 10/0;
        } catch (Exception e) {
            throw new CBException(2000,"执行自定义异常");
        }*/
        return R.ok().data("teacher",teacher);
    }
    @PostMapping("updateById")
    public R updateById(@RequestBody Teacher teacher){
        boolean b = teacherService.updateById(teacher);
        return b?R.ok():R.error();
    }
}

