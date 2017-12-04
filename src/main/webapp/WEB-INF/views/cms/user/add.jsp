<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../../common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${webTitle}-学生添加</title>
    <%@ include file="../../common/header.jsp" %>
    <style>
        .control-label {
            padding-top: 4px !important;
        }
    </style>
</head>

<body class="no-skin">
<%@ include file="../../common/top.jsp" %>

<div class="main-container" id="main-container">
    <%@ include file="../../common/menu.jsp" %>
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs breadcrumbs-fixed" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">首页</a></li>
                    <li class="active">学生管理</li>
                    <li class="active">学生添加</li>
                </ul>
            </div>

            <div class="page-content">

                <!-- /.page-header -->
                <!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <form id="infoForm" name="infoForm" class="form-horizontal"
                              action="${dynamicServer}/cms/user/save.do" method="post">
                            <div class="form-group ">
                                <h3 class="row header smaller lighter blue">
                                    <span class="col-xs-12">  添加学生 </span><!-- /.col -->
                                </h3>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">手机号：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="phone" name="phone" maxlength="11"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value=""><label id="phoneTip"></label>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">姓名：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="nickName" name="nickName" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value=""><label id="nickNameTip"></label>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">积分：</label>
                                <div class="col-sm-9">
                                    <input type="number" id="integral" name="integral" maxlength="11"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="0"><label id="integralTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">密码：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="password" name="password" maxlength="20"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value=""><label id="passwordTip"></label>

                                </div>
                            </div>
                            <div class="clearfix form-actions">
                                <div class="col-md-offset-4 col-md-8">
                                    <button class="btn btn-primary" type="submit">
                                        <i class="ace-icon fa fa-save bigger-110"></i> 保存
                                    </button>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <button class="btn" type="button"
                                            onclick="backIndex()">
                                        <i class="ace-icon fa fa-undo bigger-110"></i> 取消
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /.main-content -->
            </div>
        </div>
    </div>
</div>
<%@ include file="../../common/js.jsp" %>
<script src="${staticServer}/assets/js/jquery.validation/jquery.validate.js"></script>
<script src="${staticServer}/assets/js/jquery.validation/jquery.validate.zh-CN.js"></script>
<script src="${staticServer}/assets/js/jquery.form.js"></script>
<script src="${staticServer}/assets/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="${staticServer}/assets/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
    $(function () {

        var date = dateFormatHour(new Date());


        $("#infoForm").validate({
            errorElement: "label",
            errorClass: "valiError",
            errorPlacement: function (error, element) {
                error.appendTo($("#" + element.attr('id') + "Tip"));
            },

            rules: {
                password: {
                    maxlength: 20,
                    required: true,
                    isPassword: true
                },
                phone: {
                    required: true,
                    maxlength: 15,
                    remote: {
                        url: "${dynamicServer}/cms/user/isPhone.do", //后台处理程序
                        type: "post", //数据发送方式
                        dataType: "json", //接受数据格式
                        data: { //要传递的数据
                            phone: function () {
                                return $("#phone").val();
                            }
                        }
                    }
                },
                integral: {
                    required: true,
                    maxlength: 5
                }
            },
            messages: {
                phone: {
                    remote: "手机号已存在！"
                }
            },
            submitHandler: function (form) {
                form.submit();
            }
        });
    });
    $.validator.addMethod("isPassword", function (value, element) {
        var checkName = /^[a-zA-Z0-9]{6,20}$/;
        return this.optional(element) || (checkName.test(value));
    }, "只允许6-20位数字或字母！");

    function backIndex() {
        window.location.href = "${dynamicServer}/cms/user/index.do";
    }

</script>
</body>
</html>
