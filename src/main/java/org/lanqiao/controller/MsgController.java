package org.lanqiao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.entity.Msg;
import org.lanqiao.service.MsgMybatisImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
@Controller
public class MsgController {
    @RequestMapping("/get ")
//    public ModelAndView getAll(@RequestParam(value = "pageNo",defaultValue = "1") int pageNum){
//        PageHelper.startPage(pageNum, 3);
//        List<Msg> msglist=new MsgMybatisImpl().getAllmsg();
//        PageInfo<Msg> p =new PageInfo<Msg>(msglist);
//        return new ModelAndView("pager","pageInfo",p);
//    }
    //效果同上 不同实现
    public String getAll(@RequestParam(value = "pageNo",defaultValue = "1") int pageNum, Model m){
        PageHelper.startPage(pageNum, 3);
        List<Msg> msglist=new MsgMybatisImpl().getAllmsg();
        PageInfo<Msg> p =new PageInfo<Msg>(msglist);
//        return new ModelAndView("pager","pageInfo",p);
        m.addAttribute("pageInfo",p);
        return "pager";
    }
    @RequestMapping("/insert")
    public String insert(@Valid Msg m, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.getErrorCount()>0){
            redirectAttributes.addFlashAttribute("errors",result.getFieldErrors());
        }else {
            new MsgMybatisImpl().insert(m);
        }
        return "redirect:get";
    }
}
