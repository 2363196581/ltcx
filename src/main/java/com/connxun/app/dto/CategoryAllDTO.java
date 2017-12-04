package com.connxun.app.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Author anna
 * @Date 2017-11-16 16:33
 * @Description
 */
public class CategoryAllDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * parentCategoryId : 1
     * subList : [{"subCategoryId":"17","parentId":"1","subCategoryName":"家政服务"},{"subCategoryId":"18","parentId":"1","subCategoryName":"家电维修"},{"subCategoryId":"19","parentId":"1","subCategoryName":"房屋维修"},{"subCategoryId":"20","parentId":"1","subCategoryName":"家具装饰"},{"subCategoryId":"21","parentId":"1","subCategoryName":"配送上门"},{"subCategoryId":"22","parentId":"1","subCategoryName":"搬家"},{"subCategoryId":"23","parentId":"1","subCategoryName":"童婴用品"},{"subCategoryId":"24","parentId":"1","subCategoryName":"保育服务"},{"subCategoryId":"25","parentId":"1","subCategoryName":"养老"},{"subCategoryId":"26","parentId":"1","subCategoryName":"病号护理"},{"subCategoryId":"27","parentId":"1","subCategoryName":"供气供暖"},{"subCategoryId":"28","parentId":"1","subCategoryName":"燃气燃料"},{"subCategoryId":"29","parentId":"1","subCategoryName":"营养配餐"},{"subCategoryId":"30","parentId":"1","subCategoryName":"其他"}]
     * parentCategoryName : 居家服务
     */

    private String parentCategoryId;
    private String parentCategoryName;
    private List<SubListBean> subList;

    public String getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(String parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getParentCategoryName() {
        return parentCategoryName;
    }

    public void setParentCategoryName(String parentCategoryName) {
        this.parentCategoryName = parentCategoryName;
    }

    public List<SubListBean> getSubList() {
        return subList;
    }

    public void setSubList(List<SubListBean> subList) {
        this.subList = subList;
    }

    public static class SubListBean {
        /**
         * subCategoryId : 17
         * parentId : 1
         * subCategoryName : 家政服务
         */

        private String subCategoryId;
        private String parentId;
        private String subCategoryName;

        public String getSubCategoryId() {
            return subCategoryId;
        }

        public void setSubCategoryId(String subCategoryId) {
            this.subCategoryId = subCategoryId;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getSubCategoryName() {
            return subCategoryName;
        }

        public void setSubCategoryName(String subCategoryName) {
            this.subCategoryName = subCategoryName;
        }
    }

}
