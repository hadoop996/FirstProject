package com.example.domain;

import lombok.Data;

import java.util.List;

/**
 * @ClassName:
 * @Description:
 * @Author: zhanglw92@chinaunicom.cn
 * @Data: 2019/8/5 14:33
 */
@Data
public class CheckUserInfoRsp {
    private String respCode;                              //应答编码
    private String respDesc;                              //应答描述
    private List<CUST_INFO> custInfo;                     //客户信息
    private List<USER_INFO> userInfo;                     //用户信息
    private List<ACCT_INFO> acctInfo;                     //帐号资料
    private String scoreThresholdFlag;                    //是否达到积分阀值标记 1是；2 否
    private List<FOREGIFT_FEE_INFO> foregiftFeeInfo;      //押金信息
    private List<POST> post;                              //邮寄信息，最多三个
    private List<PURCHASE> purchase;                      //购机信息
    private List<ASSURE> assure;                          //担保信息
    private List<INFOCHANGE> infochange;                  //用户异动信息
    private List<USER_SCORE> userScore;                   //用户积分
    private List<CUST_SCORE> custScore;                   //客户积分
    private List<USER_RAFFLE> userRaffle;                 //用户抽奖信息
    private List<ACCT_DISCNT> acctDiscnt;                 //账户优惠信息
    private List<USER_PPS> userPps;                       //智能网用户状态
    private List<USER_EXCHANGE> userExchange;             //用户兑奖信息
    private List<RELATION_NUM_INFO> relationNumInfo;      //关联号码信息
    private List<GROUP_PAYRULE_INFO> groupPayruleInfo;    //集团代付规则
    private List<MORE_ACCT_INFO> moreAcctInfo;            //帐号资料
    private List<ELEMENT_INFO> elementInfo;               //
    private List<PARA> para;                              //保留字段

    //属性
    @Data
    static public class ATTR_INFO {
        private String attrCode;                          //属性
        private String attrValue;                         //值
        private String startDate;                         //开始时间
        private String endDate;                           //结束时间
        private String itemId;                            //
    }

    //客户信息
    @Data
    static public class CUST_INFO {
        private String custId;                   //客户标识
        private String custComplFlag;           //客户资料实录标志 0：未补录 1：已补录
        private String custName;            //客户名称
        private String custType;            //客户类型编码，数据模型编码CUI_000012
        private String custState;           //客户状态编码，统一数据模型编码CUI_000013
        private String certEndDate;         //证件有效期
        private String certAddr;            //证件地址
        private String certTypeCode;            //证件类别编码，见附录
        private String certType;            //证件类型名称
        private String certCode;            //证件号码
        private String provinceCode;            //省份编码，统一数据模型编码SHS_000001
        private String eparchyCode;         //归属地市
        private String auditNum;            //稽核次数
        private String developDepartId;         //发展渠道
        private String developStaffId;          //发展员工
        private String inDepartId;          //建档渠道
        private String inStaffId;           //建档员工
        private String inDate;          //建档时间，格式YYYYMMDDHH24MISS
        private String removeDate;          //销档时间
        private String remark;          //备注
        private String custClassType;           //客户级别编码，统一数据模型编码CUI_000015
        private String customerLevel;           //客户等级编码，统一数据模型编码CUI_000082
        private String creditClass;         //信用等级，编码见PRD_000054
        private String customerLoc;         //本外地标志编码，统一数据模型编码CLB_000015
        private String sex;         //客户性别编码，统一数据模型编码SHO_000020
        private String birthday;            //阳历生日
        private String birthdayLunar;           //阴历生日
        private String birthdayFlag;            //阴阳历生日标记编码，统一数据模型编码CUI_000100
        private String postAddress;         //通信地址
        private String postCode;            //邮政编码
        private String postPerson;          //收件人
        private String phone;           //联系电话
        private String faxNbr;          //传真号码
        private String email;           //电子邮件
        private String homeAddress;         //家庭地址
        private String homePhone;           //家庭电话
        private String contact;         //联系人姓名
        private String contactPhone;            //联系人电话
        private String nationalityCode;         //国籍编码，统一数据模型编码CUI_000030
        private String localNativeCode;         //籍贯编码，统一数据模型编码SHS_000001
        private String contactType;         //优先联系方式
        private String workName;            //工作单位
        private String workPhone;           //工作电话
        private String workAddress;         //工作地址
        private String jobTypeCode;         //职业类型
        private String job;                 //职位
        private String marriage;            //婚姻状况
        private String folkCode;            //民族
        private String revenueLevelCode;            //收入等级
        private String characterTypeCode;           //性格类型
        private String educateDegreeCode;           //教育程度
        private List<ATTR_INFO> attrInfo;           //客户属性信息
        private VIP_CUST_INFO vipCustInfo;     //大客户信息
        private List<GROUP_CUST_INFO> groupCustInfo; //集团客户信息

        //大客户信息
        @Data
        static public class VIP_CUST_INFO {
            private String vipId;              //VIP标识
            private String userId;             //用户标识
            private String vipClassIdB;        //会员级别
            private String custManagerName;    //客户经理名称
            private String custManagerNumber;  //客户经理手机号码
            private String vipTypeCode;         //大客户类型编码，统一数据模型编码CUI_000049
            private String vipClassId;          //VIP级别，统一数据模型编码CUI_000049
            private String classChangeDate;     //级别变更时间
            private String vipCardInfo;         //VIP卡信息
            private String vipCardNo;           //VIP卡号
            private String vipCardType;         //VIP卡类型，统一数据模型编码CLB_000008
            private String vipCardState;         //VIP卡状态，统一数据模型编码CLB_000007
            private String vipCardStartDate;     //VIP卡有效起始时间
            private String vipCardEndDate;        //VIP卡有效终止时间
            private String vipCardChangeDate;      //VIP卡变更时间
            private String vipCardChangeReason;     //VIP卡变更原因
            private String custManagerId;           //客户经理A
            private String custManagerIdB;          //客户经理B
        }

        //集团客户信息
        @Data
        static public class GROUP_CUST_INFO {
            private String groupId;                //集团编码
            private String custName;               //集团名称
            private String groupType;              //集团类型：0-单位集团，2-虚拟集团，4-名单制集团 见参数表TD_S_STATIC/CUSTGROUP_GROUPTYPE
            private String classId;            //集团级别：见参数表TD_S_STATIC/CUSTGROUP_CLASSID
            private String lastClassId;            //原集团级别：见参数表TD_S_STATIC/CUSTGROUP_CLASSID
            private String classChangeDate;            //级别变更时间
            private String custClassType;              //集团客户级别归属：0－省级、1－市级、2－区县级，见参数表TD_S_STATIC/CUSTGROUP_CUSTCLASSTYPE
            private String groupAttr;              //集团属性：顶级、一级、二级、三级，见参数表TD_S_STATIC/CUSTGROUP_GROUPATTR
            private String groupStatus;            //集团状态：0－在网，1－潜在
            private String groupAddr;              //集团地址
            private String eparchyCode;            //归属地州
            private String cityCode;               //归属业务区
            private String superGroupId;               //上级集团编码
            private String mpGroupCustCode;            //跨省集团客户编码
            private String unifyPayCode;               //统一付费编码
            private String orgStructCode;              //组织结构代码
            private String custManagerId;              //服务经理
            private String custManagerAppr;            //服务经理评价
            private String assignDate;             //客户经理调配时间
            private String assignStaffId;              //客户经理调配员工
            private String callingTypeCode;            //所属行业：见参数表TD_S_CALLINGTYPE
            private String subCallingTypeCode;             //子行业类别编码：见参数表TD_S_CALLINGSUBTYPE
            private String callingAreaCode;            //所属行业区域：几个相关行业，更粗的粒度，见参数表TD_S_CALLING_AREA
            private String groupContactPhone;              //集团联系电话
            private String enterpriseTypeCode;             //注册类型： 见参数表TD_S_STATIC/BASEGROUP_REGTYPE
            private String enterpriseSizeCode;             //目标分级：见参数表TD_S_STATIC/CUSTGROUP_CLASSID2
            private String enterpriseScope;            //集团区域特点：跨省、跨地州，跨市（指该集团下用户的分布范围：全国/省内/市内），见参数表TD_S_STATIC/CUSTGROUP_ENTERPRISESCOPE
            private String juristicTypeCode;               //法人类别：见参数表TD_S_JURISTIC_TYPE
            private String juristicCustId;                //法人代表标识
            private String juristicName;                          //法人代表姓名
            private String busiLicenceType;                       //营业执照类型：见参数表TD_S_STATIC/CUSTGROUP_BISILICENCETYPE
            private String busiLicenceNo;                         //集团证件号码
            private String busiLicenceValidDate;              //集团证件有效期
            private String groupMemo;                         //公司简介
            private String bankAcct;                          //统一付费账号
            private String bankName;                              //托收银行
            private String regMoney;                          //注册资金
            private String regDate;                           //开业时间
            private String custAim;                           //客户战略目标
            private String scope;                                 //集团经营情况
            private String mainBusi;                              //主营业务
            private String mainTrade;                             //主要业务往来对象
            private String empLsave;                                  //员工收入与消费情况
            private String latencyFeeSum;                         //潜在集团客户月消费额
            private String yearGain;                              //年营业额
            private String turnover;                          //年利润
            private String consume;                               //集团消费情况
            private String commBudget;                            //集团通信预算
            private String gtelBudget;                            //集团固话预算
            private String ltelBudget;                                //集团长途预算
            private String groupAdversary;                        //集团主要竞争对手
            private String vpmnGroupId;                       //VPMN集团编码
            private String vpmnNum;                           //VPMN的数量
            private String userNum;                               //手机用户数
            private String empNumLocal;                           //本地员工人数
            private String empNumChina;                           //中国员工人数
            private String empNumAll;                                 //全球员工人数
            private String telecomNumGh;                              //电信用户数固话
            private String telecomNumXlt;                                 //电信用户数小灵通
            private String mobileNumChinago;                          //移动用户数神州行
            private String mobileNumGlobal;                           //中国移动手机数
            private String mobileNumMzone;                            //移动用户数动感地带
            private String mobileNumLocal;                        //移动用户数本地通
            private String unicomNumG;                            //联通用户数G网
            private String unicomNumC;                            //联通用户数C网
            private String unicomNumGc;                               //联通用户数GC双网
            private String productNumLocal;                           //集团使用本运营商的主要业务
            private String productNumOther;                           //集团内各运营商产品数量占比及收入占比
            private String productNumUse;                             //使用产品数
            private String employeeArpu;                              //员工平均话费
            private String netrentPayout;                             //互联网及租线支出
            private String mobilePayout;                              //移动手机支出
            private String unicomPayout;                                  //联通手机支出
            private String telecomPayoutXlt;                          //小灵通支出
            private String groupPayMode;                              //集团支付方式
            private String payforWayCode;                             //话费报销政策：见参数表TD_S_PAYFOR_WAY
            private String writefeeCount;                         //报销话费人数
            private String writefeeSum;                               //话费报销金额
            private String userNumFullfree;                           //全额公免用户数
            private String userNumWriteoff;                       //现金报销用户数
            private String bossFeeSum;                                //领导报销话费金额
            private String doyenStaffId;                              //首席客户代表
            private String newtradeComment;                           //新业务使用情况
            private String likeMobileTrade;                           //喜欢的移动业务
            private String likeDiscntMode;                            //喜欢的优惠方式
            private String financeEarning;                        //企业规模：见参数表TD_S_STATIC/CUSTBASEGROUP_MEMBERCOUNT
            private String subclassId;                        //重要程度级别
            private String website;                           //集团网站
            private String faxNbr;                            //传真
            private String email;                                 //公司Email
            private String postCode;                              //邮政编码
            private String removeTag;                             //销档标志：0-正常、1-销档
            private String removeDate;                                //销档时间
            private String removeStaffId;                             //销档员工
            private String removeChange;                          //销档原因
            private String updateTime;                                //更新时间
            private String updateStaffId;                             //更新员工
            private String updateDepartId;                    //更新部门
            private String remark;                                //备注
            private String rsrvStr1;                            //名单制集团客户统一编码（吉林）
            private String rsrvStr2;                            //公司决策方式 select *  from td_s_static where type_id='CUSTGROUP_METHOD'
            private String rsrvStr3;                            //集团变更状态select *  from td_s_static  where type_id='CUSTGROUP_CHANGESTATE'
            private String rsrvStr4;                            //预留字段4
            private String rsrvStr5;                            //集团产品
            private String rsrvStr6;                            //预留字段6 （上级集团名称）
            private String rsrvTag1;                            //“集团客户类型”select * from td_s_static  where type_id ='CUSTGROUP_GROUPCUSTTYPE'
            private String rsrvTag2;                            //集团来源渠道(甘肃)
            private String rsrvTag3;                            //集团类别
            private String classId2;                            //集团级别2：见参数表TD_S_STATIC/CUSTGROUP_CLASSID2
            private String acceptChannel;                       //入网渠道：见参数表TD_S_STATIC/CUSTGROUP_ACCEPTCHANNEL
            private String callType;                            //行业应用：见参数表TD_S_STATIC/CUSTGROUP_CALLTYPE
            private String agreement;                           //协议类型：见参数表TD_S_STATIC/CUSTGROUP_AGREEMENT
            private String busiType;                            //业务类别：见参数表TD_S_STATIC/CUSTGROUP_BUSITYPE
            private String removeFlag;                          //流失条件：见参数表TD_S_STATIC/CUSTGROUP_REMOVEFLAG
            private String removeMethod;                        //流失类型：见参数表TD_S_STATIC/CUSTGROUP_REMOVEMETHOD
            private String removeReasonCode;                    //流失类型：见参数表TD_S_STATIC/CUSTGROUP_REMOVEREASONCODE
            private String auditState;                          //审核状态：见参数表TD_S_STATIC/CUSTGROUP_AUDITSTATE
            private String auditDate;                           //审核时间
            private String auditStaffId;                        //审核员工
            private String auditNote;                           //审核说明
            private String earningOrder;                        //机构类型：见参数表TD_S_STATIC/BASEGROUP_ORGTYPE
            private String pnationalGroupId;                    //父全国集团编码
            private String provinceCode;                        //归属省份
            private String pnationalGroupName;                  //父全国集团名称
            private String groupValidScore;                     //集团客户可用积分
            private String groupSumScore;                       //集团客户累计积分
            private String groupMgrSn;                          //集团管理员手机号码
            private String groupMgrUserId;                      //集团管理员用户标识
            private String groupMgrCustName;                    //集团管理员姓名
            private String baseAccessNo;                        //基本接入号码
            private String baseAccessNoKind;                    //基本接入号码属性：见参数表TD_S_STATIC/CUSTGROUP_BASEACCESSNOKIND
            private String custServNbr;                         //客服号码
            private String ifShortPin;                          //是否支持纯短号码鉴权：0－不支持，1－支持
            private String callingPolicyForce;                  //行业政策影响力：见参数表TD_S_STATIC/CUSTGROUP_CALLINGPOLICYFORCE
            private String callingTypeCodeDetail;               //所属行业类别细类select *  from TD_S_CALLINGTYPEDETAIL
            private String serverAssignDate;                    //服务经理调配时间
            private String serverAssignStaffId;                 //服务经理调配员工
            private String turnInnetDate;                       //转在网时间
            private String turnInnetStaffId;                    //转在网操作人
            private String takePictureTag;                      //拍照标记: 是否拍照集团 0：非拍照集团；1：拍照集团，默认非拍照集团
            private String custManagerIdB;                      //服务经理
            private String classId2StartDate;                   //维系级别开始时间
            private String classId2EndDate;                     //维系级别结束时间
            private String ifRelationCust;                      //是否关系客户
            private String areaOffice;                          //归属区局,对应值CUSTGROUP_AREA
            private String manageCode;                          //集团公司管控编码
            private String international;                       //国际属性,对应值CUSTGROUP_INTERNATIONAL
            private String fileCode;                            //档案编码
            private String financeInstance;                     //财务状况
            private String growPotential;                       //发展潜力
            private String creditDegree;                        //信用等级
            private String lastClassId2;                        //原维系级别字段
            private String class2ChangeDate;                    //维系级别变更时间
            private String licenceAuditPerson;                  //集团证件类型为其它时审批人姓名：
            private String licenceAuditFileId;                  //
            private String juristicPsptId;                      //
            private String juristicPsptType;                    //法人证件类型: 见参数表TD_S_PASSPORTTYPE
            private String telDecisionType;                     //
            private String busiTaxId;                           //
            private String belongTeamIdB;                       //服务经理所属团队或部门
            private String belongTeamId;                        //客户经理所属团队或部门
        }
    }

    //用户信息
    @Data
    static public class USER_INFO {
        private String userId;                                //用户编码
        private String userState;                             //用户状态，后付费用户见统一数据模型编码PRD_000032，预付费用户见统一数据模型编码PRD_000070
        private String brandCode;                             //品牌取值见附录，省分品牌由省分配置。
        private String serviceClassCode;                      //电信类型
        private String brand;                                 //品牌名称
        private String provinceCode;                          //省分编码，统一数据模型编码SHS_000001
        private String eparchyCode;                           //城市代码
        private String cityCode;                              //营业区编码
        private String openDate;                              //入网时间yyyymmddhh24miss
        private String landLevle;                             //通话级别
        private String roamStat;                              //漫游状态
        private String productId;                             //当前使用产品标识
        private String productName;                           //当前使用产品名称
        private String nextProductId;                         //下月使用产品标识
        private String nextProductName;                       //下月使用产品名称
        private String subscrbType;                           //用户类型，统一数据模型编码CUI_000004  0 后付费 1 预付费 2 OCS 3 其它
        private String intenetType;                           //智能网标识 0 智能网用户 1 非智能网用户
        private String userScoreAmount;                       //用户当前可用积分
        private String leadCode;                              //引示号
        private String custId;                                //客户标识
        private String usecustId;                             //使用客户标识
        private String usecustName;                           //使用客户名称
        private String usecustPsptTypeCode;                   //使用客户证件类型
        private String usecustPsptId;                         //使用客户证件号码
        private String xEparchyName;                          //地市
        private String cityName;                              //区域名称
        private String userPasswd;                            //密码
        private String userDiffCode;                          //用户关系
        private String userTypeCode;                          //用户类型
        private String serialNumber;                          //号码
        private String scoreValue;                            //积分
        private String creditClass;                           //信用等级
        private String acctTag;                               //账户标志
        private String xAcctTagName;                          //名称
        private String prepayTag;                             //付费标志
        private String xPrepayTagName;                        //付费标志名称
        private String inDate;                                //建档时间
        private String openMode;                              //开户模式
        private String xOpenModeName;                         //开户模式名称
        private String openDepartId;                          //开户部门
        private String openStaffId;                           //开户员工
        private String inDepartId;                            //建档部门
        private String inStaffId;                             //建档员工
        private String removeTag;                             //用户状态
        private String xRemoveTagName;                        //用户状态名称
        private String destroyTime;                           //销户时间
        private String removeEparchyCode;                     //销户地市
        private String removeCityCode;                        //销户区域
        private String removeDepartId;                        //销户部门
        private String removeReasonCode;                      //销户原因
        private String preDestroyTime;                        //预销户时间
        private String firstCallTime;                         //首次通话时间
        private String lastStopTime;                          //最后停机时间
        private String userStateCodeset;                      //用户状态集
        private String xSvcstateExplain;                      //用户状态集名称
        private String mputeMonthFee;                         //
        private String mputeDate;                             //
        private String assureCustId;                          //担保客户
        private String assureTypeCode;                        //担保类型编码
        private String assureDate;                            //担保日期
        private String developStaffId;                        //发展员工
        private String developDate;                           //发展日期
        private String developEparchyCode;                    //发展地州编码
        private String developCityCode;                       //发展业务区
        private String developDepartId;                       //发展部门ID
        private String developNo;                             //
        private String contractId;                            //合同号
        private String changeuserDate;                        //
        private String inNetMode;                             //入网方式
        private String productTypeCode;                       //产品类型
        private String mainDiscntCode;                        //主资费标识
        private String productSpec;                           //产品规格
        private String remark;                                //备注
        private String simCardNo;                             //SIM/USIM卡号
        private String imsi;                                  //IMSI号
        private String flag3g;                                //是否3G 1是；2 否
        private List<SAME_LINE_INFO> sameLineInfo;            //共线号码信息
        private List<PRODUCT_INFO> productInfo;               //子产品信息
        private List<ACTIVITY_INFO> activityInfo;             //活动信息
        private List<DISCNT_INFO> discntInfo;                 //优惠信息
        private List<SVC_INFO> svcInfo;                       //服务信息
        private List<SP_INFO> spInfo;                         //SP信息
        private List<UU_INFO> uuInfo;                         //用户关系信息
        private List<PLUS_PRODUCTS> plusProducts;             //集团成员产品
        private List<OTHER_INFO> otherInfo;                   //用户扩展信息
        private String vpnName;                               //所属虚拟网名称
        private String basicCreditValue;                      //基本信用度
        private String creditValue;                           //信用度
        private String creditRuleId;                          //信控规则标识
        private ARREARAGE_FEE_INFO arrearageFeeInfo;    //欠费信息
        private RESOUREC_INFO resourecInfo;             //装机资源信息
        private List<RES_INFO> resInfo;                       //资源信息
        private String payGroupCustId;                        //由集团付费时的集团客户编码
        private String payGroupCustName;                      //由集团付费时的集团客户名称
        private List<OWE_FEE_MONTH_INFO> oweFeeMonthInfo;     //用户每月欠费金额

        //共线号码信息
        @Data
        static public class SAME_LINE_INFO {
            private String sameLineTypeCode;                  //共线号码电信类型编码，编码见附录
            private String sameLineAreaCode;                  //共线号码区号
            private String sameLineNumber;                    //共线号码
        }

        //子产品信息
        @Data
        static public class PRODUCT_INFO {
            private String productId;                         //产品编码
            private String productName;                       //产品名称
            private String productMode;                       //产品模式
            private String productActiveTime;                 //生效时间
            private String productInactiveTime;               //失效时间
        }

        //活动信息
        @Data
        static public class ACTIVITY_INFO {
            private String activityId;                        //活动ID
            private String activityName;                      //活动名称
            private String activityActiveTime;                //生效时间
            private String activityInactiveTime;              //失效时间,格式：
        }

        //优惠信息
        @Data
        static public class DISCNT_INFO {
            private String userIdA;                           //A用户标识：关联优惠中的A用户标识，通常为一集团用户或虚拟用户。对于非关联优惠填-1。
            private String productId;                         //产品标识：系统中唯一的编码
            private String packageId;                         //包标识
            private String discntCode;                        //优惠编码
            private String specTag;                           //特殊优惠标记：0-正常产品优惠，1-特殊优惠，2-关联优惠。
            private String relationTypeCode;                  //关系类型：见参数表TD_S_RELATIONT
            private String startDate;                         //开始时间
            private String endDate;                           //结束时间
            private String itemId;                            //当存在属性时记录属性标识，否则为空
            private List<ATTR_INFO> attrInfo;                 //优惠属性
        }

        //服务信息
        @Data
        static public class SVC_INFO {
            private String serviceId;                         //用户订购的附属服务
            private String mainTag;                           //是否主体服务：0-否，1-是
            private String startDate;                         //开始时间
            private String endDate;                           //终止时间
            private String itemId;                            //当存在属性时记录属性标识，否则为空
            private String packageId;                         //标记服务的作用范围，传给billing；非强制包，记录为-1；强制包，记录为包id
            private String userIdA;                           //A用户标识
            private String productId;                         //产品标识
            private List<ATTR_INFO> attrInfo;                 //服务属性
        }

        //SP信息
        @Data
        static public class SP_INFO {
            private String productId;                         //产品标识
            private String packageId;                         //包标识
            private String partyId;                           //合作伙伴标识
            private String spId;                              //业务标识
            private String spName;                            //SP名称
            private String spProductId;                       //SP产品标识
            private String spProductName;                     //SP产品名称
            private String firstBuyTime;                      //首次订购时间
            private String paySerialNumber;                   //付费号码
            private String startDate;                         //生效时间
            private String endDate;                           //失效时间
            private String updateTime;                        //更新时间
            private String payUserId;                         //
            private String spServiceId;                       //
            private String itemId;                            //属性标识
            private List<ATTR_INFO> attrInfo;                 //SP属性
        }

        //用户关系信息
        @Data
        static public class UU_INFO {
            private String userIdA;                           //主号码标识
            private String productIdA;                        //亲情产品
            private String serialNumberA;                     //主号码
            private String userIdB;                           //副号码标识
            private String serialNumberB;                     //副号码
            private String relationTypeCode;                  //关系类型
            private String roleCodeA;                         //A角色
            private String roleNameA;                         //角色名称
            private String roleCodeB;                         //B角色
            private String roleNameB;                         //角色名称
            private String orderno;                           //序号
            private String shortCode;                         //短号
            private String startDate;                         //开始时间
            private String endDate;                           //结束时间
            private String itemId;                            //属性标识
            private String relationAttr;                      //关系标识
            private String brandCode;                         //品牌编码
            private String serviceClassCode;                  //电信类型编码
            private List<ATTR_INFO> attrInfo;                 //UU属性
        }

        //集团成员产品
        @Data
        static public class PLUS_PRODUCTS {
            private String productId;                         //产品标识
        }

        //用户扩展信息
        @Data
        static public class OTHER_INFO {
            private String rsrvValueCode;                     //扩展编码
            private String rsrvValue;                         //扩展资料
            private String rsrvStr1;                          //扩展资料1
            private String rsrvStr2;                          //扩展资料2
            private String rsrvStr3;                          //扩展资料3
            private String rsrvStr4;                          //扩展资料4
            private String rsrvStr5;                          //扩展资料5
            private String rsrvStr6;                          //扩展资料6
            private String rsrvStr7;                          //扩展资料7
            private String rsrvStr8;                          //扩展资料8
            private String rsrvStr9;                          //扩展资料9
            private String rsrvStr10;                         //扩展资料10
            private String rsrvStr11;                         //扩展资料11
            private String rsrvStr12;                         //扩展资料12
            private String rsrvStr13;                         //扩展资料13
            private String rsrvStr14;                         //扩展资料14
            private String rsrvStr15;                         //扩展资料15
            private String rsrvStr16;                         //扩展资料16
            private String rsrvStr17;                         //扩展资料17
            private String rsrvStr18;                         //扩展资料18
            private String rsrvStr19;                         //扩展资料19
            private String rsrvStr20;                         //扩展资料20
            private String rsrvStr21;                         //扩展资料21
            private String rsrvStr22;                         //扩展资料22
            private String rsrvStr23;                         //扩展资料23
            private String rsrvStr24;                         //扩展资料24
            private String rsrvStr25;                         //扩展资料25
            private String startDate;                         //开始时间
            private String endDate;                           //结束时间
        }

        //欠费信息
        @Data
        static public class ARREARAGE_FEE_INFO {
            private String depositMoney;                      //实时余额
            private String balanceBeforeLast;                 //上上月欠费金额
            private String lastBalance;                       //上月欠费金额
            private String fee;                               //本月实时话费
        }

        //装机资源信息
        @Data
        static public class RESOUREC_INFO {
            private String installAddress;                    //装机地址（安装地址）
            private String cityCode;                          //营业区编码
            private String exchCode;                          //局向编码
            private String addressCode;                       //标准地址编码
            private String addressName;                       //标准地址名称
            private String appointment;                       //预约时间
        }

        //资源信息
        @Data
        static public class RES_INFO {
            private String resTypeCode;                       //资源类型
            private String resCode;                           //号卡
            private String resInfo1;                          //IMSI
            private String resInfo2;                          //
            private String resInfo3;                          //
            private String resInfo4;                          //卡类型
            private String resInfo5;                          //卡容量
            private String startDate;                         //开始时间
            private String endDate;                           //结束时间
            private List<ATTR_INFO> attrInfo;                 //属性信息
        }

        //用户每月欠费金额
        @Data
        static public class OWE_FEE_MONTH_INFO {
            private String xCycleId;                          //欠费月份
            private String xAdebFee;                          //欠费金额
        }
    }

    //帐号资料
    @Data
    static public class ACCT_INFO {
        private String acctId;                                //账户标识
        private String custId;                                //客户标识
        private String debutyUserId;                          //代表用户标识
        private String debutyCode;                            //代表号码
        private String payName;                               //帐户名称
        private String payModeCode;                           //付费方式编码，数据模型编码CUI_000084
        private String payMode;                               //付费方式名称
        private String prepayTag;                             //预付费标识：0 后付费 1 准预付费 2 OCS 3 PPS
        private String acctPasswd;                            //账户密码
        private String accountCycle;                          //帐务周期
        private String isGroupAcct;                           //是否集团帐户 0否 1是
        private String payitemCode;                           //付费科目
        private String acctPriority;                          //账户优先级
        private String userPriority;                          //用户优先级
        private String bindType;                              //绑定类型
        private String startAcycId;                           //开始帐期
        private String endAcycId;                             //结束帐期
        private String defaultTag;                            //是否默认
        private String actTag;                                //帐号标志
        private String limitType;                             //限制类型
        private String limit;                                 //限额
        private String acctOnly;                              //是否独立帐户 0否 1是
        private List<ATTR_INFO> attrInfo;                     //账户属性信息
        private List<CONSIGN> acctInfo;                       //托收信息
        private String scoreValue;                            //帐户积分
        private String contractNo;                            //帐户合同号
        private String openDate;                              //开户时间。格式：YYYYMMDDHH24MISS

        //托收信息
        @Data
        static public class CONSIGN {
            private String consignMode;                       //托收方式，统一数据模型编码PRD_000048
            private String superBankCode;                     //上级银行编码，省分去ESS配置
            private String bankCode;                          //开户银行编码，省分去ESS配置
            private String bank;                              //银行名称
            private String bankAcctNo;                        //银行付费账号
            private String agreementNo;                       //托收协议号
            private String acctBalanceId;                     //账本标识
            private String bankAcctName;                      //托收名称
            private String bankBusiKind;                      //
        }
    }

    //押金信息
    @Data
    static public class FOREGIFT_FEE_INFO {
        private String foregiftFeeId;                         //押金科目编码，以省分为准
        private String foregiftFeeName;                       //押金名称
        private String foregiftFeeValue;                      //押金值
        private String canCancelTime;                         //押可退时间yyyyMMdd
    }

    //邮寄信息，最多三个
    @Data
    static public class POST {
        private String idType;                                //标识类型：0-客户,1-用户,2-帐户
        private String postName;                              //邮寄名称
        private String postTag;                               //邮寄标志：0-不邮寄,1-邮寄
        private String postContent;                           //邮寄内容：0-账单,1-清单,2-发票,3-广告,该字段以拼串形式来填写，如03，表示邮寄账单和广告。
        private String postTypeset;                           //邮寄方式：0-邮政、1-传真、2-Email,
        private String postCyc;                               //邮寄周期：0-按月,1-按季,2-按年
        private String postAddress;                           //邮寄地址
        private String postCode;                              //邮寄邮编
        private String email;                                 //EMAIL地址
        private String faxNbr;                                //传真号码
    }

    //购机信息
    @Data
    static public class PURCHASE {
        private String bindsaleAttr;                          //销售方案编码
        private String extraDevFee;                           //补差款
        private String mpfee;                                 //实交购机款
        private String feeitemCode;                           //实交营业费用编码
        private String foregift;                              //实交押金
        private String foregiftCode;                          //实交押金类型编码
        private String foregiftBackmode;                      //0-协议到期,1-消费金额满,2-协议到期或消费金额满
        private String agreementMonths;                       //捆绑协议月份数
        private String endMode;                               //0-协议到期,1-消费金额满,2-协议到期或消费金额满
        private String deviceType;                            //手机型号ID
        private String mobileCost;                            //手机成本价
        private String deviceName;                            //手机型号名称
        private String deviceBrand;                           //手机品牌
        private String imei;                                  //IMEI
        private String agreement;                             //协议号
        private String productId;                             //活动产品ID
        private String packageId;                             //活动包ID
        private String startDate;                             //开始时间
        private String endDate;                               //结束时间
        private String itemId;                                //当存在属性时记录属性标识，否则为空
        private List<ATTR_INFO> attrInfo;                     //
    }

    //担保信息
    @Data
    static public class ASSURE {
        private String assureIdType;                          //担保类型
        private String assureId;                              //担保项目
        private String assureTypeCode;                        //记录是客户担保/押金担保/用户担保等等方式
        private String assureDate;                            //担保期限
        private String assureCustId;                          //针对单位担保
        private String assureNo;                              //担保号
        private String assurePsptTypeCode;                    //担保人证件类型
        private String assurePsptId;                          //担保人证件号码
        private String assureName;                            //担保人姓名
        private String assureForegift;                        //担保押金
        private String assureForegiftCode;                    //担保押金类型
        private String assureSerialNumber;                    //担保手机号码
        private String assureUserId;                          //担保用户标识
        private String assureBankCode;                        //担保银行编码
        private String assureBankAcctNo;                      //存单或抵压编号
        private String assureBankAcctName;                    //存单或抵压户名
        private String assureBankMoney;                       //质押金额
        private String remark;                                //备注
    }

    //用户异动信息
    @Data
    static public class INFOCHANGE {
        private String productId;                             //PRODUCT_ID
        private String brandCode;                             //BRAND_CODE
        private String serialNumber;                          //SERIAL_NUMBER
        private String imsi;                                  //IMSI
        private String imsi2;                                 //IMSI2
        private String startDate;                             //START_DATE
        private String endDate;                               //END_DATE
        private String netTypeCode;                           //网别
        private String prepayTag;                             //预付费标识
    }

    //用户积分
    @Data
    static public class USER_SCORE {
        private String year;                                  //年份
        private String cycleId;                               //帐期
        private String scoreTypeCode;                         //积分类型编码：见参数表
        private String scoreValue;                            //积分值
        private String scoreSum;                              //积分累计值
        private String endDate;                               //积分失效时间
        private String rsrvStr1;                              //积分预警规则
        private String rsrvStr2;                              //积分使用规则
        private String rsrvStr3;                              //保留字段3
    }

    //客户积分
    @Data
    static public class CUST_SCORE {
        private String scoreTypeCode;                         //积分类型编码
        private String scoreValue;                            //积分值
        private String state;                                 //0：失效 1：生效
        private String stateDate;                             //状态变更时间
        private String year;                                  //年份
        private String cycleId;                               //帐期
    }

    //用户抽奖信息
    @Data
    static public class USER_RAFFLE {
        private String userId;                                //用户标识
        private String serialNumber;                          //用户号码
        private String scoreProjectId;                        //积分方案ID
        private String raffleNumber;                          //抽奖号码
        private String lotCycleId;                            //奖期
        private String lotGroupId;                            //组别
        private String lotKind;                               //0-普通奖 1-专项奖
        private String eparchyCode;                           //地州编码
        private String cityCode;                              //区县编码
        private String tradeId;                               //积分扣减流水号
        private String joinDate;                              //参与时间
        private String state;                                 //0－失效；1－生效
        private String rsrvStr1;                              //预留字段1
        private String rsrvStr2;                              //预留字段2
        private String rsrvStr3;                              //预留字段3
        private String rsrvStr4;                              //预留字段4
        private String rsrvStr5;                              //预留字段5
    }

    //账户优惠信息
    @Data
    static public class ACCT_DISCNT {
        private String acctId;                                //帐户标识
        private String discntCode;                            //优惠编码
        private String startDate;                             //开始时间
        private String endDate;                               //结束时间
        private String itemId;                                //属性标识
        private List<ATTR_INFO> attrInfo;                     //账户优惠属性信息
    }

    //智能网用户状态
    @Data
    static public class USER_PPS {
        private String userId;                                //用户标识
        private String startDate;                             //开始时间
        private String endDate;                               //结束时间
        private String stateCode;                             //智能网状态
        private String specialFlag;                           //是否黑名单
    }

    //用户兑奖信息
    @Data
    static public class USER_EXCHANGE {
        private String scoreProjectId;
        private String raffleNumber;
        private String raffleTime;
        private String exchangeState;
        private String exchangeTime;
        private String exchangeId;
        private String rsrvStr1;
        private String rsrvStr2;
        private String rsrvStr3;
        private String rsrvStr4;
        private String rsrvStr5;
        private String prizeLevel;
        private String lotCycleId;
        private String lotGroupId;
        private String cityCode;
        private String eparchyCode;
        private String actionCode;                            //物品编码
        private String userId;                                //
        private String tradeStaffId;                          //操作员工
        private String tradeDepartId;                         //操作部门
    }

    //关联号码信息
    @Data
    static public class RELATION_NUM_INFO {
        private String serialNumber;                          //用户号码
        private String relationTypeName;                      //关系名称
        private String commShareMessage;                      //关联号码描述
    }

    //集团代付规则
    @Data
    static public class GROUP_PAYRULE_INFO {
        private String acctId;                                //集团账户
        private String transRuleId;                           //转兑规则编码
        private String startDate;                             //开始帐期
        private String endDate;                               //结束帐期
        private String rsrvInfo1;                             //保留信息1
        private String rsrvInfo2;                             //保留信息2
        private String rsrvFee2;                              //保留信息3
        private String rsrvFee1;                              //保留信息4
        private String updateTime;                            //更新时间
        private String updateDepartId;                        //更新部门
        private String updateCityCode;                        //更新业务区
        private String updateEparchyCode;                     //更新地州
        private String updateStaffId;                         //更新员工
        private String payMoney;                              //付费金额
        private String userId;                                //用户标识
        private String limitMode;                             //付费方式，比例还是固定值
        private String transRule;                             //规则名称
    }

    //帐号资料
    @Data
    static public class MORE_ACCT_INFO {
        private String acctId;                                //账户标识
        private String custId;                                //客户标识
        private String debutyUserId;                          //代表用户标识
        private String debutyCode;                            //代表号码
        private String payName;                               //帐户名称
        private String payModeCode;                           //付费方式编码，数据模型编码CUI_000084
        private String payMode;                               //付费方式名称
        private String prepayTag;                             //预付费标识：0 后付费 1 准预付费 2 OCS 3 PPS
        private String acctPasswd;                            //账户密码
        private String accountCycle;                          //帐务周期
        private String payitemCode;                           //付费科目
        private String acctPriority;                          //账户优先级
        private String userPriority;                          //用户优先级
        private String bindType;                              //绑定类型
        private String startAcycId;                           //开始帐期
        private String endAcycId;                             //结束帐期
        private String defaultTag;                            //是否默认
        private String actTag;                                //帐号标志
        private String limitType;                             //限制类型
        private String limit;                                 //限额
        private String scoreValue;                            //帐户积分
        private String contractNo;                            //帐户合同号
        private String openDate;                              //开户时间。格式：YYYYMMDDHH24MISS
        private List<ATTR_INFO> attrInfo;                     //账户属性信息
        private List<CONSIGN> consign;                        //托收信息

        //托收信息
        @Data
        static public class CONSIGN {
            private String consignMode;                       //托收方式，统一数据模型编码PRD_000048
            private String superBankCode;                     //上级银行编码，省分去ESS配置
            private String bankCode;                          //开户银行编码，省分去ESS配置
            private String bank;                              //银行名称
            private String bankAcctNo;                        //银行付费账号
            private String agreementNo;                       //托收协议号
            private String acctBalanceId;                     //账本标识
            private String bankAcctName;                      //托收名称
            private String bankBusiKind;                      //CONSIGN
        }
    }

    @Data
    static public class ELEMENT_INFO {
        private String productId;                             //产品标识
        private String packageId;                             //包标识
        private String idType;                                //标识类型：0：服务1：资费
        private String id;                                    //标识
        private String startDate;                             //开始时间
        private String endDate;                               //终止时间
        private String itemId;                                //当存在属性时记录属性标识，否则为空
        private String userIdA;                               //A用户标识
        private List<ATTR_INFO> attrInfo;                     //属性信息
    }

    //保留字段
    @Data
    static public class PARA {
        private String paraId;                                //保留字段ID
        private String paraValue;                             //保留字段值
    }
}
