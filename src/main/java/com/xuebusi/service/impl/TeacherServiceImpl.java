package com.xuebusi.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xuebusi.common.cache.InitDataCacheMap;
import com.xuebusi.entity.Teacher;
import com.xuebusi.service.TeacherService;

/**
 * 讲师
 * Created by SYJ on 2017/10/8.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

	// @Autowired
	// private TeacherRepository teacherRepository;

    /**
     * 查询讲师信息
     * @param id
     * @return
     */
    @Override
    public Teacher findOne(Integer id) {
        Teacher teacher = InitDataCacheMap.getTeacherCacheMap().get(String.valueOf(id));
        if (teacher != null) {
            return teacher;
        }
		return new Teacher();
    }

    /**
     * 查询所有讲师信息
     * @return
     */
    @Override
    public List<Teacher> findAll() {
        Collection<Teacher> teachers = InitDataCacheMap.getTeacherCacheMap().values();
        if (teachers != null && teachers.size() > 0) {
            return (List<Teacher>) teachers;
        }
		return new ArrayList<Teacher>();
    }

}
