package com.changgou.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @Author: lshsh
 * @Time: 2020/10/14 上午7:56
 * @Description: 文件上传工具类
 */
public class FastDFSUtil {

    static {
        //查找classpath的文件路径
        String path = new ClassPathResource("fdfs_client.conf").getPath();
        //加载tracker配置信息
        try {
            ClientGlobal.init(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
