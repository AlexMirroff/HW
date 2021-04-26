package com.ithillel.pages;

public class Product {

    private String name;
    private String description;
    private String size;
    private String receiver;
    private String price;
    private String vendor;
    private boolean isSold;
    private String category;

    public Product() {
    }

    public Product(String name, String description, String size, String receiver, String price, String vendor, boolean isSold, String category) {
        this.name = name;
        this.description = description;
        this.size = size;
        this.receiver = receiver;
        this.price = price;
        this.vendor = vendor;
        this.isSold = isSold;
        this.category = category;
    }

    public static Builder builder() {
        return new Product().new Builder();
    }

    public class Builder {

        private String name;
        private String description;
        private String size;
        private String receiver;
        private String price;
        private String vendor;
        private boolean isSold;
        private String category;

        public Builder setName(String name) {
            Builder.this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            Builder.this.description = description;
            return this;
        }

        public Builder setSize(String size) {
            Builder.this.size = size;
            return this;
        }

        public Builder setReceiver(String receiver) {
            Builder.this.receiver = receiver;
            return this;
        }

        public Builder setPrice(String price) {
            Builder.this.price = price;
            return this;
        }

        public Builder setVendor(String vendor) {
            Builder.this.vendor = vendor;
            return this;
        }

        public Builder setSold(boolean sold) {
            isSold = sold;
            return this;
        }

        public Builder setCategory(String category) {
            Builder.this.category = category;
            return this;
        }

        public Product build() {
            return new Product(name, description, size, receiver, price, vendor, isSold, category);
        }
    }
}