package cn.summerwaves.controller;

import cn.summerwaves.model.User;
import cn.summerwaves.service.IUserService;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class InterceptorController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView toLogin(@Param("username")String username,@Param("password")String password,HttpServletRequest request,HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@Param("username")String username,@Param("password")String password,HttpServletRequest request,HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        User realUser = null;
        realUser = userService.selectUserByName(username);
        if (realUser != null && realUser.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("message", username);
            mv.setViewName("loginSuccess");
            mv.addObject("username", realUser.getUsername());
            return mv;
        } else {
            mv.setViewName("loginFail");
            return mv;
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String toWelcome() {
        return "welcome";
    }

    @RequestMapping(value = "/skip", method = RequestMethod.GET)
    public String toSkip() {
        return "skipToLogin";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String toHome() {
        return "home";
    }

    @RequestMapping(value = "/u/position", method = RequestMethod.GET)
    public String toPosition() {
        return "position";
    }

}
