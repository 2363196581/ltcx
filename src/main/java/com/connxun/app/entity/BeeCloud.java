package com.connxun.app.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Mac on 2017/6/24.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BeeCloud {


    public static final String APP_ID = "c82dd108-dd93-4575-811f-c472a4369831";
    public static final String APP_SECRET = "e22cb183-3206-4457-a009-bcb8f2d82106";
    public static final String APP_MASTER_SECRET = "6dde8fd0-3581-43a8-909d-d94a38066f98";

    /**
     * app_id + transaction_id + transaction_type + channel_type + transaction_fee + master_secret
     */
    private String signature;
    //    服务端的时间（毫秒）
    private String timestamp;
    //    WX/ALI/UN/KUAIQIAN/JD/BD/YEE/PAYPAL 分别代表微信/支付宝/银联/快钱/京东/百度/易宝/PAYPAL
    private String channel_type;
    private String channelType;
    //    交易是否成功，目前收到的消息都是交易成功的消息
    private String trade_success;
    //    PAY/REFUND 分别代表支付和退款的结果确认
    private String transaction_type;
    //    代表以上各个渠道的子渠道，参看字段说明
    private String sub_channel_type;
    //    交易单号，对应支付请求的bill_no或者退款请求的refund_no,对于秒支付button为传入的out_trade_no
    private String transaction_id;
    //    交易金额，是以分为单位的整数，对应支付请求的total_fee或者退款请求的refund_fee
    private String transaction_fee;
    private String sign;
    //    附加参数，为一个JSON格式的Map，客户在发起购买或者退款操作时添加的附加信息
    private Object optional;
    //    {orderId:xxx…..} 从支付渠道方获得的详细结果信息，例如支付的订单号，金额， 商品信息等，详见附录
    private Object message_detail;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getChannel_type() {
        return channel_type;
    }

    public void setChannel_type(String channel_type) {
        this.channel_type = channel_type;
    }

    public String getTrade_success() {
        return trade_success;
    }

    public void setTrade_success(String trade_success) {
        this.trade_success = trade_success;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getSub_channel_type() {
        return sub_channel_type;
    }

    public void setSub_channel_type(String sub_channel_type) {
        this.sub_channel_type = sub_channel_type;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTransaction_fee() {
        return transaction_fee;
    }

    public void setTransaction_fee(String transaction_fee) {
        this.transaction_fee = transaction_fee;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Object getOptional() {
        return optional;
    }

    public void setOptional(Object optional) {
        this.optional = optional;
    }

    public Object getMessage_detail() {
        return message_detail;
    }

    public void setMessage_detail(Object message_detail) {
        this.message_detail = message_detail;
    }

    @Override
    public String toString() {
        return "BeeCloud{" +
                "signature='" + signature + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", channel_type='" + channel_type + '\'' +
                ", trade_success='" + trade_success + '\'' +
                ", transaction_type='" + transaction_type + '\'' +
                ", sub_channel_type='" + sub_channel_type + '\'' +
                ", transaction_id='" + transaction_id + '\'' +
                ", transaction_fee='" + transaction_fee + '\'' +
                ", sign='" + sign + '\'' +
                ", optional=" + optional +
                '}';
    }
}