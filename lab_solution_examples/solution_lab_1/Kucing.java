class Kucing{
	String nama;
	String ras;
	int umur;
	
	public Kucing(String nama, String ras, int umur){
		this.nama = nama;
		this.umur = umur;
		this.ras = ras;
	}
	
	public String mengeong(){
		return "Meooooooonnnnnng";
	}
	
	public String berjalan(int jumlahLangkah){
		return "Kucingku, "+ this.nama + " telah berjalan sejauh " + jumlahLangkah + " langkah";
	}
	
	public void tidur(){
		this.umur += 1;
	}
}