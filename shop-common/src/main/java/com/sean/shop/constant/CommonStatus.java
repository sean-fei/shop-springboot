package com.sean.shop.constant;
/**
 * @Author: sean
 * @Date: 2018/8/14 9:23
 */
public class CommonStatus {

    // =========Informational 1xx  信息==========
    /**
     * 继续
     */
    public static final int CONTINUE = 100;

    /**
     * 交换协议
     */
    public static final int PROTOCOLS = 101;

    // =========Successful 2xx  成功==========
    /**
     * ok
     */
    public static final int OK = 200;

    /**
     * 创建
     */
    public static final  int CREATE = 201;

    /**
     * 已接受
     */
    public static final int ACCEPTED = 202;

    /**
     * 非权威信息
     */
    public static final int NON_AUTHORITATIVE_INFORMATION = 203;

    /**
     * 没有内容
     */
    public static final int NO_CONTENT = 204;

    /**
     * 重置内容
     */
    public static final int RESET_CONTENT = 205;

    /**
     * 部分内容
     */
    public static final int PARTIAL_CONTENT = 206;

    // =========Redirection 3xx  重定向==========
    /**
     * 多种选择
     */
    public static final int MULTIPLE_CHOICES = 300;
    /**
     * 永久移动
     */
    public static final int MOVED_PERMANENTLY = 301;

    /**
     * 找到
     */
    public static final int FOUND = 302;

    /**
     * 参见其他
     */
    public static final int SEE_OTHER = 303;

    /**
     * 未修改
     */
    public static final int NOT_MODIFIED = 304;

    /**
     * 使用代理
     */
    public static final int USE_PROXY = 305;

    /**
     * 未使用
     */
    public static final int UNUSED = 306;

    /**
     * 暂时重定向
     */
    public static final int TEMPORARY_REDIRECT = 307;

    // =========Client Error 4xx  客户端错误==========
    /**
     * 错误的请求
     */
    public static final int BAD_REQUEST = 400;

    /**
     * 未经授权
     */
    public static final int UNAUTHORIZED = 401;

    /**
     * 付费请求
     */
    public static final int PAYMENT_REQUIRED = 402;

    /**
     * 禁止
     */
    public static final int FORBIDDEN = 403;

    /**
     * 没有找到
     */
    public static final int NOT_FOUND = 404;

    /**
     * 方法不允许
     */
    public static final int METHOD_NOT_ALLOWED = 405;

    /**
     * 不可接受
     */
    public static final int NOT_ACCEPTABLE = 406;

    /**
     * 需要代理身份验证
     */
    public static final int PROXY_AUTHENTICATION_REQUIRED = 407;

    /**
     * 请求超时
     */
    public static final int REQUEST_TIMEOUT = 408;

    /**
     * 指令冲突
     */
    public static final int CONFLICT = 409;

    /**
     * 文档永久地离开了指定的位置
     */
    public static final int GONE = 410;

    /**
     * 需要Content-Length头请求
     */
    public static final int LENGTH_REQUIRED = 411;

    /**
     * 前提条件失败
     */
    public static final int PRECONDITION_FAILED = 412;

    /**
     * 请求实体太大
     */
    public static final int REQUEST_ENTITY_TOO_LARGE = 413;

    /**
     * 请求URI太长
     */
    public static final int REQUEST_URI_TOO_LONG = 414;

    /**
     * 不支持的媒体类型
     */
    public static final int UNSUPPORTED_MEDIA_TYPE = 415;

    /**
     * 请求的范围不可满足
     */
    public static final int REQUESTED_RANGE_NOT_SATISFIABLE = 416;

    /**
     * 期望失败
     */
    public static final int EXPECTATION_FAILED = 417;

    // =========Server Error 5xx  服务器错误==========
    /**
     * 内部服务器错误
     */
    public static final int SERVERERROR = 500;

    /**
     * 未实现
     */
    public static final int NOT_IMPLEMENTED = 501;

    /**
     * 错误的网关
     */
    public static final int BAD_GATEWAY = 502;

    /**
     * 服务不可用
     */
    public static final int SERVICE_UNAVAILABLE = 503;

    /**
     * 网关超时
     */
    public static final int GATEWAY_TIMEOUT = 504;

    /**
     * HTTP版本不支持
     */
    public static final int HTTP_VERSION_NOT_SUPPORTED = 505;

}
