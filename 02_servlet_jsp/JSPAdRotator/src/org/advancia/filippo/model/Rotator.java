package org.advancia.filippo.model;

public class Rotator {
	
	private String[] images = {"images/book1.jpg", "images/book2.jpg"};
	private String[] links = {"https://www.amazon.it/neuroni-della-lettura-Stanislas-Dehaene/dp/8860302803/?_encoding=UTF8&pd_rd_w=MCwZm&pf_rd_p=6d9d52f7-156f-4bbb-94b7-818549fb2216&pf_rd_r=RS73V8732Q5M0QJ1QG24&pd_rd_r=7f34875a-dd28-4e3f-b798-01d6ebe81732&pd_rd_wg=VlQ2Y&ref_=pd_gw_cr_wsim#",
									"https://www.amazon.it/Medioevo-Profilo-millennio-Alfio-Cortonesi/dp/8843074229/?_encoding=UTF8&pd_rd_w=MCwZm&pf_rd_p=6d9d52f7-156f-4bbb-94b7-818549fb2216&pf_rd_r=RS73V8732Q5M0QJ1QG24&pd_rd_r=7f34875a-dd28-4e3f-b798-01d6ebe81732&pd_rd_wg=VlQ2Y&ref_=pd_gw_cr_wsim#"	};

	private int selectedIndex = 0;
	
	
	public String getImage() { return this.images[selectedIndex]; }
	
	public String getLink() { return this.links[selectedIndex]; }
	
	public void nextAd() { this.selectedIndex = (this.selectedIndex + 1) % this.links.length;}

}
