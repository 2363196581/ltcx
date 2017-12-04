<%--
  Created by IntelliJ IDEA.
  User: 1553280431@qq.com
  Date: 2017/5/25
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>

<%@ include file="../../common/taglib.jsp" %>
<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>${webTitle }-用户管理</title>
    <%@ include file="../../common/header.jsp" %>
</head>

<body class="no-skin">
<%@ include file="../../common/top.jsp" %>
<div class="main-container" id="main-container">
    <%@ include file="../../common/menu.jsp" %>
    <div class="main-content">
        <div class="main-content-inner">
            <!-- #section:basics/content.breadcrumbs -->
            <div class="breadcrumbs  breadcrumbs-fixed" id="breadcrumbs">
            </div>
            <!-- /section:basics/content.breadcrumbs -->
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="widget-box" id="widget-box-search">
                            <div class="widget-header">
                                <div class="widget-toolbar">
                                    <a href="#" data-action="collapse">
                                        <i class="ace-icon fa fa-chevron-up"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="widget-body">
                                <div class="widget-main no-padding">
                                    <form:form action="/" method="post"
                                               cssClass="form-horizontal"
                                               cssStyle="padding-top: 10px;">
                                        <div class="row">
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <label class="control-label col-xs-6 col-lg-5">手机号：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <input type="text" id="phoneSearch"
                                                               class="col-xs-12 col-sm-12 col-lg-10"
                                                               value="" title=""/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <label class="control-label col-xs-6 col-lg-5">用户姓名：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <input type="text" id="nickNameSearch"
                                                               class="col-xs-12 col-sm-12 col-lg-10"
                                                               value="" title=""/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <label class="control-label col-xs-6 col-lg-5">用户积分：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <input type="text" id="integralSearch"
                                                               class="col-xs-12 col-sm-12 col-lg-10"
                                                               value="" title=""/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <button type="button" class="btn btn-primary btn-sm"
                                                            id="btn-search">
                                                        <i class="ace-icon fa fa-search"></i> 查询
                                                    </button>
                                                    &nbsp;&nbsp;
                                                    <a type="button" class="btn btn-success btn-sm"

                                                       data-backdrop="static" onclick="addUser()"
                                                       id="btn-add">
                                                        <i class="ace-icon fa fa-search"></i> 新增

                                                    </a>
                                                    <a href="#modal-import" class="btn btn-warning btn-sm"
                                                       data-toggle="modal">
                                                        <i class="ace-icon fa fa-file-excel-o"></i>导入</a>
                                                </div>
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                        <div class="hr hr-18 dotted hr-double"></div>
                        <div class="row">
                            <div class="col-xs-12">
                                <table id="lwUser" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th style="background-color: #E5E5E5">编号</th>
                                        <th style="background-color: #E5E5E5">手机号</th>
                                        <th style="background-color: #E5E5E5">姓名</th>
                                        <th style="background-color: #E5E5E5">积分</th>
                                        <th style="background-color: #E5E5E5">注册</th>
                                        <th style="background-color: #E5E5E5">登录</th>
                                        <th style="background-color: #E5E5E5">状态</th>

                                        <th style="background-color: #E5E5E5">APP</th>


                                        <th style="background-color: #E5E5E5">操作</th>
                                    </tr>
                                    </thead>
                                </table>
                            </div>
                            <!-- /.span -->
                        </div>
                    </div>
                    <!-- /.span -->
                </div>
            </div>
            <!-- /.main-content -->
        </div>
        <!-- /.main-container -->
    </div>
</div>
<div id="modal-edit" class="modal fade" role="dialog" aria-hidden="true">
    <div class="modal-dialog" style="width: 50%;top: 18%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only"></span>
                </button>
                <h4 class="modal-title">用户</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <form id="lwUserForm" name="lwUserForm" class="form-horizontal"
                              action="${dynamicServer}/cms/user/save.do" method="post">
                            <input id="id" name="id" value="" type="hidden" title=""/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">手机号：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="phone" name="phone" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value=""><label id="nameTip"></label>
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
                                    <input type="text" id="password" name="password" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value=""><label id="passwordTip"></label>

                                </div>
                            </div>
                            <%--<div class="form-group">--%>
                            <%--<label class="col-sm-3 control-label">状态：</label>--%>
                            <%--<div class="col-sm-9">--%>
                            <%--&lt;%&ndash;//0正常 1删除  2 禁用 3 审核中&ndash;%&gt;--%>

                            <%--<select id="state" name="state" class="col-xs-10 col-sm-7" title="">--%>
                            <%--<option value="0">正常</option>--%>
                            <%--<option value="2">禁用</option>--%>
                            <%--<option value="3">审核中</option>--%>
                            <%--</select>--%>
                            <%--</div>--%>
                            <%--</div>--%>
                            <div class="clearfix form-actions">
                                <div class="col-md-offset-4 col-md-8">
                                    <button class="btn btn-primary btn-sm" type="submit">
                                        <i class="ace-icon fa fa-save bigger-110"></i> 保存
                                    </button>
                                    &nbsp;&nbsp;
                                    <button class="btn btn-sm" type="button" data-dismiss="modal">
                                        <i class="ace-icon fa fa-undo bigger-110"></i> 取消
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div id="modal-import" class="modal fade" tabindex="-21">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header no-padding">
                <div class="table-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <span class="white">&times;</span>
                    </button>
                    导入检查项
                </div>
            </div>
            <div class="modal-body no-padding">
                <div class="widget-box" style="border: none">
                    <div class="widget-body">
                        <div class="widget-main">
                            <div class="form-group">
                                <div class="col-xs-12" style="margin-bottom: 10px">
                                    <span>请下载模板，按照模板格式整理数据：</span>
                                    <a href="${staticServer}/upload/model/user.xls">导入用户模板.xls</a>
                                </div>
                            </div>
                            <c:url value="${dynamicServer}/cms/user/import.do"
                                   var="import_url"/>
                            <form:form action="${import_url}"
                                       enctype="multipart/form-data" method="post" id="upload-form">
                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <input name="excel_file" type="file" id="import-input"
                                               accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"/>

                                    </div>
                                    <div class="col-xs-12" align="center">
                                        <button class="btn btn-white btn-primary" type="submit">
                                            <i class="ace-icon fa fa-cloud-upload bigger-110"></i> 确定
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
<div id="import-result-modal" class="modal fade" tabindex="-21">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header no-padding">
                <div class="table-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <span class="white">&times;</span>
                    </button>
                    导入结果
                </div>
            </div>
            <div class="modal-body no-padding">
                <div class="widget-box" style="border: none">
                    <div class="widget-body">
                        <div class="widget-main">
                            <div class="form-group">
                            </div>
                            <form:form action="" id="import-result-form">
                                <div class="form-group">
                                    <div class="col-xs-12" id="result-text">
                                    </div>
                                    <div class="col-xs-12" align="center">
                                        <button class="btn btn-white btn-primary" type="button" id="result-btn">
                                            <i class="ace-icon fa fa-check bigger-110"></i> 确认
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
<%@ include file="../../common/js.jsp" %>
<script src="${staticServer }/assets/js/jquery.form.js"></script>
<script src="${staticServer }/assets/js/jquery.validation/jquery.validate.js"></script>
<script src="${staticServer }/assets/js/jquery.validation/jquery.validate.zh-CN.js"></script>

<script>

    <%--//0正常 1删除  2 冻结 ---%>


    /*正常*/
    function normal(id) {
        bootbox.confirm("<a style='font-size: 17px;color: red'>确定用户恢复正常？</a>", function (result) {
            if (result) {
                $.ajax({
                    type: "GET",
                    url: "${dynamicServer}/cms/user/updateState.do",
                    data: {
                        "id": id,
                        "state": 0
                    },
                    contentType: 'application/json',
                    success: function () {
                        table.draw();
                    }
                });
            }
        });
    }


    /*冻结*/
    function frozen(id) {
        bootbox.confirm("<a style='font-size: 17px;color: red'>确定要冻结用户吗？</a>", function (result) {
            if (result) {
                $.ajax({
                    type: "GET",
                    url: "${dynamicServer}/cms/user/updateState.do",
                    data: {
                        "id": id,
                        "state": 2
                    },
                    contentType: 'application/json',
                    success: function () {
                        table.draw();
                    }
                });
            }
        });
    }
</script>
<script>
    $(function () {
        /*把要初始化的table的对象赋值*/
        var $table_id = $("#lwUser");
        /*自定义查询参数*/
        var userParam = {
            getQueryCondition: function (data) {
                var param = {};
                param.phone = $("#phoneSearch").val();
                param.nickName = $("#nickNameSearch").val();
                param.integral = $("#integralSearch").val();
                param.page = data.start;
                param.length = data.length;
                return param;
            }
        };
        //object可以如下初始化表格
        window.table = $table_id.DataTable({
            dom: '<".table_area_top" B and >t<".table_area_bottom" pi>',
            Filter: false, //列筛序功能
            searching: false,//本地搜索
            ordering: false, //排序功能
            Info: true,//页脚信息
            lengthMenu: [15],
            scrollY: "auto",
            Paginate: true, //翻页功能
            sortable: false,
            processing: true,
            serverSide: true,
            ajax: function (data, callback) {//ajax配置为function,手动调用异步查询
                $.ajax({
                    type: "GET",
                    url: '${dynamicServer}/cms/user/getList.do',//请求数据的参数
                    data: userParam.getQueryCondition(data),
                    cache: false,  //禁用缓存
                    dataType: "json",
                    success: function (result) {
                        callback(result);
                    }
                });
            },
            //使用对象数组，一定要配置columns，告诉 DataTables 每列对应的属性
            //data 这里是固定不变的，id，name，age，sex等为你数据里对应的属性
            columns: [
                {
                    data: "id",
                    render: function (data) {
                        return data || "";
                    }
                },
                {
                    data: "phone",
                    render: function (data) {
                        return data || "无";
                    }
                },
                {
                    data: "name",
                    render: function (data) {
                        return data || "无";
                    }
                },
                {
                    data: "sex",
                    render: function (data) {
                        return data=0?"男":"女";
                    }
                },
                {
                    data: "createDate",
                    render: function (data) {
                        return dateFormat(data) || "";
                    }
                },
                {
                    data: "loginDate",
                    render: function (data) {
                        return dateFormat(data) || "";
                    }
                },
                {
                    data: "state",
                    render: function (data) {
                        return stateOption(data) || "";
                    }
                },
                {
                    data: "isApp",
                    render: function (data) {
                        return isApp(data) || "否";
                    }
                },


                {
                    data: "id",
                    width: "280px",
                    <%--//0正常 1删除  2 冻结 ---%>

                    render: function (data, type, row) {
                        var button = '<a class="btn  btn-sm btn-info"   data-backdrop="static" ' +
                            'onclick="updateUser(\'' + data + '\')">' +
                            '<i class="ace-icon fa fa-pencil-square-o "></i>修改</a>';
                        button += '&nbsp;&nbsp;' +
                            '<a class="btn btn-sm btn-danger" onclick="free(\'' + data + '\')">' +
                            '<i class="ace-icon fa fa-pencil-square-o "></i>消费</a>';

                        if (row.state == 0) {
                            button += '&nbsp;&nbsp;<a class="btn btn-sm btn-success" onclick="frozen(\'' + data + '\')">' +
                                '<i class="ace-icon fa fa-pencil-square-o "></i>冻结</a>';
                        } else if (row.state == 2) {
                            button += '&nbsp;&nbsp;<a class="btn btn-sm btn-success" onclick="normal(\'' + data + '\')">' +
                                '<i class="ace-icon fa fa-pencil-square-o "></i>解冻</a>';

                        }

                        button += '&nbsp;&nbsp;' +
                            '<a class="btn btn-sm btn-danger" onclick="delDepartment(\'' + data + '\')">' +
                            '<i class="ace-icon fa fa-pencil-square-o "></i>删除</a>';
                        return button;
                    }
                }
            ],
            language: { //国际语言转化
                aria: {
                    sortAscending: " - click/return to sort ascending",
                    sortDescending: " - click/return to sort descending"
                },
                lengthMenu: "显示 _MENU_ 记录",
                zeroRecords: "对不起，查询不到任何相关数据",
                emptyTable: "未有相关数据",
                loadingRecords: "正在加载数据-请等待...",
                info: "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。",
                infoEmpty: "当前显示0到0条，共0条记录",
                infoFiltered: "（数据库中共为 _MAX_ 条记录）",
                processing: " 正在加载数据...",
                //多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
                paginate: {
                    first: "首页",
                    previous: " 上一页 ",
                    next: " 下一页 ",
                    last: " 尾页 "
                }
            }
        });
        /*条件查询*/
        $("#btn-search").on("click", function () {
            table.draw();
        });
        /*validate验证*/


        $("#lwUserForm").validate({
                errorElement: "label",
                errorClass: "validError",
                errorPlacement: function (error, element) {
                    error.appendTo($("#" + element.attr('id') + "Tip"));
                },

            submitHandler: function (form) {
            $("#lwUserForm").ajaxSubmit({
                success: function () {
                    $('#modal-edit').modal('hide');
                    table.draw();
                }
            });
        }
    })
        ;
        $.validator.addMethod("isPassword", function (value, element) {
            var checkName = /^[a-zA-Z0-9]{6,20}$/;
            return this.optional(element) || (checkName.test(value));
        }, "只允许6-20位数字或字母！");

        var $import_input = $('#import-input');
        $import_input.ace_file_input({
            style: 'well',
            btn_choose: '点击选择Excel文件',
            btn_change: null,
            no_icon: 'ace-icon fa fa-file-excel-o',
            droppable: false,
            thumbnail: 'small',//large | fit
            maxSize: 10240000,
            allowExt: ['xls', 'xlsx', 'xlt', 'xlw', 'xlc', 'xlm'],
            allowMime: ['application/vnd.ms-excel', 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'],
            before_remove: function () {
                return true;
            }

        }).on('change', function () {
            if ($import_input.val() == '') {
                resetFileinput();
                return false;
            }
        }).on('file.error.ace', function (ev, info) {
            if (info.error_count['ext'] || info.error_count['mime']) {
                $.notify("请选择Excel文件!");
                return false;
            }
            if (info.error_count['size']) {
                $.notify("文件不超过100M!");
                return false;
            }
        });


        var subject_upload_form = $("#upload-form");
        //导入提交
        subject_upload_form.on('submit', function () {
            var upload_check = $import_input.val();
            if (upload_check == '') {
                resetFileinput();
                $.notify("请选择文件!");
                return false;
            }
            $import_input.ace_file_input('loading', true);
            $(".ace-file-overlay").append('<div class="overlay-text">正在导入中...</div>');
            subject_upload_form.ajaxSubmit({
                type: 'post', // 提交方式 get/post
                url: subject_upload_form.attr('action'),
                dataType: 'json',
                success: function (result) {
                    console.log(result.message)
                    $import_input.ace_file_input('loading', false);
                    var msg = '';
                    if (result && result.success && result.data) {
                        $("#subject-modal").modal("hide");  //关闭上传窗口
                        $import_input.val('');
                        resetFileinput();

                        if (result.data.length == 0) {

                            msg = result.message;
                        } else {
                            $.each(result.data, function (i, item) {
                                var index = parseInt(item.rowIndex);
                                msg += '第' + index + '行,' + item.reason + '<br/>';
                            });
                            msg += '其余导入成功';
                        }
                        $("#result-text").html(msg);
                        $("#import-result-modal").modal("show");
//
                        //$.notify(msg);
                    } else {
                        $("#subject-modal").modal("hide");   //关闭上传窗口
                        $import_input.val('');
                        resetFileinput();
                        $import_input.ace_file_input('loading', false);
                    }
                }
            });
            return false;
        });
        $("#result-btn").on('click', function () {
            $("#import-result-modal").modal("hide");
            table.draw();
        })
    });

    /*新增时清空表单数据*/
    function flushForm() {
        $("#lwUserForm").find("input,select").each(function () {
            var id = $(this).attr("id");
            $("#" + id).val("");
        });
        $.ajax({
            type: "get",
            url: "${dynamicServer}/cms/user/findAll.do",
            contentType: "application/json",
            success: function (data) {

            }
        })
    }

    //重置上传窗口

    function resetFileinput() {
        var $import_input = $("#upload-form");
        $import_input.parent().find(".ace-file-container").removeClass("hide-placeholder").removeClass("selected");
        $import_input.parent().find(".ace-file-container").attr("data-title", '点击选择Excel文件');
        $import_input.parent().find(".ace-file-name").find("i").addClass("fa-file-excel-o").removeClass("fa-file");
        $import_input.parent().find(".ace-file-name").find("img").remove();
        $import_input.parent().find(".ace-file-name").attr("data-title", 'No File ...');
    }


    /*修改时需要回显数据*/
    function updateUser(id) {
        window.location.href = "${dynamicServer}/cms/user/toUpdate.do?id=" + id;
    }
    /*修改时需要回显数据*/
    function addUser() {
        window.location.href = "${dynamicServer}/cms/user/toAdd.do";
    }

    /*删除*/
    function delDepartment(id) {
        bootbox.confirm("<a style='font-size: 17px;color: red'>确定要删除该用户信息？</a>", function (result) {
            if (result) {
                $.ajax({
                    type: "GET",
                    url: "${dynamicServer}/cms/user/delete.do",
                    data: {
                        "id": id
                    },
                    contentType: 'application/json',
                    success: function () {
                        table.draw();
                    }
                });
            }
        });
    }
    function stateOption(data) {
        var x = "";
        <%--//0正常 1删除  2 冻结 ---%>
        console.log(data);
        switch (data) {
            case 0:
                x = "正常";
                break;
            case 1:
                x = "删除";
                break;
            case 2:
                x = "冻结";
                break;

        }
        return x;

    }

    function isApp(data) {
        var x = "";
//        1 是0 否
        switch (data) {
            case 0:
                x = "否";
                break;
            case 1:
                x = "是";
                break;

        }
        return x;

    }
    function free(id) {
        window.location.href = "${dynamicServer}/cms/user/course/userInfo.do?userNo=" + id;
    }

</script>
</body>
</html>


