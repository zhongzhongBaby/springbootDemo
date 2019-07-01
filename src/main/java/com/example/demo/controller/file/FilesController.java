package com.example.demo.controller.file;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/ckeditor")
public class FilesController {

    Logger logger = org.apache.log4j.Logger.getLogger(FilesController.class);

    @Value(value = "${ckeditor.storage.image.path}")
    private String ckeditorStorageImagePath;

    @Value(value = "${ckeditor.access.image.url}")
    private String ckeditorAccessImageUrl;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public  String  uploadImage( HttpServletRequest request, HttpServletResponse response) {
       return "importExcel.html";
    }



    @RequestMapping(value = "/upload/image", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> uploadImage(@RequestParam("upload") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        String name = "";
        Map<String, Object> m = new HashMap<>();
        if (!file.isEmpty()) {
            try {
                response.setContentType("text/html; charset=UTF-8");
                response.setHeader("Cache-Control", "no-cache");
                //解决跨域问题
                //Refused to display 'http://localhost:8080/upload/mgmt/img?CKEditor=practice_content&CKEditorFuncNum=1&langCode=zh-cn' in a frame because it set 'X-Frame-Options' to 'DENY'.
                response.setHeader("X-Frame-Options", "SAMEORIGIN");

                String fileClientName = file.getOriginalFilename();
                String pathName = ckeditorStorageImagePath + fileClientName;
                File newfile = new File(pathName);
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newfile));
                stream.write(bytes);
                stream.close();
                // 组装返回url，以便于ckeditor定位图片
                String fileUrl = ckeditorAccessImageUrl + File.separator + newfile.getName();
                m.put("uploaded", true);
                m.put("url", fileUrl);
            } catch (Exception e) {
                logger.info("You failed to upload " + name + " => " + e.getMessage());
            }
        } else {
            logger.info("You failed to upload " + name + " because the file was empty.");
        }
        return m;
    }
}
