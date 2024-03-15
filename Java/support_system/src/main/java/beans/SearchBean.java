package beans;

import java.io.Serializable;

public class SearchBean implements Serializable{


    private String serial_no;       //シリアルNO
    private String order_id;        //受付番号
    private String product_code;    //品名コード
    private String product_name;	//品名
    private String end_date;		//修理完了日	
    private String order_date;		//受付日	
    private String out_state;		//故障状況	
    private String check_state;     //弊社確認事項			
    private String repair_detail;   //修理内容	
    private String disorder_repair; //以上処置内容

    private String end_date_start;
    private String end_date_end;
    private String order_date_start;
    private String order_date_end;
    

    public String getSerial_no() {
        return serial_no;
    }
    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }
    public String getOrder_id() {
        return order_id;
    }
    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
    public String getProduct_code() {
        return product_code;
    }
    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public String getEnd_date() {
        return end_date;
    }
    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
    public String getOrder_date() {
        return order_date;
    }
    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }
    public String getOut_state() {
        return out_state;
    }
    public void setOut_state(String out_state) {
        this.out_state = out_state;
    }
    public String getCheck_state() {
        return check_state;
    }
    public void setCheck_state(String check_state) {
        this.check_state = check_state;
    }
    public String getRepair_detail() {
        return repair_detail;
    }
    public void setRepair_detail(String repair_detail) {
        this.repair_detail = repair_detail;
    }
    public String getDisorder_repair() {
        return disorder_repair;
    }
    public void setDisorder_repair(String disorder_repair) {
        this.disorder_repair = disorder_repair;
    }
    public String getEnd_date_start() {
        return end_date_start;
    }
    public void setEnd_date_start(String end_date_start) {
        this.end_date_start = end_date_start;
    }
    public String getEnd_date_end() {
        return end_date_end;
    }
    public void setEnd_date_end(String end_date_end) {
        this.end_date_end = end_date_end;
    }
    public String getOrder_date_start() {
        return order_date_start;
    }
    public void setOrder_date_start(String order_date_start) {
        this.order_date_start = order_date_start;
    }
    public String getOrder_date_end() {
        return order_date_end;
    }
    public void setOrder_date_end(String order_date_end) {
        this.order_date_end = order_date_end;
    }



}
