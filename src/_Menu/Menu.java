
package _Menu;

public class Menu {
    private String id_menu;
    private String id_toko;
    private String nama_menu;
    private String kategori;
    private String harga;
    private byte[] foto_menu;
    
    public Menu (){}
    public Menu (String Id, String id_toko, String nama_menu, String Kategori, String harga, byte[] Foto){
    
        this.id_menu = Id;
        this.id_toko = id_toko;
        this.nama_menu = nama_menu;
        this.kategori = Kategori;
        this.harga = harga;
        this.foto_menu = Foto;
       
    }
    
    public String getID(){
      return id_menu;
    }
    
    public void setID(String ID){
        this.id_menu = ID;
    }
    
    public String getNamaMenu(){
        return nama_menu;
    }
    
    public void setNamaMenu(String menu){
        this.nama_menu = menu;
    }
    
    public String getIdToko(){
        return id_toko;
    }
    
    public void setIdToko(String toko){
        this.id_toko = toko;
    }
    
    public String getCategory(){
        return kategori;
    }
    
    public void setKategori(String Kategori){
        this.kategori = Kategori;
    }
    
    public String getHarga(){
        return harga;
    }
    
    public void setHarga(String harga){
        this.harga = harga;
    }
    
    public byte[] getMyImage(){
        return foto_menu;
    }
}
