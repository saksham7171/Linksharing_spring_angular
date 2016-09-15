package com.ttnd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class Dummy {

    @RequestMapping(value = "/dummy",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,String>> index(HttpServletRequest request, HttpServletResponse response){
        Map<String,String> m=new LinkedHashMap<String,String>();
        m.put("status","Success");
        response.addCookie(new Cookie("dummy","dummyvalue"));
        return new ResponseEntity<Map<String,String>>(m,HttpStatus.OK);
    }

    @RequestMapping(value = "/dummy2",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,String>> dummy(@CookieValue("dummy") String value,HttpServletRequest request, HttpServletResponse response){
        Map<String,String> map=new LinkedHashMap<String,String>();
        map.put("dummy",value);
        return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
    }
}
