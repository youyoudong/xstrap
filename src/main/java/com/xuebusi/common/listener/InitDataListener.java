package com.xuebusi.common.listener;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xuebusi.common.cache.InitDataCacheMap;
import com.xuebusi.entity.Course;
import com.xuebusi.entity.CourseDetail;
import com.xuebusi.entity.Lesson;
import com.xuebusi.entity.LoginInfo;
import com.xuebusi.entity.Teacher;
import com.xuebusi.entity.User;
import com.xuebusi.service.CourseDetailService;
import com.xuebusi.service.CourseService;
import com.xuebusi.service.LessonService;
import com.xuebusi.service.LoginService;
import com.xuebusi.service.TeacherService;
import com.xuebusi.service.UserService;

/**
 * 启动时缓存数据
 * Created by SYJ on 2017/10/26.
 */
@Component
public class InitDataListener
// implements InitializingBean/*, ServletContextAware*/
{

    private static final Logger logger = LoggerFactory.getLogger(InitDataListener.class);

    @Autowired
    private LoginService loginService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseDetailService courseDetailService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private UserService userService;

    //private ServletContext servletContext;

	// @Override
    public void afterPropertiesSet() throws Exception {
        loginInfoCache();
        courseCache();
        courseDetailCache();
        lessonCache();
        teacherCache();
        userCache();
    }

    /*@Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }*/

    /**
     * 登录用户信息缓存
     */
    private void loginInfoCache() {
        List<LoginInfo> loginInfoList = loginService.findAll();
        if (loginInfoList != null && loginInfoList.size() > 0) {
            for (LoginInfo loginInfo : loginInfoList) {
                InitDataCacheMap.getLoginInfoCacheMap().put(loginInfo.getUsername(), loginInfo);
            }
        }
        logger.info(">>>>>> 登录用户信息缓存 >>>>>>\n\n");
    }

    /**
     * 缓存课程基本信息
     */
    private void courseCache() {
        List<Course> courseList = courseService.findAll();
        if (courseList != null && courseList.size() > 0) {
            for (Course course : courseList) {
                InitDataCacheMap.getCourseCacheMap().put(String.valueOf(course.getId()), course);
            }
        }
        logger.info(">>>>>> 缓存课程基本信息 >>>>>>\n\n");
    }

    /**
     * 缓存课程详情信息
     */
    private void courseDetailCache() {
        List<CourseDetail> courseDetailList = courseDetailService.findAll();
        if (courseDetailList != null && courseDetailList.size() > 0) {
            for (CourseDetail courseDetail : courseDetailList) {
                InitDataCacheMap.getCourseDetailCacheMap().put(String.valueOf(courseDetail.getId()), courseDetail);
            }
        }
        logger.info(">>>>>> 缓存课程详情信息 >>>>>>\n\n");
    }

    /**
     * 缓存课时信息
     */
    private void lessonCache() {
        List<Lesson> lessonList = lessonService.findAll();
        if (lessonList != null && lessonList.size() > 0) {
            for (Lesson lesson : lessonList) {
                InitDataCacheMap.getLessonCacheMap().put(String.valueOf(lesson.getId()), lesson);
            }
        }
        logger.info(">>>>>> 缓存课时信息 >>>>>>\n\n");
    }

    /**
     * 缓存讲师信息
     */
    private void teacherCache() {
        List<Teacher> teacherList = teacherService.findAll();
        if (teacherList != null && teacherList.size() > 0) {
            for (Teacher teacher : teacherList) {
                InitDataCacheMap.getTeacherCacheMap().put(String.valueOf(teacher.getId()), teacher);
            }
        }
        logger.info(">>>>>> 缓存讲师信息 >>>>>>\n\n");
    }

    /**
     * 缓存用户基本信息
     */
    private void userCache() {
        List<User> userList = userService.findAll();
        if (userList != null && userList.size() > 0) {
            for (User user : userList) {
                InitDataCacheMap.getUserCacheMap().put(user.getUsername(), user);
            }
        }
        logger.info(">>>>>> 缓存用户基本信息 >>>>>>\n\n");
    }

}
