
package _Toko;

public class Toko {
    private String id_toko;
    private String nama_toko;
    private String kategori;
    private byte[] foto_toko;
    
    public Toko (){}
    public Toko (String Id, String Nama, String Kategori, byte[] Foto){
    
        this.id_toko = Id;
        this.nama_toko = Nama;
        this.kategori = Kategori;
        this.foto_toko = Foto;
       
    }
    
    public String getID(){
      return id_toko;
    }
    
    public void setID(String ID){
        this.id_toko = ID;
    }
    
    public String getName(){
        return nama_toko;
    }
    
    public void setName(String Name){
        this.nama_toko = Name;
    }
    
    public String getCategory(){
        return kategori;
    }
    
    public void setKategori(String Kategori){
        this.kategori = Kategori;
    }
    
    public byte[] getMyImage(){
        return foto_toko;
    }
}
