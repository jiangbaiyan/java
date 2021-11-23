package com.imooc.controller.center;

import com.imooc.controller.BaseController;
import com.imooc.pojo.Users;
import com.imooc.pojo.bo.center.CenterUserBO;
import com.imooc.resource.FileUpload;
import com.imooc.service.center.CenterUserService;
import com.imooc.utils.CookieUtils;
import com.imooc.utils.DateUtil;
import com.imooc.utils.IMOOCJSONResult;
import com.imooc.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "用户信息接口", tags = {"用户信息相关接口"})
@RequestMapping("center")
public class CenterUserController extends BaseController {

    @Autowired
    private CenterUserService centerUserService;

    @Autowired
    private FileUpload fileUpload;

    @ApiOperation(value = "修改用户头像", notes = "修改用户头像", httpMethod ="POST")
    @GetMapping("update")
    public IMOOCJSONResult uploadFace(@RequestParam String userId, MultipartFile file, HttpServletRequest req, HttpServletResponse rsp) {
        // 头像保存的地址
        String fileSpace = fileUpload.getImageUserFaceLocation();
        String uploadPathPrefix = File.separator + userId;
        if (file == null) {
            return IMOOCJSONResult.errorMsg("文件不能为空");
        }
        String fileName = file.getOriginalFilename();
        if (StringUtils.isBlank(fileName)) {
            return IMOOCJSONResult.errorMsg("文件名不能为空");
        }
        // 文件重命名 imooc-face.png -> ["imocc-face", "png"]
        String[] fileNameArr = fileName.split("\\.");
        // 后缀名
        String suffix = fileNameArr[fileNameArr.length - 1];
        if (!suffix.equals("png") && !suffix.equals("jpg") && !suffix.equals("jpeg")) {
            return IMOOCJSONResult.errorMsg("格式不正确");
        }
        String newFileName = "face-" + userId + "." + suffix;
        String finalFacePath = fileSpace + uploadPathPrefix + File.separator + newFileName;
        uploadPathPrefix += ("/"+ newFileName);
        // 创建目录
        File outFile = new File(finalFacePath);
        if (outFile.getParentFile() != null) {
            outFile.getParentFile().mkdirs();
        }
        // 文件输出保存到目录
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(outFile);
            InputStream inputStream = file.getInputStream();
            IOUtils.copy(inputStream, fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        String serverUrl = fileUpload.getImageServerUrl();
        // 浏览器可能有缓存，需要加上时间戳保证图片及时刷新
        Users userResult = centerUserService.updateUserFace(userId, serverUrl + uploadPathPrefix + "?t=" + DateUtil.getCurrentDateString(DateUtil.DATE_PATTERN));
        userResult = setNullProperty(userResult);
        return IMOOCJSONResult.ok();
    }

    @ApiOperation(value = "修改用户信息", notes = "修改用户信息", httpMethod ="POST")
    @PostMapping("update")
    public IMOOCJSONResult update(@RequestParam String userId, @RequestBody @Valid CenterUserBO centerUserBO, BindingResult result, HttpServletRequest req, HttpServletResponse rsp) {

        if (result.hasErrors()) {
            Map<String, String> errorMap = getErrors(result);
            return IMOOCJSONResult.errorMap(errorMap);
        }
        Users user = centerUserService.updateUserInfo(userId, centerUserBO);
        user = setNullProperty(user);
        CookieUtils.setCookie(req, rsp, "user", JsonUtils.objectToJson(user), true);
        return IMOOCJSONResult.ok(user);
    }

    private Map<String, String> getErrors(BindingResult result) {
        List<FieldError> fieldErrors = result.getFieldErrors();
        Map<String, String> map = new HashMap<>();
        for (FieldError error : fieldErrors) {
            // 发生验证错误对应的某个属性
            String errorField = error.getField();
            String errorMsg = error.getDefaultMessage();
            map.put(errorField, errorMsg);
        }
        return map;
    }

    private Users setNullProperty(Users userResult) {
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        userResult.setBirthday(null);
        return userResult;
    }
}
