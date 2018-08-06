package com.example.filedemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/uploads")
public class FileUploadController {
    private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);

    @GetMapping
    public String index(){
        return "index";
    }

    @PostMapping("/upload1")
    @ResponseBody
    public Map<String,String> upload1(@RequestParam("file") MultipartFile file)throws IOException {
        log.info("[文件类型] - [{}]",file.getContentType());
        log.info("[文件名称] - [{}]",file.getOriginalFilename());
        log.info("[文件大小] - [{}]",file.getSize());
        file.transferTo(new File("E:\\springworkspace\\file\\" + file.getOriginalFilename()));
        Map<String,String> result = new HashMap<>(16);
        result.put("contentType",file.getContentType());
        result.put("fileName",file.getOriginalFilename());
        result.put("fileSize",file.getSize() + "");
        return result;
    }

    @PostMapping("/upload2")
    @ResponseBody
    public List<Map<String,String>> upload2(@RequestParam("file") MultipartFile[] files)throws IOException{
        if(files == null || files.length == 0){
                return null;
        }
        List<Map<String,String>> results = new ArrayList<>();
        for(MultipartFile file : files){
            file.transferTo(new File("E:\\springworkspace\\file\\" + file.getOriginalFilename()));
            Map<String,String> map = new HashMap<>(16);
            map.put("contentType",file.getContentType());
            map.put("fileName",file.getOriginalFilename());
            map.put("fileSize",file.getSize() + "");
            results.add(map);
        }
        return results;
    }
    @PostMapping("/upload3")
    @ResponseBody
    public void upload2(String base64) throws IOException {
        //TODO base64方式的格式和名字需要自己控制（如png图片编码后前缀就会是data:image/png;base64,）
        final File tempFile = new File("E:\\springworkspace\\file\\test.jpg");
        String[] d = base64.split("base64,");
        final byte[] bytes = Base64Utils.decodeFromString(d.length > 1 ? d[1] : d[0]);
        FileCopyUtils.copy(bytes,tempFile);
    }
}
