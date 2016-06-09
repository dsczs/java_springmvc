package com.dsczs.common;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dsczs.dao.User;

@SessionAttributes("user")  //只能放在类的上面而不能放在方法的上面
@RequestMapping("/home")
@Controller
public class SpringMvcTest {
    private final static String SUCCESS="success";
    
    @RequestMapping(value="/testGetMethod",method=RequestMethod.GET)
    public String testGetMethod(){
        System.out.println("testGetMethod");
        return SUCCESS;
    }
    
    @RequestMapping(value="/testPostMethod",method=RequestMethod.POST)
    public String testPostMethod(){
        System.out.println("testPostMethod");
        return SUCCESS;
    }
    
    @RequestMapping(value="/testParams",params={"username","age!=10"})
    public String testParams(){
        System.out.println("testParams");
        return SUCCESS;
    }
    
    @RequestMapping(value="/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id){
        System.out.println("testPathVariable :" + id);
        return SUCCESS;
    }
    
    @RequestMapping("/test")
    public String test(){
        System.out.println("SpringMvc Test");
        return SUCCESS;
    }
    
    /**
     * REST 风格的URL
     * 以CRUD为例
     * 新增: /order POST
     * 修改: /order/1 PUT
     * 获取: /order/1 GET
     * 删除: /order/1 DELETE
     */
    @RequestMapping(value="/testRest/{id}",method=RequestMethod.GET)
    public String testRest(@PathVariable("id") Integer id){
        System.out.println("testRest :" + id);
        return SUCCESS;
    }
    
    @RequestMapping(value="/testRest",method=RequestMethod.POST)
    public String testRest(){
        System.out.println("testRest POST");
        return SUCCESS;
    }
    
    @RequestMapping(value="/testRest/{id}",method=RequestMethod.DELETE)
    public String testRestDelete(@PathVariable("id") Integer id){
        System.out.println("testRest DELETE :" + id);
        return SUCCESS;
    }

    @RequestMapping(value="/testRest/{id}",method=RequestMethod.PUT)
    public String testRestPut(@PathVariable("id") Integer id){
        System.out.println("testRestPut :" + id);
        return SUCCESS;
    }
    
    @RequestMapping(value="/testRequestParam")
    public String testRequestParam(@RequestParam(value="username") String username,
            @RequestParam(value="age" ,required=false,defaultValue="0") Integer age){
        System.out.println("testRequestParam : username = " + username +",age = " + age);
        return SUCCESS;
    }
    
    @RequestMapping(value="/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId){
        System.out.println("testCookieValue sessionId " + sessionId);
        return SUCCESS;
    }
    
    @RequestMapping(value="/testPojo")
    public String testPojo(User user){
        System.out.println("testPojo" + user);
        return SUCCESS;
    }
    
    @RequestMapping(value="/testServletAPI")
    public void testServletAPI(HttpServletRequest request,
            HttpServletResponse response,Writer out) throws IOException{
        System.out.println("testServletAPI request " + request +",response" +response);
        out.write("testServletAPI");
//        return SUCCESS;
    }
    
    @RequestMapping(value="/testModelAndView")
    public ModelAndView testModelAndView(){
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject("name","zhanggang");
        modelAndView.addObject("time",new Date());
        return modelAndView;
    }
    
    @RequestMapping(value="/testSessionAttribute")
    public String testSessionAttribute(Map<String,Object> map){
        User user = new User("tuniu", 10);
        map.put("user", user);
        return SUCCESS;
    }
    
    @ModelAttribute
    public void getUser(@RequestParam(value="id",required=false) Integer id,
            Map<String,Object> map){
        if(id != null){
            User user = new User(1, "hadoop123", "aaa", 22);
            System.out.println("从数据库中获取对象" + user);
            map.put("user", user);
        }
    }
    
    @RequestMapping(value="/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("修改" + user);
        return SUCCESS;
    }
    
    
}
