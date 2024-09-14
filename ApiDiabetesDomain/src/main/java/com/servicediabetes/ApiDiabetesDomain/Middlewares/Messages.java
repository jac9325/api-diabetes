
package com.servicediabetes.ApiDiabetesDomain.Middlewares;

import org.springframework.stereotype.Component;

/**
 *
 * @author HP
 */

@Component
public class Messages {
     public String ok(){
        return "ok";
    }
    
    public String success(){
        return "success";
    }
    
    public String welcomeMessage(){
        return "Welcome to Home Page";
    }
    
    public String pageNotFound(){
        return "Page Not Found";
    }
    
    public String created(){
        return "created";
    }
    
    public String updated(){
        return "updated";
    }
    
    public String deleted(){
        return "deleted";
    }
    
    public String error(){
        return "error";
    }
    
    public String notFound(){
        return "not found";
    }
}
