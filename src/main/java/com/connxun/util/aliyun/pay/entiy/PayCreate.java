package com.connxun.util.aliyun.pay.entiy;
//alipay.trade.create(统一收单交易创建接口)
public class PayCreate {

    /**
     * alipay_trade_create_response : {"code":"10000","msg":"Success","out_trade_no":"20150423001001","trade_no":"2015042321001004720200028594"}
     * sign : ERITJKEIJKJHKKKKKKKHJEREEEEEEEEEEE
     */

    private AlipayTradeCreateResponseEntity alipay_trade_create_response;
    private String sign;

    public void setAlipay_trade_create_response(AlipayTradeCreateResponseEntity alipay_trade_create_response) {
        this.alipay_trade_create_response = alipay_trade_create_response;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public AlipayTradeCreateResponseEntity getAlipay_trade_create_response() {
        return alipay_trade_create_response;
    }

    public String getSign() {
        return sign;
    }

    public static class AlipayTradeCreateResponseEntity {
        /**
         * code : 10000
         * msg : Success
         * out_trade_no : 20150423001001
         * trade_no : 2015042321001004720200028594
         */

        private String code;
        private String msg;
        private String out_trade_no;
        private String trade_no;

        public void setCode(String code) {
            this.code = code;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
        }

        public void setTrade_no(String trade_no) {
            this.trade_no = trade_no;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public String getTrade_no() {
            return trade_no;
        }
    }
}
