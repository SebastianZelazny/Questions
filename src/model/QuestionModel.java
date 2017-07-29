package model;

public class QuestionModel {
	private String tresc;
	private String odp_a;
	private String odp_b;
	private String odp_c;
	private String odp_d;
	private String odp_ok;
	public String getTresc() {
		return tresc;
	}
	public void setTresc(String tresc) {
		this.tresc = tresc;
	}
	public String getOdp_a() {
		return odp_a;
	}
	public void setOdp_a(String odp_a) {
		this.odp_a = odp_a;
	}
	public String getOdp_b() {
		return odp_b;
	}
	public void setOdp_b(String odp_b) {
		this.odp_b = odp_b;
	}
	public String getOdp_c() {
		return odp_c;
	}
	public void setOdp_c(String odp_c) {
		this.odp_c = odp_c;
	}
	public String getOdp_d() {
		return odp_d;
	}
	public void setOdp_d(String odp_d) {
		this.odp_d = odp_d;
	}
	public String getOdp_ok() {
		return odp_ok;
	}
	public void setOdp_ok(String odp_ok) {
		this.odp_ok = odp_ok;
	}
	public QuestionModel(String tresc,String odp_a,String odp_b, String odp_c,String odp_d,String odp_ok)
	{
		this.tresc = tresc;
		this.odp_a = odp_a;
		this.odp_b = odp_b;
		this.odp_c = odp_c;
		this.odp_d = odp_d;
		this.odp_ok = odp_ok;
	}
}
