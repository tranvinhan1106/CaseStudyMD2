package src.regex;

public class MyRegex {
    public static final String REGEX_CUSTOMER_ID = "^KH-[\\d]{4}$";
    public static final String REGEX_EMPLOYEE_ID = "^NV-[\\d]{4}$";
    public static final String REGEX_SERVICE_VL = "^SVVL-[\\d]{4}$";
    public static final String REGEX_SERVICE_HO = "^SVHO-[\\d]{4}$";
    public static final String REGEX_SERVICE_RO = "^SVRO-[\\d]{4}$";
    public static final String REGEX_NAME_SERVICE_VL = "Villa";
    public static final String REGEX_NAME_SERVICE_HO = "House";
    public static final String REGEX_NAME_SERVICE_RO = "Room";
    public static final String REGEX_RENTAL_TYPE = "Ngay||Thang||Nam||Gio";
    public static final String REGEX_DATE = "dd/MM/yyyy";
    public static final String REGEX_EMAIL = "^[\\w.]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+){1,2}$";
    public static final String REGEX_PHONE = "^0[0-9]{9}$";
    public static final String REGEX_CMND = "^[0-9]{9,12}$";
}
