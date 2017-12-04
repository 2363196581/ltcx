package com.connxun.util.aliyun.pay.entiy;

import com.alipay.api.internal.mapping.ApiField;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付宝会根据原始支付API中传入的异步通知地址notify_url，通过POST请求的形式将支付结果作为参数通知到商户系统。
 */
public class PayNotifyUrl {
    //    通知的发送时间。格式为yyyy-MM-dd HH:mm:ss
    @ApiField("notify_time")
    private Date notifyTime;
    //    通知的类型	trade_status_sync
    @ApiField("notify_type")
    private String notifyType;
    //    通知校验ID
    @ApiField("notify_id")
    private String notifyId;

    @ApiField("app_id")
    private String appId;

    private String charset;
    private String version;
    //    RSA2
    @ApiField("sign_type")
    private String signType;

    private String sign;

    @ApiField("out_trade_no")
    private String outTradeNo;
    //    支付宝交易凭证号
    @ApiField("trade_no")
    private String tradeNo;
    //    商户业务号
    @ApiField("out_biz_no")
    private String outBizNo;
    //    买家支付宝用户号
    @ApiField("buyer_id")
    private String buyerId;
    //    买家支付宝账号
    @ApiField("buyer_logon_id")
    private String buyerLogonId;
    @ApiField("seller_id")
    private String sellerId;
    //    卖家支付宝账号
    @ApiField("seller_email")
    private String sellerEmail;
    //    交易目前所处的状态，见交易状态说明	TRADE_CLOSED
    @ApiField("trade_status")
    private String tradeStatus;


    //    订单金额
    @ApiField("total_amount")
    private BigDecimal totalAmout;
    //    实收金额
    @ApiField("receipt_amount")
    private BigDecimal receiptAmout;

    //    用户在交易中支付的可开发票的金额	10.00
    @ApiField("invoice_amount")
    private BigDecimal invoiceAmout;

    //    用户在交易中支付的金额	13.88
    @ApiField("buyer_pay_amount")
    private BigDecimal buyerPayAmout;

    //    使用集分宝支付的金额	12.00
    @ApiField("point_amount")
    private BigDecimal pointAmout;

    //    退款通知中，返回总退款金额，单位为元，支持两位小数	2.58
    @ApiField("refund_fee")
    private BigDecimal refundFee;

    //    商品的标题/交易标题/订单标题/订单关键字等，是请求时对应的参数，原样通知回来
    private String subject;
    //    商品描述
    private String body;
    //    该笔交易创建的时间。格式为yyyy-MM-dd HH:mm:ss	2015-04-27 15:45:57
    @ApiField("gmt_create")
    private Date gmtCreate;
    //    该笔交易的买家付款时间。格式为yyyy-MM-dd HH:mm:ss	2015-04-27 15:45:57
    @ApiField("gmt_payment")
    private Date gmtPayment;
    //    该笔交易的退款时间。格式为yyyy-MM-dd HH:mm:ss.S	2015-04-28 15:45:57.320
    @ApiField("gmt_refund")
    private Date gmtRefund;
    //    该笔交易结束时间。格式为yyyy-MM-dd HH:mm:ss	2015-04-29 15:45:57
    @ApiField("gmt_close")
    private Date gmtClose;

    //    支付成功的各个渠道金额信息，详见资金明细信息说明	[{"amount":"15.00","fundChannel":"ALIPAYACCOUNT"}]
    private String fund_bill_list;
    //    公共回传参数，如果请求时传递了该参数，则返回给商户时会在异步通知时将该参数原样返回。本参数必须进行UrlEncode之后才可以发送给支付宝	merchantBizType%3d3C%26merchantBizNo%3d2016010101111
    private String passback_params;
    //    本交易支付时所使用的所有优惠券信息，详见优惠券信息说明	[{"amount":"0.20","merchantContribute":"0.00","name":"一键创建券模板的券名称","otherContribute":"0.20","type":"ALIPAY_DISCOUNT_VOUCHER","memo":"学生卡8折优惠"]
    private String voucher_detail_list;

    public Date getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(Date notifyTime) {
        this.notifyTime = notifyTime;
    }

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

    public String getNotifyId() {
        return notifyId;
    }

    public void setNotifyId(String notifyId) {
        this.notifyId = notifyId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOutBizNo() {
        return outBizNo;
    }

    public void setOutBizNo(String outBizNo) {
        this.outBizNo = outBizNo;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerLogonId() {
        return buyerLogonId;
    }

    public void setBuyerLogonId(String buyerLogonId) {
        this.buyerLogonId = buyerLogonId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public BigDecimal getTotalAmout() {
        return totalAmout;
    }

    public void setTotalAmout(BigDecimal totalAmout) {
        this.totalAmout = totalAmout;
    }

    public BigDecimal getReceiptAmout() {
        return receiptAmout;
    }

    public void setReceiptAmout(BigDecimal receiptAmout) {
        this.receiptAmout = receiptAmout;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public BigDecimal getInvoiceAmout() {
        return invoiceAmout;
    }

    public void setInvoiceAmout(BigDecimal invoiceAmout) {
        this.invoiceAmout = invoiceAmout;
    }

    public BigDecimal getBuyerPayAmout() {
        return buyerPayAmout;
    }

    public void setBuyerPayAmout(BigDecimal buyerPayAmout) {
        this.buyerPayAmout = buyerPayAmout;
    }

    public BigDecimal getPointAmout() {
        return pointAmout;
    }

    public void setPointAmout(BigDecimal pointAmout) {
        this.pointAmout = pointAmout;
    }

    public BigDecimal getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(BigDecimal refundFee) {
        this.refundFee = refundFee;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtPayment() {
        return gmtPayment;
    }

    public void setGmtPayment(Date gmtPayment) {
        this.gmtPayment = gmtPayment;
    }

    public Date getGmtRefund() {
        return gmtRefund;
    }

    public void setGmtRefund(Date gmtRefund) {
        this.gmtRefund = gmtRefund;
    }

    public Date getGmtClose() {
        return gmtClose;
    }

    public void setGmtClose(Date gmtClose) {
        this.gmtClose = gmtClose;
    }

    public String getFund_bill_list() {
        return fund_bill_list;
    }

    public void setFund_bill_list(String fund_bill_list) {
        this.fund_bill_list = fund_bill_list;
    }

    public String getPassback_params() {
        return passback_params;
    }

    public void setPassback_params(String passback_params) {
        this.passback_params = passback_params;
    }

    public String getVoucher_detail_list() {
        return voucher_detail_list;
    }

    public void setVoucher_detail_list(String voucher_detail_list) {
        this.voucher_detail_list = voucher_detail_list;
    }
}
