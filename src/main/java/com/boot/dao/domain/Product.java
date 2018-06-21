package com.boot.dao.domain;

public class Product {
		private int id;
		private String productName;
		private int productCategory;
		private String productSpec;
		private int productCost;
		private int productPrice;
		private String productPhoto;
		private String productRemark;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public int getProductCategory() {
			return productCategory;
		}
		public void setProductCategory(int productCategory) {
			this.productCategory = productCategory;
		}
		public String getProductSpec() {
			return productSpec;
		}
		public void setProductSpec(String productSpec) {
			this.productSpec = productSpec;
		}
		public int getProductCost() {
			return productCost;
		}
		public void setProductCost(int productCost) {
			this.productCost = productCost;
		}
		public int getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(int productPrice) {
			this.productPrice = productPrice;
		}
		public String getProductPhoto() {
			return productPhoto;
		}
		public void setProductPhoto(String productPhoto) {
			this.productPhoto = productPhoto;
		}
		public String getProductRemark() {
			return productRemark;
		}
		public void setProductRemark(String productRemark) {
			this.productRemark = productRemark;
		}
}
