package com.logwire;

import org.openqa.selenium.By;

public class DashboardPage {
        private String url;

        public DashboardPage() {
                this.url = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        }

        public String getUrl() {
                return url;
        }

}
