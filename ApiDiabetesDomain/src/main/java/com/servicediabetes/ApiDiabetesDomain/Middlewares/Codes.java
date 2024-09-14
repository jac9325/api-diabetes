package com.servicediabetes.ApiDiabetesDomain.Middlewares;

import org.springframework.stereotype.Component;

/**
 *
 * @author HP
 */
/* Codigos regurlamente requeridos*/

@Component
public class Codes {
   
    public int ok(){
        return 200;
    }
    
    public int created(){
        return 201;
    }
    
    public int conflict(){
        return 409;
    }
    
    public int error(){
        return 400;
    }
    
    public int notFound(){
        return 404;
    }
    
    public int server_error(){
        return 500;
    }
    
}

