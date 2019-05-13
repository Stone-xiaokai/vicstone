package com.macro.mall.pms.service;


import com.macro.mall.component.ServiceException;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface FileUpAndDownService {
    Map<String, Object> uploadPicture(MultipartFile file) throws ServiceException;
}
