package com.example.work;

/**
 * <br>
 * 标题: <br>
 * 描述: <br>
 * 公司: www.tydic.com<br>
 *
 * @author lyj
 * @time 2018/8/23 14:53
 */
public interface Constants {

    String FAULT_CODE_COUNT = "order";

    String RELEASE_CODE_COUNT="release_order";

    String ORDER_BEGIN = "Y";

    String RELEASE_ORDER_BEGIN = "T";

    Integer DEFAULT_VERSION = 1;

    String SALEMEN_ONLINE_KEY = "hdb_online_salemen_list_";

    String HDB_SALEMEN_KEY = "hdb_salemen_";

    String REDIS_POOL_KEY_FORMAT = "POOL:%s:%s";

    // 重复获取支付链接校验key
    String USER_PAY = "user_pay_%s";

    String PAY_RESULT_STATUS_CHANGE = "pay_result_status_change_%s";

    /**
     * 支付订单流水号后六位，每天支付的数量，每天生成
     */
    String ORDER_PAY_COUNT = "order_pay_count_%s";

    /**
     * 存在对应Key说明已被抢单
     */
    String HDB_ORDER_KEY = "hdb_order_";

    /**
     * 派单是否超时key
     */
    String HDB_ORDER_TIMEOUT_KEY = "hdb_order_timeout";

    /**
     * 河南超级办引流办理业务
     */
     String HN_IPTV = "Hn_IPTV";


    /**
     * 第一次点击继续等待按钮的时间
     */
    String HDB_ORDER_FIRST_CLICK_CONTINUE_BTN_TIME = "hdb_order_first_click_continue_time_%s";


    /**
     * 派单是否超时key
     */
    String HDB_USER_BUSI_KEY = "hdb_user_busi_";

    /**
     * 端外订单创建者指定值
     */
    String outSideCreateUserId = "henan";
    /**
     * 业务单类型
     */
    interface OrderStatus {
        /**
         * 正常正向订单
         */
        String NORMAL_ORDER="1";

        /**
         * 返销订单
         */
        String RELEASE_ORDER="2";
    }

    /**
     * 下单用户类型
     */
    interface UserType{

        /**
         * 用户
         */
        String CONSUMER="1";

        /**
         * 营业员
         */
        String SALEMEN="2";
    }
    /**
     * 业务单状态
     */
    interface OrderType {
        String PUBLISHED = "10";
        String TO_BE_ROBBED = "11";
        String TO_BE_DISPATCHED = "12";
        String ACCEPTING = "20";
        String TRANSMITING = "21";
        String ROLLBACKING = "22";
        String TRANSMITED = "23";
        String RECEIPTED = "30";
        String FINISHED = "40";
        String CANCELING = "50";
        String CANCELED = "51";
        String CHARGEBACK = "60";
        String TIMEOUT_CANCEL="61";

        /**
         * 目前仅用于健身环业务 2020/09/15<br/>
         * 用于标识第一次寻找营业员过程结束
         * 15是派单中状态，添加是为了加一个判断条件
         */
        String PUBLISH_START_AGAIN = "13";
        String ORDER_SINGLE ="15" ;
        /**
         * 目前仅用于健身环业务 2020/09/15<br/>
         * 用于标识订单在扩大范围后，仍无营业员处理，订单发布失败
         * 废弃不用 2020/9/15
         */
        String PUBLISH_FAILED = "14";
        /**
         * 转交完成
         */
        String TRANSMITING_OK = "23";
        String HEALTHRING_DISPATCHED_TIMEOUT = "13";

        /**
         * 派单中
         * 注意和状态12（待派单）区分
         */
        String DISPATCHING="15";
    }

    interface PayStatus {
        String WAITING_PAY = "01";
        String PAY_FAILED = "02";
        String PAY_SUCCESS = "00";
        String REFUND_SUCCESS = "03";
        String REFUND_FAILED = "04";
    }


    /**
     * 订单子状态
     */
    interface OrderProcessStatus {

        /**
         * 10: 用户未确认
         */
        String NOT_CONFIRM = "10";
        /**
         * 11: 用户已确认
         */
        String CONFIRM = "11";
        /**
         * 12: 认证成功
         */
        String AUTHENTICATION_SUCCESS = "12";
        /**
         * 13: 认证失败
         */
        String AUTHENTICATION_FAIL = "13";
        /**
         * 14: 同步CB成功
         */
        String SYNCHRO_CB_SUCCESS = "14";
        /**
         * 15: 同步CB失败
         */
        String SYNCHRO_CB_FAIL = "15";
        /**
         * 16: CB订单提交成功
         */
        String SUBMIT_CB_SUCCESS = "16";
        /**
         * 17: CB订单提交失败
         */
        String SUBMIT_CB_FAIL = "17";
        /**
         * 18: 缴费成功
         */
        String PAY_SUCCESS = "18";
        /**
         * 19: 缴费失败
         */
        String PAY_FAIL = "19";
        /**
         * 20: 同步CB缴费信息成功
         */
        String SYNCHRO_CB_PAY_SUCCESS = "20";
        /**
         * 21: 同步CB缴费信息失败
         */
        String SYNCHRO_CB_PAY_FAIL = "21";
        /**
         * 22: CB受理完成
         */
        String CB_ACCEPT_SUCCESS = "22";
        /**
         * 23: CB受理失败
         */
        String CB_ACCEPT_FAIL = "23";
        /**
         * 24: 已返销成功
         */
        String RETURN_SUCCESS = "24";
        /**
         * 25: 已返销失败
         */
        String RETURN_FAIL = "25";
        /**
         * 26: 已退费成功
         */
        String REFUND_SUCCESS = "26";
        /**
         * 27: 已退费失败
         */
        String REFUND_FAIL = "27";

    }


    /**
     * 业务单操作类型
     */
    interface OrderOperType {
        String CREATE = "01";
        String ROB = "02";
        String DISPATCH = "03";
        String ACCEPT = "04";
        String TRANSMIT = "05";
        String ROLLBACK = "06";
        String RECEIPT = "07";
        String FINISH = "08";
        String CANCEL_APPLY = "09";
        String CANCEL = "10";
    }

    /**
     * 业务侧状态
     */
    interface BusinessOrderType {
        String WAITING_LIST = "1";
        String PROCESSING = "2";
        String TO_BE_EVALUATE = "3";
        String EVALUATED = "4";
        String CANCELED = "5";
        String WAITING_LIST_VALUE = "待接单";
        String PROCESSING_VALUE = "办理中";
        String TO_BE_EVALUATE_VALUE = "待评价";
        String EVALUATED_VALUE = "评价完成";
        String CANCELED_VALUE = "已取消";
    }

    /**
     * 工单类型
     */
    public static class WorkType {
        public static final String COMPLAINTS_WORK = "投诉工单";
        public static final String CONSULTING_WORK = "咨询工单";
        public static final String FAULT_WORK = "故障工单";
        public static final String PEOPLE_DISABILITIES_WORK = "报障工单";
        public static final String BUSINESS_WORK = "业务办理";

    }

    /**
     * 关键词回复类型
     */
    interface KeywordReplyType {

        //回复语
        public static final String REPLY_WORD = "1";

        //图片
        public static final String MULTIMEDIA = "2";

        //业务推荐
        public static final String RECOMMEND_BUSINESS = "3";

        //视频
        public static final String VIDEO = "4";

        //HTML
        public static final String HTML = "5";
    }

    interface Code{

        public static final String IMAGE_CODE_KEY="OUTSIDE_CODE_IMAGE_%s";

        public static final String MESSAGE_CODE_KEY="OUTSIDE_CODE_MESSAGE_%s";
        public static final String MESSAGE_CHECK_RESULT="OUTSIDE_CHECK_SUCCESS_%s";
    }


}
