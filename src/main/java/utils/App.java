package utils;

public enum App {

    APIDEMO("io.appium.android.apis","io.appium.android.apis.ApiDemos",""),
    BLATTER("de.cominto.blaetterkatalog.example","de.cominto.blaetterkatalog.android.codebase.app.views.BootstrapActivity",
            "Katalog.zip");

    public String appPackage;
    public String appActivitiy;
    public String appZipFile;

    App(String appPackage, String appActivitiy, String appZipFile) {
        this.appPackage = appPackage;
        this.appActivitiy = appActivitiy;
        this.appZipFile = appZipFile;
    }
}
