package com.macro.mall.pms.controller;

import com.macro.mall.component.IStatusMessage;
import com.macro.mall.component.ResponseResult;
import com.macro.mall.component.ServiceException;
import com.macro.mall.pms.service.FileUpAndDownService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/upload")
public class FileUploadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private FileUpAndDownService fileUpAndDownService;


    @RequestMapping(value = "/setFileUpload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult setFileUpload(@RequestParam(value = "file", required = false) MultipartFile file) {
        ResponseResult result = new ResponseResult();
        try {
            System.out.println("---");
            System.out.println(file);
            Map<String, Object> resultMap = upload(file);
            if (!IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(resultMap.get("result"))) {
                result.setCode(IStatusMessage.SystemStatus.ERROR.getCode());
                result.setMessage((String) resultMap.get("msg"));
                return result;
            }
            result.setData(resultMap);
        } catch (ServiceException e) {
            e.printStackTrace();
            LOGGER.error(">>>>>>图片上传异常，e={}", e.getMessage());
            result.setCode(IStatusMessage.SystemStatus.ERROR.getCode());
            result.setMessage(IStatusMessage.SystemStatus.FILE_UPLOAD_ERROR.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/setFileUploads", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult setFileUploads(@RequestParam(value = "file1", required = false) MultipartFile file1,@RequestParam(value = "file2", required = false) MultipartFile file2,@RequestParam(value = "file3", required = false) MultipartFile file3) {
        ResponseResult result = new ResponseResult();
        List pathimg = new ArrayList();
        Map<String, Object> resultMaplist = new HashMap<String, Object>();
        if(file1!=null){
            try {
                System.out.println("---");
                System.out.println(file1);
                Map<String, Object> resultMap = upload(file1);
                if (!IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(resultMap.get("result"))) {
                    result.setCode(IStatusMessage.SystemStatus.ERROR.getCode());
                    result.setMessage((String) resultMap.get("msg"));
                    return result;
                }
                pathimg.add(resultMap.get("path"));
                result.setData(resultMap);
            } catch (ServiceException e) {
                e.printStackTrace();
                LOGGER.error(">>>>>>图片上传异常，e={}", e.getMessage());
                result.setCode(IStatusMessage.SystemStatus.ERROR.getCode());
                result.setMessage(IStatusMessage.SystemStatus.FILE_UPLOAD_ERROR.getMessage());
            }
        }
        if(file2!=null){
            try {
                System.out.println("---");
                System.out.println(file2);
                Map<String, Object> resultMap = upload(file2);
                if (!IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(resultMap.get("result"))) {
                    result.setCode(IStatusMessage.SystemStatus.ERROR.getCode());
                    result.setMessage((String) resultMap.get("msg"));
                    return result;
                }
                pathimg.add(resultMap.get("path"));
                result.setData(resultMap);
            } catch (ServiceException e) {
                e.printStackTrace();
                LOGGER.error(">>>>>>图片上传异常，e={}", e.getMessage());
                result.setCode(IStatusMessage.SystemStatus.ERROR.getCode());
                result.setMessage(IStatusMessage.SystemStatus.FILE_UPLOAD_ERROR.getMessage());
            }
        }
        if(file3!=null){
            try {
                Map<String, Object> resultMap = upload(file3);
                if (!IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(resultMap.get("result"))) {
                    result.setCode(IStatusMessage.SystemStatus.ERROR.getCode());
                    result.setMessage((String) resultMap.get("msg"));
                    return result;
                }
                pathimg.add(resultMap.get("path"));
            } catch (ServiceException e) {
                e.printStackTrace();
                LOGGER.error(">>>>>>图片上传异常，e={}", e.getMessage());
                result.setCode(IStatusMessage.SystemStatus.ERROR.getCode());
                result.setMessage(IStatusMessage.SystemStatus.FILE_UPLOAD_ERROR.getMessage());
            }
        }
        resultMaplist.put("path",pathimg);
        result.setData(resultMaplist);
        return result;
    }

    private Map<String, Object> upload(MultipartFile file) throws ServiceException {
        Map<String, Object> returnMap = new HashMap<>();
        try {
            if (!file.isEmpty()) {
                Map<String, Object> picMap = fileUpAndDownService.uploadPicture(file);
                if (IStatusMessage.SystemStatus.SUCCESS.getMessage().equals(picMap.get("result"))) {
                    return picMap;
                } else {
                    returnMap.put("result", IStatusMessage.SystemStatus.ERROR.getMessage());
                    returnMap.put("msg", picMap.get("result"));
                }
            } else {
                LOGGER.info(">>>>>>上传图片为空文件");
                returnMap.put("result", IStatusMessage.SystemStatus.ERROR.getMessage());
                returnMap.put("msg", IStatusMessage.SystemStatus.FILE_UPLOAD_NULL.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(IStatusMessage.SystemStatus.FILE_UPLOAD_ERROR.getMessage());
        }
        return returnMap;
    }
}
