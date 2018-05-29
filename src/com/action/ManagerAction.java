package com.action;

import com.model.Manager;
import com.model.Venue;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ManagerService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by guagua on 18/2/23.
 */

@Component("managerAction")
@Scope("prototype")
public class ManagerAction extends ActionSupport{
    private static final long serialVersionUID =1L;

    @Autowired
    private ManagerService managerService;

    private String userid;

    private String password;

    private List<Venue>venues;

    public ManagerService getManagerService() {
        return managerService;
    }

    @Resource
    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }

    public List<Venue> getVenues() {
        return venues;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }

    public String queryManager(){
        userid = getParam("Username");
        password = getParam("Password");
        HttpSession session=ServletActionContext.getRequest().getSession();
        System.out.println(userid);
        if(userid==null){
            userid = session.getAttribute("Username").toString();
            password = session.getAttribute("Password").toString();
        }
        String result = managerService.login(userid,password);
        ActionContext actionContext = ActionContext.getContext();
        if(result.equals("SUCCESS")){
            //登录成功
            session.setAttribute("Username",userid);
            session.setAttribute("Password",password);
            venues = managerService.getVenueRegister();
            result = SUCCESS;
        }
        else{
            actionContext.put("result","wrongPW");
            result = ERROR;
        }
        return result;
    }

    public String approveVenueRegister(){
        String userid = getParam("id");
        managerService.approve(userid);
        queryManager();
        return SUCCESS;
    }



    /**
     * 从jsp页面获得参数值
     * @param key
     * @return
     */
    protected String getParam(String key){
        return ServletActionContext.getRequest().getParameter(key);
    }

}
