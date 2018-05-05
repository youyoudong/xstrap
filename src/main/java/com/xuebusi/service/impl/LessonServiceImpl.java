package com.xuebusi.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xuebusi.common.cache.InitDataCacheMap;
import com.xuebusi.entity.Lesson;
import com.xuebusi.service.LessonService;

/**
 * 课程目录
 * Created by SYJ on 2017/10/9.
 */
@Service
public class LessonServiceImpl implements LessonService {

	// @Autowired
	// private LessonRepository lessonRepository;

    @Override
    public Lesson findOne(Integer id) {
        Lesson lesson = InitDataCacheMap.getLessonCacheMap().get(String.valueOf(id));
        if (lesson != null) {
            return lesson;
        }
		return lesson;
    }

    /**
     * 查询所有课时
     * @return
     */
    @Override
    public List<Lesson> findAll() {
        Collection<Lesson> lessons = InitDataCacheMap.getLessonCacheMap().values();
        if (lessons != null && lessons.size() > 0) {
            return (List<Lesson>) lessons;
        }
		return (List<Lesson>) lessons;
    }

    /**
     * 根据课程id查询课程目录
     * @param courseId
     * @return
     */
    @Override
    public List<Lesson> findByCourseId(Integer courseId) {
		// return lessonRepository.findByCourseId(courseId);
		return new ArrayList<Lesson>();
    }
}
