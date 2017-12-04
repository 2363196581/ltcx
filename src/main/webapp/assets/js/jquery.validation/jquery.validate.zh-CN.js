$.validator.addMethod("idcard", function (value, element, params) {
    return !!(value.length == 18 || value.length == 15);

}, "请输入正确的身份证号");

$.validator.addMethod("phone", function (value, element) {
    var length = value.length;
    var regPhone = /^1(3[0-9]|4[57]|5[0-35-9]|7[01678]|8[0-9])\d{8}$/;
    return this.optional(element) || ( length == 11 && regPhone.test(value) );
}, "请输入正确的手机号码");

$.validator.addMethod("phoneOrTel", function (value, element) {
    var length = value.length;
    var regPhone = /^1([3578]\d|4[57])\d{8}$/;
    var regTel = /^(\d{3,4}-?)?\d{7,9}$/g;
    if (length == 11) {
        if (value.indexOf("-") < 0) {
            return this.optional(element) || regPhone.test(value);
        } else {
            return this.optional(element) || regTel.test(value);
        }
    }
    if (length == 12) {
        if (value.indexOf("-") < 0) {
            return false;
        } else {
            return this.optional(element) || regTel.test(value);
        }
    }
    return false;
}, "请输入正确的手机号码或电话");

$.extend($.validator.messages, {
    required: "不可为空",
    email: "请输入正确格式的电子邮件",
    url: "请输入合法的网址",
    date: "请输入合法的日期",
    dateISO: "请输入合法的日期 (ISO).",
    number: "请输入合法的数字",
    digits: "请输入整数",
    creditcard: "请输入合法的信用卡号",
    equalTo: "请再次输入",
    accept: "请输入拥有合法后缀名的字符串",
    maxlength: $.validator.format("长度最大为 {0} "),
    minlength: $.validator.format("长度最小为 {0} "),
    rangelength: $.validator.format("请输入一个长度介于 {0} 和 {1} 之间的字符串"),
    range: $.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
    max: $.validator.format("最大值为 {0}"),
    min: $.validator.format("最小值为 {0}"),
    idcard: "请输入正确的身份证号",
    phone: "请输入正确的手机号"
});