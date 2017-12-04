package com.connxun.util.aliyun.pay.entiy;

import java.util.Date;
import java.util.List;

//alipay.trade.precreate(统一收单线下交易预创建)
public class PayPrecreate {


    /**
     * alipay_trade_pay_response : {"code":"10000","msg":"Success","trade_no":"2013112011001004330000121536","out_trade_no":"6823789339978248","buyer_logon_id":"159****5620","total_amount":120.88,"receipt_amount":"88.88","buyer_pay_amount":8.88,"point_amount":8.12,"invoice_amount":12.5,"gmt_payment":"2014-11-27 15:45:57","fund_bill_list":[{"fund_channel":"ALIPAYACCOUNT","amount":10,"real_amount":11.21}],"card_balance":98.23,"store_name":"证大五道口店","buyer_user_id":"2088101117955611","discount_goods_detail":"[{\"goods_id\":\"STANDARD1026181538\",\"goods_name\":\"雪碧\",\"discount_amount\":\"100.00\",\"voucher_id\":\"2015102600073002039000002D5O\"}]","voucher_detail_list":[{"id":"2015102600073002039000002D5O","name":"XX超市5折优惠","type":"ALIPAY_FIX_VOUCHER","amount":10,"merchant_contribute":9,"other_contribute":1,"memo":"学生专用优惠","purchase_buyer_contribute":2.01,"purchase_merchant_contribute":1.03,"purchase_ant_contribute":0.82}]}
     * sign : ERITJKEIJKJHKKKKKKKHJEREEEEEEEEEEE
     */

    private AlipayTradePayResponseEntity alipay_trade_pay_response;
    private String sign;

    public void setAlipay_trade_pay_response(AlipayTradePayResponseEntity alipay_trade_pay_response) {
        this.alipay_trade_pay_response = alipay_trade_pay_response;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public AlipayTradePayResponseEntity getAlipay_trade_pay_response() {
        return alipay_trade_pay_response;
    }

    public String getSign() {
        return sign;
    }

    public static class AlipayTradePayResponseEntity {
        /**
         * code : 10000
         * msg : Success
         * trade_no : 2013112011001004330000121536
         * out_trade_no : 6823789339978248
         * buyer_logon_id : 159****5620
         * total_amount : 120.88
         * receipt_amount : 88.88
         * buyer_pay_amount : 8.88
         * point_amount : 8.12
         * invoice_amount : 12.5
         * gmt_payment : 2014-11-27 15:45:57
         * fund_bill_list : [{"fund_channel":"ALIPAYACCOUNT","amount":10,"real_amount":11.21}]
         * card_balance : 98.23
         * store_name : 证大五道口店
         * buyer_user_id : 2088101117955611
         * discount_goods_detail : [{"goods_id":"STANDARD1026181538","goods_name":"雪碧","discount_amount":"100.00","voucher_id":"2015102600073002039000002D5O"}]
         * voucher_detail_list : [{"id":"2015102600073002039000002D5O","name":"XX超市5折优惠","type":"ALIPAY_FIX_VOUCHER","amount":10,"merchant_contribute":9,"other_contribute":1,"memo":"学生专用优惠","purchase_buyer_contribute":2.01,"purchase_merchant_contribute":1.03,"purchase_ant_contribute":0.82}]
         */
// 10000	接口调用成功，调用结果请参考具体的API文档所对应的业务返回参数
        private String code;
        private String msg;
        //        支付宝交易号
        private String trade_no;
        //        商户订单号
        private String out_trade_no;
        //        买家支付宝账号
        private String buyer_logon_id;
        //        	交易金额
        private double total_amount;
        //        实收金额
        private String receipt_amount;
        //        买家付款的金额
        private double buyer_pay_amount;
        //        使用积分宝付款的金额
        private double point_amount;
        //        交易中可给用户开具发票的金额
        private double invoice_amount;
        //        交易支付时间
        private Date gmt_payment;
        //        支付宝卡余额
        private double card_balance;
        //        发生支付交易的商户门店名称
        private String store_name;
        //        买家在支付宝的用户id
        private String buyer_user_id;
        //        本次交易支付所使用的单品券优惠的商品优惠信息
        private String discount_goods_detail;
        //        交易支付使用的资金渠道
        private List<FundBillListEntity> fund_bill_list;
        /*本交易支付时使用的所有优惠券信息*/
        private List<VoucherDetailListEntity> voucher_detail_list;

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

        public void setTotal_amount(double total_amount) {
            this.total_amount = total_amount;
        }

        public void setReceipt_amount(String receipt_amount) {
            this.receipt_amount = receipt_amount;
        }

        public void setBuyer_pay_amount(double buyer_pay_amount) {
            this.buyer_pay_amount = buyer_pay_amount;
        }

        public void setPoint_amount(double point_amount) {
            this.point_amount = point_amount;
        }

        public void setInvoice_amount(double invoice_amount) {
            this.invoice_amount = invoice_amount;
        }

        public void setGmt_payment(Date gmt_payment) {
            this.gmt_payment = gmt_payment;
        }

        public void setCard_balance(double card_balance) {
            this.card_balance = card_balance;
        }

        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }

        public void setBuyer_user_id(String buyer_user_id) {
            this.buyer_user_id = buyer_user_id;
        }

        public void setDiscount_goods_detail(String discount_goods_detail) {
            this.discount_goods_detail = discount_goods_detail;
        }

        public void setFund_bill_list(List<FundBillListEntity> fund_bill_list) {
            this.fund_bill_list = fund_bill_list;
        }

        public void setVoucher_detail_list(List<VoucherDetailListEntity> voucher_detail_list) {
            this.voucher_detail_list = voucher_detail_list;
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

        public double getInvoice_amount() {
            return invoice_amount;
        }

        public Date getGmt_payment() {
            return gmt_payment;
        }

        public double getCard_balance() {
            return card_balance;
        }

        public String getStore_name() {
            return store_name;
        }

        public String getBuyer_user_id() {
            return buyer_user_id;
        }

        public String getDiscount_goods_detail() {
            return discount_goods_detail;
        }

        public List<FundBillListEntity> getFund_bill_list() {
            return fund_bill_list;
        }

        public List<VoucherDetailListEntity> getVoucher_detail_list() {
            return voucher_detail_list;
        }

        public static class FundBillListEntity {
            /**
             * fund_channel : ALIPAYACCOUNT
             * amount : 10
             * real_amount : 11.21
             */

            private String fund_channel;
            private int amount;
            private double real_amount;

            public void setFund_channel(String fund_channel) {
                this.fund_channel = fund_channel;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public void setReal_amount(double real_amount) {
                this.real_amount = real_amount;
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
        }

        public static class VoucherDetailListEntity {
            /**
             * id : 2015102600073002039000002D5O
             * name : XX超市5折优惠
             * type : ALIPAY_FIX_VOUCHER
             * amount : 10
             * merchant_contribute : 9
             * other_contribute : 1
             * memo : 学生专用优惠
             * purchase_buyer_contribute : 2.01
             * purchase_merchant_contribute : 1.03
             * purchase_ant_contribute : 0.82
             */

            private String id;
            private String name;
            private String type;
            private int amount;
            private int merchant_contribute;
            private int other_contribute;
            private String memo;
            private double purchase_buyer_contribute;
            private double purchase_merchant_contribute;
            private double purchase_ant_contribute;

            public void setId(String id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setType(String type) {
                this.type = type;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public void setMerchant_contribute(int merchant_contribute) {
                this.merchant_contribute = merchant_contribute;
            }

            public void setOther_contribute(int other_contribute) {
                this.other_contribute = other_contribute;
            }

            public void setMemo(String memo) {
                this.memo = memo;
            }

            public void setPurchase_buyer_contribute(double purchase_buyer_contribute) {
                this.purchase_buyer_contribute = purchase_buyer_contribute;
            }

            public void setPurchase_merchant_contribute(double purchase_merchant_contribute) {
                this.purchase_merchant_contribute = purchase_merchant_contribute;
            }

            public void setPurchase_ant_contribute(double purchase_ant_contribute) {
                this.purchase_ant_contribute = purchase_ant_contribute;
            }

            public String getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public String getType() {
                return type;
            }

            public int getAmount() {
                return amount;
            }

            public int getMerchant_contribute() {
                return merchant_contribute;
            }

            public int getOther_contribute() {
                return other_contribute;
            }

            public String getMemo() {
                return memo;
            }

            public double getPurchase_buyer_contribute() {
                return purchase_buyer_contribute;
            }

            public double getPurchase_merchant_contribute() {
                return purchase_merchant_contribute;
            }

            public double getPurchase_ant_contribute() {
                return purchase_ant_contribute;
            }
        }
    }
}
