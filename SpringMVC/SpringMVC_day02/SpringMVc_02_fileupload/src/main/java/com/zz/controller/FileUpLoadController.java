package com.zz.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author zhangbenchao
 * @date 2019-11-11 15:23
 * 文件描述：
 */
@Controller
@RequestMapping("/fileUpload")
public class FileUpLoadController {
    /**
     * SpringMVC方式跨服务器文件上传
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping("/testFileUpLoad3")
    public String testFileUpLoad3(MultipartFile upload) throws Exception {
        System.out.println("SpringMVC方式跨服务器文件上传执行了");

        String path = "http://localhost:9090/uploads/";

        String filename = UUID.randomUUID().toString().replace("-", "") + "_" + upload.getOriginalFilename();
        // 上传文件
        Client client = Client.create();
        WebResource webResource = client.resource(path+filename);
        webResource.put(upload.getBytes());
        return "success";
    }

    /**
     * SpringMVC方式文件上传
     * @param request
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping("/testFileUpLoad2")
    public String testFileUpLoad2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("SpringMVC方式文件上传执行了");
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        String filename = UUID.randomUUID().toString().replace("-", "") + "_" + upload.getOriginalFilename();
        // 上传文件
        upload.transferTo(new File(path,filename));

        return "success";
    }

    /**
     * 传统方式文件上传
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/testFileUpLoad1")
    public String testFileUpLoad1(HttpServletRequest request) throws Exception {
        System.out.println("执行了");
        // 创建目录保存上传的文件
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdir();
        }
        // 创建ServletFileUpload来解析request
        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
        List<FileItem> items = upload.parseRequest(request);
        // 遍历解析的结果,寻找上传文件项
        for(FileItem item:items){
            // 不是普通表单项,说明是文件上传项

            // 服务器中保存的文件名
            if (!item.isFormField()){
                String filename = UUID.randomUUID().toString().replace("-", "") + "_" + item.getName();
                // 上传文件
                item.write(new File(path, filename));
                // 删除临时文件
                item.delete();
            }
        }
        return "success";
    }
}
