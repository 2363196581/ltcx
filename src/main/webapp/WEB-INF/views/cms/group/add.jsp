<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="../../common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${webTitle }-
      频道管理</title>
    <%@ include file="../../common/header.jsp" %>
    <link rel="stylesheet" href="${staticServer}/assets/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet"
          href="${staticServer}/assets/components/bootstrap-multiselect/dist/css/bootstrap-multiselect.css"/>
    <link rel="stylesheet" href="${staticServer}/assets/select2/select2.css"/>
    <style>
        .control-label {
            padding-top: 4px !important;
        }

        .select2-container--default {
            width: 58% !important;
        }

        .select2-search--inline {
            width: 100% !important;
        }

        .select2-search__field {
            width: 100% !important;
        }
    </style>
</head>

<body class="no-skin">
<%@ include file="../../common/top.jsp" %>

<div class="main-container" id="main-container">
    <%@ include file="../../common/menu.jsp" %>
    <div class="main-content">
        <div class="main-content-inner">

            <div class="page-content">
                <div class="page-header">
                    <h1>
                     频道
                    </h1>
                </div>
                <!-- /.page-header -->

                <div class="row">
                    <div class="col-xs-12">
                        <form id="infoForm" name="infoForm" class="form-horizontal"
                              action="${dynamicServer}/cms/teacher/save.do" method="post">
                            <div class="form-group ">
                                <h3 class="row header smaller lighter blue">
                                    <span class="col-xs-12"> 添加频道 </span><!-- /.col -->
                                </h3>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label ">老师头像</label>
                                <div class="col-sm-9 control-div">
                                    <ul id="imageUl" class="ace-thumbnails clearfix hidden"
                                        style=" display: inline-block;">
                                        <li>
                                            <a data-rel="colorbox">
                                                <img width="150" id="icon-img" alt="150x150" data-path="" src=""/>
                                                <div class="tools tools-top">
                                                    <a class="delPic"> <i class="ace-icon fa fa-times red">删除</i>
                                                    </a></div>
                                            </a>
                                        </li>
                                    </ul>
                                    <input type="hidden" id="icon_hidden" name="icon" value="">
                                    <a href="#icon-modal" class="btn btn-white btn-primary" data-toggle="modal"
                                       style="position: absolute;top: 2px;">
                                        <i class="ace-icon glyphicon glyphicon-picture bigger-110"></i> 选择图片
                                    </a>
                                    <span style="margin-left: 120px">    请上传正方形的图片</span>

                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">名称：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="nickName" name="nickName" maxlength="11"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">教师手机号：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="phone" name="phone" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value=""><label id="nameTip"></label>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">性别：</label>
                                <div class="col-sm-9">
                                    <select name="sex" id="sex"
                                            class="col-sm-12 col-lg-7" title="">
                                        <option value="0">男</option>
                                        <option value="1" selected>女</option>
                                    </select>


                                </div>
                            </div>


                            <div class="clearfix form-actions">
                                <div class="col-md-offset-4 col-md-8">
                                    <button class="btn btn-primary" type="submit">
                                        <i class="ace-icon fa fa-save bigger-110"></i> 保存
                                    </button>&nbsp;&nbsp;&nbsp;&nbsp;
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
<div id="icon-modal" class="modal fade" tabindex="-21">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header no-padding">
                <div class="table-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <span class="white">&times;</span>
                    </button>
                    上传封面图片
                </div>
            </div>
            <div class="modal-body no-padding">
                <div class="widget-box" style="border: none">
                    <div class="widget-body">
                        <div class="widget-main">
                            <c:url value="${uploadServer}/common/upload.do" var="upload_url"/>
                            <form:form action="${upload_url}"
                                       enctype="multipart/form-data" method="post" id="icon-form">
                                <input type="hidden" name="file_type" value="icon">
                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <input name="file" type="file" id="icon-input"
                                               accept="image/png,image/jpeg,image/gif,image/bmp"/>
                                    </div>
                                    <div class="col-xs-12" align="center">
                                        <button class="btn btn-white btn-primary" type="submit">
                                            <i class="ace-icon fa fa-cloud-upload bigger-110"></i> 上传
                                        </button>
                                        <button class="btn btn-white btn-primary" type="button" id="closeicon-modal"
                                                data-dismiss="modal">
                                            <i class="ace-icon fa fa-undo bigger-110"></i> 取消
                                        </button>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer no-margin-top"></div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<!-- /.main-container -->
<%@ include file="../../common/js.jsp" %>

<script src="${staticServer}/assets/js/jquery.validation/jquery.validate.js"></script>
<script src="${staticServer}/assets/js/jquery.validation/jquery.validate.zh-CN.js"></script>

<script src="${staticServer}/assets/js/jquery.form.js"></script>
<script type="text/javascript">
    $(function () {


        $("#infoForm").validate({
            errorElement: "label",
            errorClass: "valiError",
            errorPlacement: function (error, element) {
                error.appendTo($("#" + element.attr('id') + "Tip"));
            },
            rules: {
                nickName: {
                    required: true,
                    maxlength: 20
                },

            },
            submitHandler: function (form) {
                form.submit();
            }
        });

        //操作背景图片
        $('#icon-input').ace_file_input({
            style: 'well',
            btn_choose: '点击选择',
            btn_change: null,
            no_icon: 'ace-icon fa fa-picture-o',
            droppable: false,
            allowExt: ["jpeg", "jpg", "png", "gif", "bmp"],
            allowMime: ["image/jpg", "image/jpeg", "image/png", "image/gif", "image/bmp"],
            thumbnail: 'large',
            maxSize: 1024000,
            before_remove: function () {
                return true;
            }
        }).on('change', function () {
            var $icon_input = $('#icon-input');
            if ($icon_input.val() == '') {
                $icon_input.ace_file_input('reset_input');
            }
        }).on('file.error.ace', function (ev, info) {
            if (info.error_count['ext'] || info.error_count['mime'])
                $.notify({message: "请选择图片!", z_index: 1051});
            if (info.error_count['size'])
                $.notify({message: "图片大小不超过1M!!", z_index: 1051});
        });
        var $icon_form = $("#icon-form");
        $icon_form.on('submit', function () {
            var imgcheck = $("#icon-input").val();
            if (imgcheck === '') {
                return false;
            }
            $icon_form.ajaxSubmit({
                type: 'post', // 提交方式 get/post
                url: $icon_form.attr('action'),
                dataType: 'json',
                success: function (result) {
                    if (result && result.success) {
                        var img_path = result.createFilePath;
                        $("#closeicon-modal").click();
                        $("[name=icon]").val(img_path);
                        var img_url = '${imageServer}' + img_path;

                        var $icon_img = $("#icon-img");
                        if ($icon_img.attr("src") != '') {
                            $.ajax({
                                url: '${uploadServer}/common/delFile',
                                data: {
                                    path: $icon_img.attr("data-path")
                                },
                                type: 'post',
                                success: function (result) {
                                    if (result.success) {
                                        $icon_img.attr("src", img_url);
                                        $icon_img.attr("data-path", img_path);
                                        $("#imageUl").removeClass("hidden");
                                    } else {
                                        $.notify({message: "文件路径错误!", z_index: 15111});
                                    }
                                }
                            })
                        } else {
                            $icon_img.attr("src", img_url);
                            $icon_img.attr("data-path", img_path);
                            $("#imageUl").removeClass("hidden");
                            $('#iconTip').html('');
                        }
                        return;
                    }

                    alert((result && result.message) || '上传失败');
                }
            });
            return false;
        });
        $("#imageUl").on('click', '.delPic', function () {
            var that = $(this);
            var path = that.closest("li").find("img").attr("data-path");
            $.ajax({
                url: '${uploadServer}/common/delFile.do',
                data: {
                    path: path
                },
                type: 'GET',
                success: function (result) {
                    if (result.success) {
                        $("#iconTip").html('');
                        $("#imageUl").addClass("hidden");
                        $("[name=icon]").val('');
                        $("#icon-img").attr("src", "");
                    } else {
                        $.notify({message: "文件路径错误!", z_index: 15111});
                    }
                }
            })
        });





    });
    function backIndex() {
        window.location.href = "${dynamicServer}/cms/teacher/index.do";
    };

</script>
</body>
</html>
