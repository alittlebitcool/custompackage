package com.mufan.custompackage.web;

import com.mufan.custompackage.cons.Constant;
import com.mufan.custompackage.service.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.mufan.custompackage.util.WeChatUtil.interfaceUtil;

/**
 * @author YuXingZh
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    private static Logger logger = Logger.getLogger(UserController.class);

    /**
     * @Description: 获取openId
     * @Param: code
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/20
     */
    @RequestMapping("/getOpenId")
    public String getOpenId(@RequestParam("code") String code) {
        logger.info("获取openId");

        //临时登录凭证
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + Constant.APPID + "&secret=" +
                Constant.APPSECRET + "&js_code=" + code + "&grant_type=authorization_code";
        String openId = interfaceUtil(url, "");
        logger.info("获取成功,openId是" + openId);
        return openId;
    }

    /**
     * @Description: 验证openId是否有授权过
     * @Param: openId
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/20
     */
    @RequestMapping("verify")
    public boolean verify(@RequestParam("openId") String openId) {
        logger.info("验证openId" + openId + "是否登录过");
        if (userService.verify(openId)) {
            logger.info("用户已授权,验证通过");
        } else {
            logger.info("用户未授权");
        }
        return userService.verify(openId);
    }

    /**
     * @Description: 授权
     * @Param: openId
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/20
     */
    @RequestMapping("grant")
    public void grant(@RequestParam("openId") String openId,@RequestParam("userName")String userName) {
        logger.info("授权openId为" + openId + "的用户");
        userService.grant(openId,userName);
        logger.info("授权成功");
    }

    /**
     * @Description: 授权
     * @Param: openId
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/20
     */
    @RequestMapping("userId")
    public int getUserId(@RequestParam("openId") String openId) {
        logger.info("获取userId");
        int userId = userService.getUserId(openId);
        logger.info("获取userId成功");
        return userId;
    }
}