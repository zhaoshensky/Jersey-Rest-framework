package com.sdc.utils;

import java.util.HashMap;
import java.util.Map;

import javax.management.j2ee.statistics.Statistic;

import org.apache.commons.io.monitor.FileAlterationListener;

/**
 * @author
 */
public class ClientConstant {


    /**************************全局返回码********************************/

    /**********************************************************/
    //数据返回成功 begin 服务器成功返回用户请求数据
    public static final String ERROR_0_STATUS = "200";
    public static final String ERROR_0_STATUSNAME = "服务器成功返回用户请求数据";
    //数据返回成功 over
    /**********************************************************/
    /**********************************************************/
    //数据返回成功 begin
    public static final String ERROR_1_STATUS = "404";
    public static final String ERROR_1_STATUSNAME = "请求的数据不存在";
    //数据返回成功 over
    /**********************************************************/
    /**********************************************************/
    //数据返回成功 begin
    public static final String ERROR_401_STATUS = "401";
    public static final String ERROR_401_STATUS_MSG = "授权验证失败";
    //数据返回成功 over
    /**********************************************************/

    /**********************************************************/
    //Filter Error Begin
    public static final String PERMISSION_ERROR_900001_STATUS = "900001";
    public static final String PERMISSION_ERROR_900001_STATUS_MSG = "非法的请求类型";
    public static final String PERMISSION_ERROR_900002_STATUS = "900002";
    public static final String PERMISSION_ERROR_900002_STATUS_MSG = "没有检测到有效的商户信息";
    public static final String PERMISSION_ERROR_900003_STATUS = "900003";
    public static final String PERMISSION_ERROR_900003_STATUS_MSG = "没有检测到有效的参数";
    public static final String PERMISSION_ERROR_900004_STATUS = "900004";
    public static final String PERMISSION_ERROR_900004_STATUS_MSG = "解析后的参数列表为空";
    public static final String PERMISSION_ERROR_900005_STATUS = "900005";
    public static final String PERMISSION_ERROR_900005_STATUS_MSG = "无效的公匙参数";
    public static final String PERMISSION_ERROR_900006_STATUS = "900006";
    public static final String PERMISSION_ERROR_900006_STATUS_MSG = "无效的签名参数";
    public static final String PERMISSION_ERROR_900007_STATUS = "900007";
    public static final String PERMISSION_ERROR_900007_STATUS_MSG = "无效的时间戳参数";
    public static final String PERMISSION_ERROR_900008_STATUS = "900008";
    public static final String PERMISSION_ERROR_900008_STATUS_MSG = "必须参数不存在或者不完整";
    public static final String PERMISSION_ERROR_900009_STATUS = "900009";
    public static final String PERMISSION_ERROR_900009_STATUS_MSG = "签名验证失败";
    //Filter Error Over
    /**********************************************************/

    /***************************增删改查成功返回码*******************************/
    public static final String QUERY_SUCCESS = "200";
    //新建跟修改成功返回码
    public static final String NEWUPDATE_SUCCESS = "201";
    public static final String DELETE_SUCCESS = "204";


    /***************************全局通用返回码*******************************/
    public static final String Search_Execption_CODE = "00001";
    public static final String Search_Execption_CODE_MSG = "查询代码中存在异常";

    public static final String SupplierId_Execption_CODE = "00002";
    public static final String SupplierId_Execption_CODE_MSG = "商户id非法";

    /**
     * 全局返回码  demo begin
     **/

    //查询失败
    public static final String QUERY_ERROR = "10001";
    public static final String QUERY_ERROR_MSG = "查询失败";
    //插入失败
    public static final String INSERT_ERROR = "10002";
    public static final String INSERT_ERROR_MSG = "新增失败";
    //更新失败
    public static final String UPDATE_ERROR = "10003";
    public static final String UPDATE_ERROR_MSG = "修改失败";
    //删除失败
    public static final String DELETE_ERROR = "10004";
    public static final String DELETE_ERROR_MSG = "删除失败";

    /**
     * 全局返回码  demo end
     **/

    public static final int VISIT_SOURCE_APP = 1;
    public static final int VISIT_SOURCE_PC = 2;
    public static final int VISIT_SOURCE_H5 = 3;
    public static final int VISIT_SOURCE_DK = 4;
    /**
     * 发送手机验证码业务名
     */
    public static final String REGISTER = "register";
    public static final String FIND = "find";
    public static final String NEW_MOBILE = "newMobile";
    public static final String OLD_MOBILE = "oldMobile";
    public static final String BINDING = "binding";
    public static final String UPDATE = "update";

    public static final String FEIHE = "feihe";
    public static final String FEIHE_MEMBER_ID = "feiheMmeberId";

    /**
     * 错误返回码 11000: 封宁进;  12000： 贾程浩;  13000 : 黄颀洪;  14000 ：王峰;  15000 :孟祥;  16000：李利赓;  17000:毛丽霞
     */
    /**********************************************************/
    public static final String ERR_PHONE_FORMAT = "13001";
    public static final String ERR_PHONE_FORMAT_MSG = "手机号格式不正确";
    public static final String MOBILE_BINDING_SUCCESS = "手机号绑定成功";
    public static final String MOBILE_UPDATE_SUCCESS = "手机号更新成功";
    public static final String MEMBER_EXIST_MOBILE = "该用户已经绑定过手机";
    public static final String MEMBER_NO_MOBILE = "该用户还没有绑定过手机";
    public static final String MEMBER_REPEAT_MOBILE = "不能和原来的手机号相同";
    public static final String VALIDATOR_FAIL = "13002";
    public static final String VALIDATOR_FAIL_MSG = "该用户没有权限";
    public static final String PARAMS_REEOR_MSG = "参数有误,必要参数不允许为空或不是正确的手机号";
    public static final String PARAMS_NULL_MSG = "必要参数不允许为空";
    public static final String PARAMS_FORMAT_ERROR_MSG = "参数格式有误";
    public static final String INSERT_MEMEBER_VALIDATOR = "13003";
    public static final String INSERT_MEMEBER_VALIDATOR_MSG = "必须字段不允许为空，请检查后重新操作";

    public static final String INSERT_MEMEBER_SOURCE = "13004";
    public static final String INSERT_MEMEBER_SOURCE_MSG = "来源不允许为空，请检查后重新操作";

    public static final int INSERT_MEMBER_SUCCESS = 1;
    public static final int INSERT_MEMBER_FAIL = 0;
    public static final int INSERT_MEMBER_EXIST = 2;
    public static final String INSERT_MEMBER_SUCCESS_MSG = "success_count";
    public static final String INSERT_MEMBER_FAIL_MSG = "fail_count";
    public static final String INSERT_MEMBER_EXIST_MSG = "exist_count";
    //获取手机 验证码 不同的业务场景
    public static final String PHONE_REGISTER = "register";
    public static final String PHONE_PASSWORD = "password";

    public static final Byte BYTE_0 = 0;
    public static final Byte BYTE_1 = 1;

    public static final String SELECT_POINTS_SET_NULL = "13005";
    public static final String SELECT_POINTS_SET_NULL_MSG = "该账户没有积分设置";

    public static final String SAVE_POINTS_SET_FAIL = "13006";
    public static final String SAVE_POINTS_SET_FAIL_MSG = "保存用户积分设置失败";

    public static final String SELECT_POINTS_RULE_NULL = "13007";
    public static final String SELECT_POINTS_RULE_NULL_MSG = "该账户没有积分规则";

    public static final String SAVE_POINTS_RULE_FAIL = "13008";
    public static final String SAVE_POINTS_RULE_FAIL_MSG = "保存用户积分规则失败";

    public static final String SAVE_POINTS_DETAIL_FAIL = "13009";
    public static final String SAVE_POINTS_DETAIL_FAIL_MSG = "保存用户积分详情失败";

    public static final String NO_VALITATOR_SELECT_POINTS = "13010";
    public static final String NO_VALITATOR_SELECT_POINTS_MSG = "该用户没有权限查询积分相关设置";
    public static final String POINTS_RULE_TYPE_NULL = "13011";
    public static final String POINTS_RULE_TYPE_NULL_MSG = "积分规则不允许为空";
    public static final String POINTS_DY_0 = "13012";
    public static final String POINTS_DY_0_MSG = "消费积分规则下积分必须小于0";
    public static final String DELETE_POINTS_RULE_TYPE_FAIL = "13013";
    public static final String DELETE_POINTS_RULE_TYPE_FAIL_MSG = "删除积分规则失败";
    public static final String INSERT_POINTS_RULE_TYPE_FAIL = "13014";
    public static final String INSERT_POINTS_RULE_TYPE_FAIL_MSG = "添加积分规则失败";
    public static final String UPDATE_POINTS_RULE_TYPE_FAIL = "13015";
    public static final String UPDATE_POINTS_RULE_TYPE_FAIL_MSG = "更新积分规则失败";
    public static final String SELECT_POINTS_RULE_TYPE_FAIL = "13016";
    public static final String SELECT_POINTS_RULE_TYPE_FAIL_MSG = "查询积分规则失败";
    public static final String NO_VALITATOR_DELETE_RULE_TYPE = "13017";
    public static final String NO_VALITATOR_DELETE_RULE_TYPE_MSG = "系统默认积分规则，不允许删除";
    public static final String NO_VALITATOR_UPDATE_RULE_TYPE = "13018";
    public static final String NO_VALITATOR_UPDATE_RULE_TYPE_MSG = "系统默认积分规则，不允许修改";
    public static final String POINTS_XY_0 = "13019";
    public static final String POINTS_XY_0_MSG = "消费积分规则下积分必须小于0";
    public static final String RULE_TYPE_EXIST = "13020";
    public static final String RULE_TYPE_EXIST_MSG = "积分规则类型已存在";
    public static final String RULE_TYPE_NULL = "13021";
    public static final String RULE_TYPE_NULL_MSG = "积分规则类型不存在";
    public static final String RULE_TYPE_OR_EXPLAIN_NULL = "13022";
    public static final String RULE_TYPE_OR_EXPLAIN_NULL_MSG = "type和explain不允许为空";
    public static final String POINTS_SET_EXIST = "13023";
    public static final String POINTS_SET_EXIST_MSG = "该商户已经存在积分设置";
    public static final String NO_POINTS_SET_EXIST = "13024";
    public static final String NO_POINTS_SET_EXIST_MSG = "该商户不存在积分设置，请先添加";
    public static final String NO_POINTS_SWITCH = "13025";
    public static final String NO_POINTS_SWITCH_MSG = "该商户未开通积分功能，请开通后再添加";
    public static final String RULE_TYPE_NO_USE = "13026";
    public static final String RULE_TYPE_NO_USE_MSG = "积分规则为空或者积分规则设置不可用";

    public static final String COUPON_ID_OR_TYPE_NULL = "13027";
    public static final String COUPON_ID_OR_TYPE_NULL_MSG = "优惠券活动id或者活动类型不允许为空";

    public static final String ACTIVITY_ID_SUPPLIERID_NULL = "13028";
    public static final String ACTIVITY_ID_SUPPLIERID_NULL_MSG = "活动id、商户id都不允许为空";
    public static final String COUPON_DETAIL_NULL = "13029";
    public static final String COUPON_DETAIL_NULL_MSG = "supplier_id,activity_id、type、code、visitSource不允许为空";
    public static final String GET_COUPON__NULL = "13030";
    public static final String GET_COUPON_NULL_MSG = "supplier_id,activity_id、type、member_id不允许为空";
    public static final String INSERT_GNM_NULL = "13031";
    public static final String INSERT_GNM_NULL_MSG = "type,coupon_activity_id,begin_at,end_at,use_stores不允许为空";
    public static final String INSERT_GNM_FAIL = "13032";
    public static final String INSERT_GNM_FAIL_MSG = "插入gnm失败";
    public static final String GNM_ID_NULL = "13033";
    public static final String GNM_ID_NULL_MSG = "id不允许为空";
    public static final String UPDATE_GNM_FAIL = "13034";
    public static final String UPDATE_GNM_FAIL_MSG = "更新gnm失败";

    public static final String MEMBERS_NULL_FAIL = "13035";
    public static final String MEMBERS_NULL_FAIL_MSG = "json数据格式不正确";

    public static final String COUPON_NULL_FAIL = "13036";
    public static final String COUPON_NULL_FAIL_MSG = "必要字段不允许为空";

    public static final String NO_VALITATOR = "13037";
    public static final String NO_VALITATOR_MSG = "没有权限，不允许修改";

    public static final String ACTIVITY_END = "13038";
    public static final String ACTIVITY_END_MSG = "优惠券活动不存在或未开始或已结束";

    public static final String ACTIVITY_QUANTUTITY_0 = "13038";
    public static final String ACTIVITY_QUANTUTITY_0_MSG = "优惠券活动库存不足";

    public static final String BEYOND_NUM = "13039";
    public static final String BEYOND_NUM_MSG = "亲，不要贪心哟，您已经领取过喽~~~";

    public static final String INSERT_COUPON_LIST_FAIL = "13040";
    public static final String INSERT_COUPON_LIST_FAIL_MSG = "优惠券活动库存不足";

    public static final String MEMBER_NULL = "13041";
    public static final String MEMBER_NULL_MSG = "必要字段不允许为空或者手机号格式不正确";
    public static final String ONE_MINUTE = "13042";
    public static final String ONE_MINUTE_MSG = "请求太频繁，请一分钟后再试";
    public static final String MEMBER_MOBILE_AUTHKEY_NULL = "13043";
    public static final String MEMBER_MOBILE_AUTHKEY_NULL_MSG = "mobile和authkey(微信唯一标识)不能同时为空";
    public static final String MEMBER_AUTHKEY_NULL_MSG = "微信唯一标识不能同时为空";
    public static final String MEMBER_SUPPLIERID_NULL = "13044";
    public static final String MEMBER_SUPPLIERID_NULL_MSG = "supplier_id等一些必要字段不允许为空";
    public static final String MEMBER_EXIST = "13045";
    public static final String MEMBER_EXIST_MSG = "会员已存在，手机号或微信唯一标识重复";
    public static final String MEMBER_INSERT_FAIL = "13046";
    public static final String MEMBER_INSERT_FAIL_MSG = "插入会员失败";
    public static final String MOBILE_TYPE_FAIL = "13047";
    public static final String MOBILE_TYPE_FAIL_MSG = "不被允许的业务类型，不允许发送验证码";
    public static final String USER_EXIST = "13048";
    public static final String USER_EXIST_MSG = "该手机号已注册！";
    public static final String USER_NO_EXIST = "13049";
    public static final String USER_NO_EXIST_MSG = "该用户不存在，请确认后重试！";
    public static final String SEND_MOBILE_CODE_SUCCESS = "发送验证码成功，请注意查收";
    public static final String SEND_MOBILE_CODE_FAIL = "13063";
    public static final String SEND_MOBILE_CODE_FAIL_MSG = "发送验证码失败";
    /*************************小票信息***********************************/
    public static final String TICKET_DEVICE_ID_NULL = "13050";
    public static final String TICKET_DEVICE_ID_NULL_MSG = "小票id、设备id不允许为空";
    public static final String TICKET_SUPPLIER_ID_NULL = "13051";
    public static final String TICKET_SUPPLIER_ID_NULL_MSG = "商户id不允许为空";
    public static final String TICKET_NO_EXIST = "13052";
    public static final String TICKET_NO_EXIST_MSG = "小票信息不存在";
    public static final String TICKET_SAVE_FAIL = "13053";
    public static final String TICKET_SAVE_FAIL_MSG = "保存小票信息失败";
    public static final String TICKET_UPDATE_FAIL_MSG = "更新小票信息失败";
    public static final String TICKET_MEMBER_ID_NULL = "13054";
    public static final String TICKET_MEMBER_ID_NULL_MSG = "会员不存在";
    public static final String TICKET_OPERATE_ID_NULL = "13055";
    public static final String TICKET_OPERATE_ID_NULL_MSG = "操作人不允许为空";
    public static final String TICKET_ID_NULL = "13056";
    public static final String TICKET_ID_NULL_MSG = "小票id不允许为空";
    public static final String DEPARTMENT_ID_NULL = "13057";
    public static final String DEPARTMENT_ID_NULL_MSG = "门店id不允许为空";
    public static final String SUPPLIER_ID_NULL = "13058";
    public static final String SUPPLIER_ID_NULL_MSG = "商户id不允许为空";
    public static final String DEVICE_ID_NULL = "13059";
    public static final String DEVICE_ID_NULL_MSG = "设备id不允许为空";
    public static final String DEVICE_ID_NULL_MSG1 = "设备和类型参数不允许为空";
    public static final String DEVICE_NULL_MSG = "必要字段不允许为空";
    public static final String DEVICE_ID_NO_EXIST_MSG = "设备id没有对应门店";
    public static final String DEVICE_EXIST_MSG = "设备已经绑定过门店";
    public static final String DEVICE_NO_EXIST_MSG = "设备不存在";
    public static final String DEVICE_INSERT_FAIL_MSG = "设备绑定失败";
    public static final String DEVICE_DELETE_FAIL_MSG = "设备删除失败";
    public static final String MEMBER_TICKET_EXIST = "13060";
    public static final String MEMBER_TICKET_EXIST_MSG = "会员已扫描过该小票上的二维码";
    public static final String UPDATE_MEMBER_TICKET_FAIL = "13061";
    public static final String UPDATE_MEMBER_TICKET_FAIL_MSG = "更新会员的小票信息失败";
    public static final String TICKET_SOURCE_NULL = "13062";
    public static final String TICKET_SOURCE_NULL_MSG = "来源不允许为空";
    public static final String TICKET_ID_CODE_NULL = "13063";
    public static final String TICKET_ID_CODE_NULL_MSG = "小票id和编码不允许同时为空，或同时不为";
    public static final String AUTH_KEY_NULL = "13064";
    public static final String AUTH_KEY_NULL_MSG = "微信唯一标识不允许为空";
    public static final String TICKET_EXIST = "13065";
    public static final String TICKET_EXIST_MSG = "已经解析过该小票";
    public static final String GNM_EXIST = "13066";
    public static final String GNM_EXIST_MSG = "活动适用门店跟已有活动时间冲突";

    public static final String REQUEST_FREQUENT = "13067";
    public static final String REQUEST_FREQUENT_MSG = "请求频繁，请稍后再试";

    public static final String SUPPLIER_EXIST = "13068";
    public static final String SUPPLIER_EXIST_MSG = "商户已经初始化！";

    /****商品评价***/
    public static final String APPRAIISE = "13100";
    public static final String APPRAIISE_NO_EXIST_MSG = "评价不存在！";
    public static final String APPRAIISE_EXIST_MSG = "该商品已经评价过！";
    public static final String APPRAIISE_DETAIL_ERROR_MSG = "评价内容格式不正确！";
    public static final String APPRAIISE_FAIL_MSG = "评价失败！";
    public static final String FROM_FEIHE = "13200";
    public static final String FROM_FEIHE_MSG = "该手机号是飞鹤老会员";


    /******** 提成设置********/
    public static final String PERCENTAGE_NULL = "13300";
    public static final String PERCENTAGE_NULL_MSG = "未找到提成设置";
    public static final String PERCENTAGE_EXIST_MSG = "该门店已经存在提成设置";

    public static final String PERCENTAGE_INSERT_FAIL = "13301";
    public static final String PERCENTAGE_INSERT_FAIL_MSG = "新增提成设置失败";
    public static final String PERCENTAGE_UPDATE_FAIL_MSG = "修改提成设置失败";
    /******** kpi设置********/
    public static final String KPI_NULL = "13310";
    public static final String KPI_NULL_MSG = "未找到kpi设置";
    public static final String KPI_EXIST_MSG = "已存在kpi设置";

    public static final String KPI_INSERT_FAIL = "13311";
    public static final String KPI_INSERT_FAIL_MSG = "新增kpi设置失败";

    /*********设备***********/
    public static final String DEVICE_TEMPLET_FAIL = "13410";
    public static final String TEMPLET_INSERT_FAIL_MSG = "新增设备解析模板失败";

    public static final String DEVICE_TYPE_NULL = "13411";
    public static final String DEVICE_TYPE_NULL_MSG = "设备类型参数错误";

    /***会员池***/
    public static final String MEMBERS_INSERT_FAIL = "13500";
    public static final String REGRESSION_INSERT_FAIL_MSG = "新增会员回归规则设置失败";
    public static final String REGRESSION_UPDATE_FAIL_MSG = "更新会员回归规则设置失败";
    public static final String DISTRI_INSERT_FAIL_MSG = "新增会员分配规则设置失败";
    public static final String DISTRI_UPDATE_FAIL_MSG = "更新会员分配规则设置失败";
    public static final String REGRESSION_SET_NULL_MSG = "商户未设置会员回归规则";
    public static final String REGRESSION_SET_EXIST_MSG = "商户已设置过会员回归规则";
    public static final String DISTRI_SET_NULL_MSG = "商户未设置会员分配规则";
    public static final String DISTRI_SET_EXIST_MSG = "商户已设置过会员分配规则";


    /****订单***/
    public static final String FULL_UPDATE = "13510";
    public static final String FULL_UPDATE_MSG = "全量更新完成";

    /*************************员工增改***********************************/
    //员工添加
    public static final String STUFF_ADD_MSG = "员工新增成功";
    public static final String STUFF_ADD_FAIL = "12001";
    public static final String STUFF_ADD_MSG1 = "参数有为空的项，添加员工失败";
    public static final String STUFF_ADD_MSG2 = "该手机号已被注册";
    public static final String STUFF_ADD_MSG3 = "所属部门不能为空";
    public static final String STUFF_ADD_MSG4 = "员工新增代码异常，添加失败";

    //员工信息修改
    public static final String STUFF_UPDATE_MSG = "员工信息修改成功";
    public static final String STUFF_UPDATE_FAIL = "12002";
    public static final String STUFF_UPDATE_MSG1 = "参数有为空的项,修改员工失败";
    public static final String STUFF_UPDATE_MSG2 = "该员工不存在";
    public static final String STUFF_UPDATE_MSG3 = "管理员信息不存在";
    public static final String STUFF_UPDATE_MSG4 = "员工修改代码异常，修改失败";
    public static final String STUFF_UPDATE_MSG5 = "该手机号已被注册";
    public static final String STUFF_UPDATE_MSG6 = "权限不足，修改失败";
    public static final String STUFF_UPDATE_MSG7 = "该员工为超管，信息只能本人修改";

    //手机号验证
    public static final String MOBILE_FAIL = "12013";
    public static final String MOBILE_SUCCESS = "200";
    public static final String MOBILE_MSG = "手机号验证可用";
    public static final String MOBILE_MSG1 = "手机号格式不正确";
    public static final String MOBILE_MSG2 = "该手机号已存在";
    public static final String MOBILE_MSG3 = "参数有为空的项，手机号验证失败";
    public static final String MOBILE_MSG4 = "验证手机号代码异常，验证失败";

    //修改员工状态
    public static final String STAFF_UPDATESTATUS_MSG = "员工状态修改成功";
    public static final String STAFF_UPDATESTATUS_FAIL = "12014";
    public static final String STAFF_UPDATESTATUS_MSG1 = "参数有为空的项，员工状态修改失败";
    public static final String STAFF_UPDATESTATUS_MSG2 = "员工状态修改异常，修改失败";
    public static final String STAFF_UPDATESTATUS_MSG3 = "";

    //修改密码
    public static final String STAFF_MODIFY_PWD_MSG = "密码修改成功";
    public static final String STAFF_MODIFY_PWD_FAIL = "12015";
    public static final String STAFF_MODIFY_PWD_MSG1 = "参数有为空的项，密码修改失败";
    public static final String STAFF_MODIFY_PWD_MSG2 = "密码修改代码异常，修改失败";
    public static final String STAFF_MODIFY_PWD_MSG3 = "权限不足，密码修改失败";
    public static final String STAFF_MODIFY_PWD_MSG4 = "原始密码不正确，密码修改失败";
    public static final String STAFF_MODIFY_PWD_MSG5 = "员工不存在，密码修改失败";

    //修改手机号
    public static final String STAFF_MODIFY_MOBILE_MSG = "验证成功";
    public static final String STAFF_MODIFY_MOBILE_FAIL = "12028";
    public static final String STAFF_MODIFY_MOBILE_MSG1 = "参数有为空的项，手机号修改失败";
    public static final String STAFF_MODIFY_MOBILE_MSG2 = "手机号修改失败";
    public static final String STAFF_MODIFY_MOBILE_MSG3 = "验证码不正确";
    public static final String STAFF_MODIFY_MOBILE_MSG4 = "验证码已失效，操作失败";
    public static final String STAFF_MODIFY_MOBILE_MSG5 = "手机号更新成功，合并会员失败";
    public static final String STAFF_MODIFY_MOBILE_MSG6 = "新手机号不能为空";
    public static final String MOBILE_EXIST = "手机号已存在";

    //找回员工密码
    public static final String STAFF_FINDPWD_MSG = "新密码设置成功";
    public static final String STAFF_FINDPWD_FAIL = "12025";
    public static final String STAFF_FINDPWD_MSG1 = "参数有为空的项，密码找回失败";
    public static final String STAFF_FINDPWD_MSG2 = "找回密码代码异常，找回失败";
    public static final String STAFF_FINDPWD_MSG3 = "该员工不是管理员，找回失败";
    public static final String STAFF_FINDPWD_MSG4 = "该员工不存在，找回失败";
    public static final String STAFF_FINDPWD_MSG5 = "该员工不是导购，找回失败";
    public static final String STAFF_FINDPWD_MSG6 = "登录来源不明，操作失败";
    public static final String STAFF_FINDPWD_MSG7 = "验证码不正确，操作失败";
    public static final String STAFF_FINDPWD_MSG8 = "验证码已失效，操作失败";

    //修改员工管理的部门
    public static final String STAFF_UPDATE_ADMIN_DEPART_MSG = "员工管理部门修改成功";
    public static final String STAFF_UPDATE_ADMIN_DEPART_FAIL = "12015";
    public static final String STAFF_UPDATE_ADMIN_DEPART_MSG1 = "修改失败，supplier_id、operator_id或staff_id为无效参数";
    public static final String STAFF_UPDATE_ADMIN_DEPART_MSG2 = "修改员工管理部门代码异常，修改失败";
    public static final String STAFF_UPDATE_ADMIN_DEPART_MSG3 = "权限不足，修改失败";
    /******************************************************************/
    public static final String SUCCESS = "\"" + "success" + "\"";
    public static final String FAIL = "\"" + "fail" + "\"";
    public static final String EMPTY = "\"" + "\"";
    public static final String EMPTYLIST = "[]";
    public static final String EXIST = "exist";
    /*************************会员模块增删改查******************************/
    //标签添加
    public static final String MEMBERTAG_ADD_MSG = "标签新增成功";
    public static final String MEMBERTAG_ADD_FAIL = "12003";
    public static final String MEMBERTAG_ADD_MSG1 = "参数有为空的项，添加标签失败";
    public static final String MEMBERTAG_ADD_MSG2 = "该员工已创建过同名标签";
    public static final String MEMBERTAG_ADD_MSG3 = "标签新增代码异常，添加失败";
    public static final String MEMBERTAG_ADD_MSG4 = "该员工添加的标签已达到20条，不能再添加";

    //标签删除
    public static final String MEMBERTAG_DELETE_MSG = "标签删除成功";
    public static final String MENBERTAG_DELETE_FAIL = "12004";
    public static final String MENBERTAG_DELETE_MSG1 = "标签不能删除,权限不足";
    public static final String MENBERTAG_DELETE_MSG2 = "部分标签不存在";
    public static final String MENBERTAG_DELETE_MSG3 = "标签删除代码异常，删除失败";
    public static final String MENBERTAG_DELETE_MSG4 = "参数有为空的项，删除标签失败";

    //标签修改
    public static final String MEMBERTAG_UPDATE_MSG = "标签修改成功";
    public static final String MENBERTAG_UPDATE_FAIL = "12005";
    public static final String MENBERTAG_UPDATE_MSG1 = "要修改的标签不存在！";
    public static final String MENBERTAG_UPDATE_MSG2 = "该标签为系统标签,不能修改";
    public static final String MENBERTAG_UPDATE_MSG3 = "该标签不能修改,权限不足";
    public static final String MENBERTAG_UPDATE_MSG4 = "该标签已存在";
    public static final String MENBERTAG_UPDATE_MSG5 = "标签修改代码异常，修改失败";
    public static final String MENBERTAG_UPDATE_MSG6 = "参数有为空的项，修改标签失败";

    //标签查询
    public static final String MEMBERTAG_QUERY_MSG = "标签查询成功";
    public static final String MENBERTAG_QUERY_FAIL = "12006";
    public static final String MENBERTAG_QUERY_MSG1 = "参数有为空的项，查询标签失败";
    public static final String MENBERTAG_QUERY_MSG2 = "标签查询代码异常，查询失败";
    public static final String MENBERTAG_QUERY_MSG3 = "查询结果为空";


    //添加会员回访记录
    public static final String MEMBERVISIT_ADD_MSG = "会员回访记录添加成功";
    public static final String MEMBERVISIT_ADD_FAIL = "12007";
    public static final String MEMBERVISIT_ADD_MSG1 = "参数有为空的项，会员回访添加失败";
    public static final String MEMBERVISIT_ADD_MSG2 = "会员回访添加代码异常，添加失败";

    //获取会员回访备注列表
    public static final String MEMBERVISIT_QUERY_MSG = "会员回访备注列表获取成功";
    public static final String MEMBERVISIT_QUERY_FAIL = "12008";
    public static final String MEMBERVISIT_QUERY_MSG1 = "参数有为空的项，会员回访备注列表获取失败";
    public static final String MEMBERVISIT_QUERY_MSG2 = "会员回访列表查询异常，获取失败";

    //获取会员行为日志
    public static final String MEMBERACTIVITIES_QUERY_MSG = "会员行为日志获取成功";
    public static final String MEMBERACTIVITIES_QUERY_FAIL = "12029";
    public static final String MEMBERACTIVITIES_QUERY_MSG1 = "参数有为空的项，获取失败";
    public static final String MEMBERACTIVITIES_QUERY_MSG2 = "获取会员行为日志代码异常，获取失败";

    //获取新增会员统计数据
    public static final String MEMBER_NEWCOUNT_MSG = "新增用户数据统计成功";
    public static final String MEMBER_NEWCOUNT_FAIL = "12030";
    public static final String MEMBER_NEWCOUNT_MSG1 = "参数有为空的项,统计失败";
    public static final String MEMBER_NEWCOUNT_MSG2 = "新增会员数量数据统计代码异常，统计失败";
    public static final String MEMBER_NEWCOUNT_MSG3 = "登录人不是管理员，无查看权限";
    /******************************************************************/
    /**
     * 全局返回码  fengningjin begin
     **/


    //给会员打标签
    public static final String MEMBER_ADDTO_TAG_MSG = "会员关联标签成功";
    public static final String MEMBER_ADDTO_TAG_FAIL = "12009";
    public static final String MEMBER_ADDTO_TAG_MSG1 = "参数有为空的项，添加标签失败";
    public static final String MEMBER_ADDTO_TAG_MSG2 = "给会员添加标签代码异常，添加标签失败";
    public static final String MEMBER_ADDTO_TAG_MSG3 = "会员超过200条，添加标签失败";
    public static final String MEMBER_ADDTO_TAG_MSG4 = "标签超过200条，添加标签失败";
    public static final String MEMBER_ADDTO_TAG_MSG5 = "对这些会员无操作权限，添加标签失败";
    public static final String MEMBER_ADDTO_TAG_MSG6 = "对这些标签无操作权限，添加标签失败";

    //对会员删除标签
    public static final String MEMBER_DELTO_TAG_MSG = "该会员的标签删除成功";
    public static final String MEMBER_DELTO_TAG_FAIL = "12010";
    public static final String MEMBER_DELTO_TAG_MSG1 = "参数有为空的项，删除失败";
    public static final String MEMBER_DELTO_TAG_MSG2 = "对会员删除标签代码异常，删除失败";
    public static final String MEMBER_DELTO_TAG_MSG3 = "对标签权限不足，删除标签失败";
    public static final String MEMBER_DELTO_TAG_MSG4 = "对会员权限不足，删除标签失败";

    //获取会员标签
    public static final String MEMBER_QUERYTO_TAG_MSG = "获取会员标签成功";
    public static final String MEMBER_QUERYTO_TAG_FAIL = "12011";
    public static final String MEMBER_QUERYTO_TAG_MSG1 = "参数有为空的项，获取会员标签失败";
    public static final String MEMBER_QUERYTO_TAG_MSG2 = "查询结果为空";
    public static final String MEMBER_QUERYTO_TAG_MSG3 = "权限不足，获取会员标签失败";
    public static final String MEMBER_QUERYTO_TAG_MSG4 = "获取会员标签代码异常，获取失败";

    //获取员工创建的标签列表
    public static final String STAFF_QUERY_TAG_MSG = "获取员工创建的标签列表成功";
    public static final String STAFF_QUERY_TAG_FAIL = "12012";
    public static final String STAFF_QUERY_TAG_MSG1 = "参数有为空的项，获取员工创建的标签列表失败";
    public static final String STAFF_QUERY_TAG_MSG2 = "获取员工创建的标签列表代码异常，获取失败";
    public static final String STAFF_QUERY_TAG_MSG3 = "查询结果为空";

    //获取会员详情
    public static final String MEMBER_QUERY_MSG = "会员详情获取成功";
    public static final String MEMBER_QUERY_FAIL = "12018";
    public static final String MEMBER_QUERY_MSG1 = "参数有为空的项，会员详情获取失败";
    public static final String MEMBER_QUERY_MSG2 = "会员详情获取代码异常，获取失败";
    public static final String MEMBER_QUERY_MSG3 = "权限不足，会员详情获取失败";
    public static final String MEMBER_QUERY_MSG4 = "该会员还没有被分配，获取失败";
    public static final String MEMBER_QUERY_MSG5 = "该会员不存在";

    //查询标签下的会员列表
    public static final String MEMBER_QUERYBYTAG_MSG = "标签下的会员列表查询成功";
    public static final String MEMBER_QUERYBYTAG_FAIL = "12026";
    public static final String MEMBER_QUERYBYTAG_MSG1 = "参数有为空的项，查询失败";
    public static final String MEMBER_QUERYBYTAG_MSG2 = "查询标签下的会员列表代码异常，查询失败";
    public static final String MEMBER_QUERYBYTAG_MSG3 = "权限不足，查询失败";
    public static final String MEMBER_QUERYBYTAG_MSG4 = "查询结果为空";
    /******************************************************************/

    /******************************商品模块****************************/
    //获取商品列表
    public static final String PRODUCT_QUERY_MSG = "商品列表获取成功";
    public static final String PRODUCT_QUERY_FAIL = "12016";
    public static final String PRODUCT_QUERY_MSG1 = "参数有为空的项，商品列表获取失败";
    public static final String PRODUCT_QUERY_MSG2 = "商品列表获取代码异常，获取失败";
    
    //获取商品详情
    public static final String PRODUCTDETAIL_QUERY_MSG = "商品详情获取成功";
    public static final String PRODUCTDETAIL_QUERY_FAIL = "11020";
    public static final String PRODUCTDETAIL_QUERY_MSG1 = "参数有为空的项，商品详情获取失败";
    public static final String PRODUCTDETAIL_QUERY_MSG2 = "商品详情获取代码异常，获取失败";

    //获取商品类目列表
    public static final String PRODUCTCAT_QUERY_MSG = "商品类目列表获取成功";
    public static final String PRODUCTCAT_QUERY_FAIL = "12036";
    public static final String PRODUCTCAT_QUERY_MSG1 = "参数有为空的项，商品类目列表获取失败";
    public static final String PRODUCTCAT_QUERY_MSG2 = "商品类目列表获取代码异常，获取失败";

    //获取商品品牌列表
    public static final String PRODUCTBRAND_QUERY_MSG = "商品品牌列表获取成功";
    public static final String PRODUCTBRAND_QUERY_FAIL = "12037";
    public static final String PRODUCTBRAND_QUERY_MSG1 = "参数有为空的项，商品品牌列表获取失败";
    public static final String PRODUCTBRAND_QUERY_MSG2 = "商品品牌列表获取代码异常，获取失败";

    //删除商品
    public static final String PRODUCT_DELETE_MSG = "删除商品成功";
    public static final String PRODUCT_DELETE_FAIL = "12017";
    public static final String PRODUCT_DELETE_MSG1 = "参数有为空的项，商品删除失败";
    public static final String PRODUCT_DELETE_MSG2 = "商品删除代码异常，删除商品失败";

    //从点开拉取商品数据
    public static final String PRODUCT_FROM_DK_MSG = "商品数据拉取成功";
    public static final String PRODUCT_FROM_DK_FAIL = "12031";
    public static final String PRODUCT_FROM_DK_MSG1 = "参数有为空的项，商品数据拉取失败";
    public static final String PRODUCT_FROM_DK_MSG2 = "商品数据拉取代码异常，数据拉取失败";
    public static final String PRODUCT_FROM_DK_MSG3 = "该商户未购买过点开应用";
//    public static final String PRODUCT_FROM_DK_MSG4 = "商品数据拉取代码异常，数据拉取失败";

    //从点开拉取订单数据
    public static final String ORDER_FROM_DK_MSG = "订单数据拉取成功";
    public static final String ORDER_FROM_DK_FAIL = "12033";
    public static final String ORDER_FROM_DK_MSG1 = "参数有为空的项，订单数据拉取失败";
    public static final String ORDER_FROM_DK_MSG2 = "订单数据拉取代码异常，数据拉取失败";

    //商户购买点开应用
    public static final String SUPPLIER_SECRET_MSG = "秘钥获取成功";
    public static final String SUPPLIER_SECRET_FAIL = "12032";
    public static final String SUPPLIER_SECRET_MSG1 = "公钥为空，获取失败";
    public static final String SUPPLIER_SECRET_MSG2 = "秘钥获取代码异常，操作失败";
    public static final String SUPPLIER_SECRET_MSG3 = "查询不到该秘钥";

    //商户购买应用，状态未审核
    public static final String SUPPLIER_BUYAPP_MSG = "购买成功，正在审核，请耐心等待";
    public static final String SUPPLIER_BUYAPP_FAIL = "12034";
    public static final String SUPPLIER_BUYAPP_MSG1 = "参数有为空的项，商户购买失败";
    public static final String SUPPLIER_BUYAPP_MSG2 = "商户购买应用代码异常，操作失败";
    public static final String SUPPLIER_BUYAPP_MSG3 = "该应用或商户不存在";
    public static final String SUPPLIER_BUYAPP_MSG4 = "登录人不存在";
    //    public static final String SUPPLIER_BUYAPP_MSG7 = "该应用或商户不存在";
    public static final String SUPPLIER_BUYAPP_MSG6 = "该商户已购买过该应用";

    //商户购买应用，审核通过，应用对商户授权
    public static final String CHECK_BUYAPP_MSG = "状态更改成功";
    public static final String CHECK_BUYAPP_FAIL = "12035";
    public static final String CHECK_BUYAPP_MSG1 = "参数有为空的项，商户购买失败";
    public static final String CHECK_BUYAPP_MSG2 = "审核代码异常，操作失败";
    public static final String CHECK_BUYAPP_MSG3 = "token不存在";
    public static final String CHECK_BUYAPP_MSG4 = "商户管理员手机号为空";
    public static final String CHECK_BUYAPP_MSG5 = "该记录不存在";
    /******************************************************************/
    /*******************************优惠券******************************/
    //查询优惠券活动列表
    public static final String COUPON_QUERYACTIVITY_MSG = "优惠券活动查询成功";
    public static final String COUPON_QUERYACTIVITY_FAIL = "12019";
    public static final String COUPON_QUERYACTIVITY_MSG1 = "权限不足，优惠券活动查询失败";
    public static final String COUPON_QUERYACTIVITY_MSG2 = "参数有为空的项，优惠券活动查询失败";
    public static final String COUPON_QUERYACTIVITY_MSG3 = "优惠券活动查询代码异常，查询失败";
    public static final String COUPON_QUERYACTIVITY_MSG4 = "查询结果为空";

    //根据活动ID查询可使用优惠券商品ID列表
    public static final String COUPON_QUERYPRODUCT_MSG = "优惠券商品ID列表获取成功";
    public static final String COUPON_QUERYPRODUCT_FAIL = "12020";
    public static final String COUPON_QUERYPRODUCT_MSG1 = "参数有为空的项，优惠券商品ID列表获取失败";
    public static final String COUPON_QUERYPRODUCT_MSG2 = "优惠券商品ID列表获取代码异常，获取失败";
    public static final String COUPON_QUERYPRODUCT_MSG3 = "查询结果为空";
    public static final String COUPON_QUERYPRODUCT_MSG4 = "权限不足，优惠券商品ID列表获取失败";

    //根据活动ID查询可使用优惠券门店ID列表
    public static final String COUPON_QUERYDEPART_MSG = "优惠券门店ID列表获取成功";
    public static final String COUPON_QUERYDEPART_FAIL = "12020";
    public static final String COUPON_QUERYDEPART_MSG1 = "参数有为空的项，优惠券门店ID列表获取失败";
    public static final String COUPON_QUERYDEPART_MSG2 = "优惠券门店ID列表获取代码异常，获取失败";
    public static final String COUPON_QUERYDEPART_MSG3 = "查询结果为空";
    public static final String COUPON_QUERYDEPART_MSG4 = "权限不足，优惠券门店ID列表获取失败";

    //使优惠券失效
    public static final String COUPON_UPDATESTATUS_MSG = "使优惠券失效成功";
    public static final String COUPON_UPDATESTATUS_FAIL = "12021";
    public static final String COUPON_UPDATESTATUS_MSG1 = "参数有为空的项,优惠券失效失败";
    public static final String COUPON_UPDATESTATUS_MSG2 = "优惠券失效代码异常，失效失败";
    public static final String COUPON_UPDATESTATUS_MSG3 = "权限不足，失效失败";

    //查询优惠券列表
    public static final String COUPON_QUERYLIST_MSG = "优惠券列表查询成功";
    public static final String COUPON_QUERYLIST_FAIL = "12022";
    public static final String COUPON_QUERYLIST_MSG1 = "参数有为空的项,优惠券列表查询失败";
    public static final String COUPON_QUERYLIST_MSG2 = "优惠券列表查询代码异常，查询失败";
    public static final String COUPON_QUERYLIST_MSG3 = "权限不足，查询失败";
    public static final String COUPON_QUERYLIST_MSG4 = "查询结果为空";

    //使赠送新会员优惠券活动失效
    public static final String COUPON_GNM_UPDATESTATUS_MSG = "使赠送新会员优惠券活动失效成功";
    public static final String COUPON_GNM_UPDATESTATUS_FAIL = "12023";
    public static final String COUPON_GNM_UPDATESTATUS_MSG1 = "参数有为空的项,使赠送新会员优惠券活动失效失败";
    public static final String COUPON_GNM_UPDATESTATUS_MSG2 = "使赠送新会员优惠券活动失效代码异常，失效失败";
    public static final String COUPON_GNM_UPDATESTATUS_MSG3 = "权限不足,失效失败";

    //根据活动ID查询参与活动门店ID列表
    public static final String COUPON_QUERY_GNMDEPART_MSG = "参与活动门店ID列表获取成功";
    public static final String COUPON_QUERY_GNMDEPART_FAIL = "12024";
    public static final String COUPON_QUERY_GNMDEPART_MSG1 = "参数有为空的项,参与活动门店ID列表获取失败";
    public static final String COUPON_QUERY_GNMDEPART_MSG2 = "参与活动门店ID列表获取代码异常，获取失败";
    public static final String COUPON_QUERY_GNMDEPART_MSG3 = "权限不足,获取失败";
    public static final String COUPON_QUERY_GNMDEPART_MSG4 = "查询结果为空";

    //app版本控制
    public static final String APP_VERSION_MSG = "版本内容获取成功";

    //新建 发券给导购活动
    public static final String COUPON_PUSHTO_STAFF_MSG = "新建发券给导购活动成功";
    public static final String COUPON_PUSHTO_STAFF_FAIL = "15001";
    public static final String COUPON_PUSHTO_STAFF_MSG1 = "发券给导购活动失败,原因:参数异常";
    public static final String COUPON_PUSHTO_STAFF_MSG2 = "发券给导购活动失败,原因:代码异常";

    //查询发券给导购活动列表
    public static final String COUPONPUSH_QUERYLIST_ACTIVITY_MSG = "查询发券给导购活动列表成功";
    public static final String COUPONPUSH_QUERYLIST_ACTIVITY_FAIL = "15002";
    public static final String COUPONPUSH_QUERYLIST_ACTIVITY_MSG1 = "查询发券给导购活动列表失败,原因:参数异常";
    public static final String COUPONPUSH_QUERYLIST_ACTIVITY_MSG2 = "查询发券给导购活动列表失败,原因:代码异常";
    public static final String COUPONPUSH_QUERYLIST_ACTIVITY_MSG3 = "查询发券给导购活动列表失败,原因:结果为空";

    //根据活动ID查询发券给导购活动
    public static final String COUPONPUSH_QUERY_ACTIVITY_MSG = "根据活动ID查询发券给导购活动成功";
    public static final String COUPONPUSH_QUERY_ACTIVITY_FAIL = "15003";
    public static final String COUPONPUSH_QUERY_ACTIVITY_MSG1 = "根据活动ID查询发券给导购活动失败,原因:参数异常";
    public static final String COUPONPUSH_QUERY_ACTIVITY_MSG2 = "根据活动ID查询发券给导购活动失败,原因:代码异常";
    public static final String COUPONPUSH_QUERY_ACTIVITY_MSG3 = "根据活动ID查询发券给导购活动失败,原因:查询结果为空";

    //根据ID更新 status字段
    public static final String COUPONPUSH_UPDATE_MSG = "发券给导购活动 状态更新成功";
    public static final String COUPONPUSH_UPDATE_FAIL = "15004";
    public static final String COUPONPUSH_UPDATE_MSG1 = "根据ID更新状态失败，原因:参数异常";
    public static final String COUPONPUSH_UPDATE_MSG2 = "根据ID更新状态失败，原因:代码异常";
    public static final String COUPONPUSH_UPDATE_MSG3 = "根据ID更新状态失败, 原因:不满足更新条件";
    public static final String COUPONPUSH_UPDATE_MSG4 = "根据ID更新状态失败，原因:对应的ID不存在";


    /******************************************************************/
    /**
     * 全局返回码  fengningjin begin
     **/


    //根据权限查询会员列表成功
    public static final String MEMBER_AUTHQUERY_MSGS = "查询会员列表成功";
    public static final String NEWMEMBER_MZQUERY_MSGS = "迈志同步飞鹤新客会员列表查询成功";
    public static final String NEWMEMBER_AUTHQUERY_MSGS = "飞鹤新客会员列表查询成功";
    public static final String OLDMEMBER_AUTHQUERY_MSGS = "飞鹤老客会员列表查询成功";
    public static final String LATENTMEMBER_AUTHQUERY_MSGS = "飞鹤潜客会员列表查询成功";
    //根据权限查询会员列表失败
    public static final String MEMBER_AUTHQUERY_FAIL = "11001";
    public static final String MEMBER_AUTHQUERY_FMSG = "权限不足";
    public static final String MEMBER_QUERY_FMSG = "is_trade只能传0或1，order_num只能传1或不传";
    public static final String MEMBER_QUERY_FMSG_CODE = "查询会员列表失败";
    public static final String MEMBER_AUTHQUERY_FMSG_CODE = "APP查询失败staff_id为空，staff_id不等于operator_id";
    public static final String MEMBERSUPPLIER_FMSG = "不存在在该商户，请查证。";
    public static final String MEMBER_QUERY_FMSG_CODE1 = "会员ID不可为空";
    
    //飞鹤新客
    public static final String NEW_MEMBER_LIST_MSG1="新客规则改变的时间点为2017-05-25 17:02:20，只能单独查询在此之前或之后的新客";
    public static final String NEW_MEMBER_LIST_MSG2="begin_time和end_time为必传项";
    

    //根据权限查询导购列表成功
    public static final String SHOPGUIDE_AUTHQUERY_MSGS = "查询导购列表成功";
    //根据权限查询导购列表失败
    public static final String SHOPGUIDE_AUTHQUERY_FAIL = "11002";
    public static final String SHOPGUIDE_AUTHQUERY_FMSG = "";
    public static final String SHOPGUIDE_QUERY_FMSG_CODE = "查询导购列表失败";

    //分配会员给导购成功成功
    public static final String ALLOTMEMBERTOGUIDE_ADD_MSG = "分配会员给导购成功";
    public static final String ALLOTMEMBERTOGUIDE_FAIL_MSG = "该会员已经分配过了，不能再进行分配";
    //分配会员给导购失败
    public static final String ALLOTMEMBERTOGUIDE_ADD_FAIL = "11003";
    public static final String ALLOTMEMBERTOGUIDE_ADD_NULL = "分配会员给导购失败";
    public static final String ALLOTMEMBERTOGUIDE_ADD_FMSG_EXCEPTION = "分配会员给导购失败";

    //删除员工会员分配关系
    public static final String STAFFMEMBER_DELETE_MSG = "员工会员分配关系删除成功";
    //删除员工会员分配关系失败
    public static final String STAFFMEMBER_DELETE_FAIL = "11004";
    public static final String STAFFMEMBER_DELETE_FMSGDEPARTNULL = "该用户下没有权限进行删除";
    public static final String STAFFMEMBER_DELETE_FMSGMEMBERNULL = "没有分配关系，删除失败";
    public static final String STAFFMEMBER_DELETE_FMSPARAMSNULL = "参数有空的选项，不能进行删除";
    public static final String STAFFMEMBER_DELETE_FMSG_EXCEPTION = "删除员工会员分配信息失败";

    //根据权限查询部门列表成功
    public static final String DEPARTMENT_AUTHQUERY_MSGS = "查询权限部门列表成功";
    //根据权限查询部门列表失败
    public static final String DEPARTMENT_AUTHQUERY_FAIL = "11005";
    public static final String DEPARTMENT_AUTHQUERY_FMSG = "该权限下没有对应的部门";

    //根据部门id获取该部门下的所有员工列表(员工所属部门)
    public static final String STAFF_AUTHQUERY_MSGS = "查询员工列表成功";
    //根据权限查询部门列表失败
    public static final String STAFF_AUTHQUERY_FAIL = "11006";
    public static final String STAFF_AUTHQUERY_FMSG = "该权限下没有对应的部门";
    public static final String STAFF_QUERY_FMSG_CODE = "查询员工列表失败";

    //根据权限获得单个部门的详情成功
    public static final String DEPARTMENTDETAIL_AUTHQUERY_MSGS = "查询部门详情成功";
    //根据权限获得单个部门的详情失败
    public static final String DEPARTMENTDETAIL_QUERY_FAIL = "11007";
    public static final String DEPARTMENTDETAIL_QUERY_FMSG = "该权限下没有对应的部门";
    public static final String DEPARTMENTDETAIL_QUERY_MSG_NULL = "参数中供应商ID,部门ID或者员工ID和type有为空的项";
    public static final String DEPARTMENTDETAIL_QUERY_FMSG_CODE = "查询部门详情中失败";

    //根据权限获得单个员工的详情成功
    public static final String STAFFDETAIL_AUTHQUERY_MSGS = "查询单个员工的详情成功";
    public static final String STAFFDETAIL_BATCHQUERY_MSGS = "员工详情批量获取成功";
    //根据权限获得单个员工的详情失败
    public static final String STAFFDETAIL_QUERY_FAIL = "11008";
    public static final String STAFFDETAIL_QUERY_FMSG = "该权限下没有对应的部门";
    public static final String STAFFDETAIL_QUERY_MSG_NULL = "权限不足,不能获取该员工详情";
    public static final String STAFFDETAIL_QUERY_FMSG_CODE = "查询员工详情失败";
    public static final String STAFFDETAIL_QUERY_NULL = "员工不存在";

    //删除员工信息成功
    public static final String STAFF_DELETE_MSG = "员工信息删除成功";
    //删除员工信息失败
    public static final String STAFF_DELETE_FAIL = "11009";
    public static final String STAFF_DELETE_FMSGDEPARTNULL = "该用户下没有对应的部门";
    public static final String STAFF_DELETE_FMSPARAMSNULL = "参数有空的选项不能被删除";
    public static final String STAFF_DELETE_FMSG_EXCEPTION = "删除员工信息失败";

    //获得部门的标签列表成功
    public static final String DEPARTMENTTAG_AUTHQUERY_MSGS = "查询部门标签了列表";
    //获得部门标签列表失败
    public static final String DEPARTMENTTAG_QUERY_FAIL = "11010";
    public static final String DEPARTMENTTAG_QUERY_FMSG = "该权限下没有对应的部门";
    public static final String DEPARTMENTDTAG_QUERY_FMSG_CODE = "查询部门标签列表失败";

    //删除部门标签成功
    public static final String DEPARTMENTAGT_DELETE_MSG = "部门标签删除成功";
    //删除部门标签失败
    public static final String DEPARTMENTTAG_DELETE_FAIL = "11011";
    public static final String DEPARTMENTTAG_DELETE_FMSG = "标签不能被删除";
    public static final String DEPARTMENTTAG_DELETE_FMSGDEPARTNULL = "该用户下没有对应标签";
    public static final String DEPARTMENTTAG_DELETE_AUTHORITYNULL = "该用户无顶级权限，不能对标签进行操作";
    public static final String DEPARTMENTTAG_DELETE_FMSG_EXCEPTION = "删除部门标签失败";

    //添加部门标签成功
    public static final String DEPARTMENTTAG_ADD_MSG = "部门新增部门标签成功";
    public static final String DEPARTMENTTAG_UPDATE_MSG = "更新部门标签成功";
    //添加部门标签失败
    public static final String DEPARTMENTTAG_ADD_FAIL = "11012";
    public static final String DEPARTMENTTAG_ADD_NULL = "该商户下没有对应的标签";
    public static final String DEPARTMENTTAG_ADD_FMSG_EXCEPTION = "添加部门或更新标签失败";

    //添加部门标签成功
    public static final String ISTOPSTAFF_ADD_MSG = "员工有顶级权限";
    public static final String NOTISTOPSTAFF_ADD_NULL = "员工无顶级权限";
    //添加部门标签失败
    public static final String ISTOPSTAFF_ADD_FAIL = "11013";
    public static final String ISTOPSTAFF_FMSG_EXCEPTION = "员工无顶级权限，添加失败";

    //登录接口
    public static final String LOGIN_ADD_FAIL = "11014";
    public static final String LOGIN_FMSG_EXCEPTION = "app登录，登录人员不是导购不能登录";
    public static final String LOGIN_FAIL_EXCEPTION = "密码不正确，请重新登录";
    public static final String LOGIN_NOINFO_EXCEPTION = "该用户不存在";
    public static final String LOGIN_BABY_EXCEPTION = "该用户不存在或该用户不是飞鹤员工！";

    //会员等级接口
    public static final String MEMBERLEVEL_ADD_SUCCESS = "会员等级以及描述插入或更新成功";
    public static final String MEMBERLEVEL_ADD_FAIL = "11015";
    public static final String MEMBERLEVEL_ADD_MSGFAIL = "参数有有空的选项";
    public static final String MEMBERLEVEL_ADD_MSGFAILLEVEL = "输入值不在允许的范围内";
    public static final String MEMBERLEVEL_ADD_EXCEPTIONFAIL = "会员等级插入失";
    public static final String MEMBERLEVEL_ADD_PARAMSFAIL = "该商户等级下已关联会员,不能对条件设置进行更改！";

    public static final String MEMBERLEVEL_DELETE_SUCCESS = "会员等级打开或关闭成功";
    public static final String MEMBERLEVEL_DELETE_FAIL = "11016";
    public static final String MEMBERLEVEL_DELETE_CONTIDIONFAIL = "此会员等级在会员表中存在关联关系，不能关闭！";
    public static final String MEMBERLEVEL_DELETE_PARAMSFAIL = "一级等级会员，不能关闭！";
    public static final String MEMBERLEVEL_DELETE_MSGFAIL = "参数有有空的选项";
    public static final String MEMBERLEVEL_DELETE_EXCEPTIONFAIL = "会员等级删除失败";
    public static final String MEMBERLEVEL_DELETE_TIJIAOFAIL = "请从比该等级高的等级开始关闭";

    public static final String MEMBERLEVELDESCRIBE_ADD_SUCCESS = "添加会员等级描述插入成功";
    public static final String MEMBERLEVELDESCRIBE_ADD_FAIL = "11017";
    public static final String MEMBERLEVELDESCRIBE_ADD_MSGFAIL = "参数有有空的选项";
    public static final String MEMBERLEVELDESCRIBE_ADD_EXCEPTIONFAIL = "会员等级描述插入失败";

    public static final String MEMBERLEVELDESCRIBE_GET_SUCCESS = "获取会员等级以及商户会员等级描述成功";
    public static final String MEMBERLEVEL_GET_SUCCESS_MSG = "会员等级详情获取成功";
    public static final String MEMBERLEVELDESCRIBE_GET_FAIL = "11018";
    public static final String MEMBERLEVELDESCRIBE_GET_MSGFAIL = "参数有有空的选项";
    public static final String MEMBERLEVELDESCRIBE_GET_EXCEPTIONFAIL = "获取会员等级以及商户等级描述失败";

    public static final String MEMBERLEVELDESCRIBE_ONOFF_SUCCESS = "打开或关闭会员等级描述成功";
    public static final String MEMBERLEVELDESCRIBE_ONOFF_FAIL = "11019";
    public static final String MEMBERLEVELDESCRIBE_ONOFF_MSGFAIL = "参数有有空的选项";
    public static final String MEMBERLEVELDESCRIBE_ONOFF_MSAGEFAIL = "和会员有关联关系不能进行关闭";
    public static final String MEMBERLEVELDESCRIBE_ONOFF_EXCEPTIONFAIL = "打开或关闭会员等级描述失败";

    /**全局返回码  fengningjin end**/


    /**************************部门增删改查 BEGIN********************************/
    //部门查询成功
    public static final String DEPARTMENT_QUERY_MSG = "部门查询成功";
    public static final String DEPARTMENT_QUERY_MSGS = "一维数组部门查询成功";
    //部门查询失败
    public static final String DEPARTMENT_QUERY_FAIL = "14001";
    public static final String DEPARTMENT_QUERY_FMSG = "没权限查看所传部门id的上级或者下级部门";
    public static final String DEPARTMENT_QUERY_MSG_NULL = "部门查询参数中供应商ID,部门ID或者员工ID和type有为空的项";
    public static final String DEPARTMENT_QUERY_FMSG_CODE = "部门查询代码中有异常";
    public static final String DEPARTMENT_QUERY_FMSG_NULL = "一维数组部门查询为空";
    public static final String DEPARTMENT_QUERY_FAIL_TYPE = "14017";
    public static final String DEPARTMENT_QUERY_FMSG_TYPE = "type的值只能为0或者1";
    public static final String DEPARTMENT_QUERY_FAIL_STYPE = "14018";
    //部门新增成功
    public static final String DEPARTMENT_ADD_MSG = "部门新增成功";
    //部门新增失败
    public static final String DEPARTMENT_ADD_FAIL = "14002";
    public static final String DEPARTMENT_ADD_FMSG = "部门新增失败";
    public static final String DEPARTMENT_ADD_FMSG1 = "部门名称和tag不能为空";
    public static final String DEPARTMENT_ADD_MSGID = "部门新增时,部门ParentID为空";
    public static final String DEPARTMENT_ADD_MSGTAG = "部门新增时,子级部门标签大于父级部门标签";
    public static final String DEPARTMENT_ADD_PARENT_MSG = "部门新增时,在数据库中查询不到父节点部门";
    public static final String DEPARTMENT_ADD_MSGISTAG = "部门新增时,标签库中查不到该标签";
    public static final String DEPARTMENT_ADD_MSGSUPPLIER = "部门新增时,一个供应商下同级部门已经存在相同名称的部门";
    public static final String DEPARTMENT_ADD_REDIS_FAIL = "14011";
    public static final String DEPARTMENT_ADD_REDIS_FMSG = "部门新增失败,redis新增时异常";
    public static final String DEPARTMENT_ADD_REDIS_FMSG1 = "门店的省、市、区、详细地址为必传字段";

    //部门修改成功
    public static final String DEPARTMENT_UPDATE_SUCCESS = "14003";
    public static final String DEPARTMENT_UPDATE_MSG = "部门修改成功";
    //部门修改失败
    public static final String DEPARTMENT_UPDATE_FAIL = "14004";
    public static final String DEPARTMENT_UPDATE_FMSG = "部门修改失败";
    public static final String DEPARTMENT_UPDATE_FMSG_NULL = "部门修改时参数中员工ID,部门ID或者部门名称有为空的项";
    public static final String DEPARTMENT_UPDATE_FMSG_STAFFID = "部门修改时参数中员工ID不能为负数或者0";
    public static final String DEPARTMENT_UPDATE_FMSG_TAG = "部门修改时tag大于99";
    public static final String DEPARTMENT_UPDATE_FMSG_DEPARTMENT = "部门修改时部门不存在";
    public static final String DEPARTMENT_UPDATE_FMSG_TAG_BIG = "部门修改时,要修改部门tag应该大于父节点的tag";
    public static final String DEPARTMENT_UPDATE_FMSG_EXCEPTION = "部门修改失败,代码中有异常";
    public static final String DEPARTMENT_UPDATE_NOMANAGE_FMSG = "该员工对这个部门没有管理权限";

    //部门删除成功
    public static final String DEPARTMENT_DALETE_MSG = "部门删除成功";
    //部门删除失败
    public static final String DEPARTMENT_DALETE_FAIL = "14005";
    public static final String DEPARTMENT_DALETE_CODE = "14013";
    public static final String DEPARTMENT_DALETE_FMSG = "部门删除失败";
    public static final String DEPARTMENT_DALETE_FMSGNULL = "部门删除时参数有为空的项,删除部门失败";
    public static final String DEPARTMENT_DALETE_FMSGDEPARTNULL = "删除部门时,该部门不存在";
    public static final String DEPARTMENT_DALETE_FMSGNOMANAGE = "删除部门时,该员工对这个部门没有管理权限";
    public static final String DEPARTMENT_DALETE_FMSGSTAFF = "删除部门时,该部门下有员工";
    public static final String DEPARTMENT_DALETE_FMSGDEPARTMENT = "删除部门时,该部门下有子部门";
    public static final String DEPARTMENT_DALETE_DEPARTMENT_MEMBER_MSG = "删除部门会员关系表时失败";
    //redis添加
    public static final String DEPARTMENT_REDIS_ADD_MSG = "redis添加成功";
    public static final String DEPARTMENT_REDIS_ADD_FAIL = "14006";
    public static final String DEPARTMENT_REDIS_ADD_FMSG = "redis添加失败,部门为空";
    public static final String DEPARTMENT_REDIS_ADD_FCODE = "14014";
    public static final String DEPARTMENT_REDIS_ADD_FMSGP = "redis添加失败,部门parentId为0";
    
    //门店列表
    public static final String SHOP_LIST_MSG="门店列表查询成功";
    public static final String SHOP_LIST_CODE="12047";
    public static final String SHOP_LIST_MSG1="visitSource和operator_id为必传字段";
    public static final String SHOP_LIST_MSG2="权限不足，查询失败";
    
    //更新门店信息
    public static final String SHOP_UPDATE_MSG="门店信息更新成功";
    public static final String SHOP_UPDATE_CODE="12048";
    public static final String SHOP_UPDATE_MSG1="operator_id为必传字段";
    public static final String SHOP_UPDATE_MSG3="省市区，详细地址，经纬度必须统一修改";
    public static final String SHOP_UPDATE_MSG2="权限不足，更新失败";
    
    //查询门店和所属的省市区信息
    public static final String SHOP_PARENTINFO_MSG="门店和所属的省市区信息查询成功";
    public static final String SHOP_DEPARTDETAILS_MSG="批量获取部门详情成功";
    public static final String SHOP_PARENTINFO_CODE="12049";
    
    //商品详情
    public static final String PRODUCT_DETAIL_CODE="12050";
    public static final String PRODUCT_DETAIL_MSG="商品详情获取成功";
    public static final String PRODUCT_DETAIL_MSG1="source不能为空， product_ids、outer_product_ids二者必传其一";
    
    /*************************部门增删改查 END*********************************/
    /*************************商户 BEGIN*********************************/
    public static final String SUPPLIER_ADD_CODE = "14015";
    public static final String SUPPLIER_ADD_FMSG = "商户添加失败,参数username,mobile,password,type,checkCode有为空的项";
    public static final String SUPPLIER_ADD_EXCEPTION_CODE = "14016";
    public static final String SUPPLIER_ADD_EXCEPTION_FMSG = "商户添加失败,代码中有异常";
    public static final String SUPPLIER_ADD_MOBILE_CODE = "14017";
    public static final String SUPPLIER_ADD_MOBILE_MSG = "商户添加失败,手机号不合格";
    public static final String SUPPLIER_ADD_PASSWORD_CODE = "14019";
    public static final String SUPPLIER_ADD_PASSWORD_MSG = "商户添加失败,密码不合格";
    public static final String SUPPLIER_ADD_USERNAME_CODE = "14020";
    public static final String SUPPLIER_ADD_USERNAME_MSG = "商户注册失败,获取不到校验码";
    public static final String SUPPLIER_ADD_EXCEPTION_FCODE = "14021";
    public static final String SUPPLIER_ADD_SUCCESS_MSG = "商户添加成功";
    public static final String SUPPLIER_ADD_INSERT_CODE = "14022";
    public static final String SUPPLIER_ADD_INSERT_FMSG = "商户添加失败,往表中插入数据不完整";
    public static final String SUPPLIER_ADD_REDIS_CODE = "14023";
    public static final String SUPPLIER_ADD_REDIS_FMSG = "商户添加失败,往REDIS中插入不完整";
    public static final String SUPPLIER_ADD_HAVEMOBILE_CODE = "14024";
    public static final String SUPPLIER_ADD_HAVEMOBILE_FMSG = "商户添加失败,已经存在相同的手机号";
    public static final String SUPPLIER_ADD_HAVENAME_CODE = "14025";
    public static final String SUPPLIER_ADD_HAVENAME_FMSG = "商户添加失败,已经存在相同的商户名称";
    public static final String SUPPLIER_ADD_SCALE_CODE = "14026";
    public static final String SUPPLIER_ADD_SCALE_FMSG = "商户添加失败,字段type不为整数";
    public static final String CHECK_CODE = "14036";
    public static final String CHECK_MSG = "商户添加失败,字段type不为整数";
    public static final String REDIS_CHECK_CODE = "14037";
    public static final String REDIS_CHECK_MSG = "校验码不匹配";
    public static final String TICKET_CODE = "14038";
    public static final String TICKET_MSG = "小票ID或者设备ID为空";
    public static final String TICKET_EXCEPTION_CODE = "14039";
    public static final String TICKET_EXCEPTION_MSG = "获取小票数据时异常";
    public static final String TICKET_SUCCESS_CODE = "14040";
    public static final String TICKET_SUCCESS_MSG = "获取小票数据成功";
    public static final String TICKET_FAIL_CODE = "14041";
    public static final String TICKET_FAIL_MSG = "获取小票数据失败";
    //查询商户信息
    public static final String SUPPLIER_QUERY_MSG = "商户信息获取成功";

    public static final String SUPPLIER_QUERY_FAIL = "12027";
    public static final String SUPPLIER_QUERY_MSG1 = "参数有为空的项，查询失败";
    public static final String SUPPLIER_QUERY_MSG2 = "查询商户信息代码异常，查询失败";
    public static final String SUPPLIER_QUERY_MSG3 = "该商户不存在";
    public static final String SUPPLIER_QUERY_MSG4 = "要查询的字段在表中不存在";

    //查询商户列表
    public static final String SUPPLIER_LIST_QUERY_MSG = "商户列表获取成功";

    public static final String SUPPLIER_LIST_QUERY_FAIL = "15007";
    public static final String SUPPLIER_LIST_QUERY_MSG1 = "查询商户列表代码异常，查询失败";
    public static final String SUPPLIER_LIST_QUERY_MSG2 = "起止日期格式不正确";
    public static final String SUPPLIER_LIST_QUERY_MSG3 = "权限不足，查询失败";
    public static final String SUPPLIER_LIST_QUERY_MSG4 = "要查询的字段在表中不存在";
    public static final String SUPPLIER_LIST_QUERY_MSG5 = "没有符合条件的查询结果";
    public static final String SUPPLIER_LIST_QUERY_MSG6 = "商户ID格式错误";

    //STEP1:商户法人注册接口
    public static final String SUPPLIER_REGISTER_FAIL = "16001";
    public static final String CAPTCHA_REDIS_KEYPREFIX = "SDC:COMMONDATA:SMS:";
    public static final String SUPPLIER_REGISTER_MSG1 = "字段不能为空";
    public static final String SUPPLIER_REGISTER_MSG2 = "不是合法的手机号";
    public static final String SUPPLIER_REGISTER_MSG3 = "用户未获取手机验证码";
    public static final String SUPPLIER_REGISTER_MSG4 = "验证码不正确，操作失败";
    public static final String SUPPLIER_REGISTER_MSG5 = "两次输入的密码不一致";
    public static final String SUPPLIER_REGISTER_MSG6 = "商户注册第一步失败";
    public static final String SUPPLIER_REGISTER_MSG7 = "该手机号已注册";

    //STEP2:商户法人注册登记公司信息
    public static final String SUPPLIER_REGISTER_COMPANY_FAIL = "16002";
    public static final String SUPPLIER_REGISTER_COMPANY_MSG1 = "未传入supplier_id";
    public static final String SUPPLIER_REGISTER_COMPANY_MSG2 = "公司名称不能为空";
    public static final String SUPPLIER_REGISTER_COMPANY_MSG3 = "未选择公司经营类目";
    public static final String SUPPLIER_REGISTER_COMPANY_MSG4 = "商户注册第二步失败";
    public static final String SUPPLIER_REGISTER_COMPANY_MSG5 = "未查询到商户信息";
    

    /*************************商户 END*********************************/


    /************************会员池 BEGIN**********************************/
    public static final String MEMBER_POOL_MSG = "获取会员池设置成功";

    public static final String MEMBER_POOL_FAIL = "14007";
    public static final String MEMBER_POOL_FMSG = "获取会员池设置失败";
    public static final String MEMBER_POOL_FMSG_EXCEPTION = "获取会员池方法中有异常";
    public static final String MEMBER_POOL_FMSG_DEPARTMENT_NULL = "获取会员池时，会员管理的部门为空";
    public static final String MEMBER_POOL_NO_PERMISSION = "会员没有权限获取会员池设置";
    public static final String MEMBER_POOL_FMSG_ADD = "添加会员池方法中有异常";
    public static final String MEMBER_POOL_FMSG_ADD_EXCEPTION = "添加会员池时,会员管理的部门为空";

    public static final String MEMBER_POOL_ADD_SUCCESS_MSG = "会员池设置添加成功";
    public static final String MEMBER_POOL_ADD_FMSG = "会员池设置添加失败";
    public static final String MEMBER_POOL_UPDATE = "14008";
    public static final String MEMBER_POOL_FMSG_UPDATE_EXCEPTION = "修改会员池设置时,会员管理的部门为空";
    public static final String MEMBER_POOL_UPDATE_SUCCESS_MSG = "会员池设置修改成功";
    public static final String MEMBER_POOL_UPDATE_FAIL = "14009";
    public static final String MEMBER_POOL_UPDATE_FMSG = "会员池设置修改失败";

    public static final String MEMBER_POOL_UPDATE_FCODE = "14010";
    public static final String MEMBER_POOL_FMSG_UPDATE_NULL = "必要字段不允许为空";
    public static final String MEMBER_FMSG_UPDATE_NULL = "修改会员池设置时,商户ID,员工ID,操作人参数有为空的项";
    public static final String MEMBER_POOL_SELECT_FCODE = "14012";
    public static final String MEMBER_POOL_SELECT_FMSG = "会员池设置查询为空";
    public static final String MEMBER_POOL_UPDATE_CODE = "14027";
    public static final String MEMBER_UPDATE_INFOMSG = "member_id不允许为空";
    public static final String NO_VALITOR_UPDATE = "14028";
    public static final String NO_VALITOR_UPDATE_MSG = "没有权限更新会员信息";
    public static final String MEMBER_NO_EXIST = "14029";
    public static final String MEMBER_NO_EXIST_MSG = "该会员不存在";

    public static final String MEMBER_POOL_MEMBERXTX_CODE = "14030";
    public static final String MEMBER_POOL_MEMBERXTX_MSG = "在会员扩展表中没查到数据";
    public static final String MEMBER_MEMBER_MSG = "会员信息更新成功";
    public static final String MEMBER_UPDATE_FAIL = "14031";
    public static final String MEMBER_UPDATE_FAIL_MSG = "会员修改失败";
    public static final String MEMBER_DATA_NULL_MSG = "合并会员数据时参数为空";
    public static final String MEMBER_DATA_FAIL_CODE = "14132";
    public static final String MEMBER_DATA_FAIL_MSG = "合并会员数据失败";
    public static final String MEMBER_NO_MSG = "操作人对会员没有管理权限";
    public static final String MEMBER_NOP_MSG = "接口调用来源有问题";
    public static final String MEMBER_CONSUMP_CODE = "14032";
    public static final String MEMBER_CONSUMP_MSG = "传入参数有为空的项";
    public static final String MEMBER_CONSUMP_EXCEPTION_CODE = "14033";
    public static final String MEMBER_CONSUMP_EXCEPTION_MSG = "查看会员消费情况抛异常";
    public static final String MEMBER_CONSUMP_PERMISSION_CODE = "14034";
    public static final String MEMBER_CONSUMP_PERMISSION_MSG = "操作人没有权限查看该会员消费情况";
    public static final String MEMBER_CONSUMP_SUCCESS_MSG = "传入参数有为空的项";
    public static final String SOURCE_ERROR = "14035";
    public static final String SOURCE_ERROR_MSG = "来源错误";
    /**************************会员池 END********************************/

    /**************************商品 START********************************/
    public static final String PRODUCT_CODE = "14042";
    public static final String PRODUCT_MSG = "传入商户ID或者商品货号有为空的项";
    public static final String PRODUCT_EXCEPTION_CODE = "14043";
    public static final String PRODUCT_EXCEPTION_MSG = "商品信息代码中有异常";
    public static final String PRODUCT_SELECT_CODE = "14044";
    public static final String PRODUCT_SELECT_MSG = "商品信息已经存在,不能添加";
    public static final String PRODUCT_SUCCESS_CODE = "14045";
    public static final String PRODUCT_SUCCESS_MSG = "商品信息添加成功";
    public static final String PRODUCT_FAIL_CODE = "14046";
    public static final String PRODUCT_FAIL_MSG = "商品信息添加失败";
    public static final String PRODUCT_API_CODE = "14047";
    public static final String PRODUCT_API_MSG = "查询API失败,没有获取到商品信息";
    /**************************商品 END********************************/

    /**************************地址库START*********************************/
    public static final String ADDRESS_OPERATOR_MSG2 = "操作人权限不足，操作失败";
    //添加收货地址
    public static final String ADDRESS_ADD_MSG = "添加收货地址成功";
    public static final String ADDRESS_ADD_CODE = "12038";
    public static final String ADDRESS_ADD_MSG1 = "部分参数为空，添加失败";
    //删除收货地址
    public static final String ADDRESS_DELETE_MSG = "删除收货地址成功";
    public static final String ADDRESS_DELETE_CODE = "12039";
    public static final String ADDRESS_DELETE_MSG1 = "部分参数为空，删除失败";
    //修改收货地址
    public static final String ADDRESS_UPDATE_MSG = "修改收货地址成功";
    public static final String ADDRESS_UPDATEDEFAULT_MSG = "修改默认收货地址成功";
    public static final String ADDRESS_UPDATE_CODE = "12040";
    public static final String ADDRESS_UPDATE_MSG1 = "部分参数为空，修改失败";
    //查询收货地址
    public static final String ADDRESS_QUERY_LIST_MSG = "查询地址列表成功";
    public static final String ADDRESS_QUERY_DETAIL_MSG = "查询地址详情成功";
    public static final String ADDRESS_QUERY_CODE = "12041";
    public static final String ADDRESS_QUERY_MSG1 = "部分参数为空，查询失败";
    /**************************地址库END*********************************/

    /**************************会员卡 START********************************/
    public static final String MEMBER_CARD_CODE = "14048";
    public static final String MEMBER_CARD_MSG = "参数商户ID,操作人ID,会员卡名称,会员卡类型ID有为空的项";
    public static final String MEMBER_EDIT_ECARD_MSG = "编辑时参数商户ID,操作人ID,会员卡类型ID和会员等级有为空的项";
    public static final String MEMBER_ADD_CARD_CODE = "14049";
    public static final String MEMBER_ADD_CARD_MSG = "添加会员卡成功";
    public static final String MEMBER_CARD_EXCEPTION_CODE = "14050";
    public static final String MEMBER_CARD_EXCEPTION_MSG = "添加会员卡有异常";
    public static final String MEMBER_CARD_TYPE_CODE = "14051";
    public static final String MEMBER_CARD_TYPE_NULL_MSG = "商户ID,操作人ID,会员卡类型名称有为空的项";
    public static final String MEMBER_CARD_TYPE_EXCEPTION_CODE = "14052";
    public static final String MEMBER_CARD_TYPE_UPDATE_EXCEPTION_CODE = "14065";
    public static final String MEMBER_CARD_TYPE_UPDATE_EXCEPTION_MSG = "更新会员卡设置信息有异常";
    public static final String MEMBER_CARD_TYPE_EXCEPTION_MSG = "查询会员卡设置信息有异常";
    public static final String MEMBER_CARD_TYPE_MSG = "查询会员卡设置信息成功";
    public static final String MEMBER_CARD_TYPE_SELECT_CODE = "14054";
    public static final String MEMBER_CARD_TYPE_SELECT_MSG = "查询会员卡设置信息为空";
    public static final String MEMBER_CARD_TYPE_UPDATE_CODE = "14053";
    public static final String MEMBER_CARD_TYPE_UPDATE_MSG = "查询会员卡设置信息为空";
    public static final String MEMBER_CARD_TYPE_UPDATED_CODE = "14055";
    public static final String MEMBER_CARD_TYPE_UPDATED_MSG = "查询会员卡设置信息大于一条";
    public static final String MEMBER_CARD_TYPE_UPDATES_MSG = "会员卡设置信息更新信息成功";
    public static final String MEMBER_CARD_TYPE_UPDATER_CODE = "14056";
    public static final String MEMBER_CARD_TYPE_UPDATER_MSG = "会员卡设置信息更新失败";
    public static final String MEMBER_ADD_CARDF_CODE = "14057";
    public static final String MEMBER_ADD_CARDF_MSG = "添加会员卡失败";
    public static final String MEMBER_EDIT_CARD_CODE = "14058";
    public static final String MEMBER_EDIT_CARD_MSG = "编辑时查询不到会员卡";
    public static final String MEMBER_EDIT_MANY_CARD_CODE = "14059";
    public static final String MEMBER_EDIT_MANY_CARD_MSG = "编辑时查询到已经存在相同级别会员卡";
    public static final String MEMBER_EDIT_CARD_BEAN_CODE = "14060";
    public static final String MEMBER_EDIT_CARD_BEAN_MSG = "编辑时查询到的对象为空";
    public static final String MEMBER_EDIT_CARDS_MSG = "编辑会员卡成功";
    public static final String MEMBER_EDIT_CARDF_CODE = "14061";
    public static final String MEMBER_EDIT_CARDF_MSG = "编辑会员卡失败";
    public static final String MEMBER_DELETE_CARDF_CODE = "14062";
    public static final String MEMBER_DELETE_CARDF_MSG = "要删除的会员卡不存在";
    public static final String MEMBER_DELETE_CARD_MSG = "删除会员卡成功";
    public static final String MEMBER_DELETE_CARD_CODE = "14063";
    public static final String MEMBER_DELETE_CARD_FMSG = "删除会员卡失败";
    public static final String MEMBER_DELETE_CARD_VALIDATE_CODE = "14064";
    public static final String MEMBER_DELETE_CARD_VALIDATE_MSG = "参数商户ID,操作人ID,会员卡ID有为空的项";
    public static final String MEMBER_CARD_EDIT_EXCEPTION_CODE = "14066";
    public static final String MEMBER_CARD_EDIT_EXCEPTION_MSG = "编辑会员卡有异常";


    public static final String MEMBER_CARD_DELETE_EXCEPTION_CODE = "14067";
    public static final String MEMBER_CARD_DELETE_EXCEPTION_MSG = "删除会员卡有异常";
    public static final String MEMBER_CARD_LIST_CODE = "14068";
    public static final String MEMBER_CARD_LIST_MSG = "会员卡列表参数商户ID,操作人ID有为空的项";
    public static final String MEMBER_CARD_LIST_EXCEPTION_CODE = "14069";
    public static final String MEMBER_CARD_LIST_EXCEPTION_MSG = "会员卡列表代码有异常";
    public static final String MEMBER_CARD_LIST_NULL_CODE = "14070";
    public static final String MEMBER_CARD_LIST_NULL_MSG = "会员卡列表查询为空";
    public static final String MEMBER_CARD_LIST_SUCCESS_MSG = "会员卡列表查询成功";
    public static final String MEMBER_CARD_TYPE_NULL_CODE = "14071";
    public static final String MEMBER_CARD_TYPE_NULL_FMSG = "添加的会员卡样式不存在";
    public static final String MEMBER_CARD_ADD_CODE = "14072";
    public static final String MEMBER_CARD_ADD_FMSG = "已经存在相同的会员卡";
    public static final String MEMBER_CARD_TYPE_INFO_CODE = "14073";
    public static final String MEMBER_CARD_TYPE_INFO_MSG = "获取到多于一条的会员卡设置信息";
    public static final String MEMBER_CARD_OPEN_NULL_CODE = "14074";
    public static final String MEMBER_CARD_OPEN_NULL_MSG = "参数商户id或者会员卡类型为空";
    public static final String MEMBER_CARD_OPEN_EXCEPTION_CODE = "14075";
    public static final String MEMBER_CARD_OPEN_EXCEPTION_MSG = "接口中有异常";
    public static final String MEMBER_CARD_SUPPLIER_CODE = "14076";
    public static final String MEMBER_CARD_SUPPLIER_MSG = "商户不存在";
    public static final String MEMBER_OPEN_CARD_CODE = "14077";
    public static final String MEMBER_OPEN_CARD_MSG = "会员卡样式多于一种";
    public static final String MEMBER_OPEN_CARDS_MSG = "会员卡打开成功";
    public static final String MEMBER_CARD_DETAIL_CODE = "14078";
    public static final String MEMBER_CARD_DETAIL_MSG = "参数商户id或者会员卡id为空";
    public static final String MEMBER_CARD_DETAIL_EXCEPTION_CODE = "14079";
    public static final String MEMBER_CARD_DETAIL_EXCEPTION_MSG = "查询会员卡详情有异常";
    public static final String MEMBER_CARD_DETAIL_NULL_CODE = "14080";
    public static final String MEMBER_CARD_DETAIL_NULL_MSG = "会员卡不存在";
    public static final String MEMBER_CARD_DETAIL_SUCCESS_MSG = "会员卡详情查询成功";
    public static final String MEMBER_CARD_ADD_LEVER_CODE = "14081";
    public static final String MEMBER_CARD_ADD_LEVER_MSG = "会员等级开关为关闭状态,不能添加";
    public static final String MEMBER_CARD_ADD_LEVER_NULL_CODE = "14082";
    public static final String MEMBER_CARD_ADD_LEVER_NULL_MSG = "查询不到会员等级";


    /******************************* mengxiang start *******************************/

    public static final String MEMBER_CARD_EDIT_TOOLONG_MSG = "会员卡名称过长";

    //根据会员ID查询会员卡相关信息
    public static final String MEMBER_CARD_INFO_FAIL = "15005";
    public static final String MEMBER_CARD_INFO_NULL_MSG = "操作失败，失败原因：查询参数中有为空项";
    public static final String MEMBER_CARD_INFO_EXCEPTION_MSG = "操作失败，失败原因：代码异常";
    public static final String MEMBER_CARD_INFO_NOTEXIST_MSG1 = "操作失败，失败原因：指定的会员不存在";
    public static final String MEMBER_CARD_INFO_NOTEXIST_MSG2 = "操作失败，失败原因：指定的会员扩展信息不存在";
    public static final String MEMBER_CARD_INFO_NOTEXIST_MSG3 = "操作失败，失败原因：指定的会员卡设置信息不存在";


    public static final String MEMBER_CARD_INFO_SUCCESS_MSG = "操作成功";

    //会员卡激活
    public static final String ACTIVE_MEMBER_CARD_FAIL = "15006";
    public static final String ACTIVE_MEMBER_CARD_FAIL_MSG1 = "操作失败，失败原因：查询参数中有为空项或手机号不合法";
    public static final String ACTIVE_MEMBER_CARD_FAIL_MSG2 = "操作失败，失败原因：代码异常";
    public static final String ACTIVE_MEMBER_CARD_FAIL_MSG3 = "操作失败，失败原因：更新失败";
    public static final String ACTIVE_MEMBER_CARD_FAIL_MSG4 = "操作失败，失败原因：要更新的会员不存在";
    public static final String ACTIVE_MEMBER_CARD_FAIL_MSG5 = "操作失败，失败原因：该会员的会员卡已激活";
    public static final String ACTIVE_MEMBER_CARD_FAIL_MSG6 = "操作失败，失败原因：日期格式错误";
    public static final String ACTIVE_MEMBER_CARD_SUCCESS_MSG = "会员卡激活成功";


    //会员卡类型
    public final static Map<String, String> MEMBER_CARD = new HashMap<String, String>();

    //同步发布至微信卡包
    public final static Map<String, String> SEND_WECHAT = new HashMap<String, String>();

    //有效期
    public final static Map<String, String> CARD_VALIDITY = new HashMap<String, String>();

    //激活设置
    public final static Map<String, String> ACTIVE_SET = new HashMap<String, String>();


    static {

        //会员卡类型
        MEMBER_CARD.put("1", "普通会员卡");
        MEMBER_CARD.put("2", "储值会员卡");

        //同步发布至微信卡包
        SEND_WECHAT.put("1", "是");
        SEND_WECHAT.put("2", "否");

        //有效期
        CARD_VALIDITY.put("1", "永久有效");

        //激活设置
        ACTIVE_SET.put("1", "需要激活");
        ACTIVE_SET.put("2", "无需激活");


    }


    /**************************会员卡  END*********************************/


    /**************************权限 START********************************/

    //公钥
    public static final String PHP_PUBLIC_KRY = "scrm2017ediankai";
    public static final String APP_PUBLIC_KRY = "app123456";
    public static final String DK_PUBLIC_KRY = "ediankai123456";

    //秘钥
    public static final String PHP_SECRET = "php123!@#";
    public static final String APP_SECRET = "app123!@#";
    public static final String DK_SECRET = "ediankai123456";

    //key value
    public final static Map<String, String> ACCESS = new HashMap<String, String>();

    static {
        ACCESS.put(PHP_PUBLIC_KRY, PHP_SECRET);
        ACCESS.put(APP_PUBLIC_KRY, APP_SECRET);
        ACCESS.put(DK_PUBLIC_KRY, DK_SECRET);

    }


    //聚宝盛私钥
    public static final String SECRETKEY = "pYGaeK";
    //商户ID
    public static final String SUPPLIERID = "275";

    /**************************权限 END********************************/

    /**************************应用 Start********************************/
    public static final String APPLICATION_ADD_CODE = "16003";
    public static final String APPLICATION_ADD_ERROR_MSG = "应用添加失败";
    public static final String APPLICATION_ADD_FAIL_MSG_NULL = "必要字段不允许为空";
    public static final String APPLICATION_ADD_FAIL_MSG_NAME_EXIST = "应用名称已存在，新增失败";

    public static final String APPLICATION_DELETE_CODE = "16004";
    public static final String APPLICATION_DELETE_ERROR_MSG = "应用删除失败";
    public static final String APPLICATION_DELETE_FAIL_MSG_NULL = "id不允许为空";

    public static final String APPLICATION_UPDATE_CODE = "16005";
    public static final String APPLICATION_UPDATE_ERROR_MSG = "应用更新失败";
    public static final String APPLICATION_UPDATE_FAIL_MSG_LENGTH = "非法的公钥或秘钥长度";
    public static final String APPLICATION_UPDATE_FAIL_MSG_NULL = "必要字段不允许为空";
    public static final String APPLICATION_UPDATE_FAIL_MSG_NAME_EXIST = "应用名称已存在，修改失败";

    public static final String APPLICATION_QUERY_CODE = "16006";
    public static final String APPLICATION_QUERY_ERROR_MSG = "应用查询失败";
    public static final String APPLICATION_QUERY_FAIL_MSG = "必要字段不允许为空";

    public static final String APPLICATION_SELECT_CODE = "16007";
    public static final String APPLICATION_SELECT_ERROR_MSG = "应用列表查询失败";
    public static final String APPLICATION_SELECT_FAIL_MSG = "传入非法字符串";
    /**************************应用  END********************************/

    /************************飞鹤商品 Start********************************/
    public static final String PRODUCT_SERIES_CODE = "16008";
    public static final String PRODUCT_SERIES_ERROR_MSG = "获取飞鹤商品系列列表失败";

    public static final String PRODUCT_SKU_CODE = "16009";
    public static final String PRODUCT_SKU_ERROR_MSG = "获取飞鹤商品SKU列表失败";

    public static final String PRODUCT_LIST_CODE = "16010";
    public static final String PRODUCT_LIST_ERROR_MSG = "获取飞鹤商品列表失败";

    public static final String PRODUCT_CATEGORY_CODE = "16011";
    public static final String PRODUCT_CATEGORY_ERROR_MSG = "获取飞鹤商品类目列表失败";
    /************************飞鹤商品  End********************************/

    /************************医生数据 Start********************************/
    public static final String DOCTOR_ADD_CODE = "16012";//迈志同步医生数据
    public static final String DOCTOR_ADD_SUCCESS_MSG = "医生数据写入成功";
    public static final String DOCTOR_ADD_FAIL_MSG = "医生数据插入失败";
    public static final String DOCTOR_ADD_FAIL_DUPLICATE_MOBILE_MSG = "医生数据写入失败，该手机号已注册";
    public static final String DOCTOR_ADD_ERROR_MSG = "医生数据写入失败";


    public static final String HOSPITAL_ADD_CODE = "16013";//迈志同步医生数据
    public static final String HOSPITAL_ADD_SUCCESS_MSG = "医院数据写入成功";
    public static final String HOSPITAL_ADD_FAIL_MSG = "医院部门数据插入失败";
    public static final String HOSPITAL_ADD_FAIL_DUPLICATE_CODE_MSG = "医院数据写入失败,医院代码已存在";
    public static final String HOSPITAL_ADD_ERROR_MSG = "医院数据写入失败";

    public static final String QUERY_DOCTOR_MANAGER_CODE = "16014";
    public static final String QUERY_DOCTOR_MANAGER_FAIL_MSG = "该医生无对应医药代表";
    public static final String QUERY_DOCTOR_MANAGER_FAIL_ORGANIZE_MSG = "医药代表无对应管理片区";
    public static final String QUERY_DOCTOR_MANAGER_FAIL_DOCTORID_MSG = "非法的医生主键";
    public static final String QUERY_DOCTOR_MANAGER_ERROR_MSG = "获取医药代表数据失败";

    /************************医生数据  End********************************/
    
    /************************数据统计分析接口 Start********************************/
    public static final String DATA_STATISTICS_CODE ="16015";
    public static final String DATA_STATISTICS_FAIL_MSG="数据分析接口访问异常";
    public static final String DATA_STATISTICS_FAIL_PERMISSION_MSG="登录用户权限不足";
    public static final String DATA_STATISTICS_DEPART_FAIL_PERMISSION_MSG="登录用户权限与所传部门不匹配";
    public static final String DATA_STATISTICS_DEPART_FAIL_NULL_MSG="登录用户部门列表为空";
    public static final String DATA_STATISTICS_ERROR_MSG = "数据分析接口访问失败";
    /************************数据统计分析接口  End********************************/
    
    /**************************商户令牌 Start********************************/
    public static final String SUPPLIERTOKEN_QUERY_MSG = "商品令牌列表获取成功";
    public static final String SUPPLIERTOKEN_QUERY_CODE = "17001";
    public static final String SUPPLIERTOKEN_QUERY_FAIL_MSG = "必要字段不允许为空";

    public static final String SUPPLIERTOKEN_UPDATE_CODE = "17002";
    public static final String SUPPLIERTOKEN_UPDATE_MSG = "商户令牌更新成功";
    public static final String SUPPLIERTOKEN_UPDATE_FAIL_MSG = "必要字段不允许为空";
    public static final String SUPPLIERTOKEN_UPDATE_FAIL_MSG1 = "要修改的商户令牌不存在";
    public static final String SUPPLIERTOKEN_UPDATE_FAIL_MSG2 = "商户令牌更新数据库失败";
    /**************************商户令牌  END********************************/

    /**************************会员宝宝 Start********************************/
    public static final String MEMBERBABY_ADD_CODE = "17003";
    public static final String MEMBERBABY_ADD_MSG = "会员宝宝添加成功";
    public static final String MEMBERBABY_ADD_FAIL_MSG = "必要的字段不允许为空";
    public static final String MEMBERBABY_ADD_FAIL_MSG1 = "会员宝宝插入到数据库异常";
    public static final String MEMBERBABY_ADD_FAIL_MSG2 = "会员宝宝信息已存在，不可重复插入";

    public static final String MEMBERBABY_UPDATE_CODE = "17004";
    public static final String MEMBERBABY_UPDATE_MSG = "会员宝宝更新成功";
    public static final String MEMBERBABY_UPDATE_FAIL_MSG = "必要的字段不允许为空";
    public static final String MEMBERBABY_UPDATE_FAIL_MSG1 = "要修改的会员宝宝信息不存在";
    public static final String MEMBERBABY_UPDATE_FAIL_MSG2 = "操作人不一致，没有操作权限";
    public static final String MEMBERBABY_UPDATE_fAIL_MSG3 = "会员宝宝更新到数据库异常";

    public static final String MEMBERBABY_QUERY_MSG = "会员的宝宝列表查询成功";
    /**************************会员宝宝  END********************************/

    /**************************图片上传 Start********************************/
    public static final String IMGUPLOAD_CODE = "17005";
    public static final String IMGUPLOAD_MSG = "图片上传成功";
    public static final String IMGUPLOAD_ERROR_MSG = "图片上传失败";
    public static final String IMGUPLOAD_FAIL_MSG = "图片上传失败";
    /**************************会员宝宝  END********************************/

    /**************************添加订单 Start********************************/
    public static final String ORDERINFO_ADD_CODE = "17006";
    public static final String ORDERINFO_ADD_MSG = "订单添加成功";
    public static final String ORDERINFO_ADD_FAIL_MSG = "订单添加时，必要字段不允许为空";
    public static final String ORDERINFO_ADD_FAIL_MSG1 = "订单添加时，插入到数据库中失败";
    public static final String ORDERINFO_ADD_FAIL_MSG2 = "该订单已经存在";
    public static final String ORDERINFO_ADD_FAIL_MSG3 = "传入的导购标识在数据库中没有查询到对应的导购信息";
    public static final String ORDERINFO_ADD_FAIL_MSG4 = "传入的门店标识在数据库中没有查询到对应的门店信息";
    public static final String ORDERINFO_ADD_FAIL_MSG5 = "添加失败，请重试";
    public static final String ORDERINFO_ADD_FAIL_MSG6 = "未查询到对应的会员信息";
    public static final String ORDERINFO_ADD_FAIL_MSG7 = "订单来源不符合条件";

    public static final String ORDERINFO_UPDATE_CODE = "17007";
    public static final String ORDERINFO_UPDATE_MSG = "订单更新成功";
    public static final String ORDERINFO_UPDATE_FAIL_MSG = "订单更新时，必要字段不允许为空";
    public static final String ORDERINFO_UPDATE_FALI_MSG1 = "需要更新的数据不存在";
    public static final String ORDERINFO_UPDATE_FAIL_MSG2 = "输入的商户ID和实际不符";
    public static final String ORDERINFO_UPDATE_FAIL_MSG3 = "订单更新时，更新数据库时失败";

    public static final String ORDERINFO_QUERY_ID_CODE = "17010";
    public static final String ORDERINFO_QUERY_ID_MSG = "订单信息查询成功";
    public static final String ORDERINFO_QUERY_ID_FAIL_MSG = "查询订单信息时，订单ID，订单号，外部订单号，必须有一项不为空";
    public static final String ORDERINFO_QUERY_ID_FAIL_MSG1 = "参数传入不正确";
    /**************************添加订单  END********************************/


    /**************************查询部门 Start********************************/
    public static final String DEPARTMENT_QUERY_OUTER_CODE = "17008";
    public static final String DEPARTMENT_QUERY_OUTER_MSG = "根据外部ID和来源查询店铺信息成功";
    public static final String DEPARTMENT_QUERY_OUTER_FAIL_MSG = "查询店铺信息时，外部ID和来源均不能为空";
    /**************************查询部门  END********************************/

    /**************************查询员工 Start********************************/
    public static final String STAFF_QUERY_OUTER_CODE = "17009";
    public static final String STAFF_QUERY_OUTER_MSG = "根据外部ID和来源查询员工信息成功";
    public static final String STAFF_QUERY_OUTER_FAIL_MSG = "查询员工时，外部ID和来源均不能为空";
    /**************************查询员工  END********************************/

    /**************************查询小票数据同步到点开 Start********************************/
    public static final String QUERY_TICKET_TO_DK_CODE = "17011";
    public static final String QUERY_TICKET_TO_DK_MSG = "将小票数据同步到点开成功";
    public static final String QUERY_TICKET_TO_DK_ERROR_MSG = "将小票数据同步到点开失败";
    public static final String QUERY_TICKET_TO_DK_FAIL_MSG = "小票ID和商户ID不可为空";
    public static final String QUERY_TICKET_TO_DK_FAIL_MSG1 = "小票信息不存在";
    /**************************查询小票数据同步到点开  END********************************/
    //获取应用公钥和秘钥
    public static final String QUERY_APP_KEY_CODE = "17012";
    public static final String QUERY_APP_KEY_MSG = "刷新成功";
    public static final String QUERY_APP_KEY_FAIL_MSG = "传入的参数有误";

    //添加商户申请门店数
    public static final String APPLY_SHOP_ADD_CODE = "17013";
    public static final String APPLY_SHOP_ADD_MSG = "申请门店成功";
    public static final String APPLY_SHOP_ADD_ERROR_MSG = "申请门店失败";
    public static final String APPLY_SHOP_ADD_FAIL_MSG = "申请门店时，必要字段不允许为空";
    public static final String APPLY_SHOP_ADD_FAIL_MSG1 = "该商户无权限添加";
    //更新商户申请门店数
    public static final String APPLY_SHOP_UPDATE_CODE = "17014";
    public static final String APPLY_SHOP_UPDATE_MSG = "门店数更新成功";
    public static final String APPLY_SHOP_UPDATE_ERROR_MSG = "门店数更新失败";
    public static final String APPLY_SHOP_UPDATE_FAIL_MSG = "更新商户门店数时，必要字段不允许为空";
    public static final String APPLY_SHOP_UPDATE_FAIL_MSG1 = "无修改权限";
    public static final String APPLY_SHOP_UPDATE_FAIL_MSG2 = "需要修改的数据不存在";
    public static final String APPLY_SHOP_UPDATE_FAIL_MSG3 = "传入的商户ID和实际不符";
    // 查询商户申请门店数-单条
    public static final String APPLY_SHOP_QUERY_ID_CODE = "17015";
    public static final String APPLY_SHOP_QUERY_ID_MSG = "查询成功";
    public static final String APPLY_SHOP_QUERY_ID_FAIL_MSG = "查询时必要字段不允许为空 ";
    public static final String APPLY_SHOP_QUERY_ID_FAIL_MSG2 = "无权限访问";
    public static final String APPLY_SHOP_QUERY_ID_FAIL_MSG3 = "查询的数据不存在";
    public static final String APPLY_SHOP_QUERY_ID_FAIL_MSG4 = "查询时商户ID和实际数据不符";
    // 查询商户申请门店数-分页
    public static final String APPLY_SHOP_QUERY_PAGE_CODE = "17016";
    public static final String APPLY_SHOP_QUERY_PAGE_MSG = "查询成功";
    public static final String APPLY_SHOP_QUERY_PAGE_FAIL_MSG = "无权限访问";
    public static final String APPLY_SHOP_QUERY_PAGE_FAIL_MSG1 = "查询时，商户ID不可为空";
    // 查询门店的可用门店数和已使用门店数 
    public static final String APPLY_SHOP_QUERY_USERED_CODE = "17017";
    public static final String APPLY_SHOP_QUERY_USERED_MSG = "查询成功";
    // 根据外部ID和来源批量查询员工信息
    public static final String STAFF_QUERY_BATCH_CODE = "17018";
    public static final String STAFF_QUERY_BATCH_MSG = "查询成功";
    public static final String STAFF_QUERY_BATCH_FAIL_MSG = "必要参数不允许为空";
    // 根据外部ID和来源批量查询部门信息
    public static final String DEPARTMENT_QUERY_BATCH_CODE = "17019";
    public static final String DEPARTMENT_QUERY_BATCH_MSG = "查询成功";
    public static final String DEPARTMENT_QUERY_FAIL_MSG = "必要参数不允许为空";
    //添加导购数据
    public static final String STAFF_ADD_99_CODE = "17020";
    public static final String STAFF_ADD_99_MSG = "添加导购成功";
    public static final String STAFF_ADD_99_FAIL_MSG = "添加导购时必要参数不可为空";
    public static final String STAFF_OPERATOR_AUTHORITY_CODE = "17021";
    public static final String STAFF_OPERATOR_AUTHORITY_MSG = "该用户无操作权限";
    public static final String STAFF_QUERY_AUTHORITY_CODE = "17022";
    public static final String STAFF_QUERY_AUTHORITY_MSG = "该用户无查询权限";
    //查询导购详情数据
    public static final String STAFF_QUERY_ID_CODE = "17023";
    public static final String STAFF_QUERY_ID_MSG = "查询导购详情成功";
    public static final String STAFF_QUERY_ID_FAIL_MSG = "查询导购时必要参数不可为空";
    public static final String STAFF_QUERY_ID_FAIL_MSG2 = "该导购信息不存在，请重新查询";
    //查询导购列表数据
    public static final String STAFF_LIST_CODE = "17024";
    public static final String STAFF_LIST_MSG = "查询导购数据成功";
    public static final String STAFF_LIST_FAIL_MSG = "查询导购列表时，必要参数不可为空";
    //更新导购备注
    public static final String STAFF_UPDATE_REMARK_CODE = "17025";
    public static final String STAFF_UPDATE_REMARK_MSG = "更新备注成功";
    public static final String STAFF_UPDATE_FAIL_MSG = "更新导购备注时，必要参数不可为空";
    public static final String STAFF_UPDATE_FAIL_MSG1 = "需要修改的导购数据不存在";
    public static final String STAFF_UPDATE_FAIL_MSG2 = "需要修改的导购不属于该店长";
    //查询导购销售情况
    public static final String STAFF_QUERY_SALES_CODE = "17026";
    public static final String STAFF_QUERY_SALES_MSG = "导购销售情况查询成功";
    public static final String STAFF_QUERY_SALES_FAIL_MSG = "查询导购销售情况，必要字段不可为空";
    //一个订单多个商品，进行订单商品数据的添加
    public static final String ORDERPRODUCT_ONE_TO_MANY_CODE = "17027";
    public static final String ORDERPRODUCT_ONE_TO_MANY_MSG = "更新订单商品成功";
    public static final String ORDERPRODUCT_ONE_TO_MANY_FAIL_MSG = "更新订单商品时，必要字段不可为空";
    public static final String ORDERPRODUCT_ONE_TO_MANY_FAIL_MSG1 = "订单不存在";
    
    //订单退货
    public static final String ORDER_RETURN_CODE = "17028";
    public static final String ORDER_RETURN_MSG = "订单退货成功";
    public static final String ORDER_RETURN_FAIL_MSG = "订单退货时，必要的字段不允许为空";
    public static final String ORDER_RETURN_FAIL_MSG1 = "订单退货时，未找到对应的导购信息";
    public static final String ORDER_RETURN_FAIL_MSG2 = "订单退货时，未找到对应的门店信息";
    public static final String ORDER_RETURN_FAIL_MSG3 = "订单退货时，未找到对应的订单信息";
    public static final String ORDER_RETURN_FAIL_MSG4 = "订单退货时，退货的订单数量大于下单时的数量";
    public static final String ORDER_RETURN_FAIL_MSG5 = "订单退货时，退货的商品数量必须大于等于1";
    public static final String ORDER_RETURN_FAIL_MSG6 = "订单退货时，不存在订单商品数据";
    public static final String ORDER_RETURN_FAIL_MSG7 = "订单退货时，商品数据和实际订单商品不符合";
    public static final String ORDER_RETURN_FAIL_MSG8 = "订单退货时，未查询到可退货的订单商品数据";

    
    //根据外部ID查询staff数据
    public static final String STAFF_QUERY_OUTER_ID_CODE = "17029";
    public static final String STAFF_QUERY_OUTER_ID_MSG = "数据查询成功";
    public static final String STAFF_QUERY_OUTER_ID_FAIL_MSG = "外部ID不可为空或0";
    public static final String STAFF_QUERY_OUTER_ID_FAIL_MSG1 = "查询数据不存在";
    //根据导购ID查询导购的固定会员数据
    public static final String STAFF_QUERY_MEMBERS_CODE = "17030";
    public static final String STAFF_QUERY_MEMBERS_MSG = "查询导购会员数据成功";
    public static final String STAFF_QUERY_MEMBERS_FAIL_MSG = "查询导购会员时，必要参数不可为空";
    //删除导购数据
    public static final String STAFFGUIDE_DELETE_CODE = "17031";
    public static final String STAFFGUIDE_DELETE_MSG = "删除导购成功";
    public static final String STAFFGUIDE_DELETE_FAIL_MSG = "删除导购时，必要参数不可为空";
    //查询导购销售情况
    public static final String STAFFGUIDE_SALES_CODE = "17032";
    public static final String STAFFGUIDE_SALES_MSG = "查询导购销售情况成功";
    public static final String STAFFGUIDE_SALES_FAIL_MSG = "查询导购销售情况时，必要参数不可为空";
    //查询门店销售情况 
    public static final String STORE_SALES_CODE = "17033";
    public static final String STORE_SALES_MSG = "查询门店销售情况成功";
    public static final String STORE_SALES_FAIL_MSG = "查询门店销售情况时，必要参数不可为空";
    //查询门店近7天销售情况
    public static final String STORE_SALES_7_CODE = "17034";
    public static final String STORE_SALES_7_MSG = "查询门店近7天销售情况成功";
    public static final String STORE_SALES_7_FAIL_MSG = "查询门店近7天销售情况时，必要字段不可为空";
    //查询门店销售榜单 
    public static final String STORE_SALES_LIST_CODE = "17035";
    public static final String STORE_SALES_LIST_MSG = "查询销售榜单成功";
    public static final String STORE_SALES_LIST_FAIL_MSG = "查询销售榜单时，必要参数不可为空";
    //查询门店会员榜单
    public static final String STORE_MEMBERS_LIST_CODE = "17036";
    public static final String STORE_MEMBERS_LIST_MSG = "查询会员榜单成功";
    public static final String STORE_MEMBERS_LIST_FAIL_MSG = "查询会员榜单时，必要参数不可为空";
    
    public static final String SUPPLIER_PASS_CODE = "17037";
    public static final String SUPPLIER_PASS_FAIL_MSG = "无商户审核权限";
    public static final String SUPPLIER_PASS_FAIL_MSG1 = "商户审核通过时，参数传入错误";
    public static final String SUPPLIER_PASS_FAIL_MSG2 = "未查询到商户信息";
    
    //查询订单列表数据
    public static final String QUERY_ORDER_LIST_CODE = "17038";
    public static final String QUERY_ORDER_LIST_MSG = "查询订单列表成功";
    public static final String QUERY_ORDER_LIST_FAIL_MSG = "查询订单列表时，必要参数不可为空";
    //查询订单详情
    public static final String QUERY_ORDER_INFO_CODE = "17039";
    public static final String QUERY_ORDER_INFO_MSG = "查询订单详情成功 ";
    public static final String QUERY_ORDER_INFO_FAIL_MSG = "查询订单详情时，必要字段不可为空 ";
    public static final String QUERY_ORDER_INFO_FAIL_MSG1 = "查询订单时，订单ID或订单号必须有一项不为空";
    public static final String QUERY_ORDER_INFO_FAIL_MSG2 = "该订单不存在";
    //更新商户状态
    public static final String UPDATE_SUPPLIER_STATUS_CODE = "17040";
    public static final String UPDATE_SUPPLIER_STATUS_MSG = "更新商户状态成功";
    public static final String UPDATE_SUPPLIER_STATUS_FAIL_MSG = "更新商户状态时，必要字段不可为空";
    public static final String UPDATE_SUPPLIER_STATUS_FAIL_MSG1 = "更新商户状态时，商户状态传入错误";
    public static final String UPDATE_SUPPLIER_STATUS_FAIL_MSG2 = "该商户不存在";
    //查询KPI完成度
    public static final String QUERY_KPI_CODE = "17041";
    public static final String QUERY_KPI_MSG = "查询KPI完成度完成";
    public static final String QUERY_KPI_FAIL_MSG = "查询KPI完成度时，必要字段不允许为空";
    public static final String QUERY_KPI_FAIL_MSG1 = "KPI设置有误";
    //admin端指定商户授权
    public static final String INSERT_SUPPLIER_TOKEN_CODE = "17042";
    public static final String INSERT_SUPPLIER_TOKEN_MSG = "指定商户授权成功";
    public static final String INSERT_SUPPLIER_TOKEN_FAIL_MSG = "指定商户授权时，必要字段不允许为空";
    public static final String INSERT_SUPPLIER_TOKEN_FAIL_MSG1 = "该用户无权限";
    
    //上传员工头像
    public static final String UPLOAD_STAFF_IMG_CODE = "17043";
    public static final String UPLOAD_STAFF_IMG_MSG = "头像上传成功";
    public static final String UPLOAD_STAFF_IMG_FAIL_MSG = "上传头像时，必要字段不允许为空";
    public static final String UPLOAD_STAFF_IMG_FAIL_MSG1 = "上传头像时，该用户不存在";
    public static final String UPLOAD_STAFF_IMG_FAIL_MSG2 = "传入商户ID和实际用户不符";
    public static final String UPLOAD_STAFF_IMG_FAIL_MSG3 = "操作人不是员工本人";
    //查询部门管理员
    public static final String QUERY_DEPART_ADMIN_CODE = "17044";
    public static final String QUERY_DEPART_ADMIN_MSG = "查询门店管理员成功";
    public static final String QUERY_DEPART_ADMIN_FAIL_MSG = "查询门店管理员信息时，必要字段不允许为空";
    public static final String QUERY_DEPART_ADMIN_FAIL_MSG1 = "部门ID数据过多，请重新查询";
    //查询优惠券的领取数量和使用数量
    public static final String QUERY_COUPON_GETANDUSED_CODE = "17045";
    public static final String QUERY_COUPON_GETANDUSED_MSG = "获取数据成功";
    public static final String QUERY_COUPON_GETANDUSED_FAIL_MSG = "统计优惠券数据时，必要字段不允许为空";
    //查询可用优惠券列表
    public static final String QUERY_COUPON_AVAILABLE_CODE = "17046";
    public static final String QUERY_COUPON_AVAILABLE_MSG = "查询可用优惠券列表成功";
    public static final String QUERY_COUPON_AVAILABLE_FAIL_MSG = "查询可用优惠券列表时，必要字段不允许为空";
    //查询优惠码是否可用
    public static final String QUERY_COUPON_CODE_AVAILABLE_CODE = "17047";
    public static final String QUERY_COUPON_CODE_AVAILABLE_MSG = "查询优惠码是否可用返回数据成功";
    public static final String QUERY_COUPON_CODE_AVAILABLE_FAIL_MSG = "查询优惠码是否可用时，必要字段不允许为空";
    //使用优惠券
    public static final String UPDATE_COUPON_USE_CODE = "17048";
    public static final String UPDATE_COUPON_USE_MSG = "使用优惠券成功";
    public static final String UPDATE_COUPON_USE_FAIL_MSG = "使用优惠券时，必要字段不允许为空";
    public static final String UPDATE_COUPON_USE_FAIL_MSG1 = "使用优惠券时，未查询到优惠券信息或不在有效期内";
    public static final String UPDATE_COUPON_USE_FAIL_MSG2 = "该优惠券已被使用";
    //取消使用优惠券
    public static final String UPDATE_COUPON_CANCEL_USE_CODE = "17049";
    public static final String UPDATE_COUPON_CANCEL_USE_MSG = "取消使用优惠券成功";
    public static final String UPDATE_COUPON_CANCEL_USE_FAIL_MSG = "取消使用优惠券时，必要字段不允许为空";
    public static final String UPDATE_COUPON_CANCEL_USE_FAIL_MSG1 = "未查询到优惠券信息";
    //查询优惠券活动
    public static final String QUERY_COUPONACTIVITYGUM_CODE = "17050";
    public static final String QUERY_COUPONACTIVITYGUM_MSG = "查询数据成功";
    public static final String QUERY_COUPONACTIVITYGUM_FAIL_MSG = "必要字段不允许为空";
    //添加优惠券推送 
    public static final String INSERT_COUPON_PUSH_CODE = "17051";
    public static final String INSERT_COUPON_PUSH_MSG = "添加优惠券推送成功";
    public static final String INSERT_COUPON_PUSH_FAIL_MSG = "添加优惠券推送数据时，必要字段不允许为空";
    //更新优惠券推送
    public static final String UPDATE_COUPON_PUSH_CODE = "17052";
    public static final String UPDATE_COUPON_PUSH_MSG = "修改优惠券推送成功";
    public static final String UPDATE_COUPON_PUSH_FAIL_MSG = "修改优惠券推送数据时，必要字段不允许为空";
    public static final String UPDATE_COUPON_PUSH_FAIL_MSG1 = "未查询到数据";
    public static final String UPDATE_COUPON_PUSH_FAIL_MSG2 = "传入数据和原数据不符";
    //查询优惠券推送列表
    public static final String query_coupon_push_list_code = "17053";
    public static final String query_coupon_push_list_msg = "获取优惠券推送列表成功";
    public static final String query_coupon_push_list_fail_msg = "获取优惠券推送列表,必要字段不允许为空";
    public static final String query_coupon_push_null = "推送优惠券活动详情不存在";
    public static final String params_null = "必要字段不允许为空";
    
   
    
    //上传图片到服务器
    public static final String UPLOADPICTURESERVICE = "http://qiye.sdccore.ediankai.com/attached";
    
    public static final String uploadPicturesUrl = "/data/sdc/images";
    
    /******************************飞鹤vip生态圈START***************************************/
    //统计导购销售额数据
    public static final String STAFF_SALEAMOUNT_LIST_MSG = "导购列表查询成功";
    public static final String STAFF_SALEAMOUNT_LIST_CODE = "12042";
    //客服列表
    public static final String STAFF_CUSTOMERSERVICE_LIST_MSG = "客服列表查询成功";
    public static final String STAFF_CUSTOMERSERVICE_LIST_CODE = "12042";
    //专家列表
    public static final String STAFF_EXPERT_LIST_MSG = "专家列表查询成功";
    public static final String STAFF_EXPERT_LIST_CODE = "12043";
    //飞鹤部门列表
    public static final String FEIHE_DEPARTMENT_LIST_CODE="12045";
    public static final String FEIHE_DEPARTMENT_LIST_MSG="飞鹤部门列表查询成功";
    public static final String FEIHE_DEPARTMENT_LIST_MSG1="查询失败，area_ids为必传项";
    //飞鹤经销商列表
    public static final String FEIHE_DISTRIBUTOR_LIST_MSG="飞鹤经销商查询成功";
    //飞鹤宅急送
    public static final String FEIHE_LOGISTICS_MSG="宅急送物流信息查询成功";
    public static final String FEIHE_LOGISTICS_CODE="12046";
    public static final String FEIHE_LOGISTICS_MSG1="快递单号不可为空";
    
    /******************************飞鹤vip生态圈END***************************************/
    /***************************商户到老会员表的映射start*********************************/
    //商户id
    public static final Long SUPPLIER_FEIHE = 1L;

    //该商户对应的老会员的表名
    public static final String MEMBER_TABLE_NAME = "core_member_feihe";

    //key value
    public final static Map<Long, String> MEMBER_TABLE = new HashMap<Long, String>();

    static {
        MEMBER_TABLE.put(SUPPLIER_FEIHE, MEMBER_TABLE_NAME);

    }
    /***************************商户到老会员表的映射end***********************************/

    /***************************报表返回start*********************************/
    public static final String Allown_Member_Execption_CODE = "20001";
    public static final String Allown_Member_Execption_CODE_MSG = "非法的统计字段";
    /***************************报表返回end*********************************/
    
}
