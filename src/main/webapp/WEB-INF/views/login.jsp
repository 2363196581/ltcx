<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>家政频道后台管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <%@ include file="common/header.jsp" %>
    <script src="${staticServer }/assets/js/userBrower.js"></script>
    <script src="${staticServer }/assets/js/jCookie.js"></script>
</head>

<body class="login-layout">
<div class="main-container login-main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-10 col-sm-offset-1">
                <div class="login-container">
                    <div class="space-6"></div>

                    <div class="position-relative" style="width :400px">
                        <div id="login-box" class="login-box visible widget-box no-border">
                            <div class="widget-body">
                                <div class="widget-main">
                                    <h4 class="header blue lighter bigger" style="text-align: center">
                                        <i class="ace-icon fa fa-globe green"></i> <b>家政频道后台管理系统</b>
                                    </h4>
                                    <div class="space-6"></div>
                                    <form id="loginForm" action="portal/checkLogin" method="post">
                                        <fieldset>
                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <input type="text" class="form-control" name="username"
                                                           id="username" placeholder="用户名"/>
                                                    <i class="ace-icon fa fa-user"></i>
												</span>
                                            </label>
                                            </label> <label class="block clearfix">
                                            <span class="block input-icon input-icon-right">
                                                <input type="password" class="form-control" name="password"
                                                       id="password" placeholder="密码"/>
                                                <i class="ace-icon fa fa-lock"></i>
												</span>
                                        </label>
                                            <label class="block clearfix">
                                                <span class="block input-icon input-icon-right">
                                                    <span id="lblMessage" class="errMsg" style="display: none">
                                                        账号或密码输入错误！
                                                    </span>
												</span>
                                            </label>
                                            <div class="space"></div>
                                            <div class="clearfix">
                                                <button type="button" onclick="register()"
                                                        class="width-35 pull-left btn btn-sm btn-success">
                                                    <i class="ace-icon fa fa-key"></i> <span
                                                        class="bigger-110">注册</span>
                                                </button>
                                                <button type="submit"
                                                        class="width-35 pull-right btn btn-sm btn-primary">
                                                    <i class="ace-icon fa fa-key"></i> <span
                                                        class="bigger-110">登录</span>
                                                </button>
                                            </div>
                                            <div class="space-4"></div>
                                            <br/>
                                            <label class=" clearfix" id="divVerifyCode">
                                                <span class="block input-icon ">
														 <span class="inline input-icon input-icon-right">版权所有 © 2017 <a
                                                                 href="#">中软动力</a>
														</span>
                                                    <%--DDDDD--%>
                                                </span>
                                            </label>
                                        </fieldset>
                                    </form>
                                </div>
                                <!-- /.widget-main -->
                            </div>
                            <!-- /.widget-body -->
                        </div>
                        <!-- /.login-box -->
                    </div>
                    <!-- /.position-relative -->
                </div>
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /.main-content -->
</div>
<!-- /.main-container -->


<%@ include file="common/js.jsp" %>

<!-- inline scripts related to this page -->
<script type="text/javascript">

    var isNeedVerifyCode = false;
    jQuery(function ($) {
        $("#divVerifyCode").hide();
        $("#loginForm").validate({

            errorElement: "label",
            errorClass: "valiError",
            errorPlacement: function (error, element) {
            },
            rules: {
                username: {
                    required: true
                },
                password: {
                    required: true
                }
            },
            messages: {
                username: {
                    required: ""
                },
                password: {
                    required: ""
                }
            },
            submitHandler: function (form) {

                checkLogin();
            }
        });

        var cookie_chk = jQuery.jCookie('bls_chk');
        if (cookie_chk != '' && cookie_chk != null && cookie_chk == '1') {
            $('#chk').prop("checked", true);
            $('#username').val(jQuery.jCookie('bls_username'));
        }
    });

    function checkLogin() {
        console.log("----------------------------------------------------");
        if ($('#chk').is(':checked')) {
            jQuery.jCookie('bls_chk', '1', 30);
            jQuery.jCookie('bls_username', $('#username').val(), 30);
        } else {
            jQuery.jCookie('bls_chk', '0', 30);
        }

        var username = $("#username").val();
        var password = $("#password").val();
        var verifyCode = $("#verifyCode").val();
        $.ajax({
            type: "post",
            url: "${dynamicServer}/portal/checkLogin",
            data: {
                username: username,
                password: password,
                verifyCode: verifyCode,
                terminal: getUserTerminalType(),
                explorerType: getExplorerInfo().browser,
                explorerVersion: getExplorerInfo().version
            },
            dataType: "json",
            success: function (data) {
                if (data.success) {
                    $("#lblMessage").hide();
                    window.location.href = "${dynamicServer}/portal/index";
                } else {
                    $("#lblMessage").html(data.msgText);
                    $("#lblMessage").show();
                    if (data.isNeedVerifyCode) {
                        $("#divVerifyCode").show();
                        changeCode();
                        isNeedVerifyCode = true;
                    }
                }
            },
            error: function (data) {
                $("#lblMessage").html('登录失败');
                $("#lblMessage").show();
            }
        });
    }


</script>
</body>
</html>