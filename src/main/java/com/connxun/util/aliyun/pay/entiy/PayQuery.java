package com.connxun.util.aliyun.pay.entiy;

import java.util.Date;
import java.util.List;

/*alipay.trade.query(统一收单线下交易查询)*/
public class PayQuery {


    /**
     * alipay_trade_query_response : {"code":"10000","msg":"Success","trade_no":"2013112011001004330000121536","out_trade_no":"6823789339978248","buyer_logon_id":"159****5620","trade_status":"TRADE_CLOSED","total_amount":88.88,"receipt_amount":"15.25","buyer_pay_amount":8.88,"point_amount":10,"invoice_amount":12.11,"send_pay_date":"2014-11-27 15:45:57","store_id":"NJ_S_001","terminal_id":"NJ_T_001","fund_bill_list":[{"fund_channel":"ALIPAYACCOUNT","amount":10,"real_amount":11.21,"fund_type":"DEBIT_CARD"}],"store_name":"证大五道口店","buyer_user_id":"2088101117955611"}
     * sign : ERITJKEIJKJHKKKKKKKHJEREEEEEEEEEEE
     */

    private AlipayTradeQueryResponseEntity alipay_trade_query_response;
    private String sign;

    public void setAlipay_trade_query_response(AlipayTradeQueryResponseEntity alipay_trade_query_response) {
        this.alipay_trade_query_response = alipay_trade_query_response;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public AlipayTradeQueryResponseEntity getAlipay_trade_query_response() {
        return alipay_trade_query_response;
    }

    public String getSign() {
        return sign;
    }

    public static class AlipayTradeQueryResponseEntity {
        /**
         * code : 10000
         * msg : Success
         * trade_no : 2013112011001004330000121536
         * out_trade_no : 6823789339978248
         * buyer_logon_id : 159****5620
         * trade_status : TRADE_CLOSED
         * total_amount : 88.88
         * receipt_amount : 15.25
         * buyer_pay_amount : 8.88
         * point_amount : 10
         * invoice_amount : 12.11
         * send_pay_date : 2014-11-27 15:45:57
         * store_id : NJ_S_001
         * terminal_id : NJ_T_001
         * fund_bill_list : [{"fund_channel":"ALIPAYACCOUNT","amount":10,"real_amount":11.21,"fund_type":"DEBIT_CARD"}]
         * store_name : 证大五道口店
         * buyer_user_id : 2088101117955611
         */

        private String code;
        private String msg;
        private String trade_no;
        private String out_trade_no;
        private String buyer_logon_id;
        private String trade_status;
        private double total_amount;
        private String receipt_amount;
        private double buyer_pay_amount;
        private double point_amount;
        private double invoice_amount;
        private Date send_pay_date;
        private String store_id;
        private String terminal_id;
        private String store_name;
        private String buyer_user_id;
        private List<FundBillListEntity> fund_bill_list;

        public void setCode(String code) {
            this.code = code;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public void setTrade_no(String trade_no) {
            this.trade_no = trade_no;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
        }

        public void setBuyer_logon_id(String buyer_logon_id) {
            this.buyer_logon_id = buyer_logon_id;
        }

        public void setTrade_status(String trade_status) {
            this.trade_status = trade_status;
        }

        public void setTotal_amount(double total_amount) {
            this.total_amount = total_amount;
        }

        public void setReceipt_amount(String receipt_amount) {
            this.receipt_amount = receipt_amount;
        }

        public void setBuyer_pay_amount(double buyer_pay_amount) {
            this.buyer_pay_amount = buyer_pay_amount;
        }

        public void setPoint_amount(int point_amount) {
            this.point_amount = point_amount;
        }

        public void setInvoice_amount(double invoice_amount) {
            this.invoice_amount = invoice_amount;
        }



        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }

        public void setTerminal_id(String terminal_id) {
            this.terminal_id = terminal_id;
        }

        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }

        public void setBuyer_user_id(String buyer_user_id) {
            this.buyer_user_id = buyer_user_id;
        }

        public void setFund_bill_list(List<FundBillListEntity> fund_bill_list) {
            this.fund_bill_list = fund_bill_list;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }

        public String getTrade_no() {
            return trade_no;
        }

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public String getBuyer_logon_id() {
            return buyer_logon_id;
        }

        public String getTrade_status() {
            return trade_status;
        }

        public double getTotal_amount() {
            return total_amount;
        }

        public String getReceipt_amount() {
            return receipt_amount;
        }

        public double getBuyer_pay_amount() {
            return buyer_pay_amount;
        }

        public double getPoint_amount() {
            return point_amount;
        }

        public void setPoint_amount(double point_amount) {
            this.point_amount = point_amount;
        }

        public double getInvoice_amount() {
            return invoice_amount;
        }

        public Date getSend_pay_date() {
            return send_pay_date;
        }

        public void setSend_pay_date(Date send_pay_date) {
            this.send_pay_date = send_pay_date;
        }

        public String getStore_id() {
            return store_id;
        }

        public String getTerminal_id() {
            return terminal_id;
        }

        public String getStore_name() {
            return store_name;
        }

        public String getBuyer_user_id() {
            return buyer_user_id;
        }

        public List<FundBillListEntity> getFund_bill_list() {
            return fund_bill_list;
        }

        public static class FundBillListEntity {
            /**
             * fund_channel : ALIPAYACCOUNT
             * amount : 10
             * real_amount : 11.21
             * fund_type : DEBIT_CARD
             */

            private String fund_channel;
            private int amount;
            private double real_amount;
            private String fund_type;

            public void setFund_channel(String fund_channel) {
                this.fund_channel = fund_channel;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public void setReal_amount(double real_amount) {
                this.real_amount = real_amount;
            }

            public void setFund_type(String fund_type) {
                this.fund_type = fund_type;
            }

            public String getFund_channel() {
                return fund_channel;
            }

            public int getAmount() {
                return amount;
            }

            public double getReal_amount() {
                return real_amount;
            }

            public String getFund_type() {
                return fund_type;
            }
        }
    }
}
