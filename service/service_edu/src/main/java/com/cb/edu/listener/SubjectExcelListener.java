package com.cb.edu.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cb.edu.entity.Subject;
import com.cb.edu.entity.excel.SubjectData;
import com.cb.edu.service.SubjectService;
import com.cb.servicebase.exceptionhandler.CBException;

public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {
    public SubjectService subjectService;

    public SubjectExcelListener() {
    }

    public SubjectExcelListener(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if(subjectData==null){
            throw new CBException(20001,"没有数据");
        }
        Subject onesubject = existOneSubject(subjectService, subjectData.getOneSubjectName());
        if (onesubject==null){
            onesubject = new Subject();
            onesubject.setTitle(subjectData.getOneSubjectName());
            onesubject.setParentId("0");
            subjectService.save(onesubject);
        }
        String id = onesubject.getId();
        Subject twosubject = existTwoSubject(subjectService,subjectData.getTwoSubjectName(),id);
        if(twosubject==null){
            twosubject = new Subject();
            twosubject.setTitle(subjectData.getTwoSubjectName());
            twosubject.setParentId(id);
            subjectService.save(twosubject);
        }




    }
    public Subject existOneSubject(SubjectService subjectService,String name){
        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",name);
        queryWrapper.eq("parent_id","0");
        Subject one = subjectService.getOne(queryWrapper);
        return one;
    }
    public Subject existTwoSubject(SubjectService subjectService,String name,String pid){
        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title",name);
        queryWrapper.eq("parent_id",pid);
        Subject two = subjectService.getOne(queryWrapper);
        return two;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
