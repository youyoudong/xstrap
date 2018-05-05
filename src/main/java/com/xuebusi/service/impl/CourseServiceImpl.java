package com.xuebusi.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xuebusi.common.cache.InitDataCacheMap;
import com.xuebusi.entity.Course;
import com.xuebusi.service.CourseService;

/**
 * 课程
 * Created by SYJ on 2017/10/8.
 */
@Service
public class CourseServiceImpl implements CourseService {

//    @Autowired
//    private CourseRepository courseRepository;

    /**
     * 课程分页查询
     * @param pageable
     * @return
     */
    @Override
    public Page<Course> findList(Pageable pageable) {
		// return courseRepository.findAll(pageable);
		return null;
    }

    /**
     * 查询所有课程
     * @return
     */
    @Override
    public List<Course> findAll() {
        Collection<Course> courses = InitDataCacheMap.getCourseCacheMap().values();
        if (courses != null && courses.size() > 0) {
            return (List<Course>) courses;
        }
		// return courseRepository.findAll();
		return (List<Course>) courses;
    }

    /**
     * 根据id查询课程详情
     * @param id
     * @return
     */
    @Override
    public Course findOne(Integer id) {
        Course course = InitDataCacheMap.getCourseCacheMap().get(String.valueOf(id));
        if (course != null) {
            return course;
        }
		// return courseRepository.findOne(id);
		return course;
    }

    /**
     * 根据多个id查询课程
     * @param ids
     * @return
     */
    @Override
    public List<Course> findByIdIn(List<Integer> ids){
        List<Course> courseList = new ArrayList<>();
        Map<String, Course> courseMap = InitDataCacheMap.getCourseCacheMap();
        for (Integer id : ids) {
            if (courseMap.containsKey(String.valueOf(id))) {
                courseList.add(courseMap.get(String.valueOf(id)));
            }
        }
        if (courseList.size() > 0) {
            return courseList;
        }
		// return courseRepository.findByIdIn(ids);
		return courseList;
    }

    /**
     * 根据类别分页查询课程列表
     * @param courseCategory
     * @param pageable
     * @return
     */
    @Override
    public Page<Course> findByCourseCategory(String courseCategory, Pageable pageable) {
		// return courseRepository.findByCourseCategory(courseCategory, pageable);
		return null;
    }

    /**
     * 根据类别分页查询课程列表
     * @param courseNavigation
     * @param pageable
     * @return
     */
    @Override
    public Page<Course> findByCourseNavigation(String courseNavigation, Pageable pageable) {
		// return courseRepository.findByCourseNavigation(courseNavigation, pageable);
		return null;
    }

    /**
     * 根据导航和类别分页查询课程列表
     * @param courseNavigation
     * @param courseCategory
     * @param pageable
     * @return
     */
    @Override
    public Page<Course> findByCourseNavigationAndCourseCategory(String courseNavigation, String courseCategory, Pageable pageable) {
		// return
		// courseRepository.findByCourseNavigationAndCourseCategory(courseNavigation,
		// courseCategory, pageable);
		return null;
    }

    /**
     * 根据导航和类别分页查询课程列表
     * @param navigation
     * @param category
     * @param pageable
     * @return
     */
    @Override
    public Page<Course> findList(final String navigation, final String category, Pageable pageable) {

		// Specification<Course> specification = new Specification<Course>() {
		// @Override
		// public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder
		// cb) {
		// Path courseNavigationPath = root.get("courseNavigation");
		// Path courseCategoryPath = root.get("courseCategory");
		// Predicate courseNavigationPredicate = null;
		// Predicate courseCategoryPredicate = null;
		// if (!CourseNavigationEnum.all.name().equals(navigation)) {
		// courseNavigationPredicate = cb.equal(courseNavigationPath, navigation);
		// }
		// if (!CourseCategoryEnum.all.name().equals(category)) {
		// courseCategoryPredicate = cb.equal(courseCategoryPath, category);
		// }
		// if (courseNavigationPredicate != null && courseCategoryPredicate == null) {
		// query.where(courseNavigationPredicate);
		// }
		// if (courseNavigationPredicate == null && courseCategoryPredicate != null) {
		// query.where(courseCategoryPredicate);
		// }
		// if (courseNavigationPredicate != null && courseCategoryPredicate != null) {
		// query.where(courseNavigationPredicate, courseCategoryPredicate);
		// }
		// return null;
		// }
		// };
		// return courseRepository.findAll(specification, pageable);

		return null;
    }

    /**
     * 根据讲师id查询所教课程
     * @param courseTeacherId
     * @return
     */
    @Override
    public List<Course> findBycourseTeacherId(Integer courseTeacherId) {
		// return courseRepository.findBycourseTeacherId(courseTeacherId);
		return new ArrayList<Course>();
    }

}
