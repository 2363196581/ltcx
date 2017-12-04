<%@ include file="../../common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>${webTitle}-用户修改</title>
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
                    <li class="active">学生修改</li>
                </ul>
            </div>

            <div class="page-content">

                <!-- /.page-header -->
                <!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <form id="infoForm" name="infoForm" class="form-horizontal"
                              action="${dynamicServer}/cms/user/update.do" method="post">
                            <div class="form-group ">
                                <h3 class="row header smaller lighter blue">
                                    <span class="col-xs-12">  修改学生信息 </span><!-- /.col -->
                                </h3>
                            </div>
                            <input type="hidden" id="id" name="id" value="${user.id}">
                            <input type="hidden" id="oldPhone" value="${user.phone}">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">手机号：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="phone" name="phone" maxlength="11"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="${user.phone}"><label id="phoneTip"></label>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">姓名：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="nickName" name="nickName" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="${user.nickName}"><label id="nickNameTip"></label>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">积分：</label>
                                <div class="col-sm-9">
                                    <input type="number" id="integral" name="integral" maxlength="11"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="${user.integral}"><label id="integralTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">密码：</label>
                                <div class="col-sm-9">
                                    <input type="hidden" id="password" name="password" value="${user.password}">
                                    <input type="text" id="newPwd" name="newPwd" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value=""><label id="newPwdTip"></label>

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
<script src="${staticServer}/js/jquery.validation/jquery.validate.js"></script>
<script src="${staticServer}/js/jquery.validation/jquery.validate.zh-CN.js"></script>
<script src="${staticServer}/js/jquery.form.js"></script>
<script src="${staticServer}/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="${staticServer}/My97DatePicker/WdatePicker.js"></script>

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
                newPwd: {

                    maxlength: 20,
                    required: false,
                    isPassword: true


                },
                phone: {
                    required: true,
                    maxlength: 11
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
        })
        ;
    });
    $.validator.addMethod("isPassword", function (value, element) {
        var checkName = /^[a-zA-Z0-9]{6,20}$/;
        return this.optional(element) || (checkName.test(value)) || $("password") == '';
    }, "只允许6-20位数字或字母！");

    function backIndex() {
        window.location.href = "${dynamicServer}/cms/user/index.do";
    }

</script>
</body>
</html>
