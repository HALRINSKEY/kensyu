package beans;

import java.io.Serializable;

public class MemberBean implements Serializable {
    private String member_id;
	private String member_name;
	private String division_name;
	private String enter_date;

    public String getMember_id() {
        return member_id;

    }
    
    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }
    
    public String getDivision_name() {
        return division_name;
    }

    public void setDivision_name(String division_name) {
        this.division_name = division_name;
    }

    public String getEnter_date() {
        return enter_date;
    }

    public void setEnter_date(String enter_date) {
        this.enter_date = enter_date;
    }
    
    
}
