package polinema.ac.id.dtschapter03_starter;


public class ScreenItem {
    String Judul, subJudul,buttonText, loginText;
    int img;

    public ScreenItem(String Judul, String subJudul, String buttonText, String loginText, int img){
        this.Judul = Judul;
        this.subJudul = subJudul;
        this.buttonText = buttonText;
        this.loginText = loginText;
        buttonText = "GET STARTED";
        loginText = "log in";
        this.img = img;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public void setSubJudul(String subJudul) {
        this.subJudul = subJudul;
    }


    public void setImg(int img) {
        this.img = img;
    }

    public String getJudul() {
        return Judul;
    }

    public String getSubJudul() {
        return subJudul;
    }

    public String getButtonText() {
        return buttonText;
    }

    public String getLoginText() {
        return loginText;
    }

    public int getImg() {
        return img;
    }
}
