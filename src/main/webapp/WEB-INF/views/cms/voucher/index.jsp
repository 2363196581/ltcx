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
    <title>${webTitle }-代金券</title>
    <%@ include file="../../common/header.jsp" %>
    <link rel="stylesheet" href="${staticServer}/assets/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet"
          href="${staticServer}/assets/components/bootstrap-multiselect/dist/css/bootstrap-multiselect.css"/>
    <link rel="stylesheet" href="${staticServer}/assets/select2/select2.css"/>
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
                                                    <label class="control-label col-xs-6 col-lg-5">代金券名称：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <input type="text" id="NameSearch"
                                                               class="col-xs-12 col-sm-12 col-lg-10"
                                                               value="" title=""/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <label class="control-label col-xs-6 col-lg-5">代金券前缀：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <input type="text" id="PrefixSearch"
                                                               class="col-xs-12 col-sm-12 col-lg-10"
                                                               value="" title=""/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div class="form-group">
                                                    <label class="control-label col-xs-6 col-lg-5">类型：</label>
                                                    <div class="col-xs-6 col-lg-7">
                                                        <select name="TypeSearch" id="TypeSearch" class="col-sm-12 col-lg-7" title="">
                                                            <option value="" selected="selected">请选择</option>
                                                            <option value="0">非营销申领</option>
                                                            <option value="1">营销申领不限时</option>
                                                            <option value="2">营销申领限时</option>
                                                        </select>
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
                                                    <%--onclick="addLwCourse()"--%>
                                                    <a type="button" class="btn btn-success btn-sm"
                                                       href="#modal-edit" data-toggle="modal"
                                                       data-backdrop="static" onclick="flushForm()"
                                                       id="btn-add">
                                                        <i class="ace-icon fa fa-search"></i> 新增

                                                    </a>
                                                    <%--&nbsp;&nbsp;--%>
                                                    <%--<a type="button" class="btn btn-success btn-sm"--%>
                                                       <%--href="#modal-marketing-dispatcher" data-toggle="modal"--%>
                                                       <%--data-backdrop="static" onclick=""--%>
                                                       <%--id="btn-add">--%>
                                                        <%--<i class="ace-icon fa fa-search"></i> 营销申领--%>

                                                    <%--</a>--%>
                                                    &nbsp;&nbsp;<%--onclick="dispatcher()"--%>
                                                    <a type="button" class="btn btn-success btn-sm"
                                                       href="#modal-dispatcher" data-toggle="modal"
                                                       data-backdrop="static"
                                                       id="btn-add">
                                                        <i class="ace-icon fa fa-search"></i> 指定发放

                                                    </a>
                                                        <%--<a href="#modal-import" class="btn btn-warning btn-sm"
                                                           data-toggle="modal">
                                                            <i class="ace-icon fa fa-file-excel-o"></i>导入</a>--%>
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
                                <table id="lwInvitation" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>
                                            <input type="checkbox" class="checkall" />
                                        </th>
                                        <th style="background-color: #E5E5E5">ID</th>
                                        <th style="background-color: #E5E5E5">代金券名称</th>
                                        <th style="background-color: #E5E5E5">代金券前缀</th>
                                        <th style="background-color: #E5E5E5">代金券面值(元)</th>
                                        <th style="background-color: #E5E5E5">代金券数量</th>

                                        <th style="background-color: #E5E5E5">开始使用时间</th>
                                        <th style="background-color: #E5E5E5">结束使用时间</th>
                                        <th style="background-color: #E5E5E5">状态</th>
                                        <th style="background-color: #E5E5E5">类型</th>

                                        <th style="background-color: #E5E5E5">使用人数</th>
                                        <th style="background-color: #E5E5E5">领取人数</th>
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

<%--voucher add--%>
<div id="modal-edit" class="modal fade" role="dialog" aria-hidden="true" style="overflow-y: auto !important;">
    <div class="modal-dialog" style="width: 50%;top: 18%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only"></span>
                </button>
                <h4 class="modal-title">代金券</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <form id="lwInvitationForm" name="lwInvitationForm" class="form-horizontal"
                              action="${dynamicServer}/cms/voucher/save.do" method="post">
                            <input id="id" name="id" value="" type="hidden" title=""/>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">代金券名称：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="name" name="name" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="">
                                    <label id="nameTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">代金券前缀：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="prefix" name="prefix" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="">
                                    <label id="prefixTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">代金券面值：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="denomination" name="denomination" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="">
                                    <label id="denominationTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">代金券数量：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="count" name="count" maxlength="256"
                                           class="col-xs-10 col-sm-7" placeholder=""
                                           title="" value="">
                                    <label id="countTip"></label>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">选择课程：</label>
                                <div class="col-sm-9">

                                    <select id="courseType" name="courseType"
                                            class="col-xs-12 col-sm-7 col-lg-7">
                                        <option value="1">部分课程</option>
                                        <option value="2">全站课程</option>
                                    </select>
                                    <label id="courseTypeTip"></label>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">选择课程：</label>
                                <div class="col-sm-9">

                                    <select id="courseNo" name="courseNo"
                                           class="col-xs-12 col-sm-7 col-lg-7" style="width: 58.5%"></select>
                                    <%--<input type="checkbox" class="coursecheckall" value="" />全选--%>
                                    <%--<c:forEach var="course" items="${courses}" varStatus="">--%>

                                        <%--<input type="checkbox" name="courseNo" class="coursecheckchild" value="${course.id}" />${course.name}--%>
                                    <%--</c:forEach>--%>
                                    <label id="courseNoTip"></label>
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-sm-3 control-label">开始时间：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="beginDate" name="beginDate"
                                           data-date-format="yyyy-mm-dd hh:ii"
                                           class="col-xs-12 col-sm-7 " title="" value="">
                                    <label id="beginDateTip"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">结束时间：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="stopDate" name="stopDate"
                                           data-date-format="yyyy-mm-dd hh:ii"
                                           class="col-xs-12 col-sm-7 " title="" value="">
                                    <label id="stopDateTip"></label>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">状态：</label>
                                <div class="col-sm-9">
                                    <select name="state" id="state" class="col-sm-12 col-lg-7" title="">
                                        <option value="0" selected="selected">暂不发布</option>
                                        <option value="1">立即发布</option>
                                        <option value="2">已作废</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">类型：</label>
                                <div class="col-sm-9">
                                    <select name="type" id="type" class="col-sm-12 col-lg-7" title="">
                                        <option value="0" selected="selected">非营销申领</option>
                                        <option value="1">营销申领不限时</option>
                                        <option value="2">营销申领限时</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">不限时申领开始时间：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="applyBeginDate" name="applyBeginDate"
                                           data-date-format="yyyy-mm-dd hh:ii"
                                           class="col-xs-12 col-sm-7 " title="" value="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">限时申领结束时间：</label>
                                <div class="col-sm-9">
                                    <input type="text" id="applyStopDate" name="applyStopDate"
                                           data-date-format="yyyy-mm-dd hh:ii"
                                           class="col-xs-12 col-sm-7 " title="" value="">
                                </div>
                            </div>



                            <div class="form-group">
                                <label class="col-sm-3 control-label ">活动图片:</label>
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
                                    <input type="hidden" id="actPhoto" name="actPhoto" value="">
                                    <a href="#icon-modal" class="btn btn-white btn-primary" data-toggle="modal"
                                       style="position: absolute;top: 2px;">
                                        <i class="ace-icon glyphicon glyphicon-picture bigger-110"></i> 选择图片
                                    </a>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label ">分享模板:</label>
                                <div class="col-sm-9 control-div">
                                    <ul id="shareUrlUl" class="ace-thumbnails clearfix hidden"
                                        style=" display: inline-block;">
                                        <li>
                                            <a data-rel="colorbox">
                                                <img width="150" id="shareUrl-img" alt="150x150" data-path="" src=""/>
                                                <div class="tools tools-top">
                                                    <a class="delPic"> <i class="ace-icon fa fa-times red">删除</i>
                                                    </a></div>
                                            </a>
                                        </li>
                                    </ul>


                                    <input type="hidden" id="sharePhoto" name="sharePhoto" value="">
                                    <img type="hidden" id="sharePhotoReturn" name="sharePhotoReturn" src="" />
                                    <a href="#shareUrl-modal" class="btn btn-white btn-primary" data-toggle="modal"
                                       style="position: absolute;top: 2px;">
                                        <i class="ace-icon glyphicon glyphicon-picture bigger-110"></i> 选择图片
                                    </a>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">说明：</label>
                                <div class="col-sm-9">
                                        <textarea id="remarks" name="remarks" class="col-xs-12 col-sm-7" rows="5" maxlength="500"></textarea>
                                    <label id="remarkTip"></label>
                                </div>
                            </div>

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

<%--voucher designated dispatcher--%>
<div id="modal-dispatcher" class="modal fade" role="dialog" aria-hidden="true">
    <div class="modal-dialog" style="width: 50%;top: 18%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">&times;</span>
                    <span class="sr-only"></span>
                </button>
                <h4 class="modal-title">代金券发放</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12">
                        <form id="lwVoucherForm" name="lwVoucherForm" class="form-horizontal"
                              action="${dynamicServer}/cms/voucher/saveLog.do" method="post">
                            <input id="code" name="code" value="" type="hidden" title=""/>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">选择代金券：</label>
                                <div class="col-sm-9">
                                    <select id="voucherId" name="voucherId"
                                            class="col-xs-12 col-sm-7 col-lg-7" style="width: 58.5%"></select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">发放对象：</label>
                                <div class="col-sm-9">
                                    <select name="dispatcheObj" id="dispatcheObj" class="col-sm-12 col-lg-7" title="">
                                        <option value="0" selected="selected">部分用户</option>
                                        <option value="1">课程用户</option>
                                        <option value="2">全站</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">选择课程：</label>
                                <div class="col-sm-9">
                                    <select id="courseNo2" name="courseNo"
                                            class="col-xs-12 col-sm-7 col-lg-7" style="width: 58.5%"></select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">发放对象：</label>
                                <div class="col-sm-9">
                                    <textarea id="telephone" name="telephone" class="col-xs-12 col-sm-7" rows="5" maxlength="500"></textarea>
                                    <label id="telephoneTip"></label>
                                </div>
                            </div>

                            <div class="clearfix form-actions">
                                <div class="col-md-offset-4 col-md-8">
                                    <button class="btn btn-primary btn-sm" type="submit" id="dispatcher-button">
                                        <i class="ace-icon fa fa-save bigger-110"></i> 发放
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


<%-- pop --%>
<div id="icon-modal" class="modal fade" tabindex="-21">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header no-padding">
                <div class="table-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <span class="white">&times;</span>
                    </button>
                    上传活动图片
                </div>
            </div>
            <div class="modal-body no-padding">
                <div class="widget-box" style="border: none">
                    <div class="widget-body">
                        <div class="widget-main">
                            <c:url value="${uploadServer}/common/upload.do" var="upload_url"/>
                            <form:form action="${upload_url}"
                                       enctype="multipart/form-data" method="post" id="icon-form">
                                <input type="hidden" name="file_type" value="actPhoto">
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
<div id="shareUrl-modal" class="modal fade" tabindex="-21">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header no-padding">
                <div class="table-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <span class="white">&times;</span>
                    </button>
                    上传分享图片
                </div>
            </div>
            <div class="modal-body no-padding">
                <div class="widget-box" style="border: none">
                    <div class="widget-body">
                        <div class="widget-main">
                            <c:url value="${uploadServer}/common/upload.do" var="upload_url"/>
                            <form:form action="${upload_url}"
                                       enctype="multipart/form-data" method="post" id="shareUrl-form">
                                <input type="hidden" name="file_type" value="sharePhoto">
                                <div class="form-group">
                                    <div class="col-xs-12">
                                        <input name="file" type="file" id="shareUrl-input"
                                               accept="image/png,image/jpeg,image/gif,image/bmp"/>
                                    </div>
                                    <div class="col-xs-12" align="center">
                                        <button class="btn btn-white btn-primary" type="submit">
                                            <i class="ace-icon fa fa-cloud-upload bigger-110"></i> 上传
                                        </button>
                                        <button class="btn btn-white btn-primary" type="button" id="closeShareUrl-modal"
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


<%--发放结果--%>
<div id="import-result-modal" class="modal fade" tabindex="-21">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header no-padding">
                <div class="table-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        <span class="white">&times;</span>
                    </button>
                    发放结果
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
                                        <%--<button class="btn btn-white btn-primary" type="button" id="result-index">--%>
                                            <%--<i class="ace-icon fa fa-check bigger-110"></i> 回到代金券首页--%>
                                        <%--</button>--%>
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
<script src="${staticServer }/assets/js/jquery.validation/additional-methods.js"></script>

<script>
    window.UEDITOR_HOME_URL = '${staticServer}/assets/ueditor1.4.3/';
</script>
<script src="${staticServer}/assets/ueditor1.4.3/ueditor.config.js"></script>
<script src="${staticServer}/assets/ueditor1.4.3/ueditor.all.min.js"></script>
<script src="${staticServer}/assets/ueditor1.4.3/lang/zh-cn/zh-cn.js"></script>
<script src="${staticServer}/assets/components/fuelux/js/spinbox.js"></script>
<script src="${staticServer}/assets/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="${staticServer}/assets/select2/select-topic-tags.js"></script>
<script src="${staticServer}/assets/select2/select2.full.js"></script>
<script>
    var $lwCourseIds = $('#courseNo');
    var $lwCourseIds2 = $('#courseNo2');
    /*下拉选择课程*/
    $lwCourseIds.select2({
        tags: true,
        multiple: true,
        createTag: function (params) {
            console.log(arguments);
            return null;
        },
        placeholder: '请输入要关联的课程',
        language: {
            noResults: function () {
                return '没有找到该课程';
            },
            inputTooShort: function () {
                return '请至少输入1个字符';
            }
        },
        ajax: {
            url: "${dynamicServer}/cms/course/getListByName.do",
            type: "get",
            dataType: 'json',
            delay: 250,
            data: function (params) {
                return {
                    name: params.term,
                    page: params.page
                };
            },
            processResults: function (data, params) {
                params.page = params.page || 1;

                return {
                    results: data
                };
            },
            cache: true
        },
        escapeMarkup: function (markup) {
            return markup;
        },
        minimumInputLength: 1,
        templateResult: function (course) {
            return course.name|| course.text;
        },
        templateSelection: function (course) {
            return course.name|| course.text;
        }
    });
    $lwCourseIds2.select2({
        tags: true,
        multiple: true,
        createTag: function (params) {
            console.log(arguments);
            return null;
        },
        placeholder: '请输入要关联的课程',
        language: {
            noResults: function () {
                return '没有找到该课程';
            },
            inputTooShort: function () {
                return '请至少输入1个字符';
            }
        },
        ajax: {
            url: "${dynamicServer}/cms/course/getListByName.do",
            type: "get",
            dataType: 'json',
            delay: 250,
            data: function (params) {
                return {
                    name: params.term,
                    page: params.page
                };
            },
            processResults: function (data, params) {
                params.page = params.page || 1;

                return {
                    results: data
                };
            },
            cache: true
        },
        escapeMarkup: function (markup) {
            return markup;
        },
        minimumInputLength: 1,
        templateResult: function (course) {
            return course.name|| course.text;
        },
        templateSelection: function (course) {
            return course.name|| course.text;
        }
    });


    $(function () {
        /*下拉代金券选择*/
        $('#voucherId').select2({
            tags: true,
            createTag: function (params) {
                console.log(arguments);
                return null;
            },
            placeholder: '请输入要关联的代金券',
            language: {
                noResults: function () {
                    return '没有找到该代金券';
                },
                inputTooShort: function () {
                    return '请至少输入1个字符';
                }
            },
            ajax: {
                url: "${dynamicServer}/cms/voucher/getListByName.do?state=1",
                type: "get",
                dataType: 'json',
                delay: 250,
                data: function (params) {
                    return {
                        name: params.term,
                        page: params.page
                    };
                },
                processResults: function (data, params) {
                    params.page = params.page || 1;

                    return {
                        results: data
                    };
                },
                cache: true
            },
            escapeMarkup: function (markup) {
                return markup;
            },
            minimumInputLength: 1,
            templateResult: function (course) {
                return course.name;
            },
            templateSelection: function (course) {
                return course.name;
            }
        });

        $('#voucherIdMarket').select2({
            tags: true,
            createTag: function (params) {
                console.log(arguments);
                return null;
            },
            placeholder: '请输入要关联的代金券',
            language: {
                noResults: function () {
                    return '没有找到该代金券';
                },
                inputTooShort: function () {
                    return '请至少输入1个字符';
                }
            },
            ajax: {
                url: "${dynamicServer}/cms/voucher/getListByName.do",
                type: "get",
                dataType: 'json',
                delay: 250,
                data: function (params) {
                    return {
                        name: params.term,
                        page: params.page
                    };
                },
                processResults: function (data, params) {
                    params.page = params.page || 1;

                    return {
                        results: data
                    };
                },
                cache: true
            },
            escapeMarkup: function (markup) {
                return markup;
            },
            minimumInputLength: 1,
            templateResult: function (course) {
                return course.name || course.text;
            },
            templateSelection: function (course) {
                return  course.name || course.text;
            }
        });



        /*把要初始化的table的对象赋值*/
        var $table_id = $("#lwInvitation");

        /*自定义查询参数*/
        var userParam = {
            getQueryCondition: function (data) {
                var param = {};
                param.name = $("#NameSearch").val();
                param.prefix = $("#PrefixSearch").val();
                param.type = $("#TypeSearch").val();

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
                    url: '${dynamicServer}/cms/voucher/getList.do',//请求数据的参数
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
                    sClass: "text-center",
                    data: "id",
                    render: function (data, type, full, meta) {
                        return '<input type="checkbox"  class="checkchild"  value="' + data + '" />';
                    },
                    bSortable: false
                },
                {
                    data: "id",
                    render: function (data) {
                        return data || "";
                    }
                },{
                    data: "name",
                    render: function (data) {
                        return data || "";
                    }
                },
                {
                    data: "prefix",
                    render: function (data) {
                        return data || "";
                    }
                },
                {
                    data: "denomination",
                    render: function (data) {
                        return data || "";
                    }
                },
                {
                    data: "count",
                    render: function (data) {
                        return data || "";
                    }
                },

                {
                    data: "beginDate",
                    render: function (data) {
                        return data!=null? dateFormat(data) : "" ;
//                        return dateFormat(data) || "";
                    }
                },
                {
                    data: "stopDate",
                    render: function (data) {
                        return data!=null? dateFormat(data) : "" ;
//                        return dateFormat(data) || "";
                    }
                },

                {
                    data: "state",
                    render: function (data) {
                        var state = "";
                        switch (data) {
                            case 0:
                                state = "未发布";
                                break;
                            case 1:
                                state = "已发布";
                                break;
                            case 2:
                                state = "已作废";
                                break;
                            default :
                                state = "未发布";
                                break;
                        }
                        return state;
                    }
                },
                {
                    data: "type",
                    render: function (data) {
                        var state = "";
                        switch (data) {
                            case 0:
                                state = "非营销申领";
                                break;
                            case 1:
                                state = "营销申领不限时";
                                break;
                            case 2:
                                state = "营销申领限时";
                                break;
                            default :
                                state = "非营销申领";
                                break;
                        }
                        return state;
                    }
                },
                {
                    data: "used",
                    render: function (data) {
                        return data==null?"0人":data+"人";
                    }
                },
                {
                    data: "receive",
                    render: function (data) {
                        return data==null?"0人":data+"人";
                    }
                },
                {
                    data: "id",
                    width: "285px",
                    render: function (data, type, row) {
                        var button = '<a class="btn btn-sm btn-success" ' +
                            'onclick="goVoucherLogById(\'' + data + '\')">' +
                            '<i class="ace-icon fa fa-pencil-square-o "></i>详情</a>';
                            if(row.state != 1){
                                button +='&nbsp;&nbsp;' +
                                    '<a class="btn  btn-sm btn-info" href="#modal-edit" data-toggle="modal"  data-backdrop="static" ' +
                                    'onclick="updateInvitation(\'' + data + '\')">' +
                                    '<i class="ace-icon fa fa-pencil-square-o "></i>修改</a>' ;
                            }
                            if (row.state == 0 || row.state == 1||row.state==null) {
                                button += '&nbsp;&nbsp;<a class="btn btn-sm btn-warning" onclick="cancelVoucher(\'' + data  + '\', 2 )">' +
                                    '<i class="ace-icon fa fa-pencil-square-o "></i>作废</a>';
                            } else if (row.state == 2) {
                                button += '&nbsp;&nbsp;<a class="btn btn-sm btn-success" onclick="cancelVoucher(\'' + data  + '\', 0 )">' +
                                    '<i class="ace-icon fa fa-pencil-square-o "></i>恢复</a>';
                            }
                        if (row.state == 0 || row.state == 2) {
                            button += '&nbsp;&nbsp;' +
                                '<a class="btn btn-sm btn-danger" onclick="delInvitation(\'' + data + '\')">' +
                                '<i class="ace-icon fa fa-pencil-square-o "></i>删除</a>';
                        }
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
                info: "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录。到第 <input type='text' id='changePage' class='input-text' style='width:50px;'>" +
                "页 <a class='btn btn-default shiny' href='javascript:void(0);' id='dataTable-btn' style='text-align:center;'>确认</a>",
                infoEmpty: "当前显示0到0条，共0条记录",
                infoFiltered: "（数据库中共为 _MAX_ 条记录）",
                processing: " 正在加载数据...",
                //多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
                paginate: {
                    first: "首页",
                    previous: " 上一页 ",
                    next: " 下一页",
                    last: " 尾页 "

                }
            },
            "fnDrawCallback": function() {
//                alert($("#changePage").length);
//                if($("#changePage").length==0) {
//                    $("#lwInvitation").append("  <span style='float: right'>到第 <input type='text' id='changePage' class='input-text' style='width:50px;height:27px;'>" +
//                        "页 <a class='btn btn-default shiny' href='javascript:void(0);' id='dataTable-btn' style='text-align:center;'>确认</a></span>");
//                }
                var oTable = $table_id.dataTable();



                var oTable = $table_id.dataTable();
                $('#dataTable-btn').click(function(e) {
                    if($("#changePage").val() && $("#changePage").val() > 0) {
                        var redirectpage = $("#changePage").val() - 1;
                    } else {
                        var redirectpage = 0;
                    }
                        oTable.fnPageChange(redirectpage);
                });
            }

        });

        /*全选*/
        $(".checkall").click(function () {
            var check = $(this).prop("checked");
            $(".checkchild").prop("checked", check);
        });
        $(".coursecheckall").click(function () {
            var check = $(this).prop("checked");
            $(".coursecheckchild").prop("checked", check);
        });

        /*日期*/
        var date = dateFormatHour(new Date());
        $(".datetimepicker").val(date);

        $.fn.datetimepicker.dates['zh'] = {
            days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
            daysShort: ["日", "一", "二", "三", "四", "五", "六", "日"],
            daysMin: ["日", "一", "二", "三", "四", "五", "六", "日"],
            months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            monthsShort: ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"],
            meridiem: ["上午", "下午"],
            today: "今天"
        };

        $('#startDate').datetimepicker({
            language: 'zh',
            autoclose: true,
            todayBtn: "linked"
        });
        $('#endDate').datetimepicker({
            language: 'zh',
            autoclose: true,
            todayBtn: "linked"
        });
        $('#beginDate').datetimepicker({
            language: 'zh',
            autoclose: true,
            todayBtn: "linked",
            format:"yyyy.mm.dd hh:ii",
        });
        $('#stopDate').datetimepicker({
            language: 'zh',
            autoclose: true,
            todayBtn: "linked",
            format:"yyyy.mm.dd hh:ii"
        });
        $('#applyBeginDate').datetimepicker({
            language: 'zh',
            autoclose: true,
            todayBtn: "linked",
            format:"yyyy.mm.dd hh:ii"
        });
        $('#applyStopDate').datetimepicker({
            language: 'zh',
            autoclose: true,
            todayBtn: "linked",
            format:"yyyy.mm.dd hh:ii"
        });
        $('#applyBeginDate2').datetimepicker({
            language: 'zh',
            autoclose: true,
            todayBtn: "linked"
        });
        $('#applyStopDate2').datetimepicker({
            language: 'zh',
            autoclose: true,
            todayBtn: "linked"
        });


        flushByType();

        if($('#type').val()==2){
            $("#applyBeginDate").parent().siblings('.col-sm-3').html("限时申领开始时间：");
        }else if($('#type').val()==1){
            $("#applyBeginDate").parent().siblings('.col-sm-3').html("不限时申领开始时间：");
        }
        /*限时申领*/
        $("#type").on("change", function () {
            if($('#type').val()==2){
                $("#applyBeginDate").parent().siblings('.col-sm-3').html("限时申领开始时间：");
                $("#applyBeginDate").parent().parent().show();
                $("#applyStopDate").parent().parent().show();
                $("#imageUl").parent().parent().show();
                $("#shareUrlUl").parent().parent().show();
            }else if($('#type').val()==1){
                $("#applyBeginDate").parent().siblings('.col-sm-3').html("不限时申领开始时间：");
                $("#applyBeginDate").parent().parent().show();
                $("#applyStopDate").parent().parent().hide();
                $("#imageUl").parent().parent().show();
                $("#shareUrlUl").parent().parent().show();
            }else{
                $("#applyBeginDate").parent().parent().hide();
                $("#applyStopDate").parent().parent().hide();
                $("#imageUl").parent().parent().hide();
                $("#shareUrlUl").parent().parent().hide();
            }
        });

        /*选择代金券改变时 给code传入参数*/
        $("#voucherId").on("change", function () {
            $("#code").val($("#voucherId").find("option:selected").attr("code"));
        });

        /*条件查询*/
        $("#btn-search").on("click", function () {
            table.draw();
        });
        /*validate验证*/
        $("#lwInvitationForm").validate({
            errorElement: "label",
            errorClass: "validError",
            errorPlacement: function (error, element) {
                error.appendTo($("#" + element.attr('id') + "Tip"));
            },
            rules: {
                name: {
                    required: true,
                    maxlength: 255
                },
                prefix: {
                    required: true,
                    minlength:6,
                    maxlength: 255
                },
                denomination: {
                    required: true,
                    number:true,
//                    minNumber:true
                },
                courseNo:{
                    required: true,
                },
                count: {
                    required: true,
                    digits: true
                },
                beginDate: {
                    required: true,
                    date:true
                },
                stopDate: {
                    required: true,
                    date:true,
                    compareDate: "#beginDate"
                }
            },
            messages:{
                name:{
                    required: "代金券名称不能为空",
                    maxlength: "最大长度不能超过255个字符"
                },
                prefix:{
                    required: "代金券前缀不能为空",
                    minlength:"代金券前缀最少为6位字符",
                    maxlength:"代金券前缀最多为255位字符"
                },
                denomination:{
                    required: "面值不能为空",
                    number:"面值必须为数字",
                },
                count:{
                    required: "数量不能为空",
                    digits: "数量必须为正整数"
                },
                beginDate:{
                    required: "开始时间不能为空",
                },
                stopDate:{
                    required: "结束时间不能为空",
                    compareDate: "结束时间必须大于开始时间"
                }

            },
//            submitHandler: function (form) {
//                $("#lwInvitationForm").ajaxSubmit({
//                    success: function () {
//                        $('#modal-edit').modal('hide');
//                        table.draw();
//                    }
//                });
//            }
        });



        /*代金券发送 validate验证*/
        $("#lwVoucherForm").validate({
            errorElement: "label",
            errorClass: "validError",
            errorPlacement: function (error, element) {
                error.appendTo($("#" + element.attr('id') + "Tip"));
            },
            rules: {
                telephone: {
                    required: true
                }
            },
//            submitHandler: function (form) {
//                $("#lwVoucherForm").ajaxSubmit({
//                    success: function (data) {
//                        var msg = '';
//                        $('#modal-dispatcher').modal('hide');
//                        $("#result-text").html(msg);
//                        $("#import-result-modal").modal("show");
//
//                        if (data.length == 0) {
//                            msg = result.message;
//                        } else {
//                            $.each(data, function (i, item) {
//                                if(!item.success){
////                                    var index = parseInt(item.object);
//                                    msg += item.data+","+ item.message + '<br/>';
//                                }
//                            });
////                            msg += '其余发放成功';
//                        }
//                        $("#result-text").html(msg);
//                        $("#import-result-modal").modal("show");
//                        table.draw();
//                    }
//                });
//            }
        });
    });


    $('#lwInvitationForm').submit(function() {
        $(this).ajaxSubmit({
            success: function (data) {
                alert(data.message);
                $('#modal-edit').modal('hide');
                table.draw();
            }
        });
        return false;
    });

    $("#dispatcher-button").click(function(){
        $(this).attr("disabled",true);
        $("#lwVoucherForm").ajaxSubmit({
            success: function (data) {
                $("#dispatcher-button").attr("disabled",false);
                var msg = '';
                var count;
                $('#modal-dispatcher').modal('hide');
                $("#result-text").html(msg);
                $("#import-result-modal").modal("show");

                if (data.length == 0) {
                    msg += '发放成功';
                } else {
                    $.each(data, function (i, item) {
                        if(!item.success){
//                                    var index = parseInt(item.object);
                            msg += item.data+","+ item.message + '<br/>';
                        }
                    });
                    msg += '其余发放成功';
                }
                $("#result-text").html(msg);
                $("#import-result-modal").modal("show");
                table.draw();
            }
        });
    });

    $("#result-btn").on('click', function () {
        $("#import-result-modal").modal("hide");
    });
    $("#result-index").on('click', function () {
        $("#import-result-modal").modal("hide");
        window.location.href = "${dynamicServer}/cms/voucher/index.do";
    });

    $("#denomination").on('blur', function () {
        inputZ=$("#denomination").val();
        var ArrMen= inputZ.split(".");    //截取字符串
        if(ArrMen.length==2){
            if(ArrMen[1].length<2){    //判断小数点后面的字符串长度
                inputZ+= '0';
            }else if (ArrMen[1].length>2){
                inputZ=ArrMen[0]+"."+ ArrMen[1].substring(0,2);
            }

        }else{
            inputZ+= '.00';
        }
        $("#denomination").val(inputZ);
    });


    $("#courseType").on('change', function () {
        switch($("#courseType").val()){
            case '1':
                $("#courseNo").parent().parent().show();
                break;
            case '2':
                $("#courseNo").parent().parent().hide();
                break;
            default:

        }

    });

    $("#courseNo2").parent().parent().hide();
    /*选择发放对象*/
    $("#dispatcheObj").on('change', function () {
        switch($("#dispatcheObj").val()){
            case '0':
                $("#courseNo2").parent().parent().hide();
                $("#telephone").parent().parent().show();
                break;
            case '1':
                $("#courseNo2").parent().parent().show();
                $("#telephone").parent().parent().hide();
                break;
            case '2':
                $("#courseNo2").parent().parent().hide();
                $("#telephone").parent().parent().hide();
                break;
            default:

        }

    });

    /*判断是否为显示申领*/
    function flushByType() {
        /*限时申领开始和结束时间隐藏*/
        if ($('#type').val() == null || $('#type').val() == 0) {
            $("#applyBeginDate").parent().parent().hide();
            $("#applyStopDate").parent().parent().hide();
            $("#imageUl").parent().parent().hide();
            $("#shareUrlUl").parent().parent().hide();
        } else if ($('#type').val() == 1) {
            $("#applyBeginDate").parent().parent().show();
            $("#applyStopDate").parent().parent().hide();
            $("#imageUl").parent().parent().show();
            $("#shareUrlUl").parent().parent().show();
        } else {
            $("#applyBeginDate").parent().parent().show();
            $("#applyStopDate").parent().parent().show();
            $("#imageUl").parent().parent().show();
            $("#shareUrlUl").parent().parent().show();
        }
    };


    /*新增时清空表单数据*/
    function flushForm() {
        //        清空表单数据
        $("#lwInvitationForm")[0].reset();
        $lwCourseIds.empty();
        $lwCourseIds.trigger('change');

        $("#courseNo").parent().parent().show();

        //        清空活动图片数据
        $("#imageUl").addClass("hidden");
        $("[name=actPhoto]").val('');
        $("#icon-img").attr("src", "");

        //        清空活动图片上传file文件
        $("#icon-input").val('');

        //        清空分享图片数据
        $("#shareUrlUl").addClass("hidden");
        $("[name=sharePhoto]").val('');
        $("#shareUrl-img").attr("src", "");

        //        清空图片上传file文件
        $("#shareUrl-input").val('');

        flushByType()



        $("#lwInvitationForm").find("input").each(function () {
            var id = $(this).attr("id");
            $("#" + id).val("");
        });
        $.ajax({
            type: "get",
            url: "${dynamicServer}/cms/voucher/findAll.do",
            contentType: "application/json",
            success: function (data) {

            }
        })
    }

    /*代金券发放*/
    function dispatcher() {
//        $("#lwInvitationForm").find("input").each(function () {
//            var id = $(this).attr("id");
//            $("#" + id).val("");
//        });
        $.ajax({
            type: "get",
            url: "${dynamicServer}/cms/voucher/findAllByState.do",
            data: {
                "state": 1
            },
            contentType: "application/json",
            success: function (data) {
                /*code赋值*/
//                $("#code").val(data[0].prefix);
                var voucherId = $("#voucherId");
                voucherId.empty();
                var str = '';
//                var data = eval("("+text+")");
                str += '<option value="0">'+'请选择'+'</option>';
                for(var o in data) {
                    str += '<option value="'+data[o].id+'" code="'+data[o].prefix+'">'+data[o].name+'</option>';
                }
                voucherId.append(str);
            }
        })
    }


    /*作废/恢复*/
    function cancelVoucher(id,state) {
        var altStr;
        if(state!=2){
            altStr=("确定要恢复该代金券？");
        }else{
            altStr=("确定要作废该代金券？");
        }
        bootbox.confirm("<a style='font-size: 17px;color: red'>"+altStr+"</a>", function (result) {
            if (result) {
                $.ajax({
                    type: "GET",
                    url: "${dynamicServer}/cms/voucher/cancelVoucher.do",
                    data: {
                        "id": id,
                        "state":state
                    },
                    contentType: 'application/json',
                    success: function (data) {
                        if(data.success){
                            alert(data.message);
                        }else{
                            alert(data.message);
                        }
                        table.draw();
                    }
                });
            }
        });
    }

    function addLwCourse() {
        window.location.href = "${dynamicServer}/cms/voucher/toAdd.do";
    }
    function goVoucherLogById(id) {
        window.location.href = "${dynamicServer}/cms/voucherLog/index.do?id="+id;
    }
    <%--function updateLwCourse(id) {--%>
        <%--window.location.href = "${dynamicServer}/cms/voucher/toUpdate.do?id=" + id + "&type=" +${type};--%>
    <%--}--%>

    var $option;
    /*修改时需要回显数据*/
    function updateInvitation(id) {
        flushForm();
        $.ajax({
            type: "GET",
            url: "${dynamicServer}/cms/voucher/findOne.do",
            data: {
                "id": id
            },
            contentType: 'application/json',
            success: function (data) {
                for (var key in data) {
                    $("#" + key).val(data[key]);
                    if(key=="lwCourseList"){
//                        alert(data[key]);
                        if(data[key]==null){
                            $("#courseType").val(2);
                            $("#courseNo").parent().parent().hide();
                        }else{
                            $lwCourseIds.empty();
                            for(var list in data[key]){
//                            $lwCourseIds.append("<option selected value='"+data[key][list]['id']+"'>"+data[key][list]['name']+"</option>");
                                var $option = $('<option selected></option>').val(data[key][list]['id']).text(data[key][list]['name']);
                                $lwCourseIds.append($option);

                            }
                            $lwCourseIds.trigger('change');
                        }

                    }

                    if(key=="actPhoto"&&data[key]!=null&&data[key]!=""){
                        var img_path = data[key];
                        var img_url = '${imageServer}' + img_path;
                        var $shareUrl_img = $("#icon-img");
                        $shareUrl_img.attr("src", img_url);
                        $shareUrl_img.attr("data-path", img_path);
                        $("#imageUl").removeClass("hidden");
                    }
                    if(key=="sharePhoto"&&data[key]!=null&&data[key]!=""){
                        var img_path = data[key];
                        var img_url = '${imageServer}' + img_path;
                        var $shareUrl_img = $("#shareUrl-img");
                        $shareUrl_img.attr("src", img_url);
                        $shareUrl_img.attr("data-path", img_path);
                        $("#shareUrlUl").removeClass("hidden");
                    }

                    flushByType();
                }

            }
        });
    }

    /*删除*/
    function delInvitation(id) {
        bootbox.confirm("<a style='font-size: 17px;color: red'>确定要删除该代金券信息？</a>", function (result) {
            if (result) {
                $.ajax({
                    type: "GET",
                    url: "${dynamicServer}/cms/voucher/deleteCheck.do",
                    data: {
                        "id": id
                    },
                    contentType: 'application/json',
                    success: function (data) {
                        if(!data.success){
                            bootbox.confirm("<a style='font-size: 17px;color: red'>"+data.message+"</a>", function (result) {
                                if (result) {
                                    $.ajax({
                                        type: "GET",
                                        url: "${dynamicServer}/cms/voucher/delete.do",
                                        data: {
                                            "id": id
                                        },
                                        contentType: 'application/json',
                                        success: function () {
                                            table.draw();
                                        }
                                    });
                                }
                            })
                        }else{
                            $.ajax({
                                type: "GET",
                                url: "${dynamicServer}/cms/voucher/delete.do",
                                data: {
                                    "id": id
                                },
                                contentType: 'application/json',
                                success: function () {
                                    table.draw();
                                }
                            });
                        }
                    }
                });



            }
        });
    }
    function stateOption(data) {
        var x = "";
        <%--//0正常 1删除  2 禁用 3 审核中--%>
        console.log(data);
        switch (data) {
            case 0:
                x = "正常";
                break;
            case 1:
                x = "删除";
                break;
            case 2:
                x = "禁用";
                break;
            case 3:
                x = "审核中";
                break;
            case 4 :
                x = "审核通过";
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
    $('#denomination').ace_spinner({
        min: 0.00,
        max: 99999.99,
        step: 0.01,
        fix: 2,
        precision: 2,
        interval: 100,
        icon_up: 'glyphicon glyphicon-plus',
        icon_down: 'glyphicon glyphicon-minus',
        btn_up_class: 'btn-success',
        btn_down_class: 'btn-danger',
        on_sides: true
    });

    //活动图片
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
                    $("[name=actPhoto]").val(img_path);
                    var img_url = '${imageServer}' + img_path;

                    var $icon_img = $("#icon-img");
                    if ($icon_img.attr("src") != '') {
                        $.ajax({
                            url: '${uploadServer}/common/delFile.do',
                            data: {
                                path: $icon_img.attr("data-path")
                            },
                            type: 'GET',
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
                    $("[name=actPhoto]").val('');
                    $("#icon-img").attr("src", "");
                } else {
                    $.notify({message: "文件路径错误!", z_index: 15111});
                }
            }
        })
    });

    //操作分享图片
    $('#shareUrl-input').ace_file_input({
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
        var $shareUrl_input = $('#shareUrl-input');
        if ($shareUrl_input.val() == '') {
            $shareUrl_input.ace_file_input('reset_input');
        }
    }).on('file.error.ace', function (ev, info) {
        if (info.error_count['ext'] || info.error_count['mime'])
            $.notify({message: "请选择图片!", z_index: 1051});
        if (info.error_count['size'])
            $.notify({message: "图片大小不超过1M!!", z_index: 1051});
    });
    var $shareUrl_form = $("#shareUrl-form");
    $shareUrl_form.on('submit', function () {
        var shareUrlcheck = $("#shareUrl-input").val();
        if (shareUrlcheck === '') {
            return false;
        }
        $shareUrl_form.ajaxSubmit({
            type: 'post', // 提交方式 get/post
            url: $shareUrl_form.attr('action'),
            dataType: 'json',
            success: function (result) {
                if (result && result.success) {
                    var img_path = result.createFilePath;

                    $("#closeShareUrl-modal").click();
                    $("[name=sharePhoto]").val(img_path);
                    var img_url = '${imageServer}' + img_path;
                    var $shareUrl_img = $("#shareUrl-img");
                    if ($shareUrl_img.attr("src") != '') {
                        $.ajax({
                            url: '${uploadServer}/common/delFile.do',
                            data: {
                                path: $shareUrl_img.attr("data-path")
                            },
                            type: 'GET',
                            success: function (result) {
                                if (result.success) {
                                    $shareUrl_img.attr("src", img_url);
                                    $shareUrl_img.attr("data-path", img_path);
                                    $("#shareUrlUl").removeClass("hidden");
                                } else {
                                    $.notify({message: "文件路径错误!", z_index: 15111});
                                }
                            }
                        })
                    } else {
                        $shareUrl_img.attr("src", img_url);
                        $shareUrl_img.attr("data-path", img_path);
                        $("#shareUrlUl").removeClass("hidden");
                    }
                    return;
                }

                alert((result && result.message) || '上传失败');
            }
        });
        return false;
    });
    $("#shareUrlUl").on('click', '.delPic', function () {
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
                    $("#shareUrlUl").addClass("hidden");
                    $("[name=sharePhoto]").val('');
                    $("#shareUrl-img").attr("src", "");
                } else {
                    $.notify({message: "文件路径错误!", z_index: 15111});
                }
            }
        })
    });
</script>
</body>
</html>


