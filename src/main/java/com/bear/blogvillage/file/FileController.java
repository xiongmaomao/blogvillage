package com.bear.blogvillage.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {
    private static String UPLOADED_FOLDER = "E://temp//";


    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        /*String szFileName = file.getOriginalFilename();
        String szNewFileName = "";
        String szDateFolder = "";
        if (file != null && szFileName != null && szFileName.length() > 0) {
            Date date = new Date();
            szDateFolder = new SimpleDateFormat("yyyy/MM/dd").format(date);
            String szFilePath = request.getSession().getServletContext().getRealPath("upload") + "\\" + szDateFolder + "\\";
            File f = new File(szFilePath);
            if (!f.exists()) {
                f.mkdirs();
            }
            szNewFileName = UUID.randomUUID() + szFileName.substring(szFileName.lastIndexOf("."));
            File newFile = new File(szFilePath + "\\" + szNewFileName);
            file.transferTo(newFile);
            *//*Path path = Paths.get(newFile);
            byte[] bytes = file.getBytes();
            Files.write()*//*
        }*/



        try {
            byte[] bytes = file.getBytes();
            File f = new File(UPLOADED_FOLDER);
            if(!f.exists()){
                f.mkdirs();
            }
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/file/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "index.html";
    }
}
