package com.cb.edu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cb.edu.entity.AllSubject.OneSubject;
import com.cb.edu.entity.AllSubject.TwoSubject;
import com.cb.edu.entity.Subject;
import com.cb.edu.entity.excel.SubjectData;
import com.cb.edu.listener.SubjectExcelListener;
import com.cb.edu.mapper.SubjectMapper;
import com.cb.edu.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author cb
 * @since 2021-09-11
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {


    @Override
    public void saveSubject(MultipartFile file,SubjectService subjectService) {
        try {
            InputStream in = file.getInputStream();
            EasyExcel.read(in, SubjectData.class,new SubjectExcelListener(subjectService)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OneSubject> getallSubject() {
        QueryWrapper<Subject> qwone = new QueryWrapper<>();
        qwone.eq("parent_id",0);
        List<Subject> Onesubjects = baseMapper.selectList(qwone);
        QueryWrapper<Subject> qwtwo = new QueryWrapper<>();
        qwtwo.ne("parent_id",0);
        List<Subject> Twosubjects = baseMapper.selectList(qwtwo);
        List<OneSubject> finnal = new ArrayList<>();
        for(Subject one:Onesubjects){
            OneSubject oneSubject = new OneSubject();
            BeanUtils.copyProperties(one,oneSubject);
            List<TwoSubject> twoSubjectList = new ArrayList<>();
            for(Subject two:Twosubjects){
                if (two.getParentId().equals(one.getId())){
                    TwoSubject twoSubject = new TwoSubject();
                    BeanUtils.copyProperties(two,twoSubject);
                    twoSubjectList.add(twoSubject);
                }
            }
            oneSubject.setChildren(twoSubjectList);
            finnal.add(oneSubject);
        }
        return finnal;
    }
}
