package com.liangyuyan.animal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class UploadImageController {
    @RequestMapping(value = "/image/photoUpload",method = RequestMethod.POST)
    public String photoUpload(MultipartFile file, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IllegalStateException, IOException {
        String uploadPath="";
        if (file!=null) {// 判断上传的文件是否为空
            String path=null;// 文件路径
            String path2=null;// 文件路径2
            String showPath = null; //显示路径
            String type=null;// 文件类型
            String fileName=file.getOriginalFilename();// 文件原名称
            System.out.println("上传的文件原名称:"+fileName);
            // 判断文件类型
            type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
            if (type!=null) {// 判断文件类型是否为空
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath="D:\\animal\\animal\\animal\\static\\";
                    String realPath2="D:\\学习资料\\myPet\\images\\content\\";
                    // 自定义的文件名称
                    String trueFileName=String.valueOf(System.currentTimeMillis())+fileName;
                    // 设置存放图片文件的路径
                    path=realPath+trueFileName;
                    path2=realPath2+trueFileName;
                    showPath="../../static/"+trueFileName;

                    System.out.println("存放图片文件的路径:"+path);
                    // 转存文件到指定的路径

                    try {
                        file.transferTo(new File(path));
                        file.transferTo(new File(path2));
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }

                    return showPath;
                }else {
                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
                    return null;
                }
            }else {
                System.out.println("文件类型为空");
                return null;
            }
        }else {
            System.out.println("没有找到相对应的文件");
            return null;
        }

    }

}
